package Datas;

import java.util.Calendar;

public class Datas {
	Calendar dataLimite;

	public boolean setdata(String data) {

		try {																	//Início do bloco try catch
			for (int i = 0; i < data.length(); i++) {							
				Character caractere = data.charAt(i);							//percorrendo os caracteres da string data e testenado, caso não tenha letras;
				if (!(Character.isDigit(caractere)) && !caractere.equals('/')) {
					throw new Exception();
				}
			}

			String[] arrayData = data.split("/");								//Cria o array string e irá quebrar a data em dia e mês;
			int[] arrayDiaEMes = new int[2];									//Criando o Array em que a data será armazenada;

			arrayDiaEMes[0] = Integer.valueOf(arrayData[0]);					//Converte cada String em um inteiro e atribui ao arrayDiaEMes;
			arrayDiaEMes[1] = Integer.valueOf(arrayData[1]);					//Converte cada String em um inteiro e atribui ao arrayDiaEMes;

			if (arrayDiaEMes[0] < 1 || arrayDiaEMes[0] > 30)					//Teste caso o usuário digite uma dia >30 e < 1;								
				throw new Exception();												
			if (arrayDiaEMes[1] < 1 || arrayDiaEMes[1] > 12)					//Teste caso o usuário digite uma mês >12 e < 1;
				throw new Exception();

			this.dataLimite = Calendar.getInstance();							//Recupera a instância de calendário;
			this.dataLimite.set(Calendar.DAY_OF_MONTH, arrayDiaEMes[0]);		//Atribui o valor inteiro pro dia no calendário;
			this.dataLimite.set(Calendar.MONTH, arrayDiaEMes[1]);				//Atribui o valor inteiro pro mês no calendário;
			return true;
		} catch (Exception e) {													//Captura o erro e mostra na tela;
			System.err.println("ERRO!! Digite uma data valida (Ex.: 30/12)");
			return false;
		}

	}
	
	//Sobrescrevendo o métodod toSTring;
	@Override
	public String toString() {

		return this.dataLimite.get(Calendar.DAY_OF_MONTH) + "/" + this.dataLimite.get(Calendar.MONTH);
	}

	public Datas(String data) {
		setdata(data);
	}
	
	public Datas() {
		
	}

}
