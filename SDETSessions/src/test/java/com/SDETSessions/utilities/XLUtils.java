package com.SDETSessions.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fos;
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException
	{
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		ws=wb.getSheet(xlSheet);
		int rowCount=ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
		
	}
	public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException
	{
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
		
	}
	
	public static String getCellData(String xlFile, String xlsheet, int rowNum, int colNum) throws IOException
	{
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		try
		{
		DataFormatter formatter = new DataFormatter();
		String cellvalue=formatter.formatCellValue(cell);
		return cellvalue;
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
		fis.close();
		return data;
		
		
	}
	
	public static void setCellData(String xlFile, String xlsheet, int rowNum, int colNum, String data) throws IOException
	{
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(xlFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
		
	}
}
