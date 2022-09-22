package com.example.codelabs_states

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter() {
    //Variables
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    val message = when {
        count != 0 -> {
            "You've had $count glasses of water today."
        }
        count == 1 -> {
            "You've had $count glass of water today!"
        }
        else -> {
            "You've had no glasses today!\nGo drink one right now!!"
        }
    }
    StatelessCounter(
        message = message,
        onIncrement = {
            count++
        }
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun StatelessCounter(
    message: String,
    onIncrement: () -> Unit,
) {
    //Components
    Surface(
        modifier = Modifier.padding(
            bottom = 8.dp
        ),
        shape = RoundedCornerShape(bottomStartPercent = 10, bottomEndPercent = 10),
        elevation = 5.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth()
        ) {
            AnimatedContent(
                targetState = message,
                transitionSpec = {
                    addAnimation().using(
                        SizeTransform(clip = true)
                    )
                }
            ) { targetCount ->
                Text(
                    text = targetCount,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(40.dp)
                        .padding(top = 8.dp)
                )
            }
            Button(
                onClick = {
                    onIncrement()
                },
                modifier = Modifier.padding(top = 8.dp)
            )
            {
                Text("Add one cup")
            }
        }
    }
}

@ExperimentalAnimationApi
fun addAnimation(duration: Int = 400): ContentTransform {
    return slideInVertically(animationSpec = tween(durationMillis = duration)) { height ->
        height
    } + fadeIn(
        animationSpec = tween(durationMillis = duration)
    ) with slideOutVertically(animationSpec = tween(durationMillis = duration)) { height ->
        -height
    } + fadeOut(
        animationSpec = tween(durationMillis = duration)
    )
}