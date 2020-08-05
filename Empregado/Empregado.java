package Empregado;



public abstract class Empregado {

	//Criando os atributos da classe abstrata Empregado;
	protected String nome;
	protected String cargo;
	protected double salarioBase;
	
	//SObrescrevendo o método toString;
	@Override
	public String toString() {
		return "----- PERFIL DO FUNCIONÁRIO -----\nNome: " + getNome() +"\nCargo: " + getCargo() + "\nSalário Base: " + getSalarioBase() + "\n";
	}
	
	
	//Criando getters e setters;
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	

}
