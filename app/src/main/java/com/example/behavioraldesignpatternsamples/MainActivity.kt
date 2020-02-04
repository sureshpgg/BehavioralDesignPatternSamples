package com.example.behavioraldesignpatternsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.behavioraldesignpatternsamples.Strategy.Printer

class MainActivity : AppCompatActivity() {
    val TAG:String="MainActivity"
lateinit var clickbtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickbtn=findViewById(R.id.observer)
        val lowerCaseFormatter:(String)->String={it.toLowerCase()}
        val upperCaseFormatter={it:String->it.toUpperCase()}
        clickbtn.setOnClickListener { view ->

            val inputString = "ANDROID developer GUIDE to learn"

            val lowerCasePrinter = Printer(lowerCaseFormatter)
            lowerCasePrinter.printString(inputString)

            val upperCasePrinter = Printer(upperCaseFormatter)
            upperCasePrinter.printString(inputString)

            val prefixPrinter = Printer { "Prefix: $it" }
            prefixPrinter.printString(inputString)


        }
    }
}

