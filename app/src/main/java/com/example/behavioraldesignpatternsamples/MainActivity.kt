package com.example.behavioraldesignpatternsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.behavioraldesignpatternsamples.Command.CommandProcessor
import com.example.behavioraldesignpatternsamples.Command.OrderAddCommand
import com.example.behavioraldesignpatternsamples.Command.OrderPayCommand

class MainActivity : AppCompatActivity() {
    val TAG:String="MainActivity"
lateinit var clickbtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickbtn=findViewById(R.id.observer)

        clickbtn.setOnClickListener { view ->

          CommandProcessor().addToQueue(OrderAddCommand(1L))
                  .addToQueue(OrderAddCommand(2L))
                  .addToQueue(OrderPayCommand(1L))
                  .addToQueue(OrderPayCommand(2L))
                  .processCommands()


        }
    }
}

