package es.androidev.cursocomposeestados.tareas_app

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ScreenTask(
    modifier: Modifier = Modifier,
    itemsTask: List<Task>,
    onAddTask: (Task) -> Unit
) {
    repeat(20){
        onAddTask(Task("Item $it"))
    }
    Column(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        TaskAdd(onAddTask)
        Divider(color= Color.Transparent, thickness = 8.dp)
        ListTask(itemsTask)
    }

}

@Composable
fun TaskAdd(
    onAddTask: (Task) -> Unit
) {
    val nameNewTask = remember { mutableStateOf("") }

    Column() {
        TextField(
            value = nameNewTask.value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { nameNewTask.value = it },
            label = { Text("Introduce una nueva tarea") }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onClick = {
                onAddTask(Task(nameNewTask.value))
                nameNewTask.value = ""
            }

        ) {
            Text(text = "Add")
        }
    }
}
@Composable
fun ListTask(itemsTask: List<Task>){
    LazyColumn{
        items(itemsTask){
            ItemTask(it)
        }
    }
}
@Composable
fun ItemTask(task: Task){
    var itemSelectedData = rememberSaveable { mutableStateOf(ItemSelected())}

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                itemSelectedData.value = ItemSelected(3, Color.Red)
            },
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(
            itemSelectedData.value.borderWidth.dp,
            itemSelectedData.value.color
        ),
        elevation = 10.dp

    ){
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(task.name)
        }

    }
}

@Preview
@Composable
fun TaskScreenPreview(){
    val itemsTask = MutableList(100){
        Task("Task $it")
    }
    ScreenTask(itemsTask = itemsTask, onAddTask = {})
}