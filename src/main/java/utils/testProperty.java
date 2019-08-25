package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class testProperty {
	
	public Properties properties = new Properties();
	File file = new File("testData.properties");
	
	public testProperty() throws IOException {
		FileInputStream fileInput = new FileInputStream(file);
		properties.load(fileInput);
		fileInput.close();
	}
}
