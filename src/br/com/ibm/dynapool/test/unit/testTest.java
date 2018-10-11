package br.com.ibm.dynapool.test.unit;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class testTest {
	
	
	
	@BeforeClass
	public void setup() throws IOException {
		Selenium_Engine.createDriver();
		Selenium_Engine.openURL("https:\\www.google.com");
	}
	
	@Test
	public void test1() {
		System.out.println("VISH");
	}

	@AfterClass
	public void teardown() {
//		Selenium_Engine.
	}

}
