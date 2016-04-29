package se.designcoach.jarvis.brain

import se.designcoach.jarvis.input.InputInterface
import se.designcoach.jarvis.output.OutputInterface

/**
 * Created by lohnn-macPro on 16/04/16.
 */
class BrainFactory {
    companion object {
        fun getStandardOutput(input: InputInterface, output: OutputInterface): BrainInterface {
            return BrainImplementation(input, output);
        }
    }
}