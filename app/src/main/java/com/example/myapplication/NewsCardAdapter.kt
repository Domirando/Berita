package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsCardAdapter(var newsCard: MutableList<NewsCard>, private val listener: NewsCardAdapter.OnItemClickListenerCard):RecyclerView.Adapter<NewsCardAdapter.MyHolder>()  {
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var comments: TextView = itemView.findViewById(R.id.card_comments)
        var image: ImageView = itemView.findViewById(R.id.card_image)
        var likes: TextView = itemView.findViewById(R.id.card_likes)
        var news_company: TextView = itemView.findViewById(R.id.card_news_company)
        var news_company_icon: ImageView = itemView.findViewById(R.id.card_news_company_icon)
        var news_type: TextView = itemView.findViewById(R.id.card_news_type)
        var title: TextView = itemView.findViewById(R.id.card_title)
        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position!=RecyclerView.NO_POSITION){
                listener.onItemClickCard(position)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false))
    }

    override fun onBindViewHolder(holder: NewsCardAdapter.MyHolder, position: Int) {
        var country = newsCard[position]
        holder.comments.text = country.messages
        holder.likes.text = country.likes
        holder.title.text = country.title
        holder.news_company.text = country.news_comp
        holder.news_type.text = country.news_type
        holder.image.setImageResource(country.wallpaper)
        holder.news_company_icon.setImageResource(country.news_icon)
    }

    override fun getItemCount(): Int {
        return newsCard.size
    }
    interface OnItemClickListenerCard {
        fun onItemClickCard(position: Int)
    }
}