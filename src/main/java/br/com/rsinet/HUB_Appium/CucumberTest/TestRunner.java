package br.com.rsinet.HUB_Appium.CucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(// Configurações do Cucumber
		features = "classpath:Feature", // configuração do pacote que contém as features
		glue = "br.com.rsinet.HUB_Appium.StepDefinitions", // configuração do pacote que contém minhas step
		plugin = {"pretty" }, // Plugin responsavel por criar o arquivo do reporte
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		dryRun = false,
		tags = {"@Sucesso, @Falha"} // Configurações das anotações que devem ser executadas
)

public class TestRunner {

}
