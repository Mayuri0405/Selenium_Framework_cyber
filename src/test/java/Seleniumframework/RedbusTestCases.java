package Seleniumframework;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

public class RedbusTestCases extends BaseClasss{
	@Test
public void verifyTheTitle()
{
	System.out.println("Test1");
	driver=launchBrowser("Chrome");
	driver.get("https://redbus.com");
	System.out.println(driver.getTitle());
	System.out.println(LocalDateTime.now().getDayOfMonth());
}
	@Test(dependsOnMethods = {"verifyTheTitle"})
	public void verifyUrl()
	{
		
	}
	@Test(dependsOnMethods = {"verifyUrl"})
	public void closeBrowser()
	{
		System.out.println("Test2");
		driver.quit();
	}
}
