package se.designcoach.jarvis.input

/**
 * Created by lohnn-macPro on 16/04/16.
 */
class InputFactory {
    companion object {
        fun getStandardInput(): InputInterface {
            return InputImplementation();
        }
    }
}