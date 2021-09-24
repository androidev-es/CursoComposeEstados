package es.androidev.cursocomposeestados.compose_viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ItemScreen(viewModel: ItemViewModel = viewModel()) {

    val name: String by viewModel.name.collectAsState("")
    ItemInput(name = name, onNameChange = { viewModel.onTextChanged(it)})
}



@Composable
fun ItemInput(
    modifier: Modifier = Modifier,
    name: String,
    onNameChange: (String) -> Unit
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(),
    verticalArrangement = Arrangement.Center) {

        Text(name)
        Divider(color = MaterialTheme.colors.surface, thickness= 20.dp)
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name")}
        )
    }

}

@Preview
@Composable
fun ItemPreview(){
    ItemScreen()
}