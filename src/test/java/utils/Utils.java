package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
	
	public static int randomNumber() {
	      int min = 1;
	      int max = 10;
	        
	      int random_int = (int)(Math.random() * (max - min + 1) + min);

	      return random_int;
	}
	
	public static String projectDirectory() {
		String diretorio = System.getProperty("user.dir");
		return diretorio;
	}
	
	public static String readLastRegisterInserted(String fileName) throws IOException {

		String ultimo = "";
		try {
			InputStream is = new FileInputStream(projectDirectory()+"\\src\\test\\resources\\Dados\\" + fileName);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line = "";
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					ultimo = line;
				}
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ultimo;
	}
	
	public static void writeData(String texto, String fileName) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(projectDirectory()+"\\src\\test\\resources\\Dados\\" + fileName, true));
		buffWrite.append(texto + "\n");
		buffWrite.close();
	}

}
