package tp1;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/*==========TP1============
 * ALUNO: HENRIQUE GALDINO - 200058258
 * 
 * VERSÃO INICIAL -> 7 de 7 opções estruturadas e funcionais
 * 
 * */
public class TP1 {
	
	private Scanner ler;
	private boolean executar;
	private List<Dados> dadosCadastrar;
	private List<Produtos> prodCadastrar;
	
	//Main
	public static void main(String[] args) {
		new TP1();
	}	
	
	private TP1() {
		ler = new Scanner(System.in);
		executar = true;
		dadosCadastrar = new ArrayList<Dados>();
		prodCadastrar = new ArrayList<Produtos>();
		
		
		System.out.println("BEM VINDO AO SISTEMA DA LOJA!");
		preCadastros();
		
		while(executar) {
			menu();
			
			int opcao = ler.nextInt();
			ler.nextLine();
			
			switch(opcao) {
				case 1: cadastrarClientes();
						break;
						
				case 2: buscarCadastro();
						break;
				
				case 3: cadastrarProdutos();
						break;
				
				case 4: buscarProduto();
						break;
				
				case 5: cadastrarVendas();
						break;
				
				case 6: listarProdutos();
						break;
				
				case 7: sairMenu();
						break;
				default:
						System.out.println("\n ERRO - ESCOLHA UMA OPÇÃO VÁLIDA \n");
						
			}
			
		}
	}
	
	//Menu
	private void menu() {
		System.out.println("Selecione a opção do menu a ser acessada:");
		System.out.println("1 - Cadastro de novo cliente");
		System.out.println("2 - Busca por cliente");
		System.out.println("3 - Cadastro de novo produto");
		System.out.println("4 - Busca por produto");
		System.out.println("5 - Cadastro de venda");
		System.out.println("6 - Mostrar produtos em estoque");
		System.out.println("7 - Sair");
	}
	
	//Cadastro de clientes
	private void cadastrarClientes() {
		boolean cadastrando = true;
		int contador,totalCadastrar;
		
		System.out.println("BEM VINDO AO CADASTRO DE CLIENTES");
		System.out.println("Informe quantos clientes deseja cadastrar: ");
		totalCadastrar = ler.nextInt();
		ler.nextLine();
		
		contador = 0;
		while(cadastrando) {
			Dados d = new Dados();
			
			System.out.println("Nome do cliente: ");
			d.nomeCliente(ler.nextLine());
			
			System.out.println("Telefone do cliente: ");
			d.telCliente(ler.nextLine());
			
			System.out.println("Endereço do cliente: ");
			d.endCliente(ler.nextLine());
			
			System.out.println("Confirmar cadastro (Sim/Não) ?");
			String confirmar = ler.nextLine();
			
			if(confirmar.equalsIgnoreCase("Sim")) {
				System.out.println("Cadastro confirmado!");
				dadosCadastrar.add(d);
				contador ++;
				
				if(contador == totalCadastrar) {
					System.out.println("CLIENTES CADASTRADOS COM SUCESSO!");
					cadastrando = false;
				}
				
			}else if (confirmar.equalsIgnoreCase("Não")) {
				System.out.println("Cadastro cancelado!");
				cadastrando = false;
			}else {
				System.out.println("\n ERRO - FAVOR REPETIR CADASTRO NOVAMENTE");
			}
			
		}
	}
	
	//Busca por cliente
	private void buscarCadastro() {
		
		
		if (dadosCadastrar.size() == 0) {
			System.out.println("\n Ainda não existem clientes cadastrados!\n");
		} else {
			System.out.println("\n \tBUSCA DE CLIENTES CADASTRADOS\n \nINFORME O NOME DO CLIENTE A SER BUSCADO");
			
			String busca = ler.nextLine();
			
			for (int i = 0; i < dadosCadastrar.size(); i++) {
				
				Dados d = dadosCadastrar.get(i);
				
				if(busca.equalsIgnoreCase(d.Nome())){
					String novoNome, novoTel, novoEnd;
					
					System.out.println("Nome: " + d.Nome());
					System.out.println("Telefone: " + d.Telefone());
					System.out.println("Endereço: " + d.Endereco() + "\n");
				
					System.out.println("Deseja alterar os dados desse cliente? (Sim/Não)");
					String alterar = ler.nextLine();
					
					if(alterar.equalsIgnoreCase("Sim")) {
						
						System.out.println("Informe o novo nome do cliente: ");
						novoNome = ler.nextLine();
						d.nomeCliente(d.Nome().replaceAll(busca, novoNome));
						
						System.out.println("Informe o novo telefone do cliente: ");
						novoTel = ler.nextLine();
						d.telCliente(d.Telefone().replaceAll(d.Telefone(), novoTel));
						
						
						System.out.println("Informe o novo endereço do cliente: ");
						novoEnd = ler.nextLine();
						d.endCliente(d.Endereco().replaceFirst(d.Endereco(), novoEnd));
					
						
						System.out.println("Esses são os novos dados do cliente: ");
						System.out.println("Cliente número: " + i);
						System.out.println("Nome: " + d.Nome());
						System.out.println("Telefone: " + d.Telefone());
						System.out.println("Endereço: " + d.Endereco() + "\n");
					}else {
						System.out.println("RETORNANDO AO MENU PRINCIPAL");
					}
				}else if(!busca.equalsIgnoreCase(d.Nome())){
					if(i == (dadosCadastrar.size()-1)) {
					System.out.println("Não há clientes cadastrados com o nome informado!\n RETORNANDO AO MENU");
					}
				}
			}
		}
	}
	
	//Busca por produto
	private void buscarProduto() {
		
		
		if (prodCadastrar.size() == 0) {
			System.out.println("\n Ainda não existem produtos cadastrados!\n");
		} else {
			System.out.println("\n~~BUSCA DE PRODUTOS CADASTRADOS~~\n INFORME O NOME DO PRODUTO A SER BUSCADO");
			
			String busca = ler.nextLine();
			
			for (int i = 0; i < prodCadastrar.size(); i++) {
				
				Produtos p = prodCadastrar.get(i);
				
				if(busca.equalsIgnoreCase(p.Produto())){
					String novoProd, novaDescricao;
					Double novoValor, novoLucro, novoEstoque;
					
					System.out.println("Cliente número: " + i++);
					System.out.println("Nome: " + p.Produto());
					System.out.println("Descrição: " + p.Descricao());
					System.out.println("Valor por unidade: R$" + p.Valor() + "\n");
					System.out.println("Porcentagem de lucro: " + p.Lucro() + "%\n");
					System.out.println("Unidades em estoque: " + p.Estoque() + "\n");
					
					System.out.println("Deseja alterar os dados deste produto? (Sim/Não)");
					String sair = ler.nextLine();
					
					if(sair.equalsIgnoreCase("Sim")) {
						
						System.out.println("Informe o novo nome do produto: ");
						novoProd = ler.nextLine();
						p.nomeProd(p.Produto().replaceAll(p.Produto(), novoProd));
						
						System.out.println("Informe a nova descrição do produto: ");
						novaDescricao = ler.nextLine();
						p.prodDescricao(p.Descricao().replaceAll(p.Descricao(), novaDescricao));
						
						System.out.println("Informe o novo valor do produto: ");
						novoValor = ler.nextDouble();
						ler.nextLine();
						p.prodValor((p.Valor()-p.Valor()) + novoValor);
						
						System.out.println("Informe a nova porcentagem de lucro do produto: ");
						novoLucro = ler.nextDouble();
						ler.nextLine();
						p.vendaLucro((p.Lucro()-p.Lucro()) + novoLucro);
						
						System.out.println("Informe a nova quantidade em estoque do produto: ");
						novoEstoque  = ler.nextDouble();
						ler.nextLine();
						p.produtoEstoque((p.Estoque()-p.Estoque()) + novoEstoque);
						
						System.out.println("Esses são os novos dados do produto: ");
						System.out.println("NOME: " + p.Produto());
						System.out.println("DESCRIÇÃO: " + p.Descricao());
						System.out.println("VALOR: " + p.Valor());
						System.out.println("PORCENTAGEM DE LUCRO: " + p.Lucro());
						System.out.println("QUANTIDADE EM ESTOQUE: " + p.Estoque());
					}
				}else if(!busca.equalsIgnoreCase(p.Produto())){
					if(i == (prodCadastrar.size() - 1)) {
					System.out.println("Não há produtos cadastrados com o nome informado!\n RETORNANDO AO MENU");
					}
				}
			}
		}
	}
	
	//Cadastro de produtos
	private void cadastrarProdutos() {
		boolean cadastrando = true;
		int contador,totalCadastrar;
		
		System.out.println("BEM VINDO AO CADASTRO DE PRODUTOS");
		System.out.println("Informe quantos produtos deseja cadastrar: ");
		totalCadastrar = ler.nextInt();
		ler.nextLine();
		
		contador = 0;
		while(cadastrando) {
			Produtos p = new Produtos();
			
			System.out.println("Nome do produto: ");
			p.nomeProd(ler.nextLine());
			
			System.out.println("Descrição do produto: ");
			p.prodDescricao(ler.nextLine());
			
			System.out.println("Valor do produto (por unidade): ");
			p.prodValor(ler.nextDouble());
			ler.nextLine();
			
			System.out.println("Porcentagem de lucro na venda do produto: ");
			p.vendaLucro(ler.nextDouble());
			ler.nextLine();
			
			System.out.println("Unidades do produto disponíveis em estoque: ");
			p.produtoEstoque(ler.nextDouble());
			ler.nextLine();
			
			System.out.println("Confirmar cadastro (Sim/Não) ?");
			String confirmar = ler.nextLine();
			
			if(confirmar.equalsIgnoreCase("Sim")) {
				System.out.println("Cadastro confirmado!");
				prodCadastrar.add(p);
				contador ++;
				
				if(contador == totalCadastrar) {
					System.out.println("PRODUTOS CADASTRADOS COM SUCESSO!");
					cadastrando = false;
				}
				
			}else if (confirmar.equalsIgnoreCase("Não")) {
				System.out.println("Cadastro cancelado!");
				cadastrando = false;
			}else {
				System.out.println("\n ERRO - FAVOR REPETIR CADASTRO NOVAMENTE");
			}
			
		}
	}
	
	//Cadastro de Vendas
	private void cadastrarVendas() {
		boolean listando = true;
		//String produtoVendido;
		
		if (dadosCadastrar.size() == 0) {
			System.out.println("\nNão existem clientes cadastrados!\n");
		}else if (prodCadastrar.size() == 0) {
				System.out.println("\nNão existem produtos cadastrados!\n");
		}else {
				System.out.println("\nLista de Cadastros\n");
				for (int i = 0; i < dadosCadastrar.size(); i++) {
					Dados d = dadosCadastrar.get(i);
					System.out.println("Cadastro número: " + i);
					System.out.println("Nome: " + d.Nome());
				
				}
				System.out.println("Informe o nome do cliente que realizou a compra: ");
				String cliente = ler.nextLine();
				
				for (int i = 0; i < dadosCadastrar.size(); i++) {
					Dados d = dadosCadastrar.get(i);

					 if(cliente.equalsIgnoreCase(d.Nome())) {
						System.out.println("Cliente comprador: " + cliente.toUpperCase());
					}
				
				}
				
				while(listando) {
					
					System.out.println("\nLista de Produtos\n");
					
					for (int i = 0; i < prodCadastrar.size(); i++) {
					
						Produtos p = prodCadastrar.get(i);
					
						System.out.println("Produto número: " + (i));
						System.out.println("Nome: " + p.Produto());
						System.out.println("Unidades em estoque: " + p.Estoque());
						
					}
					
					System.out.println("Informe o produto que foi comprado pelo cliente: ");
					String compra = ler.nextLine();
					
						for (int i = 0; i < prodCadastrar.size(); i++) {
						
						Produtos p = prodCadastrar.get(i);
					
							if(compra.equalsIgnoreCase(p.Produto())) {
								System.out.println("Informe quantas unidades do produto o cliente comprou: ");
								double unidade = ler.nextDouble();
								ler.nextLine();
								
								p.produtoEstoque(p.Estoque() - unidade);
								
								System.out.println("Venda registrada com sucesso!!");
								System.out.println("Nova quantidade do produto em estoque: " + p.Estoque());
								
								System.out.println("Deseja registrar outra compra em nome do cliente? (Sim/Não)");
								String sair  = ler.nextLine();
								
								if(sair.equalsIgnoreCase("sim")) {
									
								}else if(sair.equalsIgnoreCase("não")) {
									System.out.println("RETORNANDO AO MENU...");
									listando = false;									
								}
							}else {
								
							}
						
						}
				}
		}
	}
	
	//Produtos em Estoque
	private void listarProdutos() {
		
		if(prodCadastrar.size() == 0) {
			System.out.println("Não há produtos cadastrados no sistema");
		}else {
			System.out.println("PRODUTOS DISPONÍVEIS EM ESTOQUE");
			for (int i = 0; i < prodCadastrar.size(); i++) {
			
				Produtos p = prodCadastrar.get(i);
				
				System.out.println("PRODUTO NÚMERO " + i + ": " + p.Produto());
				System.out.println("QUANTIDADE: " + p.Estoque() + "\n");
			
			}
		}
	}
	
	//Sair
	private void sairMenu(){
		System.out.println("ENCERRANDO SISTEMA...\n =====TENHA UM BOM DIA=====");
		executar = false;
	}
	
	//10 clientes e vendas pré cadastrados
	private void preCadastros(){
		for(int i = 0; i < 10; i++) {
		Dados d = new Dados();
		Produtos p = new Produtos();
		
		//CLIENTE & PRODUTO COM INDICE 0
		if(i == 0) {
		d.nomeCliente("Alan Turing");
		d.endCliente("Londres, Inglaterra");
		d.telCliente("44 (0)20 3862 3352");
		
		p.nomeProd("Celular 32gb");
		p.prodDescricao("Celular com 32gb de memória");
		p.prodValor(1299.99);
		p.vendaLucro(68.9);
		p.produtoEstoque(5.0);
		
		}
		
		//CLIENTE & PRODUTO COM INDICE 1
		if(i == 1) {
		d.nomeCliente("Bill Gates");
		d.endCliente("Seattle, Estados Unidos");
		d.telCliente("(206) 709-3100");
		
		p.nomeProd("Biscoito de Maizena");
		p.prodDescricao("Pacote com 100g de biscoito de maizena");
		p.prodValor(2.99);
		p.vendaLucro(70.0);
		p.produtoEstoque(125.0);
		}
		
		//CLIENTE & PRODUTO COM INDICE 2
		if(i == 2) {
		d.nomeCliente("Chris Sawyer");
		d.endCliente("Dundee, Escócia");
		d.telCliente("22031999");

		p.nomeProd("Amaciante Cheiro Bão");
		p.prodDescricao("Amaciante 5 litros da marca Cheiro Bão");
		p.prodValor(13.99);
		p.vendaLucro(52.15);
		p.produtoEstoque(46.0);
		}
		
		//CLIENTE & PRODUTO COM INDICE 3
		if(i == 3) {
		d.nomeCliente("Daniela Silva");
		d.endCliente("Rua 48, Lote 10, Casa 15");
		d.telCliente("61 91234 5678");

		p.nomeProd("Arroz Sabor Bão");
		p.prodDescricao("Pacote de arroz com 5kg, da marca Sabor Bão");
		p.prodValor(16.99);
		p.vendaLucro(67.0);
		p.produtoEstoque(25.0);
		}
		
		//CLIENTE & PRODUTO COM INDICE 4
		if(i == 4) {
		d.nomeCliente("Wilson Arantes");
		d.endCliente("Chácara 121 Rua 10A Lotes 22/28, St. Hab. Vicente Pires");
		d.telCliente("98317-2693");

		p.nomeProd("Camisa Flamengo 20/21");
		p.prodDescricao("Camisa 1 do Flamengo da Temporada 20/21");
		p.prodValor(249.00);
		p.vendaLucro(354.0);
		p.produtoEstoque(21.0);
		}
		
		//CLIENTE & PRODUTO COM INDICE 5
		if(i == 5) {
		d.nomeCliente("Shigeru Miyamoto");
		d.endCliente("Tóquio, Japão");
		d.telCliente("81 3-3440-6911");

		p.nomeProd("Console Nintendo Switch 32gb");
		p.prodDescricao("Console Nintendo Switch com 32gb de memória");
		p.prodValor(2499.99);
		p.vendaLucro(84.3);
		p.produtoEstoque(12.0);
		}
		
		//CLIENTE & PRODUTO COM INDICE 6
		if(i == 6) {
		d.nomeCliente("Luiza Vieira");
		d.endCliente("Terceira Avenida, Bloco 1420, Lote 1520A - Núcleo Bandeirante, Brasília");
		d.telCliente("(61) 3041-8584");

		p.nomeProd("Máquina de lavar 9kg");
		p.prodDescricao("Máquina de lavar com capacidade 9kg");
		p.prodValor(1078.99);
		p.vendaLucro(67.2);
		p.produtoEstoque(5.0);
		}
		
		//CLIENTE & PRODUTO COM INDICE 7
		if(i == 7) {
		d.nomeCliente("Eduardo Saverin");
		d.endCliente("50 RAFFLES PL, 048623, Singapura");
		d.telCliente("2191-6565");

		p.nomeProd("Cartão pré-pago Netflix 3 meses");
		p.prodDescricao("Cartão com código para 3 meses de assinatura Netflix");
		p.prodValor(65.99);
		p.vendaLucro(30.0);
		p.produtoEstoque(109.0);
		}
		
		//Pré cadastro 9
		if(i == 8) {
		d.nomeCliente("Henrique Galdino");
		d.endCliente("Rua Logo Ali, Lote 0, Casa 0");
		d.telCliente("44 (0)20 3862 3352");

		p.nomeProd("Slam Dunk Vol. 09");
		p.prodDescricao("Volume 09 do mangá Slam Dunk, com 232 páginas");
		p.prodValor(17.99);
		p.vendaLucro(89.61);
		p.produtoEstoque(30.0);
		}
		
		//Pré cadastro 10
		if(i == 9) {
		d.nomeCliente("Fulano da Silva");
		d.endCliente("UnB - Brasília, DF");
		d.telCliente("61 4002-8922");
		
		p.nomeProd("Notebook 8gb RAM  1Tb");
		p.prodDescricao("Notebook com 8gb de memória ram e HD de 1tb");
		p.prodValor(3442.99);
		p.vendaLucro(111.0);
		p.produtoEstoque(2.0);
		}
		
		dadosCadastrar.add(d);
		prodCadastrar.add(p);
		}
	}
	
}
