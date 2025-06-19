package testAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.http.ContentType;
import model.RegisterModel;
import singleton.RegisterSingleton;

public class JsonplaceholderTests {
	
	private RegisterModel registersGet = RegisterSingleton.instanceToGet();
	private RegisterModel registersPostPut = RegisterSingleton.instanceToPostPut();
	private RegisterModel registersDelete = RegisterSingleton.instanceToDelete();
	
	public void getRegisters() {
				
		given() //pre condicao
		
			.log().all() // apresenta o log no console
		.when()
			.get(registersGet.getUrl()) //realiza a requisicao
		.then()
			.log().all()
			.statusCode(registersGet.getStatusCode()) //vaslida o status code de acordo com o esperado que esta sendo passado na feature
			.body("id.max()", is(greaterThan(0))); //valida o resultado
	}
	
	public void getNonexistentRegisterById() {
				
		given() //pre condicao
			.log().all() // apresenta o log no console
		.when()
			.get("/posts/" + registersGet.getId()) //realiza a requisicao
		.then()
			.log().all()
			.statusCode(registersGet.getStatusCode()); //vaslida o status code de acordo com o esperado que esta sendo passado na feature
	}
	
	public void getRegisterById() {
				
		given() //pre condicao
			.log().all() // apresenta o log no console
		.when()
			.get("/posts/" + registersGet.getId()) //realiza a requisicao
		.then()
			.log().all()
			.statusCode(registersGet.getStatusCode()) //vaslida o status code de acordo com o esperado que esta sendo passado na feature
			.body("id", is(registersGet.getId())); //valida o resultado
	}
	
	public void getCommentsByPostId() {
	
		given() //pre condicao
			.log().all() // apresenta o log no console
		.when()
			.get("/posts/" + registersGet.getId() + "/comments") //realiza a requisicao
		.then()
			.log().all()
			.statusCode(registersGet.getStatusCode()) //vaslida o status code de acordo com o esperado que esta sendo passado na feature
			.body("postId[1]", is(registersGet.getId())); //valida o resultado
	}
	
	public void postNewRegister() {
		
		given() //pre condicao
			.log().all() // apresenta o log no console
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "  \"userId\": " + registersPostPut.getId() + ",\r\n"
					+ "  \"title\": \"" + registersPostPut.getTitle() + "\",\r\n"
					+ "  \"body\": \"" + registersPostPut.getBody() + "\"\r\n"
					+ "}")
		.when()
			.post("/posts") //realiza a requisicao
		.then()
			.log().all()
			.statusCode(registersPostPut.getStatusCode()) //valida o status code de acordo com o esperado que esta sendo passado na feature
			.body("userId", is(registersPostPut.getId()))
			.body("id", is(notNullValue()))
			.body("title", is(registersPostPut.getTitle())) //valida o resultado
			.body("body", is(registersPostPut.getBody())); //valida o resultado
	}
	
	public void updateRegister() {
		
		given() //pre condicao
			.log().all() // apresenta o log no console
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "  \"id\": " + registersPostPut.getId() + ",\r\n"
					+ "  \"userId\": " + registersPostPut.getId() + ",\r\n"
					+ "  \"title\": \"" + registersPostPut.getTitle() + "\",\r\n"
					+ "  \"body\": \"" + registersPostPut.getBody() + "\"\r\n"
					+ "}")
		.when()
			.put("/posts/" + registersPostPut.getId()) //realiza a requisicao
		.then()
			.log().all()
			.statusCode(registersPostPut.getStatusCode()) //valida o status code de acordo com o esperado que esta sendo passado na feature
			.body("userId", is(registersPostPut.getId()))
			.body("id", is(registersPostPut.getId()))
			.body("title", is(registersPostPut.getTitle())) //valida o resultado
			.body("body", is(registersPostPut.getBody())); //valida o resultado
	}
	
	public void updateNonExistentRegister() {
		
		given() //pre condicao
			.log().all() // apresenta o log no console
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "  \"id\": " + registersPostPut.getId() + ",\r\n"
					+ "  \"userId\": " + registersPostPut.getId() + ",\r\n"
					+ "  \"title\": \"" + registersPostPut.getTitle() + "\",\r\n"
					+ "  \"body\": \"" + registersPostPut.getBody() + "\"\r\n"
					+ "}")
		.when()
			.put("/posts/" + registersPostPut.getId()) //realiza a requisicao
		.then()
			.log().all()
			.statusCode(registersPostPut.getStatusCode()); //valida o status code de acordo com o esperado que esta sendo passado na feature
	}
	
	public void patchRegister() {
		
		given() //pre condicao
			.log().all() // apresenta o log no console
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "  \"title\": \"" + registersPostPut.getTitle() + "\"\r\n"
					+ "}")
		.when()
			.patch("/posts/" + registersPostPut.getId()) //realiza a requisicao
		.then()
			.log().all()
			.statusCode(registersPostPut.getStatusCode()) //valida o status code de acordo com o esperado que esta sendo passado na feature
			.body("userId", is(notNullValue()))
			.body("id", is(notNullValue()))
			.body("title", is(registersPostPut.getTitle())) //valida o resultado
			.body("body", is(notNullValue())); //valida o resultado
	}
	
	public void deleteRegister() {
		
		given() //pre condicao
			.log().all() // apresenta o log no console
		.when()
			.delete("/posts/" + registersDelete.getId()) //realiza a requisicao
		.then()
			.log().all()
			.statusCode(registersDelete.getStatusCode()); //valida o status code de acordo com o esperado que esta sendo passado na feature
	}
	
}
