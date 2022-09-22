package com.example.codelabs_states

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codelabs_states.ui.viewModel.WellnessViewModel

@Composable
fun WellnessTodoList(
    wellnessViewModel: WellnessViewModel = WellnessViewModel()
) {
    Surface(
        modifier = Modifier.padding(8.dp),
        elevation = 5.dp
    ) {
        LazyColumn {
            items(wellnessViewModel.tasksList, key = { it }) { item ->
                WellnessTaskItem(
                    item
                ) { task ->
                    wellnessViewModel.removeItem(task)
                }
            }
        }
    }
}

