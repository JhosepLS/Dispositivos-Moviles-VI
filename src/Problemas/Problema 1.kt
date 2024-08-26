package Problemas

fun main() {
    println("Bienvenido al sistema de evaluación de empleados")

    // Parte donde se coloca la entrada y tiene una validación para números no válidos
    println("Por favor, ingrese su salario mensual:")
    val salarioTexto = readln()
    val salario: Double
    try {
        salario = salarioTexto.toDouble()
    } catch (e: NumberFormatException) {
        println("Error: El salario debe ser un número válido.")
        return
    }

    // Parte donde se coloca la entrada y se valida la puntuación
    println("Por favor, ingrese su puntuación (0-10):")
    val puntuacionTexto = readln()
    val puntuacion: Double
    try {
        puntuacion = puntuacionTexto.toDouble()
    } catch (e: NumberFormatException) {
        println("Error: La puntuación debe ser un número válido entre 0 y 10.")
        return
    }

    // Parte para determinar el nivel de rendimiento basado en la puntuación
    var nivel = ""
    if (puntuacion >= 0 && puntuacion <= 3) {
        nivel = "Inaceptable"
    } else if (puntuacion >= 4 && puntuacion <= 6) {
        nivel = "Aceptable"
    } else if (puntuacion >= 7 && puntuacion <= 10) {
        nivel = "Meritorio"
    } else {
        nivel = "Puntuación inválida"
    }

    // Parte donde se calcula el dinero recibido y se muestra los resultados
    if (nivel != "Puntuación inválida") {
        val dineroRecibido = salario * (puntuacion / 10)

        println("Resultados de la evaluación:")
        println("Nivel de Rendimiento: $nivel")
        println("Cantidad de Dinero Recibido: $$dineroRecibido")
    } else {
        println("Error: La puntuación debe estar entre 0 y 10.")
    }
}
