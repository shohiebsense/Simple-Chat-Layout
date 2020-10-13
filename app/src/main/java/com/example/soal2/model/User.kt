package com.example.soal2.model

class User(val verifynumber: String){



    interface ResponseLstener {
        fun onSuccessResponse(user: User)
    }
}