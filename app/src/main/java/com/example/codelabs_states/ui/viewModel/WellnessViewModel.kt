package com.example.codelabs_states.ui.viewModel

import androidx.compose.runtime.toMutableStateList
import com.example.codelabs_states.model.WellnessTask

class WellnessViewModel {
    private val _tasksList = getWellnessTasks().toMutableStateList()
    val tasksList: List<WellnessTask>
        get() = _tasksList

    fun removeItem(task: WellnessTask) {
        _tasksList.remove(task)
    }
}

private fun getWellnessTasks() = List(30) { item ->
    WellnessTask(item, "Task $item")
}