package org.example

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var opcion: Int = -1 // Inicializar la variable con un valor predeterminado

    do {
        mostrarMenu()
        opcion = try {
            scanner.nextInt()
        } catch (e: Exception) {
            println("Entrada inválida. Por favor, ingrese un número.")
            scanner.nextLine() // Limpiar el buffer
            continue
        }

        when (opcion) {
            1 -> realizarSuma(scanner)
            2 -> realizarResta(scanner)
            3 -> realizarMultiplicacion(scanner)
            4 -> realizarDivision(scanner)
            5 -> realizarComparacion(scanner)
            6 -> convertirADecimal(scanner)
            7 -> crearDesdeDecimal(scanner)
            8 -> mostrarEjemplos()
            0 -> println("¡Hasta luego!")
            else -> println("Opción inválida. Intente de nuevo.")
        }

        if (opcion != 0) {
            println("\nPresione Enter para continuar...")
            scanner.nextLine() // Limpiar buffer
            scanner.nextLine() // Esperar Enter
        }
    } while (opcion != 0)

    scanner.close()
}

fun mostrarMenu() {
    println("=== CALCULADORA DE FRACCIONES ===")
    println("1. Sumar fracciones")
    println("2. Restar fracciones")
    println("3. Multiplicar fracciones")
    println("4. Dividir fracciones")
    println("5. Comparar fracciones")
    println("6. Convertir fracción a decimal")
    println("7. Crear fracción desde decimal")
    println("8. Ejemplos predefinidos")
    println("0. Salir")
    print("Ingrese su opción: ")
}

fun leerFraccion(scanner: Scanner, mensaje: String): Fraccion {
    println(mensaje)
    print("Numerador: ")
    val numerador = scanner.nextInt()
    print("Denominador: ")
    val denominador = scanner.nextInt()
    return Fraccion(numerador, denominador)
}

fun realizarSuma(scanner: Scanner) {
    val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    println("Resultado de la suma: ${f1 + f2}")
}

fun realizarResta(scanner: Scanner) {
    val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    println("Resultado de la resta: ${f1 - f2}")
}

fun realizarMultiplicacion(scanner: Scanner) {
    val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    println("Resultado de la multiplicación: ${f1 * f2}")
}

fun realizarDivision(scanner: Scanner) {
    val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    try {
        println("Resultado de la división: ${f1 / f2}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

fun realizarComparacion(scanner: Scanner) {
    val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    when {
        f1 > f2 -> println("$f1 es mayor que $f2")
        f1 < f2 -> println("$f1 es menor que $f2")
        else -> println("$f1 es igual a $f2")
    }
}

fun convertirADecimal(scanner: Scanner) {
    val f = leerFraccion(scanner, "Ingrese la fracción:")
    println("El valor decimal de $f es: ${f.aDecimal()}")
}

fun crearDesdeDecimal(scanner: Scanner) {
    print("Ingrese un número decimal: ")
    val decimal = scanner.nextDouble()
    println("La fracción equivalente es: ${Fraccion.desdeDecimal(decimal)}")
}

fun mostrarEjemplos() {
    println("\n=== EJEMPLOS PREDEFINIDOS ===")
    val f1 = Fraccion(1, 2)
    val f2 = Fraccion(1, 3)

    println("Fracción 1: $f1")
    println("Fracción 2: $f2")
    println("Suma: $f1 + $f2 = ${f1 + f2}")
    println("Resta: $f1 - $f2 = ${f1 - f2}")
    println("Multiplicación: $f1 * $f2 = ${f1 * f2}")
    println("División: $f1 / $f2 = ${f1 / f2}")
    println("¿$f1 > $f2? ${f1 > f2}")
    println("$f1 en decimal: ${f1.aDecimal()}")
}
