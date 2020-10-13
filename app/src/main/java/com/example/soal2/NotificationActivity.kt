package com.example.soal2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soal2.R
import com.example.soal2.ui.notifications.NotificationsAdapter
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val adapter = NotificationsAdapter()
        val layoutManager = LinearLayoutManager(this)
        recycler_notification.layoutManager = layoutManager
        recycler_notification.adapter = adapter

    }
}