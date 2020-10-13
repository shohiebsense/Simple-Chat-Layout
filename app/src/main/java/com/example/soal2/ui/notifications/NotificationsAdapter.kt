package com.example.soal2.ui.notifications

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soal2.ChatActivity
import com.example.soal2.R
import kotlinx.android.synthetic.main.item_notification.view.*

class NotificationsAdapter() : RecyclerView.Adapter<NotificationsAdapter.NotificationViewHolder>(){

    var notificationList = arrayListOf(1)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false))
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.itemView.layout_item.setOnClickListener {
            holder.itemView.context.startActivity(Intent(holder.itemView.context, ChatActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
       return notificationList.size
    }


    inner class NotificationViewHolder(val view: View) : RecyclerView.ViewHolder(view) {



    }
}