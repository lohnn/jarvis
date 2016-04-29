import se.designcoach.jarvis.brain.BrainFactory
import se.designcoach.jarvis.input.InputFactory
import se.designcoach.jarvis.output.OutputFactory

/**
 * Created by lohnn-macPro on 15/04/16.
 */

fun main(args: Array<String>) {
    val output = OutputFactory.getStandardOutput()
    val input = InputFactory.getStandardInput()

    val brain = BrainFactory.getStandardOutput(input, output)
    brain.startRunning()
}