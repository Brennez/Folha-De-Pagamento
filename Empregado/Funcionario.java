package Empregado;

public class Funcionario extends Empregado {
	
	//Criando o construtor de Funcionário que extende a classe abstrata de Empregado;
	public Funcionario(String nome) {
		super.nome = nome;
		super.cargo = "Funcionário";
		super.salarioBase = 2500;
		
	}

}
