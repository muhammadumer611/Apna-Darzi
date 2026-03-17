package com.apna.darzi.ui

import androidx.lifecycle.ViewModel
import com.apna.darzi.data.FakeRealtimeRepository

class BuyViewModel : ViewModel() {
    val shops = FakeRealtimeRepository.shops
}
