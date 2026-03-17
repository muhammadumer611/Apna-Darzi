package com.apna.darzi

import android.app.Application
import com.apna.darzi.data.RepositoryProvider
import com.google.firebase.FirebaseApp

class ApnaDarziApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val firebaseReady = try {
            FirebaseApp.initializeApp(this) != null || FirebaseApp.getApps(this).isNotEmpty()
        } catch (_: Exception) {
            false
        }

        RepositoryProvider.initialize(useFirebase = firebaseReady)
    }
}
