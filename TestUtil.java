package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;
import com.excel.utility.XLSX_Reader;


public class TestUtil extends TestBase{
	 static String TestData_Sheet_Path="C:\\Users\\vimal786singhrana\\Desktop\\selenium project\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\CrmTESTData.xlsx";
	public static long Page_load_timeout= 20;
	public static long implicity_wait= 10;
	 static Workbook book;
	 static Sheet sheet;
	static FileInputStream file=null;
	static XLSX_Reader reader;
	
	
	
	public static ArrayList<Object[]> getdata(String sheetName){
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
	reader =new XLSX_Reader(TestData_Sheet_Path);
	for(int rowcunt=2;rowcunt<=reader.getRowCount(sheetName);rowcunt++) {
		String Fname=reader.getCellData(sheetName,"firstname",rowcunt);
		String Lname=reader.getCellData(sheetName,"lastname", rowcunt);
		Object obj[]= {Fname,Lname};
		
		myData.add(obj);
	}
	
	return myData;
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Object[][] getTestData(String sheetname)  {
		
		
			
				try {
					file=new FileInputStream(TestData_Sheet_Path);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		
		
	
		
				try {
					book=WorkbookFactory.create(file);
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			

		
		sheet=book.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum()+" "+sheet.getRow(0).getLastCellNum());
		for (int i=0;i<sheet.getLastRowNum();i++) {
			for (int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
			
		}
	return data;
	}

	


}