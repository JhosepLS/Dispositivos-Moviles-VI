/*
Descripción: Implementación simplificada de una clase Shape y sus subclases Cuadrado, Círculo y Rectángulo
             para calcular área y perímetro de figuras geométricas.
Autor: Jhosep
Fecha creación: 01 de septiembre del 2024, 02:25 pm
Fecha última modificación: 01 de septiembre del 2024, 05:22 pm
*/

// Clase base para las figuras
open class Shape {
    var area: Double = 0.0
    var perimetro: Double = 0.0

    open fun calcularArea() {}
    open fun calcularPerimetro() {}

    fun imprimirResultados() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }
}

// Subclase para representar un cuadrado
class Cuadrado(val lado: Double) : Shape() {
    override fun calcularArea() {
        area = lado * lado
    }

    override fun calcularPerimetro() {
        perimetro = 4 * lado
    }
}

// Subclase para representar un círculo
class Circulo(val radio: Double) : Shape() {
    override fun calcularArea() {
        area = 3.14 * radio * radio
    }

    override fun calcularPerimetro() {
        perimetro = 2 * 3.14 * radio
    }
}

// Subclase para representar un rectángulo
class Rectangulo(val largo: Double, val ancho: Double) : Shape() {
    override fun calcularArea() {
        area = largo * ancho
    }

    override fun calcularPerimetro() {
        perimetro = 2 * (largo + ancho)
    }
}

fun main() {
    // Crea y calcular para un cuadrado
    val cuadrado = Cuadrado(5.0)
    cuadrado.calcularArea()
    cuadrado.calcularPerimetro()
    println("Resultados del Cuadrado:")
    cuadrado.imprimirResultados()

    // Crea y calcular para un círculo
    val circulo = Circulo(3.0)
    circulo.calcularArea()
    circulo.calcularPerimetro()
    println("\nResultados del Círculo:")
    circulo.imprimirResultados()

    // Crea y calcular para un rectángulo
    val rectangulo = Rectangulo(4.0, 6.0)
    rectangulo.calcularArea()
    rectangulo.calcularPerimetro()
    println("\nResultados del Rectángulo:")
    rectangulo.imprimirResultados()
}