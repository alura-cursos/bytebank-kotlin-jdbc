package br.com.alura.bytebank.model

data class Conta(
    val numero: Int,
    val cliente: String,
    val saldo: Double
)