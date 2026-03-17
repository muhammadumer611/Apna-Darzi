package com.apna.darzi.data

data class ShopItem(
    val id: Int,
    val title: String,
    val studioName: String,
    val rating: Double,
    val price: Int,
    val deliveryDays: Int,
)

data class ChatItem(
    val id: Int,
    val name: String,
    val lastMessage: String,
    val time: String,
)

data class ProfileInfo(
    val fullName: String,
    val email: String,
    val dob: String,
    val phone: String,
)
