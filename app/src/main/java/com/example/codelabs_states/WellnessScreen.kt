package com.example.codelabs_states

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun WellnessScreen() {
    Column {
        WaterCounter()
        WellnessTodoList()
    }
}