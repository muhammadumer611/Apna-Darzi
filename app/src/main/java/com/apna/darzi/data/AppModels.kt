package com.apna.darzi.data

data class ShopItem(
    val id: Int = 0,
    val title: String = "",
    val studioName: String = "",
    val rating: Double = 0.0,
    val price: Int = 0,
    val deliveryDays: Int = 0,
)

data class ChatItem(
    val id: Int = 0,
    val name: String = "",
    val lastMessage: String = "",
    val time: String = "",
)

data class ProfileInfo(
    val fullName: String = "",
    val email: String = "",
    val dob: String = "",
    val phone: String = "",
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
