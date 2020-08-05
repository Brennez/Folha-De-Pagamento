package Gratificação;

import Datas.Datas;

public class GratDesempenho extends Gratificacao{
	
	//Criando o construtor do tipo de gratificação por desempenho e já fazendo o cálculo do valor da gratificação;
	public GratDesempenho(double salario, String data_trabalhada) {
		super.porcentagem = 0.05;
		super.dataTrabalhada = new Datas(data_trabalhada);
		super.setTipo(TipoGratificacao.Desempenho);
		super.calculaGratificacao(salario);
	}
}
