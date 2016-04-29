package se.designcoach.jarvis.brain

import se.designcoach.jarvis.input.InputInterface
import se.designcoach.jarvis.input.InputListener
import se.designcoach.jarvis.output.OutputInterface

/**
 * Created by lohnn-macPro on 16/04/16.
 */
class BrainImplementation(input: InputInterface, output: OutputInterface) : BrainInterface {
    private val input = input
    private val output = output

    override fun startRunning() {
        output.talk("Hello!")
        input.addInputListener(object : InputListener {
            override fun gotText(text: String) {
                output.talk(text)
            }
        })
        input.startListening()
        Thread.sleep(1000)
        output.talk("Hello again!")
    }
}