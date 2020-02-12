package br.com.rsinet.hub.appium.StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub.appium.CucumberTest.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;

public class Hooks {

	private AndroidDriver<WebElement> driver;
	private TestContext testContext;

	public Hooks(TestContext context) {
		this.testContext = context;
	}

	public static String pegaHora() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	@Before
	public void iniciaTeste() throws Exception {
		driver = testContext.getDriverManager().createDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After(order = 1)
	public void report(Scenario scenario) throws Exception {

		driver = testContext.getDriverManager().createDriver();

		String nomeDoArquivoImagem = scenario.getName().replace(" ", "_");

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destino = System.getProperty("user.dir") + "/target/prints/" + nomeDoArquivoImagem + pegaHora() + ".png";

		try {
			FileUtils.copyFile(file, new File(destino));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Reporter.addScreenCaptureFromPath(destino);
	}

	@After(order = 0)
	public void encerraTeste() {
		testContext.getDriverManager().closeDriver();
	}

}
