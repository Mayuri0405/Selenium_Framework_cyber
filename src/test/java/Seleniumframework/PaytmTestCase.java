package Seleniumframework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class PaytmTestCase {
@BeforeGroups("group1")
public void beforeGroup()
{
	System.out.println("This is before group method from paytm class");
}
@AfterGroups("group1")
public void afterGroup()
{
	System.out.println("This is after group method from paytm class");
}
@Test(groups = "group1")
public void paytmtestCase() {
	System.out.println("This is test method from paytm");
}
@BeforeClass()
public void beforeClass()
{
}
@AfterClass()
public void afterClass()
{
}
	
	
	
	
	
}
