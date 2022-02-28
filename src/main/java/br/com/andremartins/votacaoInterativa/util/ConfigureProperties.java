package br.com.andremartins.votacaoInterativa.util;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigureProperties {
	
			
			public static String ENV;
	
	 static{		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
			
			
			ENV = prop.getProperty("ENV");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
