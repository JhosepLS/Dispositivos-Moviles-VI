/*
 * Descripción: Actividad principal para la selección de imágenes mediante un spinner
 * Autor: Jhosep
 * Fecha creación: 15 de septiembre del 2024
 * Fecha última modificación: 16 de septiembre del 2024
 */

package com.example.practica3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class InteraccionImagenes : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var btnSiguiente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interaccion_imagenes)

        spinner = findViewById(R.id.spinnerImagenes)
        btnSiguiente = findViewById(R.id.btnSiguiente)

        // Se configura el spinner con los nombres de las imágenes
        val imagenes = arrayOf("Imagen 1", "Imagen 2", "Imagen 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imagenes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btnSiguiente.setOnClickListener {
            val intent = Intent(this, MostrarImagenActivity::class.java)
            intent.putExtra("imagenSeleccionada", spinner.selectedItemPosition)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("spinnerSelection", spinner.selectedItemPosition)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        spinner.setSelection(savedInstanceState.getInt("spinnerSelection", 0))
    }
}