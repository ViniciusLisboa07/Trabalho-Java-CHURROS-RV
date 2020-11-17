package br.edu.up.dao;

import java.util.Scanner;
import br.edu.up.util.ProcessamentoListar;
import br.up.edu.model.Compras;

public class ComprasDAO extends GenericDAO<Compras> {

	public static void Compras(Scanner sc) {

		ComprasDAO comprasDAO = new ComprasDAO();

		int j = 0;
		do {

			System.out.println("-----------MENU COMPRAS-----------");
			System.out.println("1 - ADICIONAR");
			System.out.println("2 - LISTAR");
			System.out.println("3 - APAGAR");
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

				System.out.print("Digite a descrição: ");
				String descricao = sc.nextLine();

				System.out.print("Digite o Preço: ");
				double preco = sc.nextDouble();

				Compras compras = new Compras(nome, descricao, preco);
				comprasDAO.salvar(compras);

				System.out.println();
			case 2:
				ProcessamentoListar.ListarCompras(comprasDAO);
				System.out.println();
				break;
			case 3:
				ProcessamentoListar.ListarCompras(comprasDAO);

				System.out.println();
				System.out.println("---------APAGAR------------");
				System.out.print("Qual fornecedore deseja apagar? ");
				int deletForne = sc.nextInt();

				comprasDAO.apagar(deletForne);

				System.out.println();
				ProcessamentoListar.ListarCompras(comprasDAO);
				System.out.println();
				break;
			case 0:
				j = 1;
				break;
			default:
				System.out.println("ERRO: Digite uma opção valida");
			}

		} while (j == 0);
	}

}
