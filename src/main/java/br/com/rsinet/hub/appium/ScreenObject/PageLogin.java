package br.com.rsinet.hub.appium.ScreenObject;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class PageLogin {

	private AndroidDriver<WebElement> driver;

	public PageLogin(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}

	private WebElement botaoCadastrar() {
		WebElement bntCadastrar = driver.findElementById("com.Advantage.aShopping:id/textViewDontHaveAnAccount");
		return bntCadastrar;
	}

	public void clicarCadastrar() {
		botaoCadastrar().click();
	}
}
