package singleton;

import model.RegisterModel;

//Classe responsavel por garantir apenas a instancia do objeto em uma unica classe

public class RegisterSingleton {
	
	private static RegisterModel registersGet = new RegisterModel();
	private static RegisterModel registersPostPut = new RegisterModel();
	private static RegisterModel registersDelete = new RegisterModel();

	public static RegisterModel instanceToGet() {
		return registersGet;
	}
	
	public static RegisterModel instanceToPostPut() {
		return registersPostPut;
	}
	
	public static RegisterModel instanceToDelete() {
		return registersDelete;
	}
}
