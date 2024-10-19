/**
 * Juego de preguntas y respuestas sobre consolas de videojuegos
 * Autor: Jhosep
 * Fecha Creación: 18/10/2024
 * Fecha última modificación: 19/10/2024
 *
 * Esta actividad principal maneja la navegación entre fragmentos y el estado del juego.
 * Se asegura de que el estado del juego se mantenga al girar el dispositivo.
 */

package com.example.parcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    // Maneja la navegación hacia atras
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}