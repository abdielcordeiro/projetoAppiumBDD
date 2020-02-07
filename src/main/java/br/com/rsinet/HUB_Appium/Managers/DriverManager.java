package br.com.rsinet.HUB_Appium.Managers;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.rsinet.HUB_Appium.Utility.Constant;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

	private AndroidDriver<MobileElement> driver;

	public AndroidDriver<MobileElement> createDriver() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Moto G5 Plus");
		capabilities.setCapability("udid", "10.1.0.90:5656");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", Constant.Pacote);
		capabilities.setCapability("appActivity", Constant.Ativador);

		if (driver == null)
			driver = new AndroidDriver<MobileElement>(new URL(Constant.URL), capabilities);

		return driver;
	}

	public AndroidDriver<MobileElement> closeDriver() {
		if (driver != null) {
			driver.quit();
		}
		return driver;
	}

}