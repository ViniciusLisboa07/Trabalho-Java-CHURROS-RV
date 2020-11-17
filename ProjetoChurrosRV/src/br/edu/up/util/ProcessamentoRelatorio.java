package br.edu.up.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessamentoRelatorio {

	public static void Relatorio() throws IOException, SQLException {
		System.out.println("Gerando relatório......");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			System.out.println("ERRO");
		}

		String url = "jdbc:sqlite:C:\\Users\\Vinicius\\Desktop\\Sistemas de Informação\\Desenvolvimento de software I\\Trabalho Churros\\ProjetoChurrosRVFINAL\\ProjetoChurrosRV\\BancoDeDados\\BancoDeDadosChurrosRV.db";

		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH-mm-ss").format(dataHoraAtual);

		String arq = "RelatórioChurrosRV-" + hora + ".txt";

		Connection con = DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		FileWriter writer = new FileWriter("C:\\Users\\Vinicius\\Desktop\\Sistemas de Informação\\" + arq);
		PrintWriter out = new PrintWriter(writer);

		out.println("----------------------------------RELATÓRIO GERAL--------------------------------------");
		out.println("Hora: " + hora + " Data: " + data);
		ResultSet fornecedores = stmt.executeQuery("select * from fornecedores");
		;
		out.println("-----------------------------------FORNECEDORES----------------------------------------");
		while (fornecedores.next()) {
			int id = fornecedores.getInt("id");
			String nome = fornecedores.getString("nome");
			String telefone = fornecedores.getString("telefone");
			String produto_fornecido = fornecedores.getString("produto_fornecido");
			String endereco = fornecedores.getString("endereco");
			double preco = fornecedores.getDouble("preco");

			out.println("id: " + id + "\t Nome Fornecedor: " + nome + "\t Telefone: : " + telefone
					+ "\t Produto Escolhido: " + produto_fornecido + "\t Endereço: " + endereco + "\t Preço: R$"
					+ preco);

		}
		out.println();
		ResultSet vendas = stmt.executeQuery("select * from vendas");
		out.println("----------------------------------VENDAS-------------------------------------");
		double totalVendas = 0;
		while (vendas.next()) {
			int id = vendas.getInt("id");
			String nome_cliente = vendas.getString("nome_cliente");
			int quantidade = vendas.getInt("quantidade");
			String produto_escolhido = vendas.getString("produto_escolhido");
			String obs = vendas.getString("obs");
			double preco = vendas.getDouble("preco");
			double total = vendas.getDouble("total");
			out.println("id: " + id + "\t Nome: " + nome_cliente + "\t Quantidade: " + quantidade
					+ "\t Produto Escolhido: " + produto_escolhido + "\t Observação: " + obs + "\t Preço: R$" + preco
					+ "\t Preco total pedido: R$" + total);
			totalVendas += total;
		}
		out.print("\n Preço total das vendas: R$" + totalVendas + "\n");
		out.println();
		ResultSet cardapio = stmt.executeQuery("select * from churros");
		;
		out.println("--------------------------------------CARDAPIO CHURROS-----------------------------------------");
		while (cardapio.next()) {
			int id = cardapio.getInt("id");
			String nome = cardapio.getString("nome");
			String descricao = cardapio.getString("descricao");
			double preco = cardapio.getDouble("preco");

			out.println("id: " + id + "\t Nome: " + nome + "\t Descrição: " + descricao + "\t Preco: R$" + preco);

		}
		out.println();
		ResultSet bebidas = stmt.executeQuery("select * from bebidas");
		;
		out.println("--------------------------------------CARDAPIO BEBIDAS-----------------------------------------");
		while (bebidas.next()) {
			int id = bebidas.getInt("id");
			String nome = bebidas.getString("nome");
			String descricao = bebidas.getString("descricao");
			double preco = bebidas.getDouble("preco");

			out.println("id: " + id + "\t Nome: " + nome + "\t Descrição: " + descricao + "\t Preco: R$" + preco);

		}
		System.out.println();
		out.println();
		ResultSet compras = stmt.executeQuery("select * from compra");
		;
		out.println("--------------------------------------COMPRAS-----------------------------------------");
		double totalCompras = 0;
		while (compras.next()) {
			String nome = compras.getString("nome");
			String descricao = compras.getString("descricao");
			double preco = compras.getDouble("preco");

			out.println("Nome: " + nome + "\t Descrição: " + descricao + "\t Preco: R$" + preco);
			totalCompras += preco;
		}

		out.print("\n Preço total de compras: R$" + totalCompras + "\n");
		System.out.println("Sucesso: Relatório gerado!");

		out.println("\n");
		fornecedores.close();
		vendas.close();
		cardapio.close();
		bebidas.close();
		compras.close();
		stmt.close();
		con.close();
		out.close();
		writer.close();
	}
}
