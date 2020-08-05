package Gratificação;

import Datas.Datas;

public abstract class Gratificacao {
	
	//Criando os atributos da classe gratificação;
	protected double porcentagem;
	protected TipoGratificacao tipo;
	protected Datas dataTrabalhada;
	protected double valorDaGraftificacao;
	

	
	//Sobrescrevendo o método toString;
	@Override
	public String toString() {
		
		return "Tipo gratificação: " + getTipo() + "\nValor da gratificação: " + getValorDaGraftificacao() + 
				"\nData trabalhada: " + getDataTrabalhada(); 
	}
	
	//Criando getters e setters;
	public double getValorDaGraftificacao() {
		return valorDaGraftificacao;
	}

	public void setValorDaGraftificacao(double valorDaGraftificacao) {
		this.valorDaGraftificacao = valorDaGraftificacao;
	}

	public Datas getDataTrabalhada() {
		return dataTrabalhada;
	}

	public boolean setDataTrabalhada(String dataTrabalhada) {
		if(this.dataTrabalhada.setdata(dataTrabalhada))
			return true;
		return false;
	}

	public TipoGratificacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoGratificacao tipo) {
		this.tipo = tipo;
	}

	public double getPoecentagem() {
		return porcentagem;
	}

	public void setPoecentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	public double calculaGratificacao(double salario) {
		this.valorDaGraftificacao = salario * this.porcentagem;

		return this.valorDaGraftificacao;
	}
	
	//Criando o método que calcula o valor da gratificaão;
	public double calculaGratificacao(double salario, int hora_trabalhada) {
		//Bloco de tratamento de exceção caso a hora trabalhada seja menor que zero;
		try {
			if(hora_trabalhada <= 0)
				throw new Exception();
			this.valorDaGraftificacao = salario * this.porcentagem * hora_trabalhada;
		} catch(Exception e) {
			System.err.println("ERRO !! VERIFIQUE O AS HORAS TRABALHADAS");
		}

		return this.valorDaGraftificacao;
	}
	
	

}
