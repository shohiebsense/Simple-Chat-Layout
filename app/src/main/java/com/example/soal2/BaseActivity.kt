package com.example.soal2

import androidx.appcompat.app.AppCompatActivity
import com.example.soal2.global.Preferences

open class BaseActivity : AppCompatActivity() {
    val preferences = Preferences(this)

}