package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelForDataProvider {

	public static String[][] readExcelData(String SheetName) throws InvalidFormatException, IOException{
		
		//Locating the workbook in the system
		File excelFilename = new File("./data/Leads.xlsx");
		
		//Opening the Workbook
		XSSFWorkbook wbook = new XSSFWorkbook(excelFilename);
		
		//Opening a Sheet
		
		XSSFSheet sheet = wbook.getSheet(SheetName);
		
		
		//Counting all the rows and columns
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		
			//Pulling the excel row and column count into a Array
			String[][] data = new String[rowCount][columnCount];
			
			
			//Iterate to pull row records based on index
			
			for (int i = 1; i <= rowCount; i++) {
				//Row
				XSSFRow row = sheet.getRow(i);
				
			//Iterate to pull cell records based on Index
				
			for(int j = 1; j< columnCount; j++)	{
				
				XSSFCell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
				data[i-1][j] = cell.getStringCellValue();
			}
		}
		
		
		//Iterating the row and Columns to pull the records based on the Index
		
		wbook.close();
		
		return data;
		
		
	}
	
	
	
	
}
