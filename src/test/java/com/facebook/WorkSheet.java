 package com.facebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkSheet {
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\acer\\eclipse-workspace\\Employee\\src\\main\\ExcelSheet\\Excel.xlsx");// mention the path of Excelsheet
		FileInputStream Steam = new FileInputStream(file);//Get the object,byte from file
		Workbook WorkBook = new XSSFWorkbook(Steam);
		Sheet sheet = WorkBook.getSheet("Sheet1");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(1);
		System.out.println(cell);
		
		int cells=row.getPhysicalNumberOfCells();
		
		System.out.println(cells);
		
		
		
	}
	

}
