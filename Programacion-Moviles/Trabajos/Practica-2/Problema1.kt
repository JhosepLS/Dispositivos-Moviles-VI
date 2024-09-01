/*
Descripción: Implementación de una clase CuentaBancaria con saldo, límite de retiro y métodos para gestionar transacciones.
Autor: Jhosep
Fecha creación: 01 de septiembre del 2024, 02:25 pm
Fecha última modificación: 01 de septiembre del 2024, 03:38 pm
*/

class CuentaBancaria(saldoInicial: Double, private val limiteRetiro: Double) {
    private var saldo: Double = 0.0
        set(valor) {
            if (valor >= 0) {
                field = valor
            } else {
                println("Error: El saldo no puede ser negativo.")
            }
        }

    init {
        saldo = saldoInicial
    }

    fun getSaldo(): Double {
        return saldo
    }

    fun realizarRetiro(cantidad: Double) {
        if (cantidad <= 0) {
            println("Error: La cantidad a retirar debe ser positiva.")
            return
        }

        if (cantidad > limiteRetiro) {
            println("Error: La cantidad excede el límite de retiro de $limiteRetiro")
            return
        }

        if (cantidad > saldo) {
            println("Error: Saldo insuficiente.")
            return
        }

        saldo -= cantidad
        println("Retiro exitoso. Nuevo saldo: $saldo")
    }
}

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)
    
    println("Saldo inicial: ${cuenta.getSaldo()}")
    
    cuenta.realizarRetiro(300.0)
    cuenta.realizarRetiro(700.0) // Excede el límite de retiro
    cuenta.realizarRetiro(-100.0) // Cantidad negativa
    cuenta.realizarRetiro(800.0) // Saldo insuficiente
}