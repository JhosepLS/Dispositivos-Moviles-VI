/*
 * Descripción: Interfaz para manejar la selección de imágenes en el fragmento de selección
 * Autor: Jhosep
 * Fecha creación: 22 de septiembre del 2024
 * Fecha última modificación: 23 de septiembre del 2024
 */

package com.example.myapplication

interface ImageSelectionListener {
    fun onImageSelected(position: Int)
}