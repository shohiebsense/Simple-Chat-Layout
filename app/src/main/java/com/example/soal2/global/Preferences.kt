package com.example.soal2.global

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import okhttp3.*
import okio.IOException

class Preferences(val activity: Activity) {

    val PREF_IP_ADDRESS = "PREF_IP_ADDRESS"
    val DEFAULT_PREF_NAME = "DEFAULT_PREF_NAME"
    val PREF_VERIF_NUMBER = "VERIF_NUMBER"


    fun getDefaultSharedPreferences() : SharedPreferences? {
        return activity.getSharedPreferences(DEFAULT_PREF_NAME, Context.MODE_PRIVATE)
    }


    fun setVerifNumber(newValue : String) {
        val sharedPref = getDefaultSharedPreferences() ?: null
        with(sharedPref!!.edit()){
            putString(PREF_VERIF_NUMBER, newValue)
            apply()
        }
    }

    fun setIp(newValue : String) {
        val sharedPref = getDefaultSharedPreferences() ?: null
        with(sharedPref!!.edit()){
            putString(PREF_IP_ADDRESS, newValue)
            apply()
        }
    }

    fun getIp() : String {
        val sharedPref = getDefaultSharedPreferences() ?: return ""
        with(sharedPref.edit()){
            return sharedPref.getString(PREF_IP_ADDRESS, "192.168.1.3/phalconsatu/")!!
        }
    }

    fun getVerifNumber() : String {
        val sharedPref = getDefaultSharedPreferences() ?: return ""
        with(sharedPref.edit()){
            return sharedPref.getString(PREF_VERIF_NUMBER, "")!!
        }
    }


    object URLBuilder {
        interface GenericResponseListener {
            fun onSuccessResponse(str: String)
        }
        val okHttpClient = OkHttpClient()

        fun generateGetRequest(url: String) : Request{
            val getUrl = generate(url)
            Log.e("shohiebsense ",getUrl)
            return Request.Builder().url(getUrl).build()
        }

        fun generatePostRequest(formBody: FormBody, url: String) : Request{
            val postUrl = generate(url)
            Log.e("shohiebsense",postUrl)
            return Request.Builder().url(postUrl).post(formBody).build()
        }

        fun executePostRequest(request: Request) : String{
            okHttpClient.newCall(request).execute().use {
                response ->
                if(!response.isSuccessful){
                    Log.e("shohiebsense ","error ${response.body}")
                    throw IOException("Unexpected code: $response")
                }
                return response.body!!.string()
            }
        }

        fun executeGetRequest(request: Request, listener: GenericResponseListener) {

            okHttpClient.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: java.io.IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        if(!response.isSuccessful){
                            throw IOException("Unexpected $response")
                        }
                        listener.onSuccessResponse(response.body!!.string())
                    }
                }
            })
        }

        fun generate(url: String) : String{
            var strBuilder = StringBuilder()
            if(!url.contains("http://")){
                strBuilder.append("http://")
            }
            strBuilder.append(url)
            if(!url.endsWith("/")){
                strBuilder.append("/")
            }
            return strBuilder.toString()
        }

        fun generateWithoutSlash(url : String) : String {
            var strBuilder = StringBuilder()
            if(!url.contains("http://")){
                strBuilder.append("http://")
            }
            strBuilder.append(url)
            return strBuilder.toString()
        }


    }



}