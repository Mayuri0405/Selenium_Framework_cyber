package Seleniumframework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.config.Config;

public class TestCaseSuite extends BaseClasss {
	String username;
	String password;
@BeforeSuite(groups = {"group1"})
public void beforeSuite()
{
	System.out.println("This is paytm before suit method");
	ConfigProperties config=new ConfigProperties();
	username=config.getProperty("username");
	password=config.getProperty("password");
}
@AfterSuite(groups = {"group1"})
public void afterSuit()
{
	System.out.println("This is paytm after suit method");
}
@BeforeTest(groups = {"group1"})
public void beforeTest()
{
System.out.println("This is before test method from paytm");	
}
@AfterTest(groups = {"group1"})
public void afterTest()
{
System.out.println("This is after test method from paytm");	
}
@Test(groups = {"group1"})
public void case1()
{
	System.out.println("This is case1 method from paytm");
}
@Test(groups = {"group2"},dependsOnGroups = {"group1"})
public void case2()
{
	System.out.println("This is case2 method from paytm");
}
@Test(groups = {"paytmTest"},dependsOnGroups = {"case1","case2"})
public void a()
{
	System.out.println("This is a method from paytm");
}
@BeforeClass(groups = {"group1"})
public void beforeClass()
{
	System.out.println("This is paytm before class method");

driver=launchBrowser("Chrome");
driver.get("https://gmail.com");
System.out.println(username);
System.out.println(password);
}
@AfterClass(groups = {"group1"})
public void afterClass()
{
System.out.println("This is paytm after class method");	
closeBrowserInstance();
}

}
