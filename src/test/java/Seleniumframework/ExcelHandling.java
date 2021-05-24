package Seleniumframework;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelHandling extends BaseClasss{

	public static void main(String[] args) {
		@DataProvider(name = "ExcelData")
		public Object[][] excelMethod()
		{
			Object[][] testData=null;
	File file=new File("E:\\Selenium lecture cyber\\Excel.xlsx");
	try {
		FileInputStream inputFile=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(inputFile);
		Sheet sheet=wb.getSheet("sheet1");
		XSSFRow row=sheet.getRow(0);
		int totalRows=sheet.getPhysicalNumberOfRows();
		int totalColumns=row.getPhysicalNumberofCells();
		testData=new Object[totalRows-1][totalColumns];
		//int totalRows=sheet.getLastRowNum();
		//int totalColumns=row.getLastCellNum();
		for(int i=1;i<=totalRows-1;i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
			String data=sheet.getRow(i).getCell(j).getString.cellValue();
			if(cell!=null)
			{
				if(cell.getCellType().equals(cellType.STRING))
				{
					testData[i-1][j]=cell.getStringCellValue();
				}else if(cell.getCellType().equals(cellType.NUMERIC))
				{
					testData[i-1][j]=cell.getNumericCellValue();
				}else if(cell.getCellType().equals(cellType.BOOLEAN))
				{
					testData[i-1][j]=cell.getBooleanCellValue();
				}else if(cell.getCellType().equals(cellType.BLANK))
				{
					System.out.println("Blank Cell");
					testData[i - 1][j] = null;
					testData[i-1][j]=cell.getErrorCellValue();
				}
			}
			System.out.println(data);
			System.out.println(" ");
			}
			
		}
		
	    }catch(Exception e)
	{
	    	e.printStackTrace();
	}
	return testData;
		}
		
		
	@Test(dataProvider = "ExcelData")
	public void m1(String username,Object password,String FN,String LN,double age,double salary,String city)
	{
		System.out.println("Username:"+username+",password:"+password+", First name:"+FN+" ,Last name:"+LN+" ,Age"+age+",salary:"+salary+", city:"+city);
		
	}
	@BeforeClass
	public void beforeClass()
	{
		driver=launchBrowser("Chrome");
		driver.navigate().to("");
	}
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password.toString());
	driver.findElement(By.id("loginButton")).click();
	Assert.assertTrue(driver.findElement(By.id("Admin")).isDisplayed());
	driver.findElement(By.id("firstName")).sendKeys(FN);
	
	
	}

}
