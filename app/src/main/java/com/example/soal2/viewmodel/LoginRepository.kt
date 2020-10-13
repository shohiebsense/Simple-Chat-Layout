package com.example.soal2.viewmodel

import com.example.soal2.global.Preferences
import com.example.soal2.model.User
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.FormBody

class LoginRepository(val url: String, val listener: User.ResponseLstener){

    suspend fun verify(phoneNumber: String) : User?{
        try{
            val body = FormBody.Builder().add("phoneNumber", phoneNumber).build()

            val request = Preferences.URLBuilder.generatePostRequest(body, url+"verify/")

            return withContext(Dispatchers.IO){
                val responseStr = Preferences.URLBuilder.executePostRequest(request)
                Gson().fromJson(responseStr, User::class.java)
            }

        }catch (e: Throwable){
            e.printStackTrace()
            return null
        }
    }

}