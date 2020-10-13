package com.example.soal2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.soal2.model.User

class LoginViewModelFactory(val url: String, val listener : User.ResponseLstener) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    url, listener
                ), listener
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}