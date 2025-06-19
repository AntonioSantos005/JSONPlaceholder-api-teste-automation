package listener;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class CustomListener extends RunListener {	
	
    //  Chamado quando o teste vai ser executado.     
	@Override
	public void testStarted(Description description) throws Exception {
		System.out.println("Listener.testStarted: executado " + description.getDisplayName());
	}
	
	//Chamado quando o teste eh finalizado	
	@Override
	public void testFinished(Description description) throws Exception {
		System.out.println("Listener.testFinished: executado " + description.getDisplayName());
	}
	
	// Chamado apos todos os tedes terem sido finalizados
	@Override
	public void testRunFinished(Result result) throws java.lang.Exception
    {
        System.out.println("Número de testes executados: " + result.getRunCount());
    }
	
	//Chamado quando o teste falha
	@Override
	public void testFailure(Failure failure) throws java.lang.Exception
    {
        System.out.println("Execução do caso de teste falhou: "+ failure.getMessage());
    }
}
