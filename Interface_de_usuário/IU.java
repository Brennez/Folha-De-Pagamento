package Interface_de_usu�rio;


import java.util.Scanner;

import Empregado.Empregado;
import Gratifica��o.Gratificacao;
import Gratifica��o.TipoGratificacao;
import Listas.ListaDeFuncionario;
import Listas.ListaDeGratificacoes;

public class IU {
	
	//Criando os atributos de leitura do teclado e nome;
	private static Scanner ler;											
	private static String leitura;
	
	/*
	 * "SubMenu Funcionario e Gratificacao"
	 * 
	 * + Recupera Dados 
	 * + Atualiza Dados 
	 * + Mostra Lista de Gratificacao 
	 * + Adiciona
	 * + Gratificacao 
	 * 		= Hora Extra 
	 * 		= Desemprenho
	 * + Remove Gratificacao // passa o indice da gratificacao 
	 * + Atualiza Gratificacao
	 * + Voltar
	 */
	
	//Menu Principal que ir� ser exibido;
	private static void menuPrincipal() {
		System.out.println("\n\n------ MENU DE PRINCIPAL ------\n");
		System.out.println("[1] Menu de empregados");
		System.out.println("[2] Folha de pagamento");
		System.out.println("[0] Sair");
		System.out.print("\nDigite sua op��o: ");
	}

	//Menu de funcion�rio que ir� ser exibido;
	private static void menuDeFuncionario() {

		System.out.println("\n\n------ MENU DE EMPREGADO ------\n");
		System.out.println("[1] Recupera lista de empregados");
		System.out.println("[2] Acessar Empregado");
		System.out.println("[3] Cadastrar Novo Empregado");
		System.out.println("[0] Voltar ao menu anterior");

		System.out.print("\nDigite sua op��o: ");

	}

	//Sub menu de funcion�rio que ir� ser exibido;
	private static void subMenuDeFuncionario(Empregado e) {

		System.out.println("\n\n------ MENU DO EMPREGADO " + e.getNome() + " ------\n");
		System.out.println("[1] Recupera Dados");
		System.out.println("[2] Atualiza Dados");
		System.out.println("[3] Mostrar Lista de Gratifica��o");
		System.out.println("[4] Adicionar Gratifica��o");
		System.out.println("[5] Excluir Gratifica��o");
		System.out.println("[6] Excluir Empregado");
		System.out.println("[7] Atualizar Gratifica��o");
		System.out.println("[0] Voltar ao menu anterior");

		System.out.print("\nDigite sua op��o: ");

	}



	
	//Criando o menu d que ir� atualizar uma gratifica��o;
	private static void menuAtualizaGratificacao(TipoGratificacao tp) {

		//Condi��o para saber se a gratifica��o � por desmepenho ou por hora extra;
		if (tp == TipoGratificacao.Hora_extra) {
			System.out.println("\n\n------ MENU DE ATUALIZA��O ------\n");
			System.out.println("[1] Atualiza data trabalhada");
			System.out.println("[2] Atualiza hora trabalhada");
			System.out.println("[3] Atualiza data e hora trabalhada");
			System.out.println("[0] Voltar ao menu anterior");
			System.out.print("\nDigite sua op��o: ");
		} else {
			System.out.println("\n\n------ MENU DE ATUALIZA��O ------\n");
			System.out.println("[1] Atualiza data trabalhada");
			System.out.println("[0] Voltar ao menu anterior");
			System.out.print("\nDigite sua op��o: ");
		}

	}

	//Menu que atualiza funcion�rio que ir� ser exibido;
	private static void menuAtualizaFuncionario() {

		System.out.println("\n\n------ MENU DE ATUALIZA��O ------\n");
		System.out.println("[1] Atualiza nome e sal�rio");
		System.out.println("[2] Atualiza nome");
		System.out.println("[3] Atualiza sal�rio");
		System.out.println("[0] Voltar ao menu anterior");
		System.out.print("\nDigite sua op��o: ");
	}

	//Criando a interface de usu�rio principal;
	public static void IUPrincipal() {
		int op;
		ler = new Scanner(System.in);

		do {
			menuPrincipal();											//Chama o print do menu com suas op��es 
			try {
				leitura = ler.next();
				for (int i = 0; i < leitura.length(); i++) {
					Character caractere = leitura.charAt(i);
					if (!(Character.isDigit(caractere))) {
						throw new Exception();
					}
				}
				op = Integer.valueOf(leitura);
			} catch (Exception e) {
				System.err.println("\nDigite apenas n�meros");
				op = 99;
				leitura = "erro";
			}	
			
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
				if(!leitura.equals("erro"))
					System.out.println("\nOp��o inv�lida, digite novamente.");
				break;
			}
		} while (op != 0);
	}

	//Criando a interface de usu�rio que ir� fazer as modifica��es poss�veis em um empregado;
	public static void IUdeFuncionario() {
		ler = new Scanner(System.in);
		int opf;

		do {
			menuDeFuncionario();
			
			try {
				leitura = ler.next();
				for (int i = 0; i < leitura.length(); i++) {
					Character caractere = leitura.charAt(i);
					if (!(Character.isDigit(caractere))) {
						throw new Exception();
					}
				}
				opf = Integer.valueOf(leitura);
			} catch (Exception e) {
				System.err.println("\nDigite apenas n�meros");
				opf = 99;
				leitura = "erro";
			}

			switch (opf) {

			case 1:

				ListaDeFuncionario.recuperaListaDeEmpregados();

				break;

			case 2:

				System.out.print("Digite o �ndice do empregado a ser acessado: ");
				int ep = ler.nextInt();
				IUSubFuncionario(ep);
				break;

			//op��o em caso de execu��o de um cadastro de empregado;
			case 3:
				String nome;
				String cargo = "";
				int f = 1;

				while (true) {
					System.out.println("------ MENU DE CADASTRO ------");
					System.out.println("[1] Funcion�rio");
					System.out.println("[2] Gerente");
					System.out.print("Cargo: ");
					int c;
					
					try {
						leitura = ler.next();
						for (int i = 0; i < leitura.length(); i++) {
							Character caractere = leitura.charAt(i);
							if (!(Character.isDigit(caractere))) {
								throw new Exception();
							}
						}
						c = Integer.valueOf(leitura);
					} catch (Exception e) {
						System.err.println("\nDigite apenas n�meros");
						c = 99;
						leitura = "erro";
					}
					
					switch (c) {
					case 1:
						cargo = "Funcion�rio";
						f = 0;
						break;
					case 2:
						cargo = "Gerente";
						f = 0;
						break;
					default:
						if(!leitura.equals("erro"))
							System.out.println("\nOp��o inv�lida, digite novamente.");
						break;
					}
					if (f == 0)		//condicional para sair do la�o infinito;
						break;
				}
				while (true) {
					
					//Bloco try catch para tratar a exce��o caso o usu�rio digite algo que n�o seja letras; 
					try {
						System.out.print("\nNome: ");
						nome = ler.next();
						for (int i = 0; i < nome.length(); i++) {
							Character caractere = nome.charAt(i);
							if (Character.isDigit(caractere)) {
								throw new Exception();
							}
						}
						ListaDeFuncionario.cadastraEmpregado(nome, cargo);
						System.out.println("\nEMPREGADO CADASTRADO");
						break;
					} catch (Exception e) {
						System.err.println(
								"\nErro!!\n Verifique se o nome est� correto (Sem n�meros)");
					}
				}

				break;

			case 0:
				break;
			default:
				if(!leitura.equals("erro"))
					System.out.println("\nOp��o inv�lida, digite novamente.");
				break;

			}
		} while (opf != 0);		//condi��o para sair do la�o infinito;
	}
	
	//Criando sub interface de usu�rio, na qual mostra as op��es poss�veis de um empregado;
	private static void IUSubFuncionario(int ep) {
		Empregado e = ListaDeFuncionario.recuperaEmpregado(ep);
		if (e != null) {

			ler = new Scanner(System.in);
			int ops;
			do {
				subMenuDeFuncionario(e);
				try {
					leitura = ler.next();
					for (int i = 0; i < leitura.length(); i++) {
						Character caractere = leitura.charAt(i);
						if (!(Character.isDigit(caractere))) {
							throw new Exception();
						}
					}
					ops = Integer.valueOf(leitura);
				} catch (Exception erro) {
					System.err.println("\nDigite apenas n�meros");
					ops = 99;
					leitura = "erro";
				}

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
					
				//Tela que adiciona uma gratifica��o a um empregado;
				case 4:
					int opg;
					boolean f = true;
					while (f) {
						System.out.println("[1] Hora Extra");
						System.out.println("[2] Desempenho");
						System.out.print("Op��o: ");
						
						try {
							leitura = ler.next();
							for (int i = 0; i < leitura.length(); i++) {
								Character caractere = leitura.charAt(i);
								if (!(Character.isDigit(caractere))) {
									throw new Exception();
								}
							}
							opg = Integer.valueOf(leitura);
						} catch (Exception erro) {
							System.err.println("\nDigite apenas n�meros");
							opg = 99;
							leitura = "erro";
						}
						
						switch (opg) {
						case 1:
							System.out.println("------ MENU DE CADASTRO GRATIFICA��O ------");

							System.out.print("Quantidade de horas trabalhadas: ");
							int hora = ler.nextInt();

							System.out.print("Data Trabalhada: ");
							String data = ler.next();

							if(ListaDeGratificacoes.adicionaGratificacao(ep, data, hora))
								System.out.println("GRATIFICA��O ADICIONADA");
							f = false;
							break;
							
						//Tela que ir� cadastrar uma gratifica��o a um empregado;
						case 2:
							System.out.println("------ MENU DE CADASTRO ------");

							System.out.print("Data Trabalhada: ");
							String data1 = ler.next();

							if(ListaDeGratificacoes.adicionaGratificacao(ep, data1))
								System.out.println("GRATIFICA��O ADICIONADA");
							f = false;
							break;
						default:
							if(!leitura.equals("erro"))
								System.out.println("\nOp��o inv�lida, digite novamente.");
							break;
						}
					}
					break;
				case 5:

					System.out.print("Qual o �ndice da gratifica��o: ");
					int opg1;
					
					try {
						leitura = ler.next();
						for (int i = 0; i < leitura.length(); i++) {
							Character caractere = leitura.charAt(i);
							if (!(Character.isDigit(caractere))) {
								throw new Exception();
							}
						}
						opg1 = Integer.valueOf(leitura);
					} catch (Exception erro) {
						System.err.println("\nDigite apenas n�meros");
						opg1 = 99;
						leitura = "erro";
					}
					
					ListaDeGratificacoes.removeGratificacao(ep, opg1);

					break;
				case 6:
					ListaDeFuncionario.removeEmpregado(ep);
					ops = 0;
				case 0:
					break;
				case 7:
					System.out.print("Qual o �ndice da gratifica��o: ");
					int opg2;
					
					try {
						leitura = ler.next();
						for (int i = 0; i < leitura.length(); i++) {
							Character caractere = leitura.charAt(i);
							if (!(Character.isDigit(caractere))) {
								throw new Exception();
							}
						}
						opg2 = Integer.valueOf(leitura);
					} catch (Exception erro) {
						System.err.println("\nDigite apenas n�meros");
						opg2 = 99;
						leitura = "erro";
					}
					
					IUAtualizaGratificacao(ep, opg2);
					break;
				default:
					if(!leitura.equals("erro"))
						System.out.println("\nOp��o inv�lida, digite novamente.");
					break;
				}

			} while (ops != 0);		//Condi��o para sair do la�o infinito;
		}

	}

	//Tela que faz as a��es poss�veis na gratifica��o de um funcion�rio;
	private static void IUAtualizaGratificacao(int ep, int opg2) {
		Gratificacao g = ListaDeGratificacoes.recuperaGratificacao(ep, opg2);

		//Condi��o para testar se a lista de gratifica��es n�o � nula;
		if (g != null) {
			TipoGratificacao tp = g.getTipo();
			ler = new Scanner(System.in);
			int opg;

			do {

				menuAtualizaGratificacao(tp);

				try {
					leitura = ler.next();
					for (int i = 0; i < leitura.length(); i++) {
						Character caractere = leitura.charAt(i);
						if (!(Character.isDigit(caractere))) {
							throw new Exception();
						}
					}
					opg = Integer.valueOf(leitura);
				} catch (Exception erro) {
					System.err.println("\nDigite apenas n�meros");
					opg = 99;
					leitura = "erro";
				}

				//Tela para cadastrar uma gratifica��o por desempenho ou por hora_extra;
				switch (tp) {
				case Desempenho:
					switch (opg) {
					case 1:
						System.out.print("Digite a nova data: ");
						String data = ler.next();
						if(ListaDeGratificacoes.recuperaGratificacao(ep, opg2).setDataTrabalhada(data))
							System.out.println("ATUALIZADA COM SUCESSO");
						break;
					case 0:
						break;
					default:
						System.out.println("Op��o Inv�lida");
						break;
					}
					break;
				case Hora_extra:
					switch (opg) {
					case 1:
						System.out.print("Digite a nova data: ");
						String data = ler.next();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2).setDataTrabalhada(data);
						System.out.println("ATUALIZADA COM SUCESSO");
						break;
					case 2:
						System.out.print("Digite a nova hora trabalhada: ");
						int hora = ler.nextInt();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2)
								.calculaGratificacao(ListaDeFuncionario.recuperaEmpregado(ep).getSalarioBase(), hora);
						break;
					case 3:
						System.out.print("Digite a nova data: ");
						String data1 = ler.next();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2).setDataTrabalhada(data1);
						System.out.println("Digite a nova hora trabalhada: ");
						int hora1 = ler.nextInt();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2)
								.calculaGratificacao(ListaDeFuncionario.recuperaEmpregado(ep).getSalarioBase(), hora1);
						break;
					case 0:
						break;
					default:
						if(!leitura.equals("erro"))
							System.out.println("\nOp��o inv�lida, digite novamente.");
						break;
					}
					break;
				}

			} while (opg != 0);		//Condi��o para sair do la�o infinito;
		}

	}

	//Interface de usu�rio que atualiza um funcion�rio;
	private static void IUAtualizaFuncionario(Empregado e) {
		int opsf;
		do {
			menuAtualizaFuncionario();
			
			try {
				leitura = ler.next();
				for (int i = 0; i < leitura.length(); i++) {
					Character caractere = leitura.charAt(i);
					if (!(Character.isDigit(caractere))) {
						throw new Exception();
					}
				}
				opsf = Integer.valueOf(leitura);
			} catch (Exception erro) {
				System.err.println("\nDigite apenas n�meros");
				opsf = 99;
				leitura = "erro";
			}
			
			switch (opsf) {

			case 1:
				String nome;
				while (true) {
					
					//Bloco try catch para tratar a exce��o caso o usu�rio digite algo que n�o seja letras; 
					try {
						System.out.print("Novo Nome: ");
						nome = ler.next();
						for (int i = 0; i < nome.length(); i++) {
							Character caractere = nome.charAt(i);
							if (Character.isDigit(caractere)) {
								throw new Exception();
							}
						}
						e.setNome(nome);
						break;
					} catch (Exception erro) {
						System.err.println(
								"\nErro!!\n Verifique se o nome est� correto (Sem n�meros)");
					}
				}
				
				Double salario;
				
				while (true) {
					
					//Bloco try catch para tratar a exce��o caso o usu�rio digite algo que n�o seja letras; 
					try {
						System.out.print("Novo Sal�rio: ");
						leitura = ler.next();
						for (int i = 0; i < leitura.length(); i++) {
							Character caractere = leitura.charAt(i);
							if (!(Character.isDigit(caractere))) {
								throw new Exception();
							}
						}
						salario = Double.valueOf(leitura);
						e.setSalarioBase(salario);
						break;
					} catch (Exception erro) {
						System.err.println("\nDigite apenas n�meros");
					}
				}
				
				break;
			case 2:
				String nome1;
				while (true) {
					
					//Bloco try catch para tratar a exce��o caso o usu�rio digite algo que n�o seja letras; 
					try {
						System.out.print("Novo Nome: ");
						nome1 = ler.next();
						for (int i = 0; i < nome1.length(); i++) {
							Character caractere = nome1.charAt(i);
							if (Character.isDigit(caractere)) {
								throw new Exception();
							}
						}
						e.setNome(nome1);
						break;
					} catch (Exception erro) {
						System.err.println(
								"\nErro!!\n Verifique se o nome est� correto (Sem n�meros)");
					}
				}
				break;
			case 3:
				Double salario1;
				
				while (true) {
					
					//Bloco try catch para tratar a exce��o caso o usu�rio digite algo que n�o seja letras; 
					try {
						System.out.print("Novo Sal�rio: ");
						leitura = ler.next();
						for (int i = 0; i < leitura.length(); i++) {
							Character caractere = leitura.charAt(i);
							if (!(Character.isDigit(caractere))) {
								throw new Exception();
							}
						}
						salario1 = Double.valueOf(leitura);
						e.setSalarioBase(salario1);
						break;
					} catch (Exception erro) {
						System.err.println("\nDigite apenas n�meros");
					}
				}
				break;
			case 0:
				break;
			default:
				if(!leitura.equals("erro"))
					System.out.println("\nOp��o inv�lida, digite novamente.");
				break;
			}
		} while (opsf != 0);		//Condi��o de sa�da do la�o infinito;

	}

	}
