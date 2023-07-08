package com.example.algovisu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.algovisu.ViewModel.ViewModelProviderFactory
import com.example.algovisu.ViewModel.algorithmViewModel
import com.example.algovisu.algorithm.InsertionSort
import com.example.algovisu.components.BottomBar
import com.example.algovisu.components.VisualizerSec
import com.example.algovisu.events.ApplicationEvents
import com.example.algovisu.ui.theme.AlgoVisuTheme

class MainActivity : ComponentActivity() {

    private val viewModel : algorithmViewModel by lazy {
        val viewModelProviderFactory = ViewModelProviderFactory(InsertionSort())
        ViewModelProvider(this, viewModelProviderFactory) [algorithmViewModel :: class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgoVisuTheme {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.onPrimary),
                    contentAlignment =  Alignment.BottomCenter
                ){
                    
                    Column {

                        VisualizerSec(
                            arr = viewModel.arr.value,
                            modifier = Modifier.fillMaxWidth()
                        )

                        val _isPlaying = viewModel.isPlaying.value
                        val _isFinish = viewModel.onSortFinish.value

                        BottomBar(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(75.dp),
                            playPauseClick = { viewModel.onAction(ApplicationEvents.playPause) },
                            slowClick = { viewModel.onAction(ApplicationEvents.slowDown) },
                            fastClick = { viewModel.onAction(ApplicationEvents.speedUp) },
                            prevClick = { viewModel.onAction(ApplicationEvents.prev) },
                            nextClick = { viewModel.onAction(ApplicationEvents.next) },
                            isPlaying = if (_isFinish) !_isFinish else _isPlaying
                        )

                    }
                }

            }
        }
    }
}
