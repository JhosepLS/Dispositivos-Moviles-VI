/*
Descripción: Implementación de una clase Producto con precio, descuento y método para calcular el precio final.
Autor: Jhosep
Fecha creación: 01 de septiembre del 2024, 02:25 pm
Fecha última modificación: 01 de septiembre del 2024, 04:15 pm
*/

class Producto(precioInicial: Double) {
    private var precio: Double = precioInicial
    private var descuento: Double = 0.0

    // Métodos get y set
    fun getPrecio(): Double {
        return precio
    }

    fun setPrecio(valor: Double) {
        if (valor >= 0) {
            precio = valor
        } else {
            println("Error: El precio no puede ser negativo.")
        }
    }

    fun getDescuento(): Double {
        return descuento
    }

    fun setDescuento(valor: Double) {
        if (valor in 0.0..100.0) {
            descuento = valor
        } else {
            println("Error: El descuento debe estar entre 0 y 100.")
        }
    }

    // Método para calcular el precio final después de aplicar el descuento
    fun calcularPrecioFinal(): Double {
        val precioConDescuento = precio - (precio * descuento / 100)
        return precioConDescuento
    }
}

fun main() {
    val producto = Producto(100.0)
    
    println("Precio inicial: ${producto.getPrecio()}")
    
    producto.setDescuento(20.0)
    println("Descuento aplicado: ${producto.getDescuento()}%")
    
    val precioFinal = producto.calcularPrecioFinal()
    println("Precio final después del descuento: $precioFinal")

    // Intento de establecer un precio negativo
    producto.setPrecio(-50.0)
    println("Precio después de intentar establecer un valor negativo: ${producto.getPrecio()}")

    // Intento de establecer un descuento fuera del rango válido
    producto.setDescuento(150.0)
    println("Descuento después de intentar establecer un valor fuera de rango: ${producto.getDescuento()}%")
}