package com.example.data.repository.remote.datasourceimpl

import com.example.data.repository.remote.datasource.SplashDataSource
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

// 버전 체크
class SplashDataSourceImpl @Inject constructor(
    private val firebaseRtdb: FirebaseDatabase,
    private val firestore: FirebaseFirestore
): SplashDataSource{
    override fun checkAppVersion(): Task<DataSnapshot> {
        return firebaseRtdb.reference.child("version").get()
    }
}