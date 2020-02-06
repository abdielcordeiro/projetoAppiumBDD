package br.com.rsinet.HUB_Appium.StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import br.com.rsinet.HUB_Appium.CucumberTest.TestContext;
import br.com.rsinet.HUB_Appium.Managers.DriverManager;
import br.com.rsinet.HUB_Appium.ScreenObject.PageBusca;
import br.com.rsinet.HUB_Appium.ScreenObject.PageCadastro;
import br.com.rsinet.HUB_Appium.Utility.Constant;
import br.com.rsinet.HUB_Appium.Utility.ExcelUtils;
import br.com.rsinet.HUB_Appium.Utility.MassaDados;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class BuscaCliqueStep {

	private AndroidDriver driver;
	private PageBusca busca;
	private TouchAction scroll;
	private MassaDados dados;
	private PageCadastro cadastro;
	private TestContext testContext;

	public BuscaCliqueStep(TestContext context){
		testContext = context;
	}

	@Before
	public void iniciaTeste() throws Exception {

		driver = testContext.getDriverManager().createDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Dado("^Que o usuário esteja na tela principal clique$")
	public void que_o_usuário_esteja_na_tela_principal_clique() throws Throwable {

		busca = new PageBusca(driver);
		cadastro = new PageCadastro(driver);

		scroll = new TouchAction(driver);
		dados = new MassaDados();
	}

	@Dado("^faz login$")
	public void faz_login() throws Throwable {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		cadastro.clicarMenu();
		cadastro.clicarLogin();
		busca.inserirLogin(dados.getNomeUsuarioExcel());
		busca.inserirSenha(dados.getSenha());
		driver.hideKeyboard();
		busca.botaoLogar();
		busca.clicarAutenticacaoDedo();
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

	@Quando("^Clica para adicionar mais produtos$")
	public void clica_para_adicionar_mais_produtos() throws Throwable {
		busca.botaoAdicionar();
	}

	@Quando("^Coloca a quantidade de produto desejada e adiciona$")
	public void coloca_a_quantidade_de_produto_desejada_e_adiciona() throws Throwable {
		for (int i = 0; i < dados.getQuantidadeProduto() - 1; i++) {
			busca.botaoMais();
		}
		busca.aceitarQuantidade();
		busca.botaoAdicionarCarrinho();
	}

	@Quando("^Clica para entrar no carinho$")
	public void clica_para_entrar_no_carinho() throws Throwable {
		busca.entrarNoCarrinho();
	}

	@Então("^Valida a quantidade de produtos$")
	public void valida_a_quantidade_de_produtos() throws Throwable {
		Assert.assertTrue("Quantidade diferente da quantidade pedida",
				busca.validarQuantidadeProduto() != dados.getQuantidadeProduto());
	}

	@After
	public void finalizaTeste() {
		DriverManager.closeDriver(driver);
	}
}
