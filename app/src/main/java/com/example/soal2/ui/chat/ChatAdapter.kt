package com.example.soal2.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soal2.R
import kotlin.random.Random

class ChatAdapter() : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    var itemId = 0L
    val strChatList = arrayListOf("satu")

    inner class ChatViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    }

    override fun getItemId(position: Int): Long {
        itemId++
        return itemId
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun addChatStr(){
        val randomString = (1..32)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("");

        strChatList.add(randomString)
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        var inflateLayoutId = if(viewType == 0) R.layout.item_chat_send else R.layout.item_chat_receive
        return ChatViewHolder(LayoutInflater.from(parent.context).inflate(inflateLayoutId, parent, false))
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return strChatList.size
    }
}