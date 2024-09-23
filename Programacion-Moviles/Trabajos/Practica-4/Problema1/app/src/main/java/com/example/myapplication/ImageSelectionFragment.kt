/*
 * Descripción: Fragmento para la selección de imágenes mediante un spinner
 * Autor: Jhosep
 * Fecha creación: 23 de septiembre del 2024
 * Fecha última modificación: 23 de septiembre del 2024
 */

package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment

class ImageSelectionFragment : Fragment() {

    private lateinit var spinner: Spinner
    private lateinit var btnSiguiente: Button
    private var listener: ImageSelectionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_image_selection, container, false)

        spinner = view.findViewById(R.id.spinnerImagenes)
        btnSiguiente = view.findViewById(R.id.btnSiguiente)

        val imagenes = arrayOf("Imagen 1", "Imagen 2", "Imagen 3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, imagenes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btnSiguiente.setOnClickListener {
            listener?.onImageSelected(spinner.selectedItemPosition)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ImageSelectionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement ImageSelectionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.getInt("spinnerSelection")?.let {
            spinner.setSelection(it)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("spinnerSelection", spinner.selectedItemPosition)
    }
}