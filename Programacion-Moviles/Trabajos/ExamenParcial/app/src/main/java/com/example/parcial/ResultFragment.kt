/**
 * Fragmento de resultados del juego sobre consolas de videojuegos
 * Autor: Jhosep
 * Fecha Creación: 18/10/2024
 * Fecha última modificación: 19/10/2024
 *
 * Este fragmento muestra el resultado final del juego y permite reiniciarlo.
 */

package com.example.parcial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.parcial.databinding.FragmentResultBinding
import androidx.lifecycle.ViewModelProvider

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(QuizViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener la puntuación final
        val score = viewModel.getScore()
        val totalQuestions = viewModel.getTotalQuestions()

        // Mostrar la puntuación final
        binding.scoreText.text = "Puntuación: $score de $totalQuestions"

        binding.restartButton.setOnClickListener {
            // Reiniciar el juego
            viewModel.restartGame()
            // Navegar de vuelta al fragmento de bienvenida
            findNavController().navigate(R.id.action_resultFragment_to_welcomeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}