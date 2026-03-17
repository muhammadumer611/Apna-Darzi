package com.apna.darzi.data

import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun observeShops(): Flow<List<ShopItem>>
    fun observeChats(): Flow<List<ChatItem>>
    fun observeProfile(): Flow<ProfileInfo>
}
