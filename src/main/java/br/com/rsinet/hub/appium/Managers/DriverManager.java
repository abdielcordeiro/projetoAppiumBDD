package br.com.rsinet.hub.appium.Managers;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.rsinet.hub.appium.Utility.Constant;
import io.appium.java_client.android.AndroidDriver;


public class DriverManager {

	private AndroidDriver<WebElement> driver;

	public AndroidDriver<WebElement> createDriver() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Moto G5 Plus");
		capabilities.setCapability("udid", "10.1.0.90:5757");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", Constant.Pacote);
		capabilities.setCapability("appActivity", Constant.Ativador);
		capabilities.setCapability("newCommandTimeout", "120");

		if (driver == null)
			driver = new AndroidDriver<WebElement>(new URL(Constant.URL), capabilities);

		return driver;
	}

	public AndroidDriver<WebElement> closeDriver() {
		if (driver != null) {
			driver.quit();
		}
		return driver;
	}

}