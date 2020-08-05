package Listas;

import java.util.ArrayList;

import Empregado.Empregado;
import Empregado.Funcionario;
import Empregado.Gerente;

public class ListaDeFuncionario {
	
	//Criando o Arraylist de empregado;
	private static ArrayList<Empregado> listaDeEmpregados;
	
	//Criando um get do Arraylist de empregado;
	public static ArrayList<Empregado> getListaDeEmpregados() {
		return listaDeEmpregados;
	}
	
	//M�todo que pega o index do objeto de funcion�rio instanciado;
	public static int indexDoObjeto(String nome_do_funcionario) {
		int id = 0;
		for (Empregado empregado : listaDeEmpregados) {
			if (empregado.getNome().equals(nome_do_funcionario)) {
				id = empregado.getNome().indexOf(nome_do_funcionario);
			}
		}
		return id;
	}
	
	//M�todo que cadastra empregado e atribui no Arraylist;
	public static Boolean cadastraEmpregado(String nome, String cargo) {
		Vencimento v;
		//Condi��o para testar se a lista n�o est� vazia;
		if (listaDeEmpregados == null) {
			listaDeEmpregados = new ArrayList<Empregado>();
		}
		
		//Switch case para os dois tipos poss�veis de cargos dos empregados;
		switch (cargo) {
		case "Funcion�rio":
			Empregado funcionario = new Funcionario(nome);
			 v = new Vencimento();
			listaDeEmpregados.add(funcionario);
			ListaDeGratificacoes.criaEmpregado(funcionario, v);
			return true;
			
		case "Gerente":
			Empregado gerente = new Gerente(nome);
			 v = new Vencimento();
			listaDeEmpregados.add(gerente);
			ListaDeGratificacoes.criaEmpregado(gerente, v);
			return true;
		//Tratamento de erro caso o usu�rio digite algo fora das op��es informadas;
		default:
			System.err.println("Erro!! Op��o de cargo inv�lida...");
			return false;
		}

	}
	
	//M�todo que remove empregado e retira do Arraylist por meio do index do objeto;
	public static boolean removeEmpregado(int index) {
		//Condi��o para testar se o index de empregado existe, para poder ser exclu�do;
		if (recuperaEmpregado(index) != null) {
			Empregado e = recuperaEmpregado(index);
			ListaDeGratificacoes.getListaDeGratificacoes().remove(e);
			listaDeEmpregados.remove(index);
			System.out.println("\nEMPREGADO EXCLUIDO COM SUCESSO...");
			return true;
		}
		return false;
	}
	
	//M�todo que atualiza o nome do empregado e modifica no Arraylist;
	public static void atualizaEmpregadoNome(int index, String novo_nome) {
		recuperaEmpregado(index).setNome(novo_nome);
	}
	
	//M�todo que atualiza o sal�rio do empregado e modifica no Arraylist;
	public static void atualizaEmpregado(int index, double novo_salario) {
		recuperaEmpregado(index).setSalarioBase(novo_salario);
	}
	
	//M�todo que atualiza o nome e o sal�rio do empregado e modifica no Arraylist;
	public static void atualizaEmpregado(int index, String novo_nome, Double novo_salario) {
		recuperaEmpregado(index).setNome(novo_nome);
		recuperaEmpregado(index).setSalarioBase(novo_salario);
	}
	
	//M�todo que retorna um empregado passando o index do mesmo como par�metro;
	public static Empregado recuperaEmpregado(int index) {
		for (Empregado empregado : listaDeEmpregados) {
			if(listaDeEmpregados.indexOf(empregado) == index)
				return empregado;
		}
		Empregado e = null;
		System.err.println("Empregado Inexistente");
		return e;
	}
	
	//M�todo que recupera a lista de empregados cadastrados e mostra na tela;
	public static void recuperaListaDeEmpregados() {
		System.out.println("\n-LISTA-DE-FUNCION�RIOS-\n");
		for (Empregado empregado : listaDeEmpregados) {
			System.out.println("Nome: " + empregado.getNome() + "\nCargo: " + empregado.getCargo() + "\nSal�rio: "
					+ empregado.getSalarioBase() + "\nId: " + listaDeEmpregados.indexOf(empregado) + "\n---------------\n");
		}

	}

}
