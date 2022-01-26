package br.ce.robson.test;

import static br.ce.robson.utils.DataUtils.ObterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.robson.core.BaseTest;
import br.ce.robson.core.Propriedades;
import br.ce.robson.page.MenuPage;
import br.ce.robson.page.MovimentacaoPage;
import br.ce.robson.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMOvimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(ObterDataFormatada(new Date()));
		movPage.setDataPagamento(ObterDataFormatada(new Date()));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
		
		
	}
	
	@Test
	public void test2_CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório" , 
				"Data do pagamento é obrigatório" , 
				"Descrição é obrigatório" , "Interessado é obrigatório" ,
				"Valor é obrigatório" , "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
		
	}
	
	@Test
	public void test3_InserisMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(ObterDataFormatada(dataFutura));
		movPage.setDataPagamento(ObterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
		
	}
	

}
