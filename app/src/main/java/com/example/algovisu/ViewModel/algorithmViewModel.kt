package com.example.algovisu.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algovisu.algorithm.InsertionSort
import com.example.algovisu.events.ApplicationEvents
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class algorithmViewModel( private val insertionSort : InsertionSort) : ViewModel() {

    var arr = mutableStateOf(
        intArrayOf(
            100, 120, 80, 55, 40, 5, 25, 320, 80, 23, 534, 64
        )
    )

    val isPlaying = mutableStateOf(false)
    val onSortFinish = mutableStateOf(false)
    private var Delay = 150L
    private var pause = false

    private var Next = 1
    private var Prev = 0

    private var sortedArrayLevel = mutableListOf<List<Int>>()

    init {
        viewModelScope.launch {
            insertionSort.sort(arr.value.clone(), onSwap = { modifiedArr ->
                sortedArrayLevel.add(modifiedArr.toMutableList())
            })
        }
    }

    fun onAction(event : ApplicationEvents){
        when(event){
            is ApplicationEvents.next -> {
                _next()
            }
            is ApplicationEvents.prev -> {
                _prev()
            }
            is ApplicationEvents.playPause -> {
                _playPause()
            }
            is ApplicationEvents.speedUp -> {
                _speedUp()
            }
            is ApplicationEvents.slowDown -> {
                _slowDown()
            }
        }
    }

    private fun _next(){
        if(Next < sortedArrayLevel.size){
            arr.value = sortedArrayLevel[Next].toIntArray()
            Next++
            Prev++
        }
    }

    private fun _prev(){
        if(Prev >=0 ){
            arr.value = sortedArrayLevel[Prev].toIntArray()
            Next--
            Prev--
        }
    }

    private fun _playPause(){
        if(isPlaying.value){
            pause()
        }else{
            play()
        }
        isPlaying.value = !isPlaying.value
    }

    private var level = 0
    private fun play() = viewModelScope.launch{
        pause = false

        for(i in 0 until sortedArrayLevel.size){
            if(!pause){
                delay(Delay)
                arr.value = sortedArrayLevel[i].toIntArray()
            }else{
                level = i
                Next = i + 1
                Prev = i + 1
                return@launch
            }
        }

        onSortFinish.value = true
    }

    private fun pause(){
        pause = true
    }


    private fun _speedUp(){
        if(Delay > 150L)
            Delay -= 50L
    }

    private fun _slowDown(){
        Delay += 50L
    }


}