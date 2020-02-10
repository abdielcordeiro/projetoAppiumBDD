package br.com.rsinet.hub.appium.StepDefinitions;

import org.junit.Assert;

import br.com.rsinet.hub.appium.CucumberTest.TestContext;
import br.com.rsinet.hub.appium.ScreenObject.PageCadastro;
import br.com.rsinet.hub.appium.Utility.Constant;
import br.com.rsinet.hub.appium.Utility.ExcelUtils;
import br.com.rsinet.hub.appium.Utility.MassaDados;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CadastrarUsuarioStep {

	private AndroidDriver<MobileElement> driver;
	private PageCadastro cadastro;
	private MassaDados dados;
	private TestContext testContext;
	private String nomeUsuario;

	public CadastrarUsuarioStep(TestContext context) throws Exception {
		testContext = context;
		driver = testContext.getDriverManager().createDriver();
	}

	@Dado("^O usuário esta home do aplicativo para cadastrar$")
	public void o_usuário_esta_home_do_aplicativo_para_cadastrar() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		dados = new MassaDados();
		cadastro = new PageCadastro(driver);
	}

	@Quando("^Navega para o login$")
	public void navega_para_o_login() throws Throwable {
		cadastro.clicarMenu();
		cadastro.clicarLogin();
	}

	@Quando("^clicar em cadastrar novo usuário$")
	public void clicar_em_cadastrar_novo_usuário() {
		cadastro.clicarCadastrar();
	}

	@Dado("^preenche formulario de cadastro sucesso$")
	public void preenche_formulario_de_cadastro_sucesso() throws Exception {

		nomeUsuario = dados.getNomeUsuario(6);
		cadastro.preencherNomeDeUsuario(nomeUsuario);
		cadastro.preencherEmail(dados.getEmail());
		cadastro.preencherSenha(dados.getSenha());

		driver.hideKeyboard();
		cadastro.preencherConfirmacaoSenha(dados.getSenha());

		driver.hideKeyboard();

		cadastro.preencherPrimeiroNome(dados.getPrimeiroNome());
		cadastro.preencherUltimoNome(dados.getUltimoNome());

		driver.hideKeyboard();

		cadastro.scroll(0.9, 0.0);

		driver.hideKeyboard();

		cadastro.preencherNumeroTelefone(dados.getNumeroTelefone());

		driver.hideKeyboard();
		cadastro.scroll(0.9, 0.0);

		cadastro.clicarLocalizacao();
		cadastro.clicarConfirmaLocalizacao();
		cadastro.preencherCidade(dados.getCidade());

		cadastro.clicarPais();
		cadastro.scrollAndClick("Brazil");
	}

	@Dado("^Clica no botão de registrar$")
	public void clica_no_botão_de_registrar() {
		cadastro.clicarEmCadastrar();
	}

	@Então("^Valida usuário cadastrardo com sucesso$")
	public void valida_usuário_cadastrardo_com_sucesso() throws Exception {
		cadastro.clicarMenu();
		dados.setNomeUsuario(nomeUsuario);
		Assert.assertTrue("Usuário cadastrado com sucesso",
				cadastro.validaCadastro().equals(dados.getNomeUsuarioExcel()));	
	}

	@Dado("^preenche formulario de cadastro falha$")
	public void preenche_formulario_de_cadastro_falha() throws Exception {

		nomeUsuario = dados.getNomeUsuario(16);
		cadastro.preencherNomeDeUsuario(nomeUsuario);
		cadastro.preencherEmail(dados.getEmail());
		cadastro.preencherSenha(dados.getSenha());

		driver.hideKeyboard();
		cadastro.preencherConfirmacaoSenha(dados.getSenha());

		driver.hideKeyboard();

		cadastro.preencherPrimeiroNome(dados.getPrimeiroNome());
		cadastro.preencherUltimoNome(dados.getUltimoNome());

		driver.hideKeyboard();

		cadastro.scroll(0.9, 0.0);

		driver.hideKeyboard();

		cadastro.preencherNumeroTelefone(dados.getNumeroTelefone());

		driver.hideKeyboard();
		cadastro.scroll(0.9, 0.0);

		cadastro.clicarLocalizacao();
		cadastro.clicarConfirmaLocalizacao();
		cadastro.preencherCidade(dados.getCidade());

		cadastro.clicarPais();
		cadastro.scrollAndClick("Brazil");

	}

	@Então("^valida mensagem de usuário incorreto$")
	public void valida_mensagem_de_usuário_incorreto() {
		cadastro.scrollVisible("ACCOUNT DETAILS");
		Assert.assertTrue("Falha no nome de usuário", cadastro.validaUsuarioErrado().equals("Use up to 15 characters"));
	}
}
