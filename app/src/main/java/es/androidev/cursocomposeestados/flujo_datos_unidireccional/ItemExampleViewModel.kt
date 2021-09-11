package es.androidev.cursocomposeestados.flujo_datos_unidireccional

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItemExampleViewModel: ViewModel() {

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    fun onTextChanged(newName: String){
        _name.value = newName
    }

}