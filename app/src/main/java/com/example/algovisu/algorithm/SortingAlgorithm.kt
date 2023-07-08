package com.example.algovisu.algorithm

abstract class SortingAlgorithm {
    abstract suspend fun sort(
        arr: IntArray,
        //iChange: (Int) -> Unit,
        //jChange: (Int) -> Unit,
        onSwap: (IntArray) -> Unit
    )
}