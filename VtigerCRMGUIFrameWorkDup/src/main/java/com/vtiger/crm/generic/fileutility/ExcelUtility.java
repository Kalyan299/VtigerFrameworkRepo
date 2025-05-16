package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcelFile(String SheetName, int rownum, int cellnum) throws Exception
	{
		FileInputStream fis=new FileInputStream("./resources/Test.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String data=book.getSheet(SheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		
		return data;
	}
	public int getRowCount(String SheetName) throws Exception
	{
		FileInputStream fis=new FileInputStream("./resources/Test.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		int rowCount = book.getSheet(SheetName).getLastRowNum();
		return rowCount;
	}
	
	public void setDataIntoExcel(String SheetName, int rownum, int cellnum, String data) throws Exception
	{
		FileInputStream fis=new FileInputStream("./resources/Test.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(SheetName).getRow(rownum).createCell(cellnum);
		
		FileOutputStream fos=new FileOutputStream("./resources/Test.xlsx");
		book.write(fos);
		book.close();
	}
}
