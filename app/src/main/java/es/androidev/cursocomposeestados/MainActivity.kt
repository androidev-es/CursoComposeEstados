package es.androidev.cursocomposeestados

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.androidev.cursocomposeestados.estado_no_estructurado.ItemExampleActivity
import es.androidev.cursocomposeestados.flujo_datos_unidireccional.ItemExampleViewModelActivity
import es.androidev.cursocomposeestados.ui.theme.CursoComposeEstadosTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoComposeEstadosTheme {
                ButtonsNavigationOptions()
            }
        }
    }
}


@Composable
fun ButtonNavigation(textBtn: String, onClickButton: () -> Unit) {
    Button(
        onClick = onClickButton,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = textBtn)
    }
}

@Composable
fun ButtonsNavigationOptions() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        ButtonNavigation("Estado no estructurado") {
            context.startActivity(Intent(context, ItemExampleActivity::class.java))
        }
        ButtonNavigation("Flujo datos unidireccional") {
            context.startActivity(Intent(context, ItemExampleViewModelActivity::class.java))
        }
        ButtonNavigation("Compose + ViewModel") {
            //TODO: StartActivity
        }
        ButtonNavigation("App Task") {
            //TODO: StartActivity
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CursoComposeEstadosTheme {
        ButtonsNavigationOptions()
    }
}