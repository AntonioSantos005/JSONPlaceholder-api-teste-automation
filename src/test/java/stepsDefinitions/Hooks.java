package stepsDefinitions;



import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

//Gerenciamente do que deve ser feito antes e depois de cada testes
public class Hooks {
	
	@Before
	public void setDefaultUrl() {		
		//executado sempre antes de inicar cada cenario, definindo url base	
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";	
	}
		
	//executado sempre depois de finalizar cada cenario, apresentando no log nome e resultado do cenario
	@After()
	public void getScenarioStatus(Scenario scenario) throws Exception {
		System.out.println("============== " + scenario.getName() + " ==============");
		System.out.println("====================== " + scenario.getStatus() + " ======================");
	}
	
}
