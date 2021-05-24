package Seleniumframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClasss {

		public static WebDriver driver;


		public WebDriver launchBrowser(String browserName) {


		switch (browserName) {


		case "Chrome":
		System.setProperty("webdriver.chrome.driver",
		"D:\\All Drivers\\chromedriver.exe");


		driver = new ChromeDriver();
		return driver;


		case "Mozila":


		System.setProperty("webdriver.firefox.driver",
		"D:\\All Drivers\\geckodriver.exe");


		return driver = new FirefoxDriver();


		default:
		System.setProperty("webdriver.chrome.driver",
		"D:\\All Drivers\\chromedriver.exe");


		driver = new ChromeDriver();
		return driver;


		}


		}


		public void closeBrowserInstance() {


		driver.quit();
		}


		public void selectByIndex(WebElement element, int index) {


		Select select = new Select(element);
		select.selectByIndex(index);


		}


		public void selectByValue(WebElement element,String value) {


		Select select = new Select(element);
		select.selectByValue(value);


		}


		public void selectByVisibletext(WebElement element, String visibleText) {


		Select select = new Select(element);
		select.selectByVisibleText(visibleText);


		}
		



		public String generateEmailId() {

		return "";
		}
		}


