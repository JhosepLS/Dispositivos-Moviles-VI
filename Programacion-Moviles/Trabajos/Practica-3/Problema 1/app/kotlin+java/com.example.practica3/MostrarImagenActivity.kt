/*
 * Descripción: Actividad para mostrar la imagen seleccionada
 * Autor: Jhosep
 * Fecha creación: 15 de septiembre del 2024
 * Fecha última modificación: 16 de septiembre del 2024
 */

package com.example.practica3

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MostrarImagenActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_imagen)

        imageView = findViewById(R.id.imageView)
        btnVolver = findViewById(R.id.btnVolver)

        val imagenSeleccionada = intent.getIntExtra("imagenSeleccionada", 0)

        val imagenes = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
        )

        imageView.setImageResource(imagenes[imagenSeleccionada])

        btnVolver.setOnClickListener {
            finish()
        }
    }
}