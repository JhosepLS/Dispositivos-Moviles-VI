fun main() {
    println("Bienvenido al juego de Piedra, Papel o Tijera")

    // Opciones de la computadora
    val opciones = arrayOf("piedra", "papel", "tijera")

    while (true) {
        println("Elige tu opción (1: piedra, 2: papel, 3: tijera) o escribe directamente 'piedra', 'papel' o 'tijera':")
        val eleccionUsuarioTexto = readln().toLowerCase()

        // Convertir números a texto si fuera necesario
        val eleccionUsuario = when (eleccionUsuarioTexto) {
            "1" -> "piedra"
            "2" -> "papel"
            "3" -> "tijera"
            "piedra", "papel", "tijera" -> eleccionUsuarioTexto
            else -> {
                println("Error: Opción inválida. Por favor, elige 'piedra', 'papel', 'tijera', 1, 2 o 3.")
                continue
            }
        }

        // Generar la elección de la computadora
        val indiceAleatorio = (0..2).random()
        val eleccionComputadora = opciones[indiceAleatorio]

        // Mostrar elecciones del usuario y la computadora
        println("Tu elección: $eleccionUsuario")
        println("Elección de la computadora: $eleccionComputadora")

        // Determinar el resultado
        val resultado = when {
            eleccionUsuario == eleccionComputadora -> "Empate"
            (eleccionUsuario == "piedra" && eleccionComputadora == "tijera") ||
            (eleccionUsuario == "papel" && eleccionComputadora == "piedra") ||
            (eleccionUsuario == "tijera" && eleccionComputadora == "papel") -> "Ganaste"
            else -> "Perdiste"
        }

        println("Resultado: $resultado")

        // Preguntar si se desea jugar de nuevo
        println("¿Quieres jugar de nuevo? (si/no):")
        val jugarDeNuevo = readln().toLowerCase()
        if (jugarDeNuevo != "si") {
            break
        }
    }
    println("Gracias por jugar")
}
