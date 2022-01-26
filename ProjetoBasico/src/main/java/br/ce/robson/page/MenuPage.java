package br.ce.robson.page;

import br.ce.robson.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelainserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}

	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");

	}

	public void acessarTelaInserirMovimentacao() {
		clicarLink("Criar Movimentação");

	}
	
	public void acessarTelaResumo() {
		clicarLink("Resumo Mensal");

	}
	
	public void acessarTelaPrincipal() {
		clicarLink("Home");

	}

}