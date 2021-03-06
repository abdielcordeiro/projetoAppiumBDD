package br.com.rsinet.hub.appium.Teste;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub.appium.Managers.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

/**Configurações do Cucumber
*/
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:Feature", //Configuração do pacote que contém as features
		glue = "br.com.rsinet.hub.appium.StepDefinitions", //Configuração do pacote que contém minhas step
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/resultados.html" }, //Plugin responsavel por criar o arquivo do reporte
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		dryRun = false,
		tags = {"@SucessoCadastro"} //Configurações das anotações que devem ser executadas
)

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}
}
