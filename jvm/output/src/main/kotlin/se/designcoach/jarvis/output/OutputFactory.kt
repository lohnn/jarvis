package se.designcoach.jarvis.output

/**
 * Created by lohnn-macPro on 15/04/16.
 */
class OutputFactory {
    companion object {
        fun getStandardOutput(): OutputInterface {
            return OutputImplementation();
        }
    }
}