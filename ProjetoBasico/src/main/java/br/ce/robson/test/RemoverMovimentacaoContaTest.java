package br.ce.robson.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.robson.core.BaseTest;
import br.ce.robson.core.Propriedades;
import br.ce.robson.page.ContasPage;
import br.ce.robson.page.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testExcluidContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}

}
