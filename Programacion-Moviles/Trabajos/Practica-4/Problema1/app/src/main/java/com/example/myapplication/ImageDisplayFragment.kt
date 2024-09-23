/*
 * Descripción: Fragmento para mostrar la imagen seleccionada
 * Autor: Jhosep
 * Fecha creación: 23 de septiembre del 2024
 * Fecha última modificación: 23 de septiembre del 2024
 */

package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ImageDisplayFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var btnVolver: Button

    companion object {
        private const val ARG_IMAGE_POSITION = "image_position"

        fun newInstance(position: Int): ImageDisplayFragment {
            val fragment = ImageDisplayFragment()
            val args = Bundle()
            args.putInt(ARG_IMAGE_POSITION, position)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_image_display, container, false)

        imageView = view.findViewById(R.id.imageView)
        btnVolver = view.findViewById(R.id.btnVolver)

        val imagenSeleccionada = arguments?.getInt(ARG_IMAGE_POSITION, 0) ?: 0

        val imagenes = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
        )

        imageView.setImageResource(imagenes[imagenSeleccionada])

        btnVolver.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }
}