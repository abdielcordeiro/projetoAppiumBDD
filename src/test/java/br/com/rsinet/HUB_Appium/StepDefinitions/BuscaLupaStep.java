package br.com.rsinet.HUB_Appium.StepDefinitions;

import org.junit.Assert;

import br.com.rsinet.HUB_Appium.CucumberTest.TestContext;
import br.com.rsinet.HUB_Appium.ScreenObject.PageBusca;
import br.com.rsinet.HUB_Appium.Utility.Constant;
import br.com.rsinet.HUB_Appium.Utility.ExcelUtils;
import br.com.rsinet.HUB_Appium.Utility.MassaDados;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class BuscaLupaStep {

	private AndroidDriver<MobileElement> driver;
	private PageBusca busca;
	private TouchAction scroll;
	private MassaDados dados;
	private TestContext testContext;


	public BuscaLupaStep(TestContext context){
		testContext = context;
	}

	@Dado("^Que o usuário esteja na tela principal$")
	public void que_o_usuário_esteja_na_tela_principal() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");
		dados = new MassaDados();
		busca = new PageBusca(driver);
		scroll = new TouchAction(driver);
	}

	@Quando("^Clica no botão da lupa$")
	public void clica_no_botão_da_lupa() throws Throwable {
		busca.clicarLupa();
	}

	@Quando("^Digita nome do produto existente$")
	public void digita_nome_do_produto_existente() throws Throwable {
		busca.inserirBusca(dados.getNomeProduto());
	}

	@Quando("^Clica na lupa para buscar Sucesso$")
	public void clica_na_lupa_para_buscar_Sucesso() throws Throwable {
		busca.clicarLupa();
	}

	@Então("^busca realizada com sucesso produto encontrado$")
	public void busca_realizada_com_sucesso_produto_encontrado() throws Throwable {
		busca.selecionarProduto();
		Assert.assertTrue("Produto encontrado com sucesso", busca
				.retornaNomeProduto(dados.getNomeProduto().toUpperCase()).equals(dados.getNomeProduto().toUpperCase()));
	}

	@Quando("^Digita o nome do tipo do produto inexistente$")
	public void digita_o_nome_do_tipo_do_produto_inexistente() throws Throwable {
		busca.inserirBusca(dados.getNomeProdutoFalha());
	}

	@Quando("^Clica na lupa para buscar falha$")
	public void clica_na_lupa_para_buscar_falha() throws Throwable {
		busca.clicarLupa();
	}

	@Então("^valida mensagem de produto não encontrado$")
	public void valida_mensagem_de_produto_não_encontrado() throws Throwable {
		Assert.assertTrue("Produto: " + dados.getNomeProdutoFalha() + "  não encontrado",
				busca.mensagemDeErro().equals("- No results for " + "\"" + dados.getNomeProdutoFalha() + "\" -"));
	}

}
