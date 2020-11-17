package br.edu.up.sistema;


import java.util.Scanner;
import br.edu.up.dao.BebidasDAO;
import br.edu.up.dao.ChurrosDAO;
import br.edu.up.dao.ComprasDAO;
import br.edu.up.dao.FornecedorDAO;
import br.edu.up.dao.VendasDAO;
import br.edu.up.util.ProcessamentoRelatorio;


public class Programa {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int i = 0;

		do {

			System.out.println("\n Sistema Comercial de Controle de Vendas Churros RV");
			System.out.println("\n");
			System.out.print("                           --MENU--          ");
			System.out.println("\n                  ----------------------------");
			System.out.println("                  |     1 - Vendas           |");
			System.out.println("                  |     2 - Fornecedores     |");
			System.out.println("                  |     3 - Cardapio         |");
			System.out.println("                  |     4 - Compras          |");
			System.out.println("                  |     5 - Relatório Geral  |");
			System.out.println("                  |     0 - Sair             |");
			System.out.println("                  ----------------------------\n");
			System.out.println();

			System.out.print("Digite a opção desejada: ");
			int valor = sc.nextInt();
			System.out.println();
			switch (valor) {
			case 1:
				VendasDAO.Vendas(sc);
				break;
			case 2:
				FornecedorDAO.Fornecedores(sc);
				break;
			case 3:
				System.out.println("1 - BEBIDAS");
				System.out.println("2 - CHURROS");
				System.out.print("\n Qual cardapio deseja: ");
				int val = sc.nextInt();
				switch (val) {
				case 1:
					System.out.println();
					BebidasDAO.Cardapio(sc);
					break;
				case 2:
					System.out.println();
					ChurrosDAO.Cardapio(sc);
					break;
				default:
					System.out.println("ERRO: OPÇÃO INVALIDA");
					break;
				}
				break;
			case 4:
				ComprasDAO.Compras(sc);
				break;
			case 5:
				ProcessamentoRelatorio.Relatorio();
				break;
			case 0:
				ProcessamentoRelatorio.Relatorio();
				i = 1;
				break;
			default:
				System.out.println("ERRO: OPÇÃO INVALIDA");
			}

		} while (i == 0);

	}

}
