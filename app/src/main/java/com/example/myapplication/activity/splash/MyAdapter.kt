package com.example.myapplication.activity.splash

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R

class MyAdapter(private val strings:ArrayList<String>):Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):ViewHolder(itemView){
        val textView:TextView = itemView.findViewById(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_body,parent,false))
    }

    override fun getItemCount(): Int {
        return strings.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = strings[position]
    }
}