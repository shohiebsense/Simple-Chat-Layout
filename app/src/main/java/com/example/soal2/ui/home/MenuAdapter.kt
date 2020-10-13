package com.example.soal2.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soal2.R

class MenuAdapter() : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    var menuList = arrayListOf(1,2,3,4,5,6,7,8,9)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_rounded, parent, false))
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    inner class MenuViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


    }
}