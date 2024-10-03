/*
 * Descripción: Actividad principal que maneja la navegación entre fragmentos
 * Autor: Assistant
 * Fecha creación: 3 de octubre del 2024
 * Fecha última modificación: 3 de octubre del 2024
 */

package com.example.practica5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), AudioSelectionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SeleccionAudioFragment())
                .commit()
        }
    }

    override fun onAudioSelected(audio: Audio) {
        val fragment = ReproductorFragment.newInstance(audio)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}