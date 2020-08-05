package Listas;

import java.util.ArrayList;

import Gratificação.Gratificacao;

public class Vencimento {
	
	//Criando um arraylist de vencimentos;
	protected ArrayList<Gratificacao> lista;

	//Construtor de vencimento que instancia uma lista de gratificação;
	public Vencimento() {
		lista = new ArrayList<Gratificacao>();
	}
	
	//Criando o get da lista de gratificação;
	public ArrayList<Gratificacao> getLista() {
		return lista;
	}
	
	//Lista que adiciona uma gratificação a uma lista de vencimentos;
	public boolean adicionaNaLista(Gratificacao g) {

		return lista.add(g);

	}
	
	//Método que remove uma gratificação da lista de vencimentos;
	public void removeDaLista(int index) {
		if (recuperaDaLista(index) != null) {
			lista.remove(index);
			System.out.println("GRATIFICACAO EXCLUIDA COM SUCESSO...");
		}

	}
	
	//Método que recupera uma gratificação, da lista de vencimentos;
	public Gratificacao recuperaDaLista(int index) {

		for (Gratificacao gratificacao : lista) {
			
			//Condição para testar se o index de da gratificação desejada na lista de vencimentos é igual ao passado no parâmtero; 
			if (lista.indexOf(gratificacao) == index)
				return gratificacao;
		}
		
		Gratificacao g = null;
		System.err.println("Gratificacao Inexistente");
		return g;
	}
	
	//Método atualiza a data na lista de vencimentos;
	public void atualizaData(int index, String nova_data) {
		Gratificacao g = recuperaDaLista(index);
		g.setDataTrabalhada(nova_data);

	}
	
	//Recupera a lista vencimentos de gratificações;
	public void recuperaListaDeGratificacao() {
		System.out.println("\n-LISTA-DE-VENCIMENTOS-\n");
		
		//Condição para saber se a lista de gratificações de dado funcionário está vazia;
		if (lista.isEmpty()) {
			System.err.println("O empregado não possui gratificações...");
		}

		for (Gratificacao g : lista) {
			System.out.println("\nGratificação: " + g + "\nIndex: " + lista.indexOf(g));
		}

	}
	
	//Atributos de valor mensal recebido pelo funcionário e o contador de gratificações recebidas;
	private double valorMensal = 0;
	private int contGrat = 0;

	//Criando getters e setters
	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public int getContGrat() {
		return contGrat;
	}

	public void setContGrat(int contGrat) {
		this.contGrat = contGrat;
	}
	
	
	//Método que calcula o valor da gratificação que irpa ser atribuída a um empregado;
	public double valorDaGratificacao() {
		//Condição para testar se a lista é vazia ou nula;
		if (!lista.isEmpty() || getLista() != null) {
			setContGrat(0);
			setValorMensal(0);
			for (Gratificacao gratificacao : lista) {
				setContGrat(getContGrat() + 1);
				setValorMensal(gratificacao.getValorDaGraftificacao() + getValorMensal());

			}
			return getValorMensal();
		}
		return 0;

	}

}
