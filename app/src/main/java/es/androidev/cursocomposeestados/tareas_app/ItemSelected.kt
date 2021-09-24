package es.androidev.cursocomposeestados.tareas_app

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemSelected(
    val borderWidth: Int = 0,
    val color: Color = Color.Transparent
): Parcelable
