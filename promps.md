
### prompt 1
- fecha: 2025-07-22
- herramienta: chatgpt
- prompt: "como implemento la suma y resta de fracciones en kotlin usando operadores"
- respuesta:  
Este código define cómo implementar la suma y la resta de fracciones en Kotlin usando operadores sobrecargados. 

---

### 🔍 **Operador `plus` y `minus`**

```kotlin
operator fun plus(other: Fraccion): Fraccion {
    val nuevoNumerador = this.numerador * other.denominador + other.numerador * this.denominador
    val nuevoDenominador = this.denominador * other.denominador
    return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
}

operator fun minus(other: Fraccion): Fraccion {
    val nuevoNumerador = this.numerador * other.denominador - other.numerador * this.denominador
    val nuevoDenominador = this.denominador * other.denominador
    return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
}
````

* La suma y resta se hacen multiplicando cruzado numeradores y denominadores.
* Luego se crea una nueva fracción con el resultado.
* La función `simplificar()` reduce la fracción a su forma más simple usando el máximo común divisor.

---

¿Querés que te ayude con la función `simplificar()`?

---



### prompt 2

* fecha: 2025-07-22
* herramienta: chatgpt
* prompt: "error no such element exception"
* respuesta:
  Este error ocurre cuando `Scanner.nextInt()` intenta leer un valor pero la entrada estándar ya no tiene datos disponibles o se encuentra en un estado inesperado.

Para solucionarlo:

* Asegúrate de que haya datos disponibles antes de llamar a `nextInt()`.
* Después de leer un número con `nextInt()`, consume el salto de línea pendiente con `nextLine()`.
* Si el programa usa un ciclo para leer inputs, valida que no se quede sin datos antes de llamar a `nextInt()`.

Ejemplo:

```kotlin
val scanner = Scanner(System.`in`)
val opcion = if (scanner.hasNextInt()) scanner.nextInt() else -1
scanner.nextLine() // para limpiar el buffer
```

---

### prompt 3

* fecha: 2025-07-22
* herramienta: chatgpt
* prompt: "que es UnsupportedClassVersionError"
* respuesta:
  El error `UnsupportedClassVersionError` indica que el programa fue compilado con una versión de Java más reciente que la que tu máquina virtual está usando para ejecutar el programa.

Por ejemplo:

* Compilaste con Java 17 (class file version 61.0)
* Intentas ejecutar con Java 11 (class file version 55.0)

Para solucionarlo:

* Actualiza tu JRE/JDK a la versión igual o mayor a la que usaste para compilar.
* O bien, configura tu compilación para apuntar a una versión más antigua compatible con tu runtime (en Gradle, por ejemplo, usando `targetCompatibility = '11'`).

---

### prompt 4

* fecha: 2025-07-22
* herramienta: chatgpt
* prompt: "como valido que el denominador no sea cero en kotlin?"
* respuesta:
  Para garantizar que el denominador nunca sea cero, lo mejor es hacer la validación dentro de la clase `Fraccion`:

```kotlin
var denominador: Int = 1
    set(value) {
        if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
        field = value
    }
```

Además, puedes validar en el constructor para evitar crear objetos inválidos:

```kotlin
init {
    require(denominador != 0) { "El denominador no puede ser cero" }
}
```


### prompt 5
- fecha: 2025-07-22
- herramienta: chatgpt
- prompt: "como uso los operadores en kotlin para sumar fracciones"
- respuesta:  
En Kotlin puedes sobrecargar operadores para que tus objetos puedan usar símbolos como `+`, `-`, `*`, `/`. Para esto defines funciones con la palabra clave `operator`.

Ejemplo para sumar fracciones:

```kotlin
operator fun plus(other: Fraccion): Fraccion {
    val num = this.numerador * other.denominador + other.numerador * this.denominador
    val den = this.denominador * other.denominador
    return Fraccion(num, den).simplificar()
}
````

Con esto, puedes hacer:

```kotlin
val f1 = Fraccion(1, 2)
val f2 = Fraccion(3, 4)
val resultado = f1 + f2
```

Esto mejora la legibilidad del código y aprovecha las capacidades del lenguaje.

---

### prompt 6

* fecha: 2025-07-22
* herramienta: chatgpt
* prompt: "overriding member with different name parameter"
* respuesta:
  Este warning indica que al sobrescribir una función de la superclase o interfaz, el nombre de los parámetros no coincide con el original.

Aunque Kotlin solo requiere que los tipos y posición coincidan, se recomienda usar el mismo nombre de parámetros para evitar confusión y problemas con llamadas usando argumentos nombrados.

Ejemplo:

```kotlin
// en superclase
open fun sumar(other: Fraccion): Fraccion { ... }

// en subclase
override fun sumar(other: Fraccion): Fraccion { ... } // correcto

// si usas diferente nombre
override fun sumar(otra: Fraccion): Fraccion { ... } // genera warning
```

Para evitar el warning, cambia el nombre del parámetro para que coincida exactamente.

---

### prompt 7

* fecha: 2025-07-22
* herramienta: chatgpt
* prompt: "como puedo usar los setter y getter"
* respuesta:
  En Kotlin puedes definir propiedades con getters y setters personalizados para controlar cómo se accede o modifica un valor.

Ejemplo básico:

```kotlin
var denominador: Int = 1
    get() = field
    set(value) {
        if (value == 0) throw IllegalArgumentException("No puede ser cero")
        field = value
    }
```

`field` es una referencia al valor interno de la propiedad. Así puedes validar valores antes de asignarlos o modificar la forma en que se obtiene la propiedad.

---


### prompt 8

* fecha: 2025-07-22
* herramienta: chatgpt
* prompt: "que significa init"
* respuesta:
  `init` es un bloque de inicialización que se ejecuta cuando se crea una instancia de la clase, después del constructor principal.

Se usa para validar o ejecutar código necesario para la inicialización del objeto.

Ejemplo:

```kotlin
class Fraccion(val numerador: Int, val denominador: Int) {
    init {
        require(denominador != 0) { "denominador no puede ser cero" }
    }
}
```

Así te aseguras que no se creen objetos inválidos.

---

### prompt 9

* fecha: 2025-07-22
* herramienta: chatgpt
* prompt: "como puedo imprimir una clase personalizada"
* respuesta:
  Para personalizar cómo se imprime una instancia de una clase, se debe sobrescribir el método `toString()`.

Ejemplo:

```kotlin
override fun toString(): String {
    return "$numerador/$denominador"
}
```

Después puedes hacer:

```kotlin
val f = Fraccion(3,4)
println(f) // imprime "3/4"
```

Sin este método, se imprimiría la referencia del objeto, no su contenido legible.
