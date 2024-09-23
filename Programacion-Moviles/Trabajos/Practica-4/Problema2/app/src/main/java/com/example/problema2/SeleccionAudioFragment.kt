/*
 * Descripción: Fragmento para la selección de canciones mediante un spinner
 * Autor: Jhosep
 * Fecha creación: 23 de septiembre del 2024
 * Fecha última modificación: 23 de septiembre del 2024
 */

package com.example.problema2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment

class SeleccionAudioFragment : Fragment() {

    private lateinit var spinnerAudios: Spinner
    private lateinit var btnSeleccionar: Button
    private var listener: AudioSelectionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_seleccion_audio, container, false)

        spinnerAudios = view.findViewById(R.id.spinnerAudios)
        btnSeleccionar = view.findViewById(R.id.btnSeleccionar)

        val audios = arrayOf("Miedo y Fe", "Me tengo que ir", "Treasure", "Rain")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, audios)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAudios.adapter = adapter

        btnSeleccionar.setOnClickListener {
            listener?.onAudioSelected(
                spinnerAudios.selectedItemPosition,
                spinnerAudios.selectedItem.toString()
            )
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AudioSelectionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement AudioSelectionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}

interface AudioSelectionListener {
    fun onAudioSelected(position: Int, nombre: String)
}