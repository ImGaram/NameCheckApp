package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataLoveResponse
import com.example.data.remote.model.DataScore
import com.example.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot

interface MainDataSource {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ): DataLoveResponse?

//    fun getStatistics(): Task<DataSnapshot>
//
//    fun setStatistics(plusResult: Int): Task<Void>
//
//    fun setScore(score: DataScore): Task<Void>
//
//    fun getScore(): Task<QuerySnapshot>
}