package br.com.rsinet.HUB_Appium.CucumberTest;

import br.com.rsinet.HUB_Appium.Managers.DriverManager;

public class TestContext {

	private DriverManager driverManager;

	public TestContext() throws Exception {
		driverManager = new DriverManager();
	}

	public DriverManager getDriverManager() {
		return driverManager;
	}
}