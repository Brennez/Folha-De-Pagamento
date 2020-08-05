package Gratifica��o;

import Datas.Datas;

public abstract class Gratificacao {
	
	//Criando os atributos da classe gratifica��o;
	protected double porcentagem;
	protected TipoGratificacao tipo;
	protected Datas dataTrabalhada;
	protected double valorDaGraftificacao;
	

	
	//Sobrescrevendo o m�todo toString;
	@Override
	public String toString() {
		
		return "Tipo gratifica��o: " + getTipo() + "\nValor da gratifica��o: " + getValorDaGraftificacao() + 
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
	
	//Criando o m�todo que calcula o valor da gratifica�o;
	public double calculaGratificacao(double salario, int hora_trabalhada) {
		//Bloco de tratamento de exce��o caso a hora trabalhada seja menor que zero;
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
