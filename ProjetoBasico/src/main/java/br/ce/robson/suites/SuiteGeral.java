package br.ce.robson.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.robson.core.DriverFactory;
import br.ce.robson.page.LoginPage;
import br.ce.robson.test.ContaTest;
import br.ce.robson.test.MovimentacaoTest;
import br.ce.robson.test.RemoverMovimentacaoContaTest;
import br.ce.robson.test.ResumoTest;
import br.ce.robson.test.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({ ContaTest.class, MovimentacaoTest.class, RemoverMovimentacaoContaTest.class, SaldoTest.class,
		ResumoTest.class })
public class SuiteGeral {
	private static LoginPage page = new LoginPage();

	@BeforeClass
	public static void inicliaza() {
		page.acessarTelaInicial();

		page.setEmail("robson@augusto");
		page.setSenha("123456");
		page.entrar();
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
}
