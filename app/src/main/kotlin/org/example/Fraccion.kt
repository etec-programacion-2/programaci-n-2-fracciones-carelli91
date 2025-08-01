package org.example

import kotlin.math.abs
import kotlin.math.pow

class Fraccion(
    private var _numerador: Int,
    private var _denominador: Int
) : Comparable<Fraccion> {

    init {
        require(_denominador != 0) { "El denominador no puede ser cero" }
        simplificar()
    }

    var numerador: Int
        get() = _numerador
        set(value) {
            _numerador = value
            simplificar()
        }

    var denominador: Int
        get() = _denominador
        set(value) {
            require(value != 0) { "El denominador no puede ser cero" }
            _denominador = value
            simplificar()
        }

    override fun toString(): String = "$numerador/$denominador"

    fun mostrar() {
        println(this.toString())
    }

    private fun simplificar() {
        val mcd = mcd(abs(_numerador), abs(_denominador))
        _numerador /= mcd
        _denominador /= mcd
        if (_denominador < 0) {
            _numerador *= -1
            _denominador *= -1
        }
    }

    private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) a else mcd(b, a % b)
    }

    operator fun plus(otra: Fraccion): Fraccion {
        val num = this.numerador * otra.denominador + otra.numerador * this.denominador
        val den = this.denominador * otra.denominador
        return Fraccion(num, den)
    }

    operator fun minus(otra: Fraccion): Fraccion {
        val num = this.numerador * otra.denominador - otra.numerador * this.denominador
        val den = this.denominador * otra.denominador
        return Fraccion(num, den)
    }

    operator fun times(otra: Fraccion): Fraccion {
        val num = this.numerador * otra.numerador
        val den = this.denominador * otra.denominador
        return Fraccion(num, den)
    }

    operator fun div(otra: Fraccion): Fraccion {
        require(otra.numerador != 0) { "No se puede dividir por una fracción con numerador cero." }
        val num = this.numerador * otra.denominador
        val den = this.denominador * otra.numerador
        return Fraccion(num, den)
    }

    override operator fun compareTo(otra: Fraccion): Int {
        return (this.numerador * otra.denominador).compareTo(otra.numerador * this.denominador)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        return this.compareTo(other) == 0
    }

    override fun hashCode(): Int {
        return numerador.hashCode() * 31 + denominador.hashCode()
    }

    fun esMayor(otra: Fraccion): Boolean = this > otra

    fun esMenor(otra: Fraccion): Boolean = this < otra

    fun aDecimal(): Double = numerador.toDouble() / denominador.toDouble()

    companion object {
        fun desdeDecimal(decimal: Double): Fraccion {
            val str = decimal.toString()
            val partes = str.split(".")
            if (partes.size == 1) return Fraccion(decimal.toInt(), 1)
            val decimales = partes[1].length
            val denominador = 10.0.pow(decimales).toInt()
            val numerador = (decimal * denominador).toInt()
            return Fraccion(numerador, denominador)
        }
    }
}
