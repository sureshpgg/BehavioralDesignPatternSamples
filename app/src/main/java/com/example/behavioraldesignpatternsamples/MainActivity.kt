package com.example.behavioraldesignpatternsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.behavioraldesignpatternsamples.Command.CommandProcessor
import com.example.behavioraldesignpatternsamples.Command.OrderAddCommand
import com.example.behavioraldesignpatternsamples.Command.OrderPayCommand
import com.example.behavioraldesignpatternsamples.State.AuthorizationPresenter

class MainActivity : AppCompatActivity() {
    val TAG:String="MainActivity"
lateinit var clickbtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickbtn=findViewById(R.id.observer)

        clickbtn.setOnClickListener { view ->
            val authorizationPresenter = AuthorizationPresenter()

            authorizationPresenter.loginUser("admin")
            Log.i(this.toString(),"$authorizationPresenter")

            authorizationPresenter.logoutUser()
            Log.i(this.toString(),"$authorizationPresenter")


        }
    }
}

