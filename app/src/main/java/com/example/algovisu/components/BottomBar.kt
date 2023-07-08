package com.example.algovisu.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.algovisu.R

@Composable
fun BottomBar(
    modifier : Modifier = Modifier,
    playPauseClick : () -> Unit,
    slowClick : () -> Unit,
    fastClick : () -> Unit,
    prevClick : () -> Unit,
    nextClick : () -> Unit,
    isPlaying : Boolean = false
) {
    BottomAppBar( modifier = modifier , backgroundColor = MaterialTheme.colors.surface ) {
        
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            
            IconButton(onClick = slowClick ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_horizontal),
                    contentDescription = "Slow Down",
                    tint = MaterialTheme.colors.onSurface
                )
            }

            IconButton(onClick = playPauseClick ) {
                Icon(
                    painter = painterResource(id = if(isPlaying) R.drawable.ic_pause else R.drawable.ic_play),
                    contentDescription = "Play Pause",
                    tint = MaterialTheme.colors.onSurface
                )
            }

            IconButton(onClick = fastClick ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_forward),
                    contentDescription = "Go Fast",
                    tint = MaterialTheme.colors.onSurface
                )
            }

            IconButton(onClick = prevClick ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_left_arrow),
                    contentDescription = "Previous",
                    tint = MaterialTheme.colors.onSurface
                )
            }

            IconButton(onClick = nextClick ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "Next",
                    tint = MaterialTheme.colors.onSurface
                )
            }

        }
        
    }



}