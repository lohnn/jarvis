package se.designcoach.jarvis.output

/**
 * Created by lohnn-macPro on 15/04/16.
 */
class OutputImplementation : OutputInterface {
    override fun talk(text: String) {
        println(text)
    }
}