package com.example.soal2.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soal2.model.User
import kotlinx.coroutines.launch

class LoginViewModel(val loginRepository: LoginRepository, val listener: User.ResponseLstener) : ViewModel(){

    fun verify(phoneNumber: String){
        viewModelScope.launch {
            val result = loginRepository.verify(phoneNumber)
            when(result){
                is User -> {
                    Log.e("shohiebsense ",result.verifynumber)
                    listener.onSuccessResponse(result)
                }
                else -> {
                    Log.e("shohiebsense ","error")
                }
            }
        }
    }
}