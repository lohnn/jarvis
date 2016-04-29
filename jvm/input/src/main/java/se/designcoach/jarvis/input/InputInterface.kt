package se.designcoach.jarvis.input

/**
 * Created by lohnn-macPro on 16/04/16.
 */
interface InputInterface {
    fun addInputListener(listener: InputListener)
    fun startListening()
}

interface InputListener {
    fun gotText(text: String)
}