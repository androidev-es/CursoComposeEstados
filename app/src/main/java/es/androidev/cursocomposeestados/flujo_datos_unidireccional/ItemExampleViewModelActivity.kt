package es.androidev.cursocomposeestados.flujo_datos_unidireccional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import es.androidev.cursocomposeestados.R
import es.androidev.cursocomposeestados.databinding.ActivityItemExampleViewModelBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ItemExampleViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemExampleViewModelBinding
    private val viewModel by viewModels<ItemExampleViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "FLUJOS DATOS UNIDIRECCIONAL"
        binding = ActivityItemExampleViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Evento "doAfterTextChange" se activa cuando sobre la caja de texto el texto cambia
        binding.etInputName.doAfterTextChanged {
            //Cambiamos el estado de la variable en el ViewModel
            viewModel.onTextChanged(it.toString())
        }

        //Usamos una coroutina para observar con flow cualquier cambio y recoger el estado del cambio
        lifecycleScope.launch {
            viewModel.name.collect {
                //De forma reactiva cualquier cambio realizado sobre el estado de "name" llamará a UpdateUi
                updateUI(it)
            }
        }
    }
    private fun updateUI(name: String){
        binding.tvShowName.text = name
    }
}