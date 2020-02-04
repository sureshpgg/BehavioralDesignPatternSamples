package com.example.behavioraldesignpatternsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.behavioraldesignpatternsamples.observer.PrintingTextChangedListener
import com.example.behavioraldesignpatternsamples.observer.TextView

class MainActivity : AppCompatActivity() {
    val TAG:String="MainActivity"
lateinit var clickbtn : Button
    lateinit var listener: PrintingTextChangedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickbtn=findViewById(R.id.observer)
        clickbtn.setOnClickListener { view ->

            val textView = TextView().apply {
                listener = PrintingTextChangedListener()
            }

            with(textView) {


                textView.text = "Lorem ipsum"
                Log.i(TAG,"@"+textView.text)

                textView.text = "dolor sit amet"
                Log.i(TAG,"@"+textView.text)
            }


        }
    }
}

