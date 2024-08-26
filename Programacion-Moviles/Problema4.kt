fun main() {
    println("Bienvenido al juego Adivina el Número!")

    // Genera el número aleatorio entre 1 y 30
    val numeroSecreto = (1..30).random()
    var intentos = 5

    while (intentos > 0) {
        println("Tienes $intentos intentos. Adivina el número (entre 1 y 30):")
        val adivinanza = readln().toIntOrNull()

        if (adivinanza == null) {
            println("Por favor, ingresa un número válido.")
            continue
        }

        if (adivinanza == numeroSecreto) {
            println("¡Felicidades! Has adivinado el número correcto: $numeroSecreto")
            return
        } else if (adivinanza < numeroSecreto) {
            println("El número secreto es mayor.")
        } else {
            println("El número secreto es menor.")
        }

        intentos--
    }

    println("Game Over. El número secreto era $numeroSecreto")
}