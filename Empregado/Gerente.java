package Empregado;

public class Gerente extends Empregado {
	
	//Criando o construtor de Gerente que extende a classe abstrata de Empregado;
	public Gerente(String nome) {
		super.nome = nome;
		super.cargo = "Gerente";
		super.salarioBase = 4000;
	}

}
