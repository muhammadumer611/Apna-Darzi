package com.apna.darzi.ui

import androidx.lifecycle.ViewModel
import com.apna.darzi.data.FakeRealtimeRepository
import com.apna.darzi.data.ProfileInfo
import com.apna.darzi.data.RepositoryProvider
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.onStart

class ProfileViewModel : ViewModel() {
    val profile = RepositoryProvider.getRepository()
        .observeProfile()
        .onStart { emit(ProfileInfo()) }
        .catch { emitAll(FakeRealtimeRepository.observeProfile()) }
}
