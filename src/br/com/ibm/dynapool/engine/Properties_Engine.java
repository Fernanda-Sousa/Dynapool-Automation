/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 10-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.engine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Properties_Engine {

	private void createNewProperties() {

		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("resources\\config.properties");

			// set the properties value
			prop.setProperty("environment", "test");
			prop.setProperty("testwebsite", "xxxxx");
			prop.setProperty("prodwebsite", "xxxxx");
			prop.setProperty("driverpath", "C:\\DeveloperTools\\WebDriver\\");

			/* Add more fields if necessary */

			prop.store(output, null);
			System.out.println("Done!\n\n");

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public String readPropertiesFile(String property) throws IOException{
		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "config.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				System.out.println("Creating a new propertiesfile: " + filename);
				createNewProperties();
				System.out.println("You need to insert real values there before start using.\n\n");
				System.out.println("The test will break now, please, update your project and verify if config.properties exists");
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("environment"));
			
			return prop.getProperty(property);
			
		} catch (IOException ex) {
			ex.printStackTrace();
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