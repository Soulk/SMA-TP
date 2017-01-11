package core;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.InputStream;

public class PropertiesReader {

	private static PropertiesReader instance;
	static Properties prop = new Properties();
	static InputStream input;
	
	public PropertiesReader() throws FileNotFoundException {
		input = new FileInputStream("multi_agents.properties");
	}
	
	public static PropertiesReader getInstance()  {
		if(instance == null) {
			try {
				instance = new PropertiesReader();
				prop.load(input);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public String getProperties(String key){
		return prop.getProperty(key);
	}
	
}
