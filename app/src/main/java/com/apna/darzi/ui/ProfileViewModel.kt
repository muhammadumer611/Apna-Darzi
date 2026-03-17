package com.apna.darzi.ui

import androidx.lifecycle.ViewModel
import com.apna.darzi.data.FakeRealtimeRepository

class ProfileViewModel : ViewModel() {
    val profile = FakeRealtimeRepository.profile
}
