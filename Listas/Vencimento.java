package Listas;

import java.util.ArrayList;

import Gratifica��o.Gratificacao;

public class Vencimento {
	
	//Criando um arraylist de vencimentos;
	protected ArrayList<Gratificacao> lista;

	//Construtor de vencimento que instancia uma lista de gratifica��o;
	public Vencimento() {
		lista = new ArrayList<Gratificacao>();
	}
	
	//Criando o get da lista de gratifica��o;
	public ArrayList<Gratificacao> getLista() {
		return lista;
	}
	
	//Lista que adiciona uma gratifica��o a uma lista de vencimentos;
	public boolean adicionaNaLista(Gratificacao g) {

		return lista.add(g);

	}
	
	//M�todo que remove uma gratifica��o da lista de vencimentos;
	public void removeDaLista(int index) {
		if (recuperaDaLista(index) != null) {
			lista.remove(index);
			System.out.println("GRATIFICACAO EXCLUIDA COM SUCESSO...");
		}

	}
	
	//M�todo que recupera uma gratifica��o, da lista de vencimentos;
	public Gratificacao recuperaDaLista(int index) {

		for (Gratificacao gratificacao : lista) {
			
			//Condi��o para testar se o index de da gratifica��o desejada na lista de vencimentos � igual ao passado no par�mtero; 
			if (lista.indexOf(gratificacao) == index)
				return gratificacao;
		}
		
		Gratificacao g = null;
		System.err.println("Gratificacao Inexistente");
		return g;
	}
	
	//M�todo atualiza a data na lista de vencimentos;
	public void atualizaData(int index, String nova_data) {
		Gratificacao g = recuperaDaLista(index);
		g.setDataTrabalhada(nova_data);

	}
	
	//Recupera a lista vencimentos de gratifica��es;
	public void recuperaListaDeGratificacao() {
		System.out.println("\n-LISTA-DE-VENCIMENTOS-\n");
		
		//Condi��o para saber se a lista de gratifica��es de dado funcion�rio est� vazia;
		if (lista.isEmpty()) {
			System.err.println("O empregado n�o possui gratifica��es...");
		}

		for (Gratificacao g : lista) {
			System.out.println("\nGratifica��o: " + g + "\nIndex: " + lista.indexOf(g));
		}

	}
	
	//Atributos de valor mensal recebido pelo funcion�rio e o contador de gratifica��es recebidas;
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
	
	
	//M�todo que calcula o valor da gratifica��o que irpa ser atribu�da a um empregado;
	public double valorDaGratificacao() {
		//Condi��o para testar se a lista � vazia ou nula;
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
