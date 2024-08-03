package com.Fieldy.TestUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	File file;
	FileInputStream inputStream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	int rowNum;
	int cellNum;
	XSSFRow row;
	XSSFCell cell;
	DataFormatter format;
	int i,j;
	String stringArray[][];
	
	public ExcelUtils(String excelPath,String sheetName){
		try{
		file=new File(excelPath);
		inputStream=new FileInputStream(file);
		workbook=new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);
		}
		
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public String getSingleValue(int rowNum,int columnNum){
		row = sheet.getRow(rowNum);
		cell = row.getCell(columnNum);
		format=new DataFormatter();
		return format.formatCellValue(cell);
	}
	
	public int getRowCount(){
		rowNum=sheet.getLastRowNum()+1;
		return rowNum;
	}
	
	public int getColumnCount(){
		cellNum = sheet.getRow(0).getLastCellNum();	
		return cellNum;
	}
	
	public String[][] getEntireValue(int rowSize,int columnSize){
		stringArray=new String[rowSize][columnSize];
		for(int i=0; i<rowSize; i++){
			for(int j=0; j<columnSize; j++){
				row = sheet.getRow(i);
				cell = row.getCell(j);
				DataFormatter format=new DataFormatter();
				String value=format.formatCellValue(cell);
				stringArray[i][j]=value;
			}
		}
		return stringArray;
	}
}
