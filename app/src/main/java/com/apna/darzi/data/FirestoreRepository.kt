package com.apna.darzi.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class FirestoreRepository(
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance(),
) : AppRepository {

    override fun observeShops(): Flow<List<ShopItem>> = callbackFlow {
        val registration = firestore.collection("shops")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }

                val data = snapshot?.documents?.mapNotNull { document ->
                    document.toObject(ShopItem::class.java)
                }.orEmpty()

                trySend(data)
            }

        awaitClose { registration.remove() }
    }

    override fun observeChats(): Flow<List<ChatItem>> = callbackFlow {
        val registration = firestore.collection("chats")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }

                val data = snapshot?.documents?.mapNotNull { document ->
                    document.toObject(ChatItem::class.java)
                }.orEmpty()

                trySend(data)
            }

        awaitClose { registration.remove() }
    }

    override fun observeProfile(): Flow<ProfileInfo> = callbackFlow {
        val registration = firestore.collection("profiles")
            .document("current_user")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }

                val profile = snapshot?.toObject(ProfileInfo::class.java) ?: ProfileInfo()
                trySend(profile)
            }

        awaitClose { registration.remove() }
    }
}
