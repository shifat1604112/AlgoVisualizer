package com.example.algovisu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VisualizerSec(
    modifier : Modifier = Modifier,
    arr: IntArray
){
    BoxWithConstraints(modifier = modifier) {
        val maxHeight = maxHeight - 75.dp
        val itemWidth = remember {
            maxWidth / arr.size - 8.dp
        }

        Row( modifier = modifier , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
            arr.forEach {
                Box(modifier = Modifier
                    .height(if (it.dp > maxHeight) maxHeight else it.dp)
                    .width(itemWidth)
                    .background(MaterialTheme.colors.secondary)
                )
            }
        }
    }

}