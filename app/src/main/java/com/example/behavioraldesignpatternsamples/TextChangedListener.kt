package com.example.behavioraldesignpatternsamples

import android.util.Log
import kotlin.properties.Delegates


interface TextChangedListener {

    fun onTextChanged(oldText: String, newText: String)
}
class PrintingTextChangedListener : TextChangedListener {

    private var text = ""

    override fun onTextChanged(oldText: String, newText: String) {
        text = "Text is changed: $oldText -> $newText"
        Log.i("onTextChanged","@"+text)

    }
}

class TextView {

    val listeners = mutableListOf<TextChangedListener>()

    var text: String by Delegates.observable("<empty>") { _, old, new ->
        listeners.forEach {
            it.onTextChanged(old, new)
            Log.i("Delegates.observable ","@old "+old+"@new "+new)
        }
    }
}