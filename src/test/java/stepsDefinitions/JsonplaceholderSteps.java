package stepsDefinitions;

import static utils.Utils.randomNumber;
import static utils.Utils.readLastRegisterInserted;
import static utils.Utils.writeData;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import model.RegisterModel;
import singleton.RegisterSingleton;
import testAPI.JsonplaceholderTests;

public class JsonplaceholderSteps {
	
	private RegisterModel registersGet = RegisterSingleton.instanceToGet();
	private RegisterModel registersPostPut = RegisterSingleton.instanceToPostPut();
	private RegisterModel registersDelete = RegisterSingleton.instanceToDelete();
	
	JsonplaceholderTests jsonplaceholder = new JsonplaceholderTests();
	
	@Dado("^que o usuario deseja realizar uma consulta geral pela url \"([^\"]*)\"$")
	public void queOUsuarioDesejaRealizarUmaConsultaGeralPelaUrl(String url) throws Throwable {
		registersGet.setUrl(url);
	}

	@Entao("^o status code ao realizar uma consulta geral com sucesso deve ser (\\d+) e deve retornar a lista com um ou mais registros cadastrados$")
	public void oStatusCodeAoRealizarUmaConsultaGeralComSucessoDeveSerEDeveRetornarAListaComUmaOuMaisRegistrosCadastrados(
			int statusCode) throws Throwable {
		
		registersGet.setStatusCode(statusCode);
		
	    jsonplaceholder.getRegisters();
	}

	@Dado("^que o usuario deseja realizar uma consulta de registro por um id existente$")
	public void queOUsuarioDesejaRealizarUmaConsultaDeRegistroPeloPorUlIdExistente() throws Throwable {
		int id = Integer.parseInt(readLastRegisterInserted("DadosConsultarRegistros.txt"));
		registersGet.setId(id);
	}
	
	@Dado("^que o usuario deseja realizar uma consulta de registro pelo id inexistente (\\d+)$")
	public void queOUsuarioDesejaRealizarUmaConsultaDeRegistroPeloIdInexistente(int id) throws Throwable {
		registersGet.setId(id);
	}

	@Entao("^o status code ao realizar uma consulta por id com sucesso deve ser (\\d+) e deve retornar a lista com o resusultado referente ao id$")
	public void oStatusCodeAoRealizarUmaConsultaPorIdComSucessoDeveSerEDeveRetornarAListaComOResultadoReferenteAoId(
			int statusCode) throws Throwable {
		registersGet.setStatusCode(statusCode);
		
	    jsonplaceholder.getRegisterById();
	}

	@Dado("^que o usuario deseja realizar uma consulta de comentario de registro pelo postid (\\d+)$")
	public void queOUsuarioDesejaRealizarUmaConsultaDeComentarioDeRegistroPeloPostid(int id) throws Throwable {
		registersGet.setId(id);
	}

	@Entao("^o status code ao realizar uma consulta de comentarios por postid com sucesso deve ser (\\d+) e deve retornar a lista com o resusultado referente ao postid$")
	public void oStatusCodeAoRealizarUmaConsultaDeComentariosPorPostidComSucessoDeveSerEDeveRetornarAListaComOResusultadoReferenteAoPostid(
			int statusCode) throws Throwable {
		registersGet.setStatusCode(statusCode);
		
	    jsonplaceholder.getCommentsByPostId();
	}

	@Dado("^que o usuario deseja inserir um novo registro com um userId valido, o title \"([^\"]*)\" e o body \"([^\"]*)\"$")
	public void queOUsuarioDesejaInserirUmNovoRegistroNaUrlComUmUserIdValidoOTitleEOBody(String title,
			String body) throws Throwable {
		registersPostPut.setId(randomNumber());
		
		//registrar ultimo numero cadastrado no arquivo de dados
		writeData(registersPostPut.getId().toString(), "DadosCriarAlterarRegistros.txt");
//		writeData(registersPostPut.getId().toString(), "DadosConsultarRegistros.txt");
//		writeData(registersPostPut.getId().toString(), "DadosApagarRegistros.txt");
		
		registersPostPut.setTitle(title);
		registersPostPut.setBody(body);
	}

	@Entao("^o status code ao inserir um registro com sucesso deve ser (\\d+)$")
	public void oStatusCodeAoInserirUmRegistroComSucessoDeveSer(int statusCode) throws Throwable {
		registersPostPut.setStatusCode(statusCode);
		
		jsonplaceholder.postNewRegister();
	}
	

	@Dado("^que o usuario deseja alterar um registro com um userId ja cadastrado, o title \"([^\"]*)\" e o body \"([^\"]*)\"$")
	public void queOUsuarioDesejaAlterarUmRegistroComUmUserIdJaCadastradoOTitleEOBody(String title, String body)
		throws Throwable {
		int id = Integer.parseInt(readLastRegisterInserted("DadosCriarAlterarRegistros.txt"));
		registersPostPut.setId(id);
		registersPostPut.setTitle(title);
		registersPostPut.setBody(body);
	}

	@Entao("^o status code ao alterar um registro com sucesso deve ser (\\d+)$")
	public void oStatusCodeAoAlterarUmRegistroComSucessoDeveSer(int statusCode) throws Throwable {
		registersPostPut.setStatusCode(statusCode);
		
		jsonplaceholder.updateRegister();
	}

	@Dado("^que o usuario deseja apagar um registro que possua um userId valido$")
	public void queOUsuarioDesejaApagarUmRegistroQuePossuaUmUserIdValido() throws Throwable {
		int id = Integer.parseInt(readLastRegisterInserted("DadosApagarRegistros.txt"));
		registersDelete.setId(id);
	}

	@Entao("^o status code ao apagar um registro com sucesso deve ser (\\d+)$")
	public void oStatusCodeAoApagarUmRegistroComSucessoDeveSer(int statusCode) throws Throwable {
		registersDelete.setStatusCode(statusCode);
		
		jsonplaceholder.deleteRegister();
	}

	@Dado("^que o usuario deseja alterar parcialmente um registro com um userId ja cadastrado e apenas o title \"([^\"]*)\"$")
	public void queOUsuarioDesejaAlterarParcialmenteUmRegistroComUmUserIdJaCadastradoEApenasOTitle(String title)
			throws Throwable {
		int id = Integer.parseInt(readLastRegisterInserted("DadosCriarAlterarRegistros.txt"));
		registersPostPut.setId(id);
		registersPostPut.setTitle(title);
	}

	@Entao("^o status code ao alterar parcialmente um registro com sucesso deve ser (\\d+)$")
	public void oStatusCodeAoAlterarParcialmenteUmRegistroComSucessoDeveSer(int statusCode) throws Throwable {
		registersPostPut.setStatusCode(statusCode);
		
		jsonplaceholder.patchRegister();
	}

	@Entao("^o status code ao realizar uma consulta por id inexistente deve ser (\\d+)$")
	public void oStatusCodeAoRealizarUmaConsultaPorIdInexistenteDeveSer(int statusCode) throws Throwable {
		registersGet.setStatusCode(statusCode);
		
		jsonplaceholder.getNonexistentRegisterById();
	}

	@Dado("^que o usuario deseja alterar um registro com um userId inexistente (\\d+), o title \"([^\"]*)\" e o body \"([^\"]*)\"$")
	public void queOUsuarioDesejaAlterarUmRegistroComUmUserIdInexistenteOTitleEOBody(int id, String title, String body)
			throws Throwable {
		registersPostPut.setId(id);
		registersPostPut.setTitle(title);
		registersPostPut.setBody(body);
	}
	

	@Entao("^o status code ao alterar um registro com userId inexistente deve ser (\\d+)$")
	public void oStatusCodeAoAlterarUmRegistroComUserIdInexistenteDeveSer(int statusCode) throws Throwable {
		registersPostPut.setStatusCode(statusCode);
		
		jsonplaceholder.updateNonExistentRegister();
	}

	
}
