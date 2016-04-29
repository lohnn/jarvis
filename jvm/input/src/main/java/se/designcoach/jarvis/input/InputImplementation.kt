package se.designcoach.jarvis.input

import edu.cmu.sphinx.api.Configuration
import edu.cmu.sphinx.api.SpeechResult
import edu.cmu.sphinx.api.StreamSpeechRecognizer
import edu.cmu.sphinx.util.TimeFrame
import java.io.File
import java.io.FileInputStream
import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by lohnn-macPro on 16/04/16.
 */
class InputImplementation : InputInterface {
    val listeners = ArrayList<InputListener>()

    override fun startListening() {
        Thread({
            println("Starting listening to file")
            val configuration = Configuration()
            configuration.acousticModelPath = "resource:/edu/cmu/sphinx/models/en-us/en-us"
            configuration.dictionaryPath = "resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict"
            configuration.languageModelPath = "resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin"
            configuration.sampleRate = 44100

            val recognizer = StreamSpeechRecognizer(configuration)
            val file = File("test.wav")
            println(file.absolutePath)
            val stream = FileInputStream(file)

            recognizer.startRecognition(stream, TimeFrame(3000))
            while (true) {
                val result: SpeechResult? = recognizer.result ?: break

                broadcastToListeners("Hypothesis: ${result!!.hypothesis}")

                broadcastToListeners("List of recognized words and their times:")
                for (r in result.words) {
                    broadcastToListeners(r.toString())
                }

                System.out.println("Best 3 hypothesis:")
                for (s in result.getNbest(3))
                    broadcastToListeners(s)

                Thread.sleep(20)
            }
            recognizer.stopRecognition()
        }).start()
    }

    override fun addInputListener(listener: InputListener) {
        listeners.add(listener)
    }

    private fun getRandomTime(): Int {
        return ThreadLocalRandom.current().nextInt(1000, 5000 + 1)
    }

    private fun broadcastToListeners(text: String) {
        listeners.forEach { it.gotText(text) }
    }
}