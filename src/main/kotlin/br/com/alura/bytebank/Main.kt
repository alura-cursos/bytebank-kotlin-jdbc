package br.com.alura.bytebank

import br.com.alura.bytebank.model.Conta
import java.sql.Connection
import java.sql.DriverManager

fun main() {
    println("bem vindo ao Bytebank")
    val contaAlex = Conta(1, "Alex", 1000.0)
    println("informações da conta $contaAlex")

    try {
        Class.forName("com.mysql.cj.jdbc.Driver")
        val conexao = criaConexao()

//        criaTabela(conexao)
//        salvaConta(conexao, contaAlex)
//        buscaContas(conexao)
    } catch (e: Exception) {
        e.printStackTrace()
        println("não foi possível conectar com o banco")
    }
}

private fun buscaContas(conexao: Connection) {
    val buscaContas = "SELECT * FROM contas;"
    val buscaContasQuery = conexao.prepareStatement(buscaContas)
    val resultado = buscaContasQuery.executeQuery()
    while (resultado.next()) {
        val numero = resultado.getInt(1)
        val cliente = resultado.getString(2)
        val saldo = resultado.getDouble(3)
        val conta = Conta(numero, cliente, saldo)
        println("conta devolvida $conta")
    }
}

private fun salvaConta(conexao: Connection, contaAlex: Conta) {
    val insereContaSql = "INSERT INTO contas (cliente, saldo) VALUES (?, ?);"

    val queryInsereConta = conexao.prepareStatement(insereContaSql)
    queryInsereConta.setString(1, contaAlex.cliente)
    queryInsereConta.setDouble(2, contaAlex.saldo)
    queryInsereConta.execute()

    println("conta registrada: $contaAlex")
}

private fun criaConexao(): Connection {
    val conexao = DriverManager.getConnection("jdbc:mysql://localhost/bytebank", "root", "")
    println("Conexão realizada com sucesso")
    return conexao
}

private fun criaTabela(conexao: Connection) {
    val sql = """
            CREATE TABLE IF NOT EXISTS contas (
                id INT PRIMARY KEY AUTO_INCREMENT,
                cliente VARCHAR(255),
                saldo DOUBLE
                );
            """.trimIndent()

    val query = conexao.prepareStatement(sql)
    query.execute()

    println("Tabela de contas criada")
}