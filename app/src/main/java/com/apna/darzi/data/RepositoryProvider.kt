package com.apna.darzi.data

object RepositoryProvider {
    @Volatile
    private var repository: AppRepository = FakeRealtimeRepository

    fun initialize(useFirebase: Boolean) {
        repository = if (useFirebase) {
            FirestoreRepository()
        } else {
            FakeRealtimeRepository
        }
    }

    fun getRepository(): AppRepository = repository
}
