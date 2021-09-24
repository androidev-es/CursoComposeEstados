package es.androidev.cursocomposeestados.compose_viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItemViewModel: ViewModel() {

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    fun onTextChanged(newName: String){
        _name.value = newName
    }

}