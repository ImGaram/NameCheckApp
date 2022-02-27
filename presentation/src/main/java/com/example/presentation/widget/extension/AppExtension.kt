package com.example.presentation.widget.extension

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// 쉽게 recyclerView를 쓰기 위한 확장 함수
fun RecyclerView.showVertical(content: Context) {
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}