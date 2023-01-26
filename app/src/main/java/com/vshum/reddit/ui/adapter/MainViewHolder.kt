package com.vshum.reddit.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.vshum.reddit.entities.PostData
import com.vshum.reddit.databinding.ItemListBinding
import com.vshum.reddit.extesions.asString
import java.util.*

class MainViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    /** Отобразить данные по посту */
    fun setData(postData: PostData) {
        with(binding) {
            title.text = postData.title
            commentCount.text = postData.comments.toString()
            favoriteCount.text = postData.favorites.toString()
            val dateText = "${Date(postData.created * 1000).asString("dd.MM.yyyy HH:mm")} " +
                    "[${postData.name}]"
            date.text =dateText
        }
    }
}