/**
 * Fragmento de respuestas del juego sobre consolas de videojuegos
 * Autor: Jhosep
 * Fecha Creación: 18/10/2024
 * Fecha última modificación: 19/10/2024
 *
 * Este fragmento muestra la retroalimentación sobre la respuesta seleccionada
 * y permite al usuario pasar a la siguiente pregunta o finalizar el juego.
 */

package com.example.parcial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.parcial.databinding.FragmentAnswerBinding
import androidx.lifecycle.ViewModelProvider

class AnswerFragment : Fragment() {

    private var _binding: FragmentAnswerBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAnswerBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(QuizViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentQuestion = viewModel.getCurrentQuestion()
        val userAnswer = viewModel.getLastAnswerIndex()

        // Mostrar si la respuesta es correcta o incorrecta
        binding.resultText.text = if (userAnswer == currentQuestion.correctAnswer) "¡Correcto!" else "Incorrecto"
        // Mostrar la explicación de la respuesta correcta
        binding.explanationText.text = currentQuestion.explanation

        binding.nextButton.setOnClickListener {
            if (viewModel.moveToNextQuestion()) {
                // Si hay más preguntas, navegar al fragmento de preguntas
                findNavController().navigate(R.id.action_answerFragment_to_questionFragment)
            } else {
                // Si no hay más preguntas, navegar al fragmento de resultados
                findNavController().navigate(R.id.action_answerFragment_to_resultFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}