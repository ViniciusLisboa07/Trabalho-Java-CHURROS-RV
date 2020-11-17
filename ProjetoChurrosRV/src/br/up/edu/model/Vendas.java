package br.up.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "vendas")
@TableGenerator(
		name = "gerador",
		table = "sqlite_sequence",
		pkColumnName = "name",
		valueColumnName = "seq",
		pkColumnValue = "vendas",
		initialValue = 1,
		allocationSize = 1
		)

public class Vendas {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gerador")	
	private int id;
	private String nome_cliente;
	private int quantidade;
	private String produto_escolhido;
	private String bebida;
	private String obs;
	private double preco;
	private double total;

	public Vendas() {

	}

	public Vendas(String nome_cliente, int quantidade, String produto_escolhido, String bebida, String obs,
			double preco, double total) {
		super();
		this.nome_cliente = nome_cliente;
		this.quantidade = quantidade;
		this.produto_escolhido = produto_escolhido;
		this.bebida = bebida;
		this.obs = obs;
		this.preco = preco;
		this.total = total;
	}

	public Vendas(String nome_cliente, int quantidade, String produto_escolhido, String bebida, String obs,
			double preco) {
		super();
		this.nome_cliente = nome_cliente;
		this.quantidade = quantidade;
		this.produto_escolhido = produto_escolhido;
		this.bebida = bebida;
		this.obs = obs;
		this.preco = preco;
	}

	public Vendas(int id, String nome_cliente, int quantidade, String produto_escolhido, String bebida, String obs,
			double preco, double total) {
		super();
		this.id = id;
		this.nome_cliente = nome_cliente;
		this.quantidade = quantidade;
		this.produto_escolhido = produto_escolhido;
		this.bebida = bebida;
		this.obs = obs;
		this.preco = preco;
		this.total = total;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getProduto_escolhido() {
		return produto_escolhido;
	}

	public void setProduto_escolhido(String produto_escolhido) {
		this.produto_escolhido = produto_escolhido;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\t Nome do Cliente: " + nome_cliente + "\t Quantidade: " + quantidade
				+ "\t Produto Escolhido: " + produto_escolhido + "\t Bebida: " + bebida + "\t Observação: " + obs + "\t Preco: R$" + preco
				+ "\t Total: R$" + total;
	}

}
