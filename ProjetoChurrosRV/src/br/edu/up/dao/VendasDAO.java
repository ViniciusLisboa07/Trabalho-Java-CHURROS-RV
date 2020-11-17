package br.edu.up.dao;


import java.util.Scanner;
import br.edu.up.util.ProcessamentoListar;
import br.up.edu.model.Vendas;

public class VendasDAO extends GenericDAO<Vendas> {

	public static void Vendas(Scanner sc) {

		VendasDAO vendasDAO = new VendasDAO();
		ChurrosDAO cardapioDAO = new ChurrosDAO();
		BebidasDAO bebidasDAO = new BebidasDAO();

		int c = 0;

		do {

			System.out.println("-----------MENU VENDAS-----------");
			System.out.println("1 - NOVA VENDA");
			System.out.println("2 - EXCLUIR VENDA");
			System.out.println("3 - LISTAR");
			System.out.println("0 - SAIR");
			System.out.println();

			System.out.print("Qual opção deseja?: ");
			int menu = sc.nextInt();
			System.out.println();
			switch (menu) {
			case 1:
				System.out.println("-------------CARDAPIO CHURROS--------------");
				ProcessamentoListar.ListarChurros(cardapioDAO);
				System.out.println();
				System.out.println("-------------CARDAPIO BEBIDAS--------------");
				ProcessamentoListar.ListarBebidas(bebidasDAO);
				System.out.println();
				sc.nextLine();
				System.out.println("----------NOVA VENDA------------");
				System.out.print("Digite o Nome do Cliente: ");
				String nome_cliente = sc.nextLine();

				System.out.print("Digite a quantidade: ");
				int quantidade = sc.nextInt();

				sc.nextLine();
				System.out.print("Digite o produto: ");
				String produto_escolhido = sc.nextLine();

				System.out.print("Digite a bebida: ");
				String bebida = sc.nextLine();

				String obs;
				System.out.print("Deseja colocar uma observação [S/N]: ");
				String resp = sc.nextLine();

				if (resp.equals("s") || resp.equals("S")) {
					System.out.print("Digite a obs: ");
					obs = sc.nextLine();
				} else {
					obs = "SEM OBSERVAÇÃO";
				}

				System.out.print("Digite o Preço: ");
				double preco = sc.nextDouble();

				double total = quantidade * preco;

				System.out.println();
				System.out.println("\t\t--------------CUPOM VISCAL--------------------");
				System.out.println("\t\t            Empresa Churros RV ltda.          ");
				System.out.println("\t\t            Nome cliente: " + nome_cliente);
				System.out.println("\t\t            Quantidade: " + quantidade);
				System.out.println("\t\t            Churros: " + produto_escolhido);
				System.out.println("\t\t            Bebida: " + bebida);
				System.out.println("\t\t            Observação: " + obs);
				System.out.println("\t\t            Preço Total: " + total);
				System.out.println("\t\t----------------------------------------------");
				System.out.println();

				Vendas vendas = new Vendas(nome_cliente, quantidade, produto_escolhido, bebida, obs, preco, total);
				vendasDAO.salvar(vendas);
				System.out.println();
				break;
			case 2:

				ProcessamentoListar.ListarVendas(vendasDAO);
				System.out.println();
				System.out.print("Qual vendas deseja excluir: ");
				int deletForne = sc.nextInt();

				vendasDAO.apagar(deletForne);

				System.out.println();
				ProcessamentoListar.ListarVendas(vendasDAO);
				System.out.println();
				break;
			case 3:

				ProcessamentoListar.ListarVendas(vendasDAO);
				System.out.println();
				break;
			case 0:
				c = 1;
				break;
			default:
				System.out.println();
				System.out.println("ERRO: Digite uma opção valida");
				System.out.println();
				break;
			}

		} while (c == 0);
	}

}
