package br.up.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "churros")
@TableGenerator(
		name = "geradoreid",
		table = "sqlite_sequence",
		pkColumnName = "name",
		valueColumnName = "seq",
		pkColumnValue = "churros",
		initialValue = 1,
		allocationSize = 1
		)
public class CardapioChurros {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "geradoreid")	
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	
	public CardapioChurros() {
		
	}

	public CardapioChurros(String nome, String descricao, double preco) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public CardapioChurros(int id, String nome, String descricao, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "id: " + id + "\t Nome: " + nome + "\t Descrição: " + descricao + "\t Preco: R$" + preco;
	}

}
