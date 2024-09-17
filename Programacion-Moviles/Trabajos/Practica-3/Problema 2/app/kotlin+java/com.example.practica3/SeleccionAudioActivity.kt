/*
 * Descripción: Actividad principal para la selección de canciones
 * Autor: Jhosep
 * Fecha creación: 16 de septiembre del 2024
 * Fecha última modificación: 17 de septiembre del 2024
 */

package com.example.practica3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SeleccionAudioActivity : AppCompatActivity() {

    private lateinit var spinnerAudios: Spinner
    private lateinit var btnSeleccionar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion_audio)

        spinnerAudios = findViewById(R.id.spinnerAudios)
        btnSeleccionar = findViewById(R.id.btnSeleccionar)

        val audios = arrayOf("Miedo y Fe", "Me tengo que ir", "Treasure", "Rain")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, audios)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAudios.adapter = adapter

        btnSeleccionar.setOnClickListener {
            val intent = Intent(this, ReproductorActivity::class.java)
            intent.putExtra("audioSeleccionado", spinnerAudios.selectedItemPosition)
            intent.putExtra("nombreAudio", spinnerAudios.selectedItem.toString())
            startActivity(intent)
        }
    }
}