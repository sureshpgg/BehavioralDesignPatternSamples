package com.example.behavioraldesignpatternsamples.Strategy;

class Printer(private  val stringFormatterStrategy: (String) -> String) {
    fun printString(string: String) {
        println(stringFormatterStrategy(string))
    }

}
