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

			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty("environment", "test");
			prop.setProperty("testwebsite", "xxxxx");
			prop.setProperty("prodwebsite", "xxxxx");

			/* Add more fields if necessary */

			prop.store(output, null);
			System.out.println("Done!");

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

	public String readPropertiesFile(String property) {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "config.properties";
			input = Properties_Engine.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				System.out.println("Creating a new propertiesfile: " + filename);
				createNewProperties();
				System.out.println("You need to insert real values there before use.");
				
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("environment"));
			
			return prop.getProperty("environment");
			
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