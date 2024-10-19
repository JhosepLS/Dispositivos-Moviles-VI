/**
 * ViewModel para el juego de preguntas sobre consolas de videojuegos
 * Autor: Jhosep
 * Fecha Creación: 18/10/2024
 * Fecha última modificación: 19/10/2024
 *
 * Este ViewModel maneja la lógica del juego y almacena el estado,
 * asegurando que se mantenga la información al girar el dispositivo.
 */

package com.example.parcial

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    // Lista de preguntas del juego
    private val questions = listOf(
        Question(
            "¿Cuál fue la primera consola de videojuegos de Nintendo?",
            listOf("NES", "SNES", "Nintendo 64", "GameCube"),
            0,
            "La Nintendo Entertainment System (NES) fue lanzada en 1985 y fue la primera consola de videojuegos de Nintendo."
        ),
        Question(
            "¿Qué compañía desarrolló la PlayStation?",
            listOf("Microsoft", "Nintendo", "Sega", "Sony"),
            3,
            "Sony desarrolló y lanzó la primera PlayStation en 1994."
        ),
        Question(
            "¿Cuál de estas consolas NO es de Microsoft?",
            listOf("Xbox", "Xbox 360", "Xbox One", "Dreamcast"),
            3,
            "Dreamcast fue una consola desarrollada por Sega, no por Microsoft."
        ),
        Question(
            "¿En qué año se lanzó la Nintendo Switch?",
            listOf("2015", "2016", "2017", "2018"),
            2,
            "La Nintendo Switch fue lanzada el 3 de marzo de 2017."
        ),
        Question(
            "¿Cuál fue la primera consola en utilizar discos ópticos como medio principal?",
            listOf("PlayStation", "Sega Saturn", "Nintendo 64", "Atari Jaguar"),
            1,
            "La Sega Saturn, lanzada en 1994, fue la primera consola en utilizar discos ópticos como medio principal de almacenamiento."
        )
    )

    private var currentQuestionIndex = 0
    private var score = 0
    private var lastAnswerIndex = -1

    fun getCurrentQuestion(): Question = questions[currentQuestionIndex]

    // Responder a la pregunta actual
    fun answerQuestion(answerIndex: Int) {
        lastAnswerIndex = answerIndex
        if (answerIndex == getCurrentQuestion().correctAnswer) {
            score++
        }
    }

    // Mover a la siguiente pregunta
    fun moveToNextQuestion(): Boolean {
        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            return true
        }
        return false
    }

    fun getLastAnswerIndex(): Int = lastAnswerIndex

    // Obtener la puntuación actual
    fun getScore(): Int = score

    // Obtener la cantidad de preguntas
    fun getTotalQuestions(): Int = questions.size

    // Reiniciar el juego
    fun restartGame() {
        currentQuestionIndex = 0
        score = 0
        lastAnswerIndex = -1
    }
}

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: Int,
    val explanation: String
)