package es.androidev.cursocomposeestados.tareas_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import es.androidev.cursocomposeestados.tareas_app.ui.theme.CursoComposeEstadosTheme

class TaskActivity : ComponentActivity() {

    val taskViewModel by viewModels<TaskViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenTask(itemsTask = taskViewModel.listTask, onAddTask = taskViewModel::addTask)
        }
    }
}
