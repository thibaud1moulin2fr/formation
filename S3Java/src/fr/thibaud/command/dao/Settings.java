package fr.thibaud.command.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
	private static Properties properties;
	static {
		properties = new Properties();
		InputStream is = null;
		File file = new File ("C:/Users/Administrateur/Desktop/settings.txt");
		try {
			is = new FileInputStream(file);
			properties.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getProperty (String key) {
		return properties.getProperty(key);
	}
}
