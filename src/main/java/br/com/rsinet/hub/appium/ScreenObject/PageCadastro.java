package br.com.rsinet.hub.appium.ScreenObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PageCadastro {

	private AndroidDriver<WebElement> driver;

	public PageCadastro(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}

	private WebElement esperaCadastrar() {
		WebElement el1 = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView");
		return el1;
	}

	private WebElement botaoMenu() {
		WebElement bntMenu = driver.findElementById("com.Advantage.aShopping:id/imageViewMenu");
		return bntMenu;
	}

	public void clicarMenu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(esperaCadastrar()));
		botaoMenu().click();
	}

	private WebElement botaoLogin() {
		WebElement bntLogin = driver.findElementByXPath(
				"//android.support.v4.widget.DrawerLayout[@content-desc=\"Main Menu\"]/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout");
		return bntLogin;
	}

	public void clicarLogin() {
		botaoLogin().click();
	}

	private WebElement botaoCadastrar() {
		WebElement bntCadastrar = driver.findElementById("com.Advantage.aShopping:id/textViewDontHaveAnAccount");
		return bntCadastrar;
	}

	public void clicarCadastrar() {
		botaoCadastrar().click();
	}

	private WebElement inserirNomeUsuario() {
		WebElement nomeUsuario = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText");
		return nomeUsuario;
	}

	public void preencherNomeDeUsuario(String nomeUsuario) {
		inserirNomeUsuario().click();
		inserirNomeUsuario().sendKeys(nomeUsuario);
	}

	private WebElement inserirEmail() {
		WebElement inserirEmail = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText");
		return inserirEmail;
	}

	public void preencherEmail(String email) {
		inserirEmail().click();
		inserirEmail().sendKeys(email);
	}

	private WebElement inserirSenha() {
		WebElement senha = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText");
		return senha;
	}

	public void preencherSenha(String senha) {
		inserirSenha().click();
		inserirSenha().sendKeys(senha);
	}

	private WebElement inserirConfirmacaoSenha() {
		List<WebElement> els1 = driver.findElementsByXPath(
				"//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText");
		return els1.get(3);
	}

	public void preencherConfirmacaoSenha(String confirmaSenha) {
		inserirConfirmacaoSenha().click();
		inserirConfirmacaoSenha().sendKeys(confirmaSenha);
	}

	private WebElement inserirPrimeiroNome() {
		WebElement el1 = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText");
		return el1;
	}

	public void preencherPrimeiroNome(String primeiroNome) {
		inserirPrimeiroNome().click();
		inserirPrimeiroNome().sendKeys(primeiroNome);
	}

	private WebElement inserirUltimoNome() {
		WebElement el2 = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText");
		return el2;
	}

	public void preencherUltimoNome(String ultimoNome) {
		inserirUltimoNome().click();
		inserirUltimoNome().sendKeys(ultimoNome);
	}

	private WebElement inserirNumeroTelefone() {
		WebElement el1 = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText");
		return el1;
	}

	public void preencherNumeroTelefone(String numero) {
		inserirNumeroTelefone().click();
		inserirNumeroTelefone().sendKeys(numero);
	}

	private WebElement botaoLocalizacao() {
		WebElement localizacao = driver.findElementById("com.Advantage.aShopping:id/switchLocation");
		return localizacao;
	}

	public void clicarLocalizacao() {
		botaoLocalizacao().click();
	}

	private WebElement botaoConfirmaLocalizacao() {
		WebElement confLocation = driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
		return confLocation;
	}

	public void clicarConfirmaLocalizacao() {
		botaoConfirmaLocalizacao().click();
	}

	private WebElement inserirCidade() {
		WebElement el1 = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText");
		return el1;
	}

	public void preencherCidade(String cidade) {
		inserirCidade().clear();
		inserirCidade().click();
		inserirCidade().sendKeys(cidade);
	}

	private WebElement botaoPais() {
		WebElement botaoPais = driver.findElementById("com.Advantage.aShopping:id/linearLayoutCountry");
		return botaoPais;
	}

	public void clicarPais() {
		botaoPais().click();
	}

	private WebElement confirmaPais() {
		WebElement confirmaPais = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[6]");
		return confirmaPais;
	}

	public void clicarConfirmaPais() {
		confirmaPais().click();
	}

	private WebElement botaoConfirmaCadastro() {
		WebElement botaoConfirmaCadastro = driver.findElementById("com.Advantage.aShopping:id/buttonRegister");
		return botaoConfirmaCadastro;
	}

	public void clicarEmCadastrar() {
		botaoConfirmaCadastro().click();
	}

	private WebElement avalidacaoDeSucesso() {
		WebElement validacao = driver.findElementById("com.Advantage.aShopping:id/textViewMenuUser");
		return validacao;
	}

	public String validaCadastro() {

		return avalidacaoDeSucesso().getText();
	}

	private WebElement validaUsuarioInvalido() {
		WebElement nomeErrado = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView");
		return nomeErrado;
	}

	public String validaUsuarioErrado() {
		return validaUsuarioInvalido().getText();
	}

	public void scrollAndClick(String esperado) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ esperado + "\").instance(0))")
				.click();
	}

	public void scrollVisible(String esperado) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ esperado + "\").instance(0))");
	}

	@SuppressWarnings("rawtypes")
	public void scroll(double inicio, double fim) throws Exception {
		Dimension size = driver.manage().window().getSize();

		int x = size.width / 2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		new TouchAction(driver).press(PointOption.point(x, start_y))
				.waitAction((WaitOptions.waitOptions(Duration.ofMillis(500))))//
				.moveTo(PointOption.point(x, end_y))//
				.release().perform();

	}

}
