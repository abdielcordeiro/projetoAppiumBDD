package br.com.rsinet.hub.appium.ScreenObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class PageHome {

	private AndroidDriver<WebElement> driver;

	public PageHome(AndroidDriver<WebElement> driver) {
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

}
