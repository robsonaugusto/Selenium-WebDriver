package br.ce.robson.test;

import org.junit.Assert;
import org.junit.Test;


import br.ce.robson.core.BaseTest;
import br.ce.robson.core.Propriedades;
import br.ce.robson.page.HomePage;
import br.ce.robson.page.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();

	@Test
	public void testSaldoConta() {
		menu.acessarTelaPrincipal();
		Assert.assertEquals("500.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));

	}
}
