package runners;

//Classe responsavel por gerenciar as execucoes
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(CustomRunner.class)
@CucumberOptions(
	plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty", "json:target/cucumber-report/report.json"},
	features="classpath:features",
	glue="stepsDefinitions",
	tags = "",
	snippets = SnippetType.CAMELCASE,
	dryRun = false,
	monochrome = true)

public class RunnerTest {

}
