package com.example.soal2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_verification.*

class VerificationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        Handler().postDelayed(Runnable(){
            button_confirmation.isEnabled = true
            square_field.setText(preferences.getVerifNumber())
            startActivity(Intent(this@VerificationActivity, ProfileActivity::class.java))
        }, 5000)

    }
}