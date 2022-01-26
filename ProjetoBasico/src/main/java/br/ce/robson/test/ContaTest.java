package br.ce.robson.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.robson.core.BaseTest;
import br.ce.robson.core.Propriedades;
import br.ce.robson.page.ContasPage;
import br.ce.robson.page.MenuPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void test1_InserirConta() {
		menuPage.acessarTelainserirConta();

		contasPage.SetNome("Conta do Teste alterada");
		contasPage.salvar();

		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());

	}

	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListarConta();

		contasPage.clicarAlterarConta("Conta do Teste alterada");
		
		contasPage.SetNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());

	}
	@Test
	public void test3_InserirContaMesmoNome() {
		menuPage.acessarTelainserirConta();
		
		contasPage.SetNome("Propriedades.NOME_CONTA_ALTERADA");
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
	
	
		
}
