package Gratifica��o;

import Datas.Datas;

public class GratDesempenho extends Gratificacao{
	
	//Criando o construtor do tipo de gratifica��o por desempenho e j� fazendo o c�lculo do valor da gratifica��o;
	public GratDesempenho(double salario, String data_trabalhada) {
		super.porcentagem = 0.05;
		super.dataTrabalhada = new Datas(data_trabalhada);
		super.setTipo(TipoGratificacao.Desempenho);
		super.calculaGratificacao(salario);
	}
}
