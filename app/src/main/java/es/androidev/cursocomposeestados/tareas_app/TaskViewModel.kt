package es.androidev.cursocomposeestados.tareas_app

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {

    var listTask = mutableStateListOf<Task>()

    fun addTask(task: Task){
        listTask.add(task)
    }
}