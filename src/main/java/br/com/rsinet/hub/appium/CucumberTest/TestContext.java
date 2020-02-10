package br.com.rsinet.hub.appium.CucumberTest;

import br.com.rsinet.hub.appium.Managers.DriverManager;

public class TestContext {

	private DriverManager driverManager;

	public TestContext() throws Exception {
		driverManager = new DriverManager();
	}

	public DriverManager getDriverManager() {
		return driverManager;
	}
}