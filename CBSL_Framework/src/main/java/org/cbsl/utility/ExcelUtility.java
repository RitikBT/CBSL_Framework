package org.cbsl.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public Workbook getWorkBook(String fileName) throws IOException {
		File fis=new File(fileName);
		InputStream is=new FileInputStream(fis);
		Workbook wBook=new XSSFWorkbook(is);
		return wBook;
	}

	public int getColumnNumByColumnName(Sheet sheetObj,String uniqueColumnName) {
		int cellNum=0;
		Row rowObj=sheetObj.getRow(0);
		int lastCell=rowObj.getLastCellNum();
		for(int i=0;i<lastCell;i++) {
			Cell cellObj=rowObj.getCell(i);
			String getCellValue=cellObj.getStringCellValue();
			if(getCellValue.equalsIgnoreCase(uniqueColumnName)) {
				cellNum=i;
				break;
			}
		}
		return cellNum; 
	}

	public int getRowNumByRowName(Sheet sheetObj, String uniqueColumnName,String uniqueRowId) {
		int cellNum=getColumnNumByColumnName(sheetObj, uniqueColumnName) ;                                                                                                           
		int lastRow=sheetObj.getLastRowNum();
		int rowNum=0;
		for(int i=0;i<=lastRow;i++) {
			Row rowObj=sheetObj.getRow(i);
			Cell cellObj=rowObj.getCell(cellNum);
			String getCellValue=cellObj.getStringCellValue();
			if(getCellValue.equalsIgnoreCase(uniqueRowId)) {
				rowNum=i;	
				break;
			}
		}
		return rowNum;
	}

	public Map<String, String> getTestData(String testCaseName) {
		String fileName="TestCase.xlsx";
		Workbook wBook = null;;
		try {
			wBook=getWorkBook(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheetObj=wBook.getSheet("Data");
		int rowNum=getRowNumByRowName(sheetObj, "TestCaseName", testCaseName);
		int cellNum=getColumnNumByColumnName(sheetObj, "DataName1");
		Row rowObj=sheetObj.getRow(rowNum);
		int lastCellNum=rowObj.getLastCellNum();
		Map<String, String> mapObj=new HashMap<String, String>();

		for(int i=cellNum;i<lastCellNum;i=i+2) {
			String keyName=	getCellData(rowObj, i);
			String keyValue=getCellData(rowObj, i+1);
			mapObj.put(keyName, keyValue);
		}
		return mapObj;

	}

	public String getCellData(Row rowObj,int cellNumber) {
		return 	rowObj.getCell(cellNumber,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
	}


}
