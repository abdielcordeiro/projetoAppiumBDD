package br.com.rsinet.hub.appium.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub.appium.CucumberTest.TestContext;
import br.com.rsinet.hub.appium.ScreenObject.PageBusca;
import br.com.rsinet.hub.appium.ScreenObject.PageCadastro;
import br.com.rsinet.hub.appium.Utility.Constant;
import br.com.rsinet.hub.appium.Utility.ExcelUtils;
import br.com.rsinet.hub.appium.Utility.MassaDados;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class BuscaCliqueStep {

	private AndroidDriver<WebElement> driver;
	private PageBusca busca;
	private MassaDados dados;
	private PageCadastro cadastro;
	private TestContext testContext;

	public BuscaCliqueStep(TestContext context) throws Exception {
		testContext = context;
		driver = testContext.getDriverManager().createDriver();
	}

	@Dado("^Que o usuário esteja na tela principal clique$")
	public void que_o_usuário_esteja_na_tela_principal_clique() throws Throwable {

		busca = new PageBusca(driver);
		cadastro = new PageCadastro(driver);
		dados = new MassaDados();
	}

	@Dado("^Clica no filtros$")
	public void clica_no_filtros() {
		busca.clicarBotaoFiltro();
	}

	@Dado("^Adiciona filtros para buscar um produto$")
	public void adiciona_filtros_para_buscar_um_produto() {
		busca.botaoFuncionalidade();
		busca.botaoResolucao();
		busca.botaoMemoria();
		busca.botaoAplicar();
	}

	@Quando("^Clica em uma categoria$")
	public void clica_em_uma_categoria() throws Throwable {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");
		busca.selecionaTipo(dados.getTipoProduto());
	}

	@Quando("^Clica no produto desejado$")
	public void clica_no_produto_desejado() throws Throwable {
		busca.selecionaProduto(dados.getNomeProduto().toUpperCase());
	}

	@Então("^Valida produto encontrado com sucesso$")
	public void valida_produto_encontrado_com_sucesso() throws Throwable {
		Assert.assertTrue("Produto encontrado com sucesso", busca
				.retornaNomeProduto(dados.getNomeProduto().toUpperCase()).equals(dados.getNomeProduto().toUpperCase()));
	}

	@Então("^Valida produto não encontrado pelos filtro$")
	public void valida_produto_não_encontrado_pelos_filtro() {
		//System.out.println(busca.mensagemProdutoClique());
		Assert.assertTrue("Produto não encontrado", busca.mensagemProdutoClique().equals("- No results -"));
	}
}
