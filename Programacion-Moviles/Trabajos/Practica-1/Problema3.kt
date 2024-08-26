fun main() {
    var continuar = true
    
    // Menú donde el usuario elegirá la operación
    while (continuar) {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        
        println("Elige una opción (1-5):")
        val opcion = readln()
        
        if (opcion == "5") {
            continuar = false
            println("Gracias por usar la calculadora. ¡Hasta luego!")
        } else if (opcion == "1" || opcion == "2" || opcion == "3" || opcion == "4") {
            val num1: Double
            val num2: Double

            // Captura el primer número
            while (true) {
                try {
                    println("Ingresa el primer número:")
                    num1 = readln().toDouble()
                    break
                } catch (e: NumberFormatException) {
                    println("Error: Por favor, ingresa un número válido.")
                }
            }

            // Captura el segundo número
            while (true) {
                try {
                    println("Ingresa el segundo número:")
                    num2 = readln().toDouble()
                    break
                } catch (e: NumberFormatException) {
                    println("Error: Por favor, ingresa un número válido.")
                }
            }

            var resultado = 0.0
            
            // Realiza la operación según la opción
            when (opcion) {
                "1" -> {
                    resultado = num1 + num2
                    println("Resultado de la suma: $resultado")
                }
                "2" -> {
                    resultado = num1 - num2
                    println("Resultado de la resta: $resultado")
                }
                "3" -> {
                    resultado = num1 * num2
                    println("Resultado de la multiplicación: $resultado")
                }
                "4" -> {
                    if (num2 != 0.0) {
                        resultado = num1 / num2
                        println("Resultado de la división: $resultado")
                    } else {
                        println("Error: No se puede dividir por cero")
                    }
                }
            }
        } else {
            println("Opción no válida. Por favor, elige una opción del 1 al 5.")
        }
        
        println()
    }
}
