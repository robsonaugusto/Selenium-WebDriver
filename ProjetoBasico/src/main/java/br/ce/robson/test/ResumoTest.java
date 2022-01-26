package br.ce.robson.test;

import static br.ce.robson.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.robson.core.BaseTest;
import br.ce.robson.page.MenuPage;
import br.ce.robson.page.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
		public void test1_ExcluirMovimentacao() {
			menuPage.acessarTelaResumo();
		
			resumoPage.excluirMovimentacao();
			
			Assert.assertEquals("Movimentação removida com sucesso!", 
					resumoPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void test2_ResumoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
	}

}
