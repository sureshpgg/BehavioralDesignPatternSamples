package com.example.behavioraldesignpatternsamples.State

sealed class AuthorizationState

class Unauthorized(val userName: String) : AuthorizationState()

object LogOutauthorized: AuthorizationState()

class Authorized(val userName: String) : AuthorizationState()

class AuthorizationPresenter{
   private var state:AuthorizationState=LogOutauthorized
private val entryName:String?=null
    val isAuthorized: Boolean
        get()=when(state) {
            is Authorized->true
            is LogOutauthorized->false
            is Unauthorized->false
        }
    val userName:String
    get(){
        var state=this.state
        return when (state) {
           is Authorized -> state.userName
           is Unauthorized -> state.userName
            is LogOutauthorized->"Present"
       }
    }
    fun loginUser(userName: String) {

        if (userName.equals("admin"))
        state = Authorized(userName)
        else
            state = Unauthorized(userName)
    }

    fun logoutUser() {
        state = LogOutauthorized
    }

    override fun toString() = "'$userName'User  is logged in: $isAuthorized"
    }

