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

	private WebElement btnFiltro() {
		WebElement el1 = driver.findElementByXPath(
				"//android.widget.RelativeLayout[@content-desc=\"Laptops\"]/android.widget.LinearLayout/android.widget.LinearLayout");
		return el1;
	}

	public void clicarBotaoFiltro() {
		btnFiltro().click();
	}

	private WebElement btnFuncionalidade() {
		WebElement el1 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
		return el1;
	}

	private WebElement escolheFuncionalidade() {
		WebElement el1 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
		return el1;
	}

	public void botaoFuncionalidade() {
		btnFuncionalidade().click();
		escolheFuncionalidade().click();
		btnFuncionalidade().click();
	}

	private WebElement bntResolucao() {
		WebElement el1 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]/android.widget.LinearLayout");
		return el1;
	}

	private WebElement escolheResolucao() {
		WebElement el2 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[6]/android.widget.LinearLayout");
		return el2;
	}

	public void botaoResolucao() {
		bntResolucao().click();
		escolheResolucao().click();
		bntResolucao().click();
	}

	private WebElement bntMemoria() {
		WebElement el1 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[6]/android.widget.LinearLayout");
		return el1;
	}

	private WebElement escolhaMemoria() {
		WebElement el2 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[7]/android.widget.LinearLayout");
		return el2;
	}

	public void botaoMemoria() {
		bntMemoria().click();
		escolhaMemoria().click();
		bntMemoria().click();
	}

	private WebElement bntAplicar() {
		WebElement el1 = driver.findElementById("com.Advantage.aShopping:id/textViewApply");
		return el1;
	}

	public void botaoAplicar() {
		bntAplicar().click();
	}

	private WebElement validaMensagemErroClique() {
		WebElement el1 = driver.findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");
		return el1;
	}

	public String mensagemProdutoClique() {
		return validaMensagemErroClique().getText();
	}

}