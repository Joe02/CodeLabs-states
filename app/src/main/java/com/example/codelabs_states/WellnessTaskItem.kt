package com.example.codelabs_states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codelabs_states.model.WellnessTask

@Composable
fun WellnessTaskItem(
    task: WellnessTask,
    removeTask: (WellnessTask) -> Unit,
) {
    var checkedState by rememberSaveable { mutableStateOf(false) }
    StatelessWellnessTaskItem(
        task = task,
        checked = checkedState,
        onCheckedChange = { newValue -> checkedState = newValue },
        onClose = removeTask
    )
}

@Composable
private fun StatelessWellnessTaskItem(
    task: WellnessTask,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: (WellnessTask) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 12.dp, end = 4.dp)
    ) {
        Text(
            task.label,
            modifier = Modifier.weight(1f),

        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.padding(all = 0.dp)
        )
        IconButton(onClick = {
            onClose(task)
        }
        ) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}