package Seleniumframework;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtil {
	static Workbook wb;
	static Sheet sheet;
	static Row row;


	public static Object[][] readExcelData(String filePath) throws IOException {


	Object[][] testData = null;


	// String file = "E:\Selenium lecture cyber\\Excel.xlsx";


	String extention = filePath.substring(filePath.indexOf("."));


	try {
	FileInputStream input = new FileInputStream(filePath);


	if (extention.equals(".xlsx")) {


	wb = new XSSFWorkbook(input);


	} else {
	wb = new HSSFWorkbook(input);


	}


	sheet = wb.getSheetAt(0);
	row = sheet.getRow(0);


	int totalRows = sheet.getPhysicalNumberOfRows();
	int totalColumns = row.getPhysicalNumberOfCells();


	testData = new Object[totalRows - 1][totalColumns];


	for (int i = 1; i <= totalRows - 1; i++) {


	for (int j = 0; j < row.getLastCellNum(); j++) {


	Cell cell = sheet.getRow(i).getCell(j);


	if (cell != null) {
	if (cell.getCellType().equals(CellType.STRING)) {


	testData[i - 1][j] = cell.getStringCellValue();


	} else if (cell.getCellType().equals(CellType.NUMERIC)) {


	testData[i - 1][j] = cell.getNumericCellValue();
	} else if (cell.getCellType().equals(CellType.BOOLEAN)) {


	testData[i - 1][j] = cell.getBooleanCellValue();


	} else if (cell.getCellType().equals(CellType.BLANK)) {
	System.out.println("Blank Cell");
	testData[i - 1][j] = null;
	}
	}


	}


	}
	} catch (Exception e) {


	e.printStackTrace();
	} finally {
	wb.close();


	}
	return testData;
	}


	public static void writeExcelData(String filePath, int rowNumber, int cellPosition, Object value)
	throws IOException {
	String extention = filePath.substring(filePath.indexOf("."));


	try {
	FileInputStream input = new FileInputStream(filePath);


	if (extention.equals(".xlsx")) {


	wb = new XSSFWorkbook(input);
	System.out.println(wb);


	} else {
	wb = new HSSFWorkbook(input);


	}


	sheet = wb.getSheetAt(0);
	row = sheet.getRow(0);


	int totalRows = sheet.getPhysicalNumberOfRows();


	/*
	* for(int i=1; i<=totalRows-1; i++) {
	* 
	* sheet.getRow(i).createCell(cellPosition).setCellValue("Fail");
	* 
	* }
	*/


	if (value.getClass().toString().contains("class java.lang.Integer")) {


	sheet.getRow(rowNumber).createCell(cellPosition).setCellValue((int) value);


	} else if (value.getClass().toString().contains("class java.lang.String")) {


	sheet.getRow(rowNumber).createCell(cellPosition).setCellValue(value.toString());
	}


	FileOutputStream output = new FileOutputStream(filePath);


	wb.write(output);
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	wb.close();
	}


	}


	public static Object getCellValue(String filePath, int rowNum, int columnNum) throws IOException {


	String extention = filePath.substring(filePath.indexOf("."));


	Object returnData = null;


	try {
	FileInputStream input = new FileInputStream(filePath);


	if (extention.equals(".xlsx")) {


	wb = new XSSFWorkbook(input);


	} else {
	wb = new HSSFWorkbook(input);


	}


	sheet = wb.getSheetAt(0);


	Row row = sheet.getRow(rowNum);


	Cell cell = row.getCell(columnNum);


	if (cell.getCellType().equals(CellType.NUMERIC)) {


	returnData = cell.getNumericCellValue();


	} else if (cell.getCellType().equals(CellType.STRING)) {
	returnData = cell.getStringCellValue();


	} else if (cell.getCellType().equals(CellType.BOOLEAN)) {
	returnData = cell.getBooleanCellValue();


	}


	// returnData =  row.getCell(columnNum).getStringCellValue();


	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	wb.close();
	}


	return returnData;
	}
	}
	Class comments


}
