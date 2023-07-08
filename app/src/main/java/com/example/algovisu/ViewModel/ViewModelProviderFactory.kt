package com.example.algovisu.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.algovisu.algorithm.InsertionSort

class ViewModelProviderFactory (private var insertionSort: InsertionSort):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return algorithmViewModel(insertionSort) as T
    }
}