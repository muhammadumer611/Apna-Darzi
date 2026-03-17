package com.apna.darzi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apna.darzi.data.ShopItem
import com.apna.darzi.databinding.ItemBuyBinding

class ShopAdapter : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {
    private val items = mutableListOf<ShopItem>()

    fun submitList(newItems: List<ShopItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding = ItemBuyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ShopViewHolder(private val binding: ItemBuyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ShopItem) {
            binding.shopTitle.text = item.title
            binding.studioName.text = item.studioName
            binding.ratingText.text = item.rating.toString()
            binding.tvPrice.text = "PKR ${item.price}"
            binding.tvDelivery.text = "${item.deliveryDays} Days Delivery"
        }
    }
}
