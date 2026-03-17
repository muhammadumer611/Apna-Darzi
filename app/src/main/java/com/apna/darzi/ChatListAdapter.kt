package com.apna.darzi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apna.darzi.data.ChatItem
import com.apna.darzi.databinding.ChatItemBinding

class ChatListAdapter : RecyclerView.Adapter<ChatListAdapter.ChatViewHolder>() {
    private val items = mutableListOf<ChatItem>()

    fun submitList(newItems: List<ChatItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ChatViewHolder(private val binding: ChatItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChatItem) {
            binding.tvName.text = item.name
            binding.tvSubtitle.text = item.lastMessage
            binding.tvTime.text = item.time
        }
    }
}
