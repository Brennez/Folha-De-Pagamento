package Empregado;

public class Funcionario extends Empregado {
	
	//Criando o construtor de Funcion�rio que extende a classe abstrata de Empregado;
	public Funcionario(String nome) {
		super.nome = nome;
		super.cargo = "Funcion�rio";
		super.salarioBase = 2500;
		
	}

}
