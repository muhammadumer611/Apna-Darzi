package com.apna.darzi.ui

import androidx.lifecycle.ViewModel
import com.apna.darzi.data.FakeRealtimeRepository

class ChatViewModel : ViewModel() {
    val chats = FakeRealtimeRepository.chats
}
