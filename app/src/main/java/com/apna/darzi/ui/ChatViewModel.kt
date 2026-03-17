package com.apna.darzi.ui

import androidx.lifecycle.ViewModel
import com.apna.darzi.data.FakeRealtimeRepository
import com.apna.darzi.data.RepositoryProvider
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.onStart

class ChatViewModel : ViewModel() {
    val chats = RepositoryProvider.getRepository()
        .observeChats()
        .onStart { emit(emptyList()) }
        .catch { emitAll(FakeRealtimeRepository.observeChats()) }

class ChatViewModel : ViewModel() {
    val chats = FakeRealtimeRepository.chats
}
