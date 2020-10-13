package com.example.soal2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.soal2.model.User
import com.example.soal2.viewmodel.LoginViewModel
import com.example.soal2.viewmodel.LoginViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    lateinit var loginViewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginViewModel = ViewModelProviders.of(this, LoginViewModelFactory(preferences.getIp(), loginListener)).get(LoginViewModel::class.java)

        button_next.setOnClickListener {
            loginViewModel.verify(edit_handphone_no.text.toString())
        }

    }

    val loginListener = object : User.ResponseLstener {
        override fun onSuccessResponse(user: User) {
            Log.e("shohiebsense ","verifyNumber "+user?.verifynumber)
            preferences.setVerifNumber(user.verifynumber)
            setResult(Activity.RESULT_OK)
            //Complete and destroy login activity once successful
            startActivity(Intent(baseContext, VerificationActivity::class.java))
            finish()
        }
    }
}