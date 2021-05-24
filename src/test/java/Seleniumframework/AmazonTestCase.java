package Seleniumframework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class AmazonTestCase {
@BeforeClass
public void beforeClass()
{
	System.out.println("This is before class");
}
@AfterClass
public void afterClass()
{
	System.out.println("This is after class");
}
@BeforeGroups("group1")
public void beforeGroup()
{
	System.out.println("This is before grp method from amazon class");
}
@AfterGroups("group1")
public void afterGroup()
{
	System.out.println("This is after grp method from amazon class");
}
@Test(groups = "group2")
public void Test1()
{
	System.out.println("This is Test1 method");
}
@Test(groups = "group1")
public void Test2()
{
	System.out.println("This is Test2 method");
}
}
