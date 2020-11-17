package br.edu.up.dao;

import java.util.Scanner;

import br.edu.up.util.ProcessamentoListar;
import br.up.edu.model.Fornecedor;

public class FornecedorDAO extends GenericDAO<Fornecedor> {

	public static void Fornecedores(Scanner sc) {

		FornecedorDAO fornecedorDAO = new FornecedorDAO();

		int i = 0;

		do {

			System.out.println("-----------MENU FORNECEDORES-----------");
			System.out.println("1 - ADICIONAR");
			System.out.println("2 - EDITAR");
			System.out.println("3 - APAGAR");
			System.out.println("4 - LISTAR");
			System.out.println("0 - SAIR");
			System.out.println();

			System.out.print("Qual opção deseja?: ");
			int menu = sc.nextInt();
			System.out.println();
			switch (menu) {
			case 1:
				System.out.println();
				sc.nextLine();
				System.out.println("----------ADICIONAR------------");
				System.out.print("Digite o Nome: ");
				String nome = sc.nextLine();

				System.out.print("Digite o telefone: ");
				String telefone = sc.nextLine();

				System.out.print("Digite o Produto Fornecido: ");
				String produto_fornecido = sc.nextLine();

				System.out.print("Digite o Endereço: ");
				String endereco = sc.nextLine();

				System.out.print("Digite o Preço: ");
				double preco = sc.nextDouble();

				Fornecedor fornecedor = new Fornecedor(nome, telefone, produto_fornecido, endereco, preco);
				fornecedorDAO.salvar(fornecedor);

				System.out.println();
				ProcessamentoListar.ListarFornecedores(fornecedorDAO);
				System.out.println();
				System.out.println("Voltando para Menu Inicial......");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ex) {
					System.out.println("ERRO");
				}
				break;

			case 2:
				System.out.println();
				ProcessamentoListar.ListarFornecedores(fornecedorDAO);
				System.out.println();
				System.out.println("---------------EDITAR------------------");
				System.out.print("Digite o ID: ");
				int id = sc.nextInt();

				sc.nextLine();
				System.out.print("Digite o Nome: ");
				String nome2 = sc.nextLine();

				System.out.print("Digite o telefone: ");
				String telefone2 = sc.nextLine();

				System.out.print("Digite o Produto Fornecido: ");
				String produto_fornecido2 = sc.nextLine();

				System.out.print("Digite o Endereço: ");
				String endereco2 = sc.nextLine();

				System.out.print("Digite o Preço: ");
				double preco2 = sc.nextDouble();

				Fornecedor fornecedor2 = new Fornecedor(id, nome2, telefone2, produto_fornecido2, endereco2, preco2);
				fornecedorDAO.atualizar(fornecedor2);
				System.out.println();
				ProcessamentoListar.ListarFornecedores(fornecedorDAO);

				System.out.println();
				break;

			case 3:
				ProcessamentoListar.ListarFornecedores(fornecedorDAO);

				System.out.println();
				System.out.println("---------APAGAR------------");
				System.out.print("Qual fornecedore deseja apagar? ");
				int deletForne = sc.nextInt();
				System.out.println();
				fornecedorDAO.apagar(deletForne);
				ProcessamentoListar.ListarFornecedores(fornecedorDAO);
				System.out.println();
				System.out.println("Voltando para Menu Inicial......");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ex) {
					System.out.println("ERRO");
				}
				System.out.println();
				break;
			case 4:
				ProcessamentoListar.ListarFornecedores(fornecedorDAO);
				System.out.println();
				break;
			case 0:
				i = 1;
				break;
			default:
				System.out.println("ERRO: Digite uma opção valida");

			}

		} while (i == 0);
	}

}