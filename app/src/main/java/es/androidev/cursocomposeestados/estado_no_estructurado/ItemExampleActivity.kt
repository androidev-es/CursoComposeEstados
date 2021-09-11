package es.androidev.cursocomposeestados.estado_no_estructurado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import es.androidev.cursocomposeestados.R
import es.androidev.cursocomposeestados.databinding.ActivityItemExampleBinding

class ItemExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityItemExampleBinding
    //Variable nombre cuyo estado incial es vacio.
    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "DATOS NO ESTRUCTURADOS"
        binding = ActivityItemExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Evento "doAfterTextChange" se activa cuando sobre la caja de texto el texto cambia
        binding.etInputName.doAfterTextChanged {
            //Cambiamos el estado de la variable
            name = it.toString()
            //Avisamos a la vista de los cambios realizados.
            updateUI()
        }
    }
    private fun updateUI(){
        binding.tvShowName.text = name
    }
}