package com.mckinsey.Newton.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelsUtils {
	
	public static List<Hashtable<String, String>> readFile(String strFilePath, String strSheetName, String PrimaryKey) throws Exception{
		String colName;
		
		List<Hashtable<String, String>> dataList = new ArrayList<Hashtable<String, String>>();
		XSSFSheet sheet = getSheet(strFilePath, strSheetName);
		List<Integer> rownum = getRow(PrimaryKey, sheet);
		Iterator<Integer> rowIterator = rownum.iterator();
		while(rowIterator.hasNext()) {
			int loadRow = rowIterator.next();
			Hashtable<String, String> codes = new Hashtable<String, String>();
			for(int i = 0; i< getColumnCount(sheet)-1; i++) {
				colName = sheet.getRow(0).getCell(i).getStringCellValue().trim();
				String colValue;
				if(sheet.getRow(loadRow).getCell(i) == null) {
					colValue = "";
				}else if(sheet.getRow(loadRow).getCell(i).getCellTypeEnum() == CellType.STRING) {
					colValue = sheet.getRow(loadRow).getCell(i).getStringCellValue().trim();		
			  }else if(sheet.getRow(loadRow).getCell(i).getCellTypeEnum() == CellType.NUMERIC) {
					colValue = String.valueOf(new Double(sheet.getRow(loadRow).getCell(i).getNumericCellValue()).intValue());		
			  }else if(sheet.getRow(loadRow).getCell(i).getCellTypeEnum() == CellType.FORMULA) {
					colValue = String.valueOf(sheet.getRow(loadRow).getCell(i).getCellFormula());
			  } else if(sheet.getRow(loadRow).getCell(i).getCellTypeEnum() == CellType.BLANK){
					colValue = "";
			  } else {
				  colValue = sheet.getRow(loadRow).getCell(i).getStringCellValue().trim();
			  }
				System.out.println(colName +" "+colValue);
			codes.put(colName, colValue);
			}
		  dataList.add(codes);
		}
		return dataList;
   }
	
	private static int getColumnCount(XSSFSheet sheet) {
		return sheet.getRow(0).getLastCellNum();
	}
	
	private static List<Integer> getRow(String primarykey,XSSFSheet sheet2){
		int i, k=0;
		List<Integer> rowNum = new ArrayList<Integer>();
		int maxrow =getRowCount(sheet2);
		for(i=1;i<=maxrow; i++) {
			if(sheet2.getRow(1).getCell(0).getStringCellValue().trim().toLowerCase().contains(primarykey.toLowerCase())) {
				rowNum.add(i);
				k=1;				
			}
		}
		if(k==0) {
			rowNum =null;
			
		}
		return rowNum;
	}
	
	private static int getRowCount(XSSFSheet sheet2) {
		return sheet2.getLastRowNum();
	}
	
	private static XSSFSheet getSheet(String strFileName,String strSheetName)throws Exception{
		FileInputStream file = new FileInputStream(new File(strFileName));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(strSheetName);
		return sheet;
		
	}


}
