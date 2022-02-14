package com.example.newapp.data.remote

import com.example.newapp.data.model.Soccer
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class SoccerDataSource {

    suspend fun getLatestCourt(): Result<List<Soccer>> {
        val courtList = mutableListOf<Soccer>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("canchas").get().await()
        for (court in querySnapshot.documents) {
            court.toObject(Soccer::class.java)?.let {
                courtList.add(it)
            }
        }
        return Result.success(courtList)
    }
}