/**
 * Fragmento de bienvenida del juego de preguntas sobre consolas de videojuegos
 * Autor: Jhosep
 * Fecha Creación: 17/10/2024
 * Fecha última modificación: 19/10/2024
 *
 * Este fragmento muestra la pantalla de bienvenida con una breve explicación del juego.
 */

package com.example.parcial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.parcial.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Se infla el layout para este fragmento
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Se configura el listener para el botón de inicio
        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_questionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}