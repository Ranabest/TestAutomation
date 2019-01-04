package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20; 
	public static long IMPLICIT_WAIT = 15;
	
	public static String TESTDATA_SHEET_PATH= "C:\\Users\\mkari\\Desktop\\All in One\\FreeCRM\\src"
			+ "\\main\\java\\com\\crm\\qa\\testdata\\TESTDATA.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	public static Object[][] getTestData (String sheetName) {
		
		FileInputStream file = null;
		
	try {
		file= new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
try {
	book=WorkbookFactory.create(file);
} catch (EncryptedDocumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	sheet = book.getSheet(sheetName);
	// Row row=sheet.getRow(rowNum);
	   // Cell cell=row.getCell(cellNum);
	Object [][]data= new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	//
for(int i = 0;i<sheet.getLastRowNum();i++)
{
for(int k= 0;k<sheet.getRow(0).getLastCellNum();k++) {
	data [i][k] = sheet.getRow(i+1).getCell(k).toString();
}	 
/*
  @SuppressWarnings("deprecation")
 
CellType type = cell.getCellTypeEnum();
if (type == CellType.STRING) {
            //cell.getRichStringCellValue().toString();
            cell.getStringCellValue();
} else if (type == CellType.NUMERIC) {
             cell.getNumericCellValue();
*/
}
return data;
	}

    /*public static String getCellValueAsString(Cell cell) {
        String strCellValue = null;
        if (cell != null) {
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                strCellValue = cell.toString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "dd/MM/yyyy");
                    strCellValue = dateFormat.format(cell.getDateCellValue());
                } else {
                    Double value = cell.getNumericCellValue();
                    Long longValue = value.longValue();
                    strCellValue = new String(longValue.toString());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                strCellValue = new String(new Boolean(
                        cell.getBooleanCellValue()).toString());
                break;
            case Cell.CELL_TYPE_BLANK:
                strCellValue = "";
                break;
            }
        }
        return strCellValue;
    }

*/
	public void popUp() {
	WebElement framehandle=driver.findElement(By.name("intercom-borderless-frame"));
	driver.switchTo().frame(framehandle);
	Actions a = new Actions (driver);
	a.moveToElement(driver.findElement(By.cssSelector(".intercom-borderless-dismiss-button"))).click().build().perform();
	driver.switchTo().defaultContent();

}
public void switchToFrame() {
	driver.switchTo().frame("mainpanel");
}

public static void getScreenShot(String result) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File ("./ScreenShots/"+result+"FreeCRM.png"));
	
}
}
