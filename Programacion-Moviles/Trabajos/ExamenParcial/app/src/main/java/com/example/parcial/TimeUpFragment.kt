/**
 * Fragmento para el tiempo acabado en las preguntas
 * Autor: Jhosep
 * Fecha Creación: 19/10/2024
 * Fecha última modificación: 19/10/2024
 *
 * Este fragmento se encargará de dar una pantalla de tiempo acabado al acabarse los 30 segundos
 */

package com.example.parcial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.parcial.databinding.FragmentTimeUpBinding

class TimeUpFragment : Fragment() {

    private var _binding: FragmentTimeUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTimeUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_timeUpFragment_to_questionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}