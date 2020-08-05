package Gratifica��o;

import Datas.Datas;

public class GratHoraExtra extends Gratificacao {
	
	//Criando o construtor do tipo de gratifica��o por hora extra e j� fazendo o c�lculo do valor da gratifica��o;
	public GratHoraExtra(Double salario, String data_trabalhada, int hora_trabalhada) {
		super.porcentagem = 0.001;
		super.dataTrabalhada = new Datas(data_trabalhada);
		super.setTipo(TipoGratificacao.Hora_extra);
		super.calculaGratificacao(salario, hora_trabalhada);
	}

}
