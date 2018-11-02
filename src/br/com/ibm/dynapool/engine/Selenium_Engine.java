/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 31-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.engine;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.ibm.dynapool.pages.Home_Page;
import br.com.ibm.dynapool.pages.Login_Page;

public class Selenium_Engine {

	public static WebDriver driver;
	Properties_Engine prop = new Properties_Engine();
	public final boolean CHROME = true;

	String parentWindowHandler = null; // Store your parent window (pop up)
	String subWindowHandler = null;

	final boolean DEBUG = true;

	public WebDriver driver() {
		return driver;
	}

	public void sysOut(Object s) {
		if (DEBUG) {
			System.out.print("\n" + s.toString());
		}
	}

	public void sleepMinutes(int minutes) {
		try {
			TimeUnit.MINUTES.sleep(minutes);
		} catch (InterruptedException ex) {
			System.out.println("Error on sleeptime minutes: " + ex);
		}
	}

	public void sleepSeconds(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException ex) {
			System.out.println("Error on sleeptime seconds: " + ex);
		}
	}

	public void waitElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 60000);
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitForPageLoad() {

		Wait<WebDriver> wait = new WebDriverWait(driver, 60000);
		wait.until((WebDriver driver1) -> {
//		sysOut("Current Window State       : "
//					+ String.valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState")));
//			
			return String.valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
					.equals("complete");
		});
	}

	public void click(By by) {
		moveScreen(by);
		waitForPageLoad();
		driver.findElement(by).click();
	}

	public void doubleClick(By by) {
		driver.findElement(by).click();
		driver.findElement(by).click();
	}

	/* Necessary driver on system/user path */
	public void createDriver() {

		if (CHROME) {
			System.setProperty("webdriver.chrome.driver", prop.readPropertiesFile("driverpath") + "chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",
					prop.readPropertiesFile("driverpath") + "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		parentWindowHandler = driver.getWindowHandle();
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public void manipulatePopUp(boolean manipulate) {
		try {
			if (manipulate) {
				Set<String> handles = driver.getWindowHandles();
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext()) {
					subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler);
			} else {
				driver.switchTo().window(parentWindowHandler);
			}
		} catch (Exception e) {
			System.out.println("Error on get popup, is it open?" + e);
		}

	}

	public void selectCheckBox(By by) {
		try {
			if (!driver.findElement(by).isSelected()) {
				driver.findElement(by).click();
	
			}
		} catch (Exception e) {
			System.out.println("Checkbox " + by.toString() + "is already selected" + e);
		}
	}

	public void unselectCheckBox(By by) {
		try {
			
			if (driver.findElement(by).isSelected()) {
				driver.findElement(by).click();
				
			}
		} catch (Exception e) {
			System.out.println("Checkbox " + by.toString() + "is already unselected" + e);
		}
	}

	public void selectAutoGeneratedlink(String linkname) {

		linkname = linkname.trim();

		if (linkname.contains(" ")) {
			linkname = linkname.split(" ")[0];
	
		}
		driver.findElement(By.partialLinkText(linkname)).click();
	}

	public void selectDropDown(By element, String item) {
		try {
	
			moveScreen(element);
			driver.findElement(element).click();
			sleepSeconds(2);
			Select selItem = new Select(driver.findElement(element));
			selItem.selectByVisibleText(item);

		} catch (Exception e) {
			System.out.println("item " + item + " not found on dropdown" + e);
		}
	}

	public void setTextbox(By element, String text) {
		try {

			moveScreen(element);
			driver.findElement(element).click();
			driver.findElement(element).clear();
//        waitElement(element);
			driver.findElement(element).sendKeys(text);
		} catch (Exception e) {
			System.out.println("\nNot able to edit Textbox, is it enabled?" + e);
		}
	}

	public void shutdownDriver() {
		try {
			sleepSeconds(10);
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception ee) {
			sysOut("No Driver to close" + ee);
		}
	}

	/* This method will return first file on folder */
	public String verifyFolder(String dir, boolean logged) {
		try {
			File file = new File(dir);
			File afile[] = file.listFiles();
			return afile[0].getName();
		} catch (Exception e) {
			sysOut("***No file on folder***\n\n" + e);
			sleepSeconds(1);
		}
		return "";
	}

	public boolean verifyTextOnFieldPartial(String text) {
		try {

			if (driver.getPageSource().contains(text)) {

				return true;
			}
		} catch (Exception e) {
			System.out.println("No text found for string: " + text + e);
		}
		return false;
	}

	public boolean verifyTextOnField(String text) {
		try {

			String text1;

			text1 = driver.findElement(By.linkText(text)).getText();
			sysOut(text1);
			if (text1.contains(text)) {

				return true;
			}
		} catch (Exception e) {
			System.out.println("No text found for string: " + text + e);
		}
		return false;
	}

	public void moveScreen(By by) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("javascript:window.scrollBy(" + driver.findElement(by).getLocation().x + ","
				+ driver.findElement(by).getLocation().y + ")");

	}

	public void waitElement(By by, int i) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public String alertClick() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.accept();
		return alertMessage;
	}

	List<?> findElements(By by) {

		return driver.findElements(by);
	}

	public String getAttribute(By by, String attribute) {

		return driver.findElement(by).getAttribute(attribute);
	}

	public boolean compareText(By by, String text) {

		return driver.findElement(by).getText().equals(text);
	}

	public boolean compareAttribute(By by, String attribute, String text) {

		return driver.findElement(by).getAttribute(attribute).equals(text);
	}

	public int getIntegerContent(By by) {

		return Integer.parseInt(driver.findElement(by).getText());
	}

	public String getContent(By by) {
		moveScreen(by);
		return driver.findElement(by).getText();
	}

	public boolean compareTextPartial(By by, String text) {

		return driver.findElement(by).getText().contains(text);
	}

	public void addDays(By by, int numDays) {

		// Get current day and add more x days for planned start date
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, numDays);
		date = c.getTime();
		String startDate = dateFormat.format(date);
		setTextbox(by, startDate);

	}

	public void login(String role) {

		Login_Page login = new Login_Page();

		login.setUserName(prop.readPropertiesFile(role + "_user"));
		login.setUserPassword(prop.readPropertiesFile(role + "_pass"));
		login.setGDPRcheckbox(true);
		login.clickLoginButton();

	}

	public void changeUser(String newRole) {
		// Configuration
		Login_Page login = new Login_Page();
		Home_Page home = new Home_Page();

		openURL(prop.readPropertiesFile("testwebsite"));


		// Logout
		home.clickExitButton();

		// Login
		login.setUserName(prop.readPropertiesFile(newRole + "_user"));
		login.setUserPassword(prop.readPropertiesFile(newRole + "_pass"));
		login.setGDPRcheckbox(true);
		login.clickLoginButton();

	}
}
