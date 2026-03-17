package com.apna.darzi.ui

import androidx.lifecycle.ViewModel
import com.apna.darzi.data.FakeRealtimeRepository
import com.apna.darzi.data.RepositoryProvider
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.onStart

class BuyViewModel : ViewModel() {
    val shops = RepositoryProvider.getRepository()
        .observeShops()
        .onStart { emit(emptyList()) }
        .catch { emitAll(FakeRealtimeRepository.observeShops()) }

class BuyViewModel : ViewModel() {
    val shops = FakeRealtimeRepository.shops
}
