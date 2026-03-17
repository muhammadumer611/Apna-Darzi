package com.apna.darzi.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

object FakeRealtimeRepository : AppRepository {
object FakeRealtimeRepository {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    private val _shops = MutableStateFlow(
        listOf(
            ShopItem(1, "Premium Suit Stitching", "Arshad Tailor Studio", 4.7, 3200, 3),
            ShopItem(2, "Wedding Sherwani Design", "Nawab Fashion House", 4.9, 8900, 7),
            ShopItem(3, "Ladies Fancy Dress", "Noor Boutique", 4.6, 4500, 4),
        )
    )
    private val shops: StateFlow<List<ShopItem>> = _shops.asStateFlow()
    val shops: StateFlow<List<ShopItem>> = _shops.asStateFlow()

    private val _chats = MutableStateFlow(
        listOf(
            ChatItem(1, "Arshad Tailor", "Aapka order cutting me chala gaya hai.", "10:45 PM"),
            ChatItem(2, "Noor Boutique", "Kal fitting ready ho jayegi.", "09:20 PM"),
            ChatItem(3, "Nawab House", "Fabric approve kar dein.", "Yesterday"),
        )
    )
    private val chats: StateFlow<List<ChatItem>> = _chats.asStateFlow()
    val chats: StateFlow<List<ChatItem>> = _chats.asStateFlow()

    private val _profile = MutableStateFlow(
        ProfileInfo(
            fullName = "Ali Raza",
            email = "aliraza12@gmail.com",
            dob = "21-Dec-2001",
            phone = "+923012345678",
        )
    )
    private val profile: StateFlow<ProfileInfo> = _profile.asStateFlow()

    override fun observeShops(): StateFlow<List<ShopItem>> = shops

    override fun observeChats(): StateFlow<List<ChatItem>> = chats

    override fun observeProfile(): StateFlow<ProfileInfo> = profile
    val profile: StateFlow<ProfileInfo> = _profile.asStateFlow()

    init {
        startAutoUpdates()
    }

    private fun startAutoUpdates() {
        scope.launch {
            var tick = 1
            while (true) {
                delay(15000)
                tick++

                _shops.update { current ->
                    current.mapIndexed { index, item ->
                        if (index == 0) item.copy(rating = (item.rating + 0.01).coerceAtMost(5.0)) else item
                    }
                }

                _chats.update { current ->
                    listOf(
                        ChatItem(
                            id = 99,
                            name = "System Update",
                            lastMessage = "Live update #$tick: New offers added.",
                            time = "Now",
                        )
                    ) + current.take(4)
                }
            }
        }
    }
}
