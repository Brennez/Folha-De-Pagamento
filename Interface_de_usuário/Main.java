package Interface_de_usuário;

import Listas.ListaDeFuncionario;
import Listas.ListaDeGratificacoes;


public class Main {

	public static void main(String[] args) {
		
		//cadastrando um funcionário;
		ListaDeFuncionario.cadastraEmpregado("Alcemir", "Gerente");
		ListaDeFuncionario.cadastraEmpregado("Santos", "Funcionário");
		
		//Adicionanado gratificações ao funcionário;
		ListaDeGratificacoes.adicionaGratificacao(0, "23/04");
		ListaDeGratificacoes.adicionaGratificacao(1, "05/05");

		
		IU.IUPrincipal();
		


	}

}
