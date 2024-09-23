/*
 * Descripción: Actividad principal que actúa como contenedor para los fragmentos de selección y visualización de imágenes
 * Autor: Jhosep
 * Fecha creación: 22 de septiembre del 2024
 * Fecha última modificación: 23 de septiembre del 2024
 */

package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), ImageSelectionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, ImageSelectionFragment())
            }
        }
    }

    override fun onImageSelected(position: Int) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, ImageDisplayFragment.newInstance(position))
            addToBackStack(null)
        }
    }
}