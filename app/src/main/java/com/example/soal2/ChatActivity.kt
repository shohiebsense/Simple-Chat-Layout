package com.example.soal2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.soal2.ui.chat.ChatAdapter
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val adapter = ChatAdapter()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.reverseLayout = false
        layoutManager.stackFromEnd = true


        recycler_chat.layoutManager = layoutManager
        recycler_chat.adapter = adapter
        (recycler_chat.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        recycler_chat.itemAnimator = null

        image_submit.setOnClickListener {
            adapter.addChatStr()
            recycler_chat.invalidate()
            recycler_chat.smoothScrollToPosition(adapter.itemCount)
        }

    }
}