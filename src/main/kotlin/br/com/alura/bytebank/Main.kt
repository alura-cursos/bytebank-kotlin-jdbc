package br.com.alura.bytebank

import br.com.alura.bytebank.model.Conta
import java.sql.DriverManager

fun main() {
    println("bem vindo ao Bytebank")
    val contaAlex = Conta(1, "Alex", 1000.0)
    println("informações da conta $contaAlex")
}