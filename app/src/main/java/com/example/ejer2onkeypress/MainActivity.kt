package com.example.ejer2onkeypress

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mitexto = findViewById<EditText>(R.id.etTexto)
        val resultTexto = findViewById<TextView>(R.id.tvResultado)

        //Asocio un escuchador a ese editText a traves de
        // la función de extensión definida en Extensiones.kt
        mitexto.despues_cambio_texto {
            var textoAnterior = resultTexto.text.toString()
            var texto = it
            for (i in 0..texto.length) {
                if (textoAnterior.length < texto.length)
                    resultTexto.text = textoAnterior + "_"
                else {
                    if (texto.length == 1) {
                        textoAnterior = ""
                    } else {
                        textoAnterior = resultTexto.text.substring(0, resultTexto.length() - 1)
                    }
                    resultTexto.text = textoAnterior
                }
            }

        }
    }
}