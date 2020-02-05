package br.com.rsinet.HUB_Appium.PageObject;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageCadastro {

	private AndroidDriver<MobileElement> driver;

	public PageCadastro(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	private MobileElement botaoMenu() {
		MobileElement bntMenu = driver.findElementById("com.Advantage.aShopping:id/imageViewMenu");
		return bntMenu;
	}

	public void clicarMenu() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(botaoMenu()));
		botaoMenu().click();
	}

	private MobileElement botaoLogin() {
		MobileElement bntLogin = driver.findElementByXPath(
				"//android.support.v4.widget.DrawerLayout[@content-desc=\"Main Menu\"]/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout");
		return bntLogin;
	}

	public void clicarLogin() {
		botaoLogin().click();
	}

	private MobileElement botaoCadastrar() {
		MobileElement bntCadastrar = driver
				.findElementById("com.Advantage.aShopping:id/textViewDontHaveAnAccount");
		return bntCadastrar;
	}

	public void clicarCadastrar() {
		botaoCadastrar().click();
	}

	private MobileElement inserirNomeUsuario() {
		MobileElement nomeUsuario = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText");
		return nomeUsuario;
	}

	public void preencherNomeDeUsuario(String nomeUsuario) {
		inserirNomeUsuario().click();
		inserirNomeUsuario().sendKeys(nomeUsuario);
	}

	private MobileElement inserirEmail() {
		MobileElement inserirEmail = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText");
		return inserirEmail;
	}

	public void preencherEmail(String email) {
		inserirEmail().click();
		inserirEmail().sendKeys(email);
	}

	private MobileElement inserirSenha() {
		MobileElement senha = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText");
		return senha;
	}

	public void preencherSenha(String senha) {
		inserirSenha().click();
		inserirSenha().sendKeys(senha);
	}

	private MobileElement inserirConfirmacaoSenha() {
		MobileElement confirmacaoSenha = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText");
		return confirmacaoSenha;
	}

	public void preencherConfirmacaoSenha(String confirmaSenha) {
		inserirConfirmacaoSenha().click();
		inserirConfirmacaoSenha().sendKeys(confirmaSenha);
	}

	private MobileElement inserirPrimeiroNome() {
		MobileElement primeiroNome = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText");
		return primeiroNome;
	}

	public void preencherPrimeiroNome(String primeiroNome) {
		inserirPrimeiroNome().click();
		inserirPrimeiroNome().sendKeys(primeiroNome);
	}

	private MobileElement inserirUltimoNome() {
		MobileElement ultimoNome = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText");
		return ultimoNome;
	}

	public void preencherUltimoNome(String ultimoNome) {
		inserirUltimoNome().click();
		inserirUltimoNome().sendKeys(ultimoNome);
	}

	private MobileElement inserirNumeroTelefone() {
		MobileElement numeroTelefone = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText");

		return numeroTelefone;
	}

	public void preencherNumeroTelefone(String numero) {
		inserirNumeroTelefone().click();
		inserirNumeroTelefone().sendKeys(numero);
	}

	private MobileElement botaoLocalizacao() {
		MobileElement localizacao = driver.findElementById("com.Advantage.aShopping:id/switchLocation");
		return localizacao;
	}

	public void clicarLocalizacao() {
		botaoLocalizacao().click();
	}

	private MobileElement botaoConfirmaLocalizacao() {
		MobileElement confLocation = driver
				.findElementById("com.android.packageinstaller:id/permission_allow_button");
		return confLocation;
	}

	public void clicarConfirmaLocalizacao() {
		botaoConfirmaLocalizacao().click();
	}

	private MobileElement inserirCidade() {
		MobileElement cidade = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText");
		return cidade;
	}

	public void preencherCidade(String cidade) {
		inserirCidade().click();
		inserirCidade().sendKeys(cidade);
	}

	private MobileElement botaoPais() {
		MobileElement botaoPais = driver
				.findElementById("com.Advantage.aShopping:id/linearLayoutCountry");
		return botaoPais;
	}

	public void clicarPais() {
		botaoPais().click();
	}

	private MobileElement confirmaPais() {
		MobileElement confirmaPais = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[6]");
		return confirmaPais;
	}

	public void clicarConfirmaPais() {
		confirmaPais().click();
	}

	private MobileElement botaoConfirmaCadastro() {
		MobileElement botaoConfirmaCadastro = driver
				.findElementById("com.Advantage.aShopping:id/buttonRegister");
		return botaoConfirmaCadastro;
	}

	public void clicarEmCadastrar() {
		botaoConfirmaCadastro().click();
	}

	private MobileElement avalidacaoDeSucesso() {
		MobileElement validacao = driver.findElementById("com.Advantage.aShopping:id/textViewMenuUser");
		return validacao;
	}

	public String validaCadastro() {
		return avalidacaoDeSucesso().getText();
	}

	private MobileElement validaUsuarioInvalido() {
		MobileElement nomeErrado = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView");
		return nomeErrado;
	}

	public String validaUsuarioErrado() {
		return validaUsuarioInvalido().getText();
	}

}
