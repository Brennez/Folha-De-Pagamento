package Interface_de_usu�rio;

import Listas.ListaDeFuncionario;
import Listas.ListaDeGratificacoes;


public class Main {

	public static void main(String[] args) {
		
		//cadastrando um funcion�rio;
		ListaDeFuncionario.cadastraEmpregado("Alcemir", "Gerente");
		ListaDeFuncionario.cadastraEmpregado("Santos", "Funcion�rio");
		
		//Adicionanado gratifica��es ao funcion�rio;
		ListaDeGratificacoes.adicionaGratificacao(0, "23/04");
		ListaDeGratificacoes.adicionaGratificacao(1, "05/05");

		
		IU.IUPrincipal();
		


	}

}
