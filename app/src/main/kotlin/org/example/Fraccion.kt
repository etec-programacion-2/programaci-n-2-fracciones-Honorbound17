package org.example

class Fraccion(var numerador: Int, denominador: Int) : Comparable<Fraccion> {

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

    // Operador Multiplicación
    operator fun times(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }

    // Operador División
    operator fun div(otra: Fraccion): Fraccion {
        if (otra.numerador == 0) throw IllegalArgumentException("No se puede dividir por una fracción con numerador cero")
        val nuevoNumerador = this.numerador * otra.denominador
        val nuevoDenominador = this.denominador * otra.numerador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }

    // Operador Igualdad
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        val simplificada1 = this.simplificar()
        val simplificada2 = other.simplificar()
        return simplificada1.numerador == simplificada2.numerador &&
               simplificada1.denominador == simplificada2.denominador
    }

    // Método para saber si una Fracción es Mayor
    fun esMayor(otra: Fraccion): Boolean {
        return this.compareTo(otra) > 0
    }

    // Método para saber si una Fracción es Menor
    fun esMenor(otra: Fraccion): Boolean {
        return this.compareTo(otra) < 0
    }

    // Método de Fracción a Decimal
    fun aDecimal(): Double {
        return numerador.toDouble() / denominador.toDouble()
    }

    // Método para crear una Fracción desde Decimal
    companion object {
        fun desdeDecimal(decimal: Double): Fraccion {
            val precision = 1_000_000
            val numerador = (decimal * precision).toInt()
            val denominador = precision
            return Fraccion(numerador, denominador).simplificar()
        }
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

    // Operador de comparación
    override operator fun compareTo(otra: Fraccion): Int {
        val diferencia = this.numerador * otra.denominador - otra.numerador * this.denominador
        return when {
            diferencia > 0 -> 1
            diferencia < 0 -> -1
            else -> 0
        }
    }
}
