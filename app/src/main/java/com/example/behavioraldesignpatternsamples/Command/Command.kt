package com.example.behavioraldesignpatternsamples.Command

import android.util.Log

interface OrderCommand{
    fun execute()
}
class OrderAddCommand(val id: Long) : OrderCommand {
    override fun execute() { Log.i("OrderAddCommand","Adding order with id: $id")}
}

class OrderPayCommand(val id: Long) : OrderCommand {
    override fun execute() { Log.i("OrderAddCommand","Paying for order with id: $id")}
}

class CommandProcessor{
    private val queue = ArrayList<OrderCommand>()
    /*
       apply is an extension function on a type.
       It requires an object reference to run into an expression.
       It also return an object reference on completion.
*/
    fun addToQueue(orderCommand: OrderCommand)=apply{

        queue.add(orderCommand)
    }
    fun processCommands():CommandProcessor=apply {
        queue.forEach(){ it.execute() }
        queue.clear()

    }
}