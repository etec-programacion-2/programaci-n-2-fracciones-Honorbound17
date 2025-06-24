package org.example

class Fraccion(var numerador: Int, denominador: Int) {

    var denominador: Int = denominador
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            field = value
        }

    init {
        if (denominador == 0) throw IllegalArgumentException("El denominador no puede ser cero")
    }

    override fun toString(): String {
        return "$numerador/$denominador"
    }

    fun mostrar() {
        println(toString())
    }
    // Operador Suma
    operator fun plus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador + this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }

    // Operador Resta
    operator fun minus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador - this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }

    // Simplificación de la fracción
    private fun simplificar(): Fraccion {
        val mcd = calcularMCD(numerador, denominador)
        return Fraccion(numerador / mcd, denominador / mcd)
    }

    // Algoritmo de Euclides
    private fun calcularMCD(a: Int, b: Int): Int {
        var num1 = a
        var num2 = b
        while (num2 != 0) {
            val temp = num2
            num2 = num1 % num2
            num1 = temp
        }
        return kotlin.math.abs(num1)
    }
}
