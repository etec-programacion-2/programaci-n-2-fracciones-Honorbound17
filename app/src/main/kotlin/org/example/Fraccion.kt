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
}
