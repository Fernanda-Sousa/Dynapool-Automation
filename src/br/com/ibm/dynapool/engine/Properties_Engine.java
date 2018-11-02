/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 10-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Properties_Engine {

	public String readPropertiesFile(String property) {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "config.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);

			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			return prop.getProperty(property);

		} catch (IOException ex) {
			System.out.println("Error on get file: " + ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "";

	}

}