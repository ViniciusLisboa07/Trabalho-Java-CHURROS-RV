package br.edu.up.util;

import java.util.List;

import br.edu.up.dao.BebidasDAO;
import br.edu.up.dao.ChurrosDAO;
import br.edu.up.dao.ComprasDAO;
import br.edu.up.dao.FornecedorDAO;
import br.edu.up.dao.VendasDAO;
import br.up.edu.model.CardapioBebidas;
import br.up.edu.model.CardapioChurros;
import br.up.edu.model.Compras;
import br.up.edu.model.Fornecedor;
import br.up.edu.model.Vendas;

public class ProcessamentoListar {

	public static void ListarBebidas(BebidasDAO bebidasDAO) {
		List<CardapioBebidas> listaDeBebidas = bebidasDAO.listar();
		for (CardapioBebidas j : listaDeBebidas) {
			System.out.println(j);
		}
	}

	public static void ListarChurros(ChurrosDAO cardapioDAO) {
		List<CardapioChurros> listaDeCardapio = cardapioDAO.listar();
		for (CardapioChurros j : listaDeCardapio) {
			System.out.println(j);
		}
	}

	public static void ListarCompras(ComprasDAO comprasDAO) {
		List<Compras> listaDeCompras = comprasDAO.listar();
		for (Compras f : listaDeCompras) {
			System.out.println(f);
		}
	}

	public static void ListarFornecedores(FornecedorDAO fornecedorDAO) {
		List<Fornecedor> listaDeFornecedores = fornecedorDAO.listar();
		for (Fornecedor f : listaDeFornecedores) {
			System.out.println(f);
		}
	}

	public static void ListarVendas(VendasDAO vendasDAO) {
		List<Vendas> listaDeVenda = vendasDAO.listar();
		for (Vendas f : listaDeVenda) {
			System.out.println(f);
		}
	}

}
