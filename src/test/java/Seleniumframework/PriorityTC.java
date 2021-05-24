package Seleniumframework;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PriorityTC extends BaseClasss {
@BeforeSuite
@Parameters({"Browser"})
public void beforeSuit(@Optional("Chrome")String Browser)
{
driver=launchBrowser(Browser);	
}
@BeforeTest
public void beforeTest()
{	
}
@AfterTest
public void afterTest()
{
	closeBrowserInstance();
}
@Test(priority =0)
@Parameters({"username","password"})
public void login() throws InterruptedException
{
	System.out.println("Login Method");
	Properties config=new Properties();
	driver.navigate().to(config.getProperty("orangehrm"));
	driver.findElement(By.id("txtUsername")).sendKeys(config.getProperty("OrangeHrmUN"));
	driver.findElement(By.id("txtPassword")).sendKeys(config.getProperty("orangeHrmpw"));
	driver.findElement(By.id("btnlogin")).click();
	Thread.sleep(1000);
}
@Test(dependsOnMethods = "verifyLogin")
public void logout() {
	System.out.println("Logout Method");
	WebElement logoutLink=driver.findElement(By.id("welcome"));
	Wait<WebDriver> wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
	logoutLink.click();
	}
WebElement logoutButton=driver.findElement(By.xpath("//div[@id='welcome-menu']/descendent::a[4]"));
Wait<WebDriver> wait=new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
logoutButton.click();
if(driver.findElement(By.id("btnLogin")).isDisplayed())
{
	System.out.println("Successfully logout from application");
}else {
	System.out.println("Fail to logout fromapplication");
}


@Test(priority =2)
public void verifyLogin()
{
	System.out.println("Verify Login Method");
	String AdminModuleName=driver.findElement(By.id("menu-admin-view-Admin Module")).getText();
	if(AdminModuleName.equals("Admin"))
	{
		System.out.println("Login verified successfully");
	}else {
		System.out.println("Unable to verify login");
	}
}




}
