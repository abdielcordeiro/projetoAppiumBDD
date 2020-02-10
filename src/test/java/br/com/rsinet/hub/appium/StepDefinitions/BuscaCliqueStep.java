package br.com.rsinet.hub.appium.StepDefinitions;

import org.junit.Assert;

import br.com.rsinet.hub.appium.CucumberTest.TestContext;
import br.com.rsinet.hub.appium.ScreenObject.PageBusca;
import br.com.rsinet.hub.appium.ScreenObject.PageCadastro;
import br.com.rsinet.hub.appium.Utility.Constant;
import br.com.rsinet.hub.appium.Utility.ExcelUtils;
import br.com.rsinet.hub.appium.Utility.MassaDados;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BuscaCliqueStep {

	private AndroidDriver<MobileElement> driver;
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
}
