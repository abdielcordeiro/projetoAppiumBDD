package br.com.rsinet.hub.appium.ScreenObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub.appium.Utility.Constant;
import io.appium.java_client.android.AndroidDriver;

public class PageBusca {

	private AndroidDriver<WebElement> driver;

	public PageBusca(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}

	private WebElement botaoLupa() {
		WebElement bntLupa = driver.findElementById("com.Advantage.aShopping:id/imageViewSearch");
		return bntLupa;
	}

	public void clicarLupa() {
		botaoLupa().click();
	}

	private WebElement escreverBusca() {
		WebElement escLupa = driver.findElementById("com.Advantage.aShopping:id/editTextSearch");
		return escLupa;
	}

	public void inserirBusca(String busca) {
		escreverBusca().sendKeys(busca);
	}

	private WebElement clicarProduto() {
		WebElement apertarProduto = driver.findElementById("com.Advantage.aShopping:id/imageViewProduct");
		return apertarProduto;
	}

	public void selecionarProduto() {
		clicarProduto().click();
	}

	private WebElement verificarNomeProduto(String nome) {
		WebDriverWait wait = new WebDriverWait(driver, Constant.wait);
		wait.until(ExpectedConditions.textToBePresentInElement(
				driver.findElementById("com.Advantage.aShopping:id/textViewProductName"), nome));

		WebElement el2 = driver.findElementById("com.Advantage.aShopping:id/textViewProductName");
		return el2;
	}

	public String retornaNomeProduto(String nome) {
		return verificarNomeProduto(nome).getText();
	}

	private WebElement verificarNomeProdutoFalha() {
		WebElement el1 = driver.findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");
		return el1;
	}

	public String mensagemDeErro() {
		return verificarNomeProdutoFalha().getText();
	}

	private WebElement escolherTipo(String tipo) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement el2 = wait.until(ExpectedConditions.visibilityOf(
				driver.findElementByXPath("//android.widget.TextView[starts-with(@text, '" + tipo + "')]")));

		return el2;
	}

	public void selecionaTipo(String tipo) {
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		escolherTipo(tipo).click();
	}

	private WebElement escolherProduto(String produto) {
		WebElement el2 = driver.findElementByXPath("//android.widget.TextView[starts-with(@text, '" + produto + "')]");
		return el2;
	}

	public void selecionaProduto(String produto) {
		escolherProduto(produto).click();
	}

	private WebElement bntAdicionar() {
		WebElement el1 = driver.findElementById("com.Advantage.aShopping:id/linearLayoutProductQuantity");
		return el1;
	}

	public void botaoAdicionar() {
		bntAdicionar().click();
	}

	private WebElement bntMais() {
		WebElement el2 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.ImageView[2]");
		return el2;
	}

	public void botaoMais() {
		bntMais().click();
	}

	private WebElement bntApply() {
		WebElement el1 = driver.findElementById("com.Advantage.aShopping:id/textViewApply");
		return el1;
	}

	public void aceitarQuantidade() {
		bntApply().click();
	}

	private WebElement bntAddCarinho() {
		WebElement el2 = driver.findElementById("com.Advantage.aShopping:id/buttonProductAddToCart");
		return el2;
	}

	public void botaoAdicionarCarrinho() {
		bntAddCarinho().click();
	}

	private WebElement inputLogin() {
		WebElement el3 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText");
		return el3;
	}

	public void inserirLogin(String nome) {
		inputLogin().click();
		inputLogin().sendKeys(nome);
	}

	private WebElement inputSenha() {
		WebElement el1 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText");
		return el1;
	}

	public void inserirSenha(String senha) {
		inputSenha().click();
		inputSenha().sendKeys(senha);
	}

	private WebElement bntLogar() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement el2 = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElementById("com.Advantage.aShopping:id/buttonLogin")));
		return el2;
	}

	public void botaoLogar() {
		bntLogar().click();

	}

	private WebElement bntDedo() {
		WebElement el2 = driver.findElementById("android:id/button2");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement el3 = wait.until(ExpectedConditions.visibilityOf(el2));

		return el3;
	}

	public void clicarAutenticacaoDedo() {
		bntDedo().click();
	}

	private WebElement bntEntrarCarinho() {
		WebElement el1 = driver.findElementById("com.Advantage.aShopping:id/imageViewCart");
		return el1;
	}

	public void entrarNoCarrinho() {
		bntEntrarCarinho().click();
	}

	private WebElement validaQnt() {
		WebElement el2 = driver.findElementById("com.Advantage.aShopping:id/textViewCartQuantity");
		return el2;
	}

	public int validarQuantidadeProduto() {
		return Integer.parseInt(validaQnt().getText());
	}
}
