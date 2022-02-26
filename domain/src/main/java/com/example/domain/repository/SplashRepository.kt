package com.example.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface SplashRepository {
    fun checkAppVersion(): Task<DataSnapshot>
}