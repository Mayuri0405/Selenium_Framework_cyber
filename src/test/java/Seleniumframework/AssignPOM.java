package Seleniumframework;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//from dateand to date should be same consider next day date of assig next date
public class AssignPOM extends BaseClasss{

driver=launchBrowser("Chrome");
	  
	
	 driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']")).click();
	driver.findElement(By.xpath("//input[@id='calFromDate']")).click();
	Date d = new Date(1);
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
	String date = formatter.format(d);
	String splitter[] = date.split("-");
	String month_year = splitter[1];
	String day = splitter[0]; 
	System.out.println(month_year);
	System.out.println(day);


	selectDate(month_year,day); 
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='calToDate']")).click();
	selectDate(month_year,day); 
	driver.findElement(By.xpath("//div[@id='leaveList_chkSearchFilter_checkboxgroup']")).isSelected();

}
