package Seleniumframework;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelExecution extends BaseClasss {
@DataProvider(name="Dataobject")
public Object[] provideData()
{
	Object[] obj=new Object[] {
			{"username1","password1"},
			{"username2","password2"},
			{"username3","password3"},
			{"username4","password4"},
			{"username5","password5"},
			};
	return obj;
	
}
//@Test(dataProvider="DataObject")
@Test(dataProvider = "LoginData", dataProviderClass = "TestDataProvider.class")
public void method1(String srNo,String username,String password)
{
	/*
	 * System.out.println(username +":"+password); driver=launchBrowser(username);
	 * driver.navigate().to(
	 * "https://opensource-demo.org.orangehrm.live.com/index.php/dashboard");
	 * driver.findElement(By.id("username")).sendKeys(username);
	 * driver.findElement(By.id("password")).sendKeys(password);
	 * driver.findElement(By.id("login-button")).click();
	 */
	
	System.out.println("Sr NO:"+srNo +"username:"+username +"password:"+password);
}




}
