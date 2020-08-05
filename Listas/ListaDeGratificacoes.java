package Listas;

import java.util.HashMap;
import java.util.Map;

import Datas.Datas;
import Empregado.Empregado;
import Gratificação.GratDesempenho;
import Gratificação.GratHoraExtra;
import Gratificação.Gratificacao;

public class ListaDeGratificacoes {

	/*
	 * Criando um Mapa que cria um mapa passando como key: Empregado e Value:
	 * Vencimento para relacionar a lista de empregados com sua lista de
	 * vencimentos;
	 */
	private static Datas dataTest = new Datas();
	private static Map<Empregado, Vencimento> listaDeGratificacoes;

	// Criando o get do mapa de empregado / vencimento;
	public static Map<Empregado, Vencimento> getListaDeGratificacoes() {
		return listaDeGratificacoes;
	}

	// Método que adiciona uma gratificação à um funcionário, passando como
	// parâmetro um index de funcionário e a data trabalhada;
	public static boolean adicionaGratificacao(int index_funcionario, String data_trabalhada) {
		Vencimento v;
		Empregado e = ListaDeFuncionario.recuperaEmpregado(index_funcionario);

		if (listaDeGratificacoes == null) {
			listaDeGratificacoes = new HashMap<>();
		}
		
		if(dataTest.setdata(data_trabalhada)) {
			v = (Vencimento) listaDeGratificacoes.get(e);
			v.adicionaNaLista(new GratDesempenho(e.getSalarioBase(), data_trabalhada));
			return true;
		}
		return false;

	}

	// Método que recupera uma gratificação, passando como parâmetro o index do
	// funcionário e o index da gratificação desejada;
	public static Gratificacao recuperaGratificacao(int index_funcionario, int index_gratificacao) {
		Empregado e = ListaDeFuncionario.getListaDeEmpregados().get(index_funcionario);
		Vencimento v = (Vencimento) listaDeGratificacoes.get(e);
		Gratificacao g = v.recuperaDaLista(index_gratificacao);

		// Condição para testar se o objeto de gratificação for nulo;
		if (g == null)
			System.err.println("Gratificacao Inexistente");
		return g;
	}

	/*
	 * Método que adiciona uma gratificação por Hora extra ao funcionário, passando
	 * como parâmtro index do funcionário, a data trabalhada, e quantidade e horas
	 * extras trabalhadas;
	 */

	public static boolean adicionaGratificacao(int index_funcionario, String data_trabalhada, int horas_trabalhadas) {
		Vencimento v;
		Empregado e = ListaDeFuncionario.recuperaEmpregado(index_funcionario);

		if (listaDeGratificacoes == null) {
			listaDeGratificacoes = new HashMap<>();
		}

		if (horas_trabalhadas > 0 && dataTest.setdata(data_trabalhada)) {
			v = (Vencimento) listaDeGratificacoes.get(e);
			v.adicionaNaLista(new GratHoraExtra(e.getSalarioBase(), data_trabalhada, horas_trabalhadas));
			return true;
		} else if (horas_trabalhadas <= 0) {
			System.out.println("VERIFIQUE O AS HORAS TRABALHADAS");
		}
		return false;

	}

	// Remove uma gratificação atribuída a um empregado, passando como parâmtero o
	// index do funcionário e o index da gratificação a ser removida;
	public static boolean removeGratificacao(int index_funcionario, int index_gratificacao) {
		if (!listaDeGratificacoes.isEmpty() || listaDeGratificacoes != null) {
			Empregado e = ListaDeFuncionario.getListaDeEmpregados().get(index_funcionario);
			Vencimento v = (Vencimento) listaDeGratificacoes.get(e);
			v.removeDaLista(index_gratificacao);
			return true;
		}
		return false;
	}

	// Método que mostra um empregado contida na lista de funcionários;
	public static void mostraLista(int index_funcionario) {
		Empregado e = ListaDeFuncionario.recuperaEmpregado(index_funcionario);
		Vencimento v = listaDeGratificacoes.get(e);
		v.recuperaListaDeGratificacao();
	}

	/*
	 * Método que mostra a folha de pagamento completa, com o nome do funcionário,
	 * cargo, salário Base, qtd. de gratificações e o valor das gratificações;
	 * 
	 * OBS:. Deu muito trabalho fazer esse print.
	 */
	public static void mostraFolhaDePagamento() {
		if (listaDeGratificacoes != null && !listaDeGratificacoes.isEmpty()) {
			System.out.println(
					"\n\n-------------------------------------------------- FOLHA DE PAGAMENTO ---------------------------------------------------\n");
			System.out.println(
					"Nome\t\tCargo\t\tSalário Base\tQtde. de Gratificações\t   Valor das Gratificações\tVencimento mensal\n");
			for (Empregado empregado : ListaDeFuncionario.getListaDeEmpregados()) {

				listaDeGratificacoes.get(empregado).valorDaGratificacao();

				System.out.printf("%-16s%-17sR$ %-10s%12s\t\t\t  R$ %-23sR$ %-17s\n", empregado.getNome(),
						empregado.getCargo(), empregado.getSalarioBase(),
						listaDeGratificacoes.get(empregado).getContGrat(),
						listaDeGratificacoes.get(empregado).getValorMensal(),
						(empregado.getSalarioBase() + listaDeGratificacoes.get(empregado).getValorMensal()));

			}
			System.out.println(
					"\n\n-------------------------------------------------------------------------------------------------------------------------\n");

		} else {
			System.out.println(
					"\n\n-------------------------------------------------- FOLHA DE PAGAMENTO ---------------------------------------------------\n");
			System.err.println("\n\t\t\t\t\tNÃO POSSUI FUNCIONARIOS PARA APRESENTAR");
			System.out.println(
					"\n\n-------------------------------------------------------------------------------------------------------------------------\n");

		}
	}

	// Método vai referenciar um empregado a sua lista de gratificações;
	public static void criaEmpregado(Empregado e, Vencimento v) {
		if (listaDeGratificacoes == null) {
			listaDeGratificacoes = new HashMap<>();
		}
		listaDeGratificacoes.put(e, v);
	}

}
