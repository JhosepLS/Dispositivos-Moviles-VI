/*
 * Descripción: Actividad principal que actúa como contenedor para los fragmentos de selección y reproducción de música
 * Autor: Jhosep
 * Fecha creación: 23 de septiembre del 2024
 * Fecha última modificación: 23 de septiembre del 2024
 */

package com.example.practica3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), AudioSelectionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragment_container, SeleccionAudioFragment())
            }
        }
    }

    override fun onAudioSelected(position: Int, nombre: String) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, ReproductorFragment.newInstance(position, nombre))
            addToBackStack(null)
        }
    }
}