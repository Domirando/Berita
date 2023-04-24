package com.example.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsTypeAdapter(var types:MutableList<NewsType>, private val listener: OnItemClickListener):RecyclerView.Adapter<NewsTypeAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.types, parent, false))
    }
    override fun getItemCount(): Int {
        return types.size
    }

    override fun onBindViewHolder(holder: NewsTypeAdapter.MyHolder, position: Int) {
        var item = types[position]
        holder.type.text = item.type
        holder.status = item.status
        if (item.status){
            holder.typeContainer.setBackgroundResource(R.drawable.sign_filled)
            holder.type.setTextColor(Color.WHITE)
        }
    }

     inner class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var type:TextView = itemView.findViewById(R.id.type)
        var typeContainer: View = itemView
        var status:Boolean = false
        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position!=RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
