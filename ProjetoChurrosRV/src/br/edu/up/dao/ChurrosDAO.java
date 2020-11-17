package br.edu.up.dao;

import java.util.Scanner;
import br.edu.up.util.ProcessamentoListar;
import br.up.edu.model.CardapioChurros;

public class ChurrosDAO extends GenericDAO<CardapioChurros> {

	public static void Cardapio(Scanner sc) {

		ChurrosDAO churrosDAO = new ChurrosDAO();

		int c = 0;
		int ap = 0;

		do {

			System.out.println("-----------MENU CHURROS-----------");
			System.out.println("1 - ADICIONAR");
			System.out.println("2 - EDITAR");
			System.out.println("3 - APAGAR");
			System.out.println("4 - LISTAR");
			System.out.println("0 - SAIR");
			System.out.println();

			System.out.print("Qual opção deseja: ");
			int menu = sc.nextInt();
			System.out.println();
			switch (menu) {
			case 1:
				sc.nextLine();
				System.out.println();
				System.out.println("----------ADICIONAR------------");
				System.out.print("Digite o Nome: ");
				String nome2 = sc.nextLine();

				System.out.print("Digite a descrição: ");
				String descricao2 = sc.nextLine();

				System.out.print("Digite o Preço: ");
				double preco2 = sc.nextDouble();
				CardapioChurros cardapioChurros = new CardapioChurros(nome2, descricao2, preco2);
				churrosDAO.salvar(cardapioChurros);
				System.out.println();
				break;
			case 2:
				System.out.println();
				ProcessamentoListar.ListarChurros(churrosDAO);
				System.out.println();
				System.out.println("---------------EDITAR------------------");
				System.out.print("Digite o ID: ");
				int id = sc.nextInt();

				sc.nextLine();
				System.out.print("Digite o Nome: ");
				String nome3 = sc.nextLine();

				System.out.print("Digite a descrição: ");
				String descricao3 = sc.nextLine();

				System.out.print("Digite o Preço: ");
				double preco3 = sc.nextDouble();

				CardapioChurros churros = new CardapioChurros(id, nome3, descricao3, preco3);
				churrosDAO.atualizar(churros);
				System.out.println();
				break;

			case 3:

				System.out.println("------------APAGAR-----------------");

				System.out.println();
				ProcessamentoListar.ListarChurros(churrosDAO);
				System.out.print("\nDigite o id: ");
				ap = sc.nextInt();

				churrosDAO.apagar(ap);
				System.out.println();
				break;
			case 4:
				System.out.println(
						"\n\n----------------------CARDAPIO BEBIDAS---------------------------------------------------------------\n");
				ProcessamentoListar.ListarChurros(churrosDAO);
				System.out.println("\n");
				break;
			case 0:
				c = 1;
				break;
			default:
				System.out.println("ERRO: Digite uma opção valida");
				break;
			}

		} while (c == 0);
	}

}
