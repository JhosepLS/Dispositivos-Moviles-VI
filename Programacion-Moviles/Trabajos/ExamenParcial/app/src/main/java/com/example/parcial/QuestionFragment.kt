/**
 * Fragmento de preguntas del juego sobre consolas de videojuegos
 * Autor: Jhosep
 * Fecha Creación: 17/10/2024
 * Fecha última modificación: 19/10/2024
 *
 * Este fragmento muestra las preguntas y opciones de respuesta al usuario.
 * Incluye un temporizador para limitar el tiempo de respuesta.
 */

package com.example.parcial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.parcial.databinding.FragmentQuestionBinding
import android.os.CountDownTimer
import androidx.lifecycle.ViewModelProvider
import androidx.core.content.ContextCompat
import android.graphics.drawable.GradientDrawable

class QuestionFragment : Fragment() {

    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: QuizViewModel
    private lateinit var timer: CountDownTimer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(QuizViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateQuestion()

        binding.submitButton.setOnClickListener {
            checkAnswer()
        }

        styleOptions()
        styleSubmitButton()
        // Inicia el temporizador
        startTimer()
    }

    // Actualiza la interfaz con la pregunta y opciones actuales
    private fun updateQuestion() {
        val currentQuestion = viewModel.getCurrentQuestion()
        binding.questionText.text = currentQuestion.text
        binding.option1.text = currentQuestion.options[0]
        binding.option2.text = currentQuestion.options[1]
        binding.option3.text = currentQuestion.options[2]
        binding.option4.text = currentQuestion.options[3]
    }

    // Verifica la respuesta seleccionada y navega al fragmento de respuesta
    private fun checkAnswer() {
        timer.cancel()
        val selectedOption = when {
            binding.option1.isChecked -> 0
            binding.option2.isChecked -> 1
            binding.option3.isChecked -> 2
            binding.option4.isChecked -> 3
            else -> -1
        }

        if (selectedOption != -1) {
            viewModel.answerQuestion(selectedOption)
            findNavController().navigate(R.id.action_questionFragment_to_answerFragment)
        }
    }

    // Inicia el temporizador para la pregunta actual
    private fun startTimer() {
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timerText.text = "Tiempo: ${millisUntilFinished / 1000}s"
            }

            override fun onFinish() {
                timeUp()
            }
        }.start()
    }

    private fun styleOptions() {
        val options = listOf(binding.option1, binding.option2, binding.option3, binding.option4)
        options.forEach { option ->
            option.setBackgroundResource(R.drawable.option_background)
        }
    }

    private fun styleSubmitButton() {
        binding.submitButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_button)
        (binding.submitButton.background as GradientDrawable).setColor(ContextCompat.getColor(requireContext(), R.color.white))
    }

    private fun timeUp() {
        viewModel.timeUp()
        findNavController().navigate(R.id.action_questionFragment_to_timeUpFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Cancela el temporizador
        timer.cancel()
        _binding = null
    }
}