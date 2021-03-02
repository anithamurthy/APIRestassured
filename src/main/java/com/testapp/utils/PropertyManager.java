package com.testapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	private static Properties prop;
	private static PropertyManager manager;

	private PropertyManager() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PropertyManager getInstance() {

		if (manager == null) {
			synchronized (PropertyManager.class) {
				manager = new PropertyManager();
			}

		}
		return manager;
	}

	public String getString(String key) {
		return System.getProperty(key, prop.getProperty(key));
	}

}
