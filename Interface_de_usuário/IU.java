package Interface_de_usuário;

import java.util.InputMismatchException;
import java.util.Scanner;

import Empregado.Empregado;
import Gratificação.Gratificacao;
import Gratificação.TipoGratificacao;
import Listas.ListaDeFuncionario;
import Listas.ListaDeGratificacoes;

public class IU {
	
	//Criando os atributos de leitura do teclado e nome;
	private static Scanner ler;

	private static String nome;
	
	//Menu Principal que irá ser exibido;
	private static void menuPrincipal() {
		System.out.println("\n\n------ MENU DE PRINCIPAL ------");
		System.out.println("[1] Menu de empregados");
		System.out.println("[2] Folha de pagamento");
		System.out.println("[0] SAIR");
		System.out.print("Digite sua opção: ");
	}
	
	//Menu de funcionário que irá ser exibido;
	private static void menuDeFuncionario() {

		System.out.println("\n\n------ MENU DE EMPREGADO ------");
		System.out.println("[1] Recupera lista de empregados");
		System.out.println("[2] Acessar Empregado");
		System.out.println("[3] Cadastrar Novo Empregado");
		System.out.println("[0] Voltar ao menu anterior\n");

		System.out.print("Digite sua opção: ");

	}


	//Sub menu de funcionário que irá ser exibido;
	private static void subMenuDeFuncionario(Empregado e) {

		System.out.println("\n\n------ MENU DO EMPREGADO " + e.getNome() + " ------");
		System.out.println("[1] Recupera Dados");
		System.out.println("[2] Atualiza Dados");
		System.out.println("[3] Mostrar Lista de Gratificao");
		System.out.println("[4] Adicionar Gratificacao");
		System.out.println("[5] Excluir Gratificacao");
		System.out.println("[6] Excluir Empregado");
		System.out.println("[7] Atualizar Gratificacao");
		System.out.println("[0] Voltar ao menu anterior\n");

		System.out.print("Digite sua opção: ");

	}

	@SuppressWarnings("unused")
	//Menu de Gratificação  que irá ser exibido;
	private static void menuDeGratificacao() {
		System.out.println("\n\n------ MENU DE GRATIFICAÇÃO ------");
		System.out.println("[1] Cadastrar Nova Gratificacao");
		System.out.println("[2] Atualiza Gratificao");
		System.out.println("[3] Recupera Lista de um Empregado");
		System.out.println("[3] Recupera Lista Completa");
		System.out.println("[0] Voltar ao menu anterior\n");
		System.out.print("Digite sua opção: ");
	}
	
	//Criando o menu d que irá atualizar uma gratificação;
	private static void menuAtualizaGratificacao(int index_empregado, int index_gratificacao,TipoGratificacao tp) {

		Gratificacao g = ListaDeGratificacoes.recuperaGratificacao(index_empregado, index_gratificacao);
		
		//Condição para saber se a gratificação é por desmepenho ou por hora extra;
		if (g.getTipo().equals(TipoGratificacao.Desempenho)) {
			System.out.println("\n\n------ MENU DE ATUALIZAÇÃO ------");
			System.out.println("[1] Atualiza data e hora trabalhada");
			System.out.println("[3] Atualiza data trabalhada");
			System.out.println("[3] Atualiza hora trabalhada");
			System.out.println("[0] Voltar ao menu anterior\n");
			System.out.print("Digite sua opção: ");
		} else {
			System.out.println("\n\n------ MENU DE ATUALIZAÇÃO ------");
			System.out.println("[1] Atualiza data trabalhada");
			System.out.println("[0] Voltar ao menu anterior\n");
			System.out.print("Digite sua opção: ");
		}

	}
	
	
	//Menu que atualiza funcionário que irá ser exibido;
	private static void menuAtualizaFuncionario() {

		System.out.println("\n\n------ MENU DE ATUALIZAÇÃO ------");
		System.out.println("[1] Atualiza nome e salário");
		System.out.println("[2] Atualiza nome");
		System.out.println("[3] Atualiza salário");
		System.out.println("[0] Voltar ao menu anterior\n");
		System.out.print("Digite sua opção: ");
	}
	
	//Criando a interface de usuário principal;
	public static void IUPrincipal() {
		int op;
		ler = new Scanner(System.in);
		do {
			menuPrincipal();
			op = ler.nextInt();
			switch (op) {
			case 1:
				IUdeFuncionario();
				break;
			case 2:
				ListaDeGratificacoes.mostraFolhaDePagamento();
				break;
			case 0:
				System.err.println("Saindo .....");
				break;
			default:
				System.out.println("Opção inválida, digite novamente.");
				break;
			}
		} while (op != 0);
	}
	
	//Criando a interface de usuário que irá fazer as modificações possíveis em um empregado;
	public static void IUdeFuncionario() {
		ler = new Scanner(System.in);
		int opf;

		do {
			menuDeFuncionario();
			opf = ler.nextInt();

			switch (opf) {

			case 1:
				/*
				 * bloco try catch para tratar a exceção caso a lista de funcionários 
				 * não tenha nenhum funcionário cadastrado ainda;
				 */
				try {
					ListaDeFuncionario.recuperaListaDeEmpregados();
				} catch (Exception e) {
					System.err.println("\nErro! Não existe lista de funcionários\n");
					System.out.println("Cadastre um funcionário\n");
					IUdeFuncionario();
				}
				break;

			case 2:
				/*
				 * Bloco try catch para tratar a exceção caso o usuário digite uma letra ou algo que não seja um  número;
				 */
				try {
					System.out.print("Digite o índice do empregado a ser acessado: ");
					int ep = ler.nextInt();
					IUSubFuncionario(ep);
				} catch (InputMismatchException e) {
					System.err.println("Erro!! Insira apenas números...");
				}
				
				break;
			//opção em caso de execução de um cadastro de empregado;
			case 3:

				String cargo = "";
				int f = 1;

				while (true) {
					
					System.out.println("------ MENU DE CADASTRO ------");
					System.out.println("[1] Funcionário");
					System.out.println("[2] Gerente");
					System.out.print("Cargo: ");
					int c = ler.nextInt();
					switch (c) {
					case 1:
						cargo = "Funcionário";
						f = 0;
						break;
					case 2:
						cargo = "Gerente";
						f = 0;
						break;
					default:
						System.err.println("Opcão inválida");
						break;
					}
					if (f == 0) //condicional para sair do laço infinito;
						break;
				}
				
				while (true) {
					
					/*
					 * Bloco try catch para tratar a exceção caso o usuário digite algo que não seja letras; 
					 */
					try {
						System.out.print("\n\nNome: ");
						nome = ler.next();
						for (int i = 0; i < nome.length(); i++) {
							Character caractere = nome.charAt(i);
							if (Character.isDigit(caractere)) {
								throw new Exception();
							}
						}
						ListaDeFuncionario.cadastraEmpregado(nome, cargo);
						System.out.println("EMPREGADO CADASTRADO COM SUCESSO...");
						break;
					} catch (Exception e) {
						System.err.println(
								"\nErro!!\n Verifique se o nome está correto (Sem números)\nVerifique se o cargo existe");
					}
				}

				break;

			case 0:
				break;
			default:
				System.out.println("Opção inválida, digite novamente: ");
				break;

			}
		} while (opf != 0); //condição para sair do laço infinito;
	}
	
	//Criando sub interface de usuário, na qual mostra as opções possíveis de um empregado;
	private static void IUSubFuncionario(int ep) {
		Empregado e = ListaDeFuncionario.recuperaEmpregado(ep);
		if (e != null) {

			ler = new Scanner(System.in);
			int ops;
			do {
				subMenuDeFuncionario(e);
				ops = ler.nextInt();

				switch (ops) {
				case 1:
					System.out.println(e);
					break;
				case 2:
					IUAtualizaFuncionario(e);
					break;

				case 3:
					ListaDeGratificacoes.mostraLista(ep);
					break;
				case 4:
					int opg;
					boolean f = true;
					//Tela que adiciona uma gratificação a um empregado;
					while (f) {
						System.out.println("[1] Hora Extra");
						System.out.println("[2] Desempenho");
						System.out.print("Opcao: ");
						opg = ler.nextInt();
						switch (opg) {
						case 1:
							System.out.println("------ MENU DE CADASTRO GRATIFICACAO ------");

							System.out.print("Quantidade de horas trabalhada: ");
							int hora = ler.nextInt();

							System.out.print("Data Trabalhada: ");
							String data = ler.next();

							ListaDeGratificacoes.adicionaGratificacao(ep, data, hora);
							if(ListaDeGratificacoes.adicionaGratificacao(ep, data))
								System.out.println("GRATIFICACAO ADICIONADA COM SUCESSO...");
							f = false;
							break;
						//Tela que irá cadastrar uma gratificação a um empregado;
						case 2:
							System.out.println("------ MENU DE CADASTRO ------");

							System.out.print("Data Trabalhada: ");
							String data1 = ler.next();

							ListaDeGratificacoes.adicionaGratificacao(ep, data1);
							if(ListaDeGratificacoes.adicionaGratificacao(ep, data1))
								System.out.println("GRATIFICACAO ADICIONADA COM SUCESSO...");
							
							f = false;
							break;
						default:
							System.err.println("Opção inválida ...");
							break;
						}
					}
					break;
				case 5:

					System.out.print("Qual o índice da gratificação: ");
					int opg1 = ler.nextInt();
					ListaDeGratificacoes.removeGratificacao(ep, opg1);
					
					break;
				case 6:
					ListaDeFuncionario.removeEmpregado(ep);
					System.out.println("Usuário excluído com sucesso...");
					ops = 0;
				case 0:
					break;
				case 7:
					System.out.println("Qual o índice da gratificação: ");
					int opg2 = ler.nextInt();
					IUAtualizaGratificacao(ep, opg2);
					break;
				default:
					System.out.println("Opção inválida, digite novamente.");
					break;
				}

			} while (ops != 0); //Condição para sair do laço infinito;
		}

	}

	//Tela que faz as ações possíveis na gratificação de um funcionário;
	private static void IUAtualizaGratificacao(int ep, int opg2) {
		Gratificacao g = ListaDeGratificacoes.recuperaGratificacao(ep, opg2);
		
		//Condição para testar se a lista de gratificações não é nula;
		if (g != null) {
			TipoGratificacao tp = g.getTipo();
			ler = new Scanner(System.in);
			int opg;

			do {

				menuAtualizaGratificacao(ep, opg2, tp);

				opg = ler.nextInt();
				
				//Tela para cadastrar uma gratificação por desempenho ou por hora_extra;
				switch (tp) {
				case Desempenho:
					switch (opg) {
					case 1:
						System.out.print("Digite a nova data: ");
						String data = ler.next();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2).setDataTrabalhada(data);
						System.out.println("ATUALIZADA COM SUCESSO...");
						break;
					case 0:
						break;
					default:
						System.err.println("Opção Inválida");
						break;
					}
					break;
				case Hora_extra:
					switch (opg) {
					case 1:
						System.out.print("Digite a nova data: ");
						String data = ler.next();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2).setDataTrabalhada(data);
						System.out.println("ATUALIZADA COM SUCESSO...");
						break;
					case 2:
						System.out.print("Digite a nova hora trabalhada: ");
						int hora = ler.nextInt();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2)
								.calculaGratificacao(ListaDeFuncionario.recuperaEmpregado(ep).getSalarioBase(), hora);
						System.out.println("ATUALIZADA COM SUCESSO...");
						break;
					case 3:
						System.out.print("Digite a nova data: ");
						String data1 = ler.next();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2).setDataTrabalhada(data1);
						System.out.print("Digite a nova hora trabalhada: ");
						int hora1 = ler.nextInt();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2)
								.calculaGratificacao(ListaDeFuncionario.recuperaEmpregado(ep).getSalarioBase(), hora1);
						System.out.println("ATUALIZADA COM SUCESSO...");
						break;
					case 0:
						break;
					default:
						System.err.println("Opção inválida");
						break;
					}
					break;
				}

			} while (opg != 0);	//Condição para sair do laço infinito;
		}

	}
	
	//Interface de usuário que atualiza um funcionário;
	private static void IUAtualizaFuncionario(Empregado e) {
		int opsf;
		do {
			menuAtualizaFuncionario();
			opsf = ler.nextInt();
			switch (opsf) {

			case 1:
				System.out.print("Novo Nome: ");
				String nome = ler.next();
				e.setNome(nome);
				System.out.print("Novo Salário: ");
				Double salario = ler.nextDouble();
				e.setSalarioBase(salario);
				break;
			case 2:
				System.out.print("Novo Nome: ");
				String nome1 = ler.next();
				e.setNome(nome1);
				break;
			case 3:
				System.out.print("Novo Salário: ");
				Double salario1 = ler.nextDouble();
				e.setSalarioBase(salario1);
				break;
			case 0:
				break;
			default:
				System.err.println("Opção inválida");
				break;
			}
		} while (opsf != 0);	//Condição de saída do laço infinito;

	}
}