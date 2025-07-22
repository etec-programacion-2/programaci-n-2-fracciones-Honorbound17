### Prompt 1
- Fecha: 2025-07-16
- Herramienta: GitHub Copilot
- Prompt: "Cómo defino una clase en Kotlin con propiedades numerador y denominador?"
- Respuesta: "Puedes definir una clase en Kotlin con propiedades así: 
  ```kotlin
  class Fraccion(var numerador: Int, var denominador: Int)


### Prompt 2
- Fecha: 2025-07-17
- Herramienta: GitHub Copilot
- Prompt: "Cómo implemento el operador suma para una clase en Kotlin?"
- Respuesta: "Puedes usar el modificador operator para sobrecargar el operador +:
 ```kotlin
 operator fun plus(otra: Fraccion): Fraccion {
    val nuevoNumerador = this.numerador * otra.denominador + this.denominador * otra.numerador
    val nuevoDenominador = this.denominador * otra.denominador
    return Fraccion(nuevoNumerador, nuevoDenominador)
}


### Prompt 3
- Fecha: 2025-07-17
- Herramienta: GitHub Copilot
- Prompt: "Cómo simplifico una fracción en Kotlin usando el MCD?"
- Respuesta: "Puedes usar el algoritmo de Euclides para calcular el MCD:
 ```kotlin
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
Luego divide el numerador y denominador por el MCD."


### Prompt 4
- Fecha: 2025-07-22
- Herramienta: GitHub Copilot
- Prompt: "Cómo implemento el operador de comparación para una clase en Kotlin?"
- Respuesta: "Puedes implementar la interfaz Comparable y sobrecargar el método compareTo:
 ```kotlin
 override operator fun compareTo(otra: Fraccion): Int {
    val diferencia = this.numerador * otra.denominador - otra.numerador * this.denominador
    return when {
        diferencia > 0 -> 1
        diferencia < 0 -> -1
        else -> 0
    }
}
```


### Prompt 5
- Fecha: 2025-07-17
- Herramienta: GitHub Copilot
- Prompt: "¿Cómo convierto un número decimal a una fracción en Kotlin?"
- Respuesta: "Puedes usar un método companion para convertir un decimal a fracción:
 ```kotlin
 companion object {
    fun desdeDecimal(decimal: Double): Fraccion {
        val precision = 1_000_000
        val numerador = (decimal * precision).toInt()
        val denominador = precision
        return Fraccion(numerador, denominador).simplificar()
    }
}
```


### Prompt 6
- Fecha: 2025-07-18
- Herramienta: GitHub Copilot
- Prompt: "¿Cómo creo un menú interactivo en Kotlin para una calculadora de fracciones?"
- Respuesta: "Puedes usar un bucle do-while y un Scanner para leer las opciones del usuario:
 ```kotlin
 fun main() {
    val scanner = Scanner(System.`in`)
    var opcion: Int
    do {
        println(\"1. Sumar fracciones\")
        println(\"2. Restar fracciones\")
        println(\"0. Salir\")
        opcion = scanner.nextInt()
        when (opcion) {
            1 -> println(\"Suma seleccionada\")
            2 -> println(\"Resta seleccionada\")
        }
    } while (opcion != 0)
}
```


### Prompt 7
- Fecha: 2025-07-21
- Herramienta: GitHub Copilot
- Prompt: "¿Cómo manejo excepciones en Kotlin para entradas inválidas en un menú?"
- Respuesta: "Puedes usar un bloque try-catch para capturar excepciones:
 ```kotlin
 try {
    val opcion = scanner.nextInt()
} catch (e: Exception) {
    println(\"Entrada inválida. Por favor, ingrese un número.\")
    scanner.nextLine() // Limpiar el buffer
}
```


### Prompt 8
- Fecha: 2025-07-20
- Herramienta: GitHub Copilot
- Prompt: "¿Cómo muestro ejemplos predefinidos de operaciones con fracciones en Kotlin?"
- Respuesta: "Puedes crear una función que muestre ejemplos:
 ```kotlin
 fun mostrarEjemplos() {
    val f1 = Fraccion(1, 2)
    val f2 = Fraccion(1, 3)
    println(\"Suma: $f1 + $f2 = ${f1 + f2}\")
    println(\"Resta: $f1 - $f2 = ${f1 - f2}\")
}
```
