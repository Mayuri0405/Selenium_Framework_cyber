package Seleniumframework;

import java.io.File;

public class ExtendAutomationReport extends BaseClasss {
public static ExtentReports getExtentReport()
{
	ConfigProperties config=new ConfigProperties();
	String xmlFilePath=System.getProperty("user.dir")+"src/main/java/Reporting/extentReportConfig.xml";
	File file=new File(xmlFilePath);
	extentReports=new ExtentReports(System.getProperty("user.dir")+"/target/ExtentReport/ExtentReport.html");
	extentReports.addSystemInfo("Browser",config.getProperty("browser"));
	extentReports.addSystemInfo("Environment",config.getProperty("Environment"));
	extentReports.addSystemInfo("Url",config.getProperty("url"));
	extentReports.addSystemInfo("username",config.getProperty("username"));
	extentReports.addSystemInfo("password",config.getProperty("password"));
	extentReports.loadConfig(file);
	return extentReports;
}
public static ExtentTest startTest(String methodName)
{
	logger=extentReports.startTest(methodName);
	return logger;
	
}
}
 