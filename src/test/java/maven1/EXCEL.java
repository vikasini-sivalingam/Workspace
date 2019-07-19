package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EXCEL {
  @Test
  public void f() throws IOException {
	  //define file location
	  File src=new File("C:\\vikasini\\EXCEL.xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		int lastrow=sheet1.getLastRowNum();
		System.out.println(lastrow);
		for(int i=1;i<=lastrow;i++){
		String un= sheet1.getRow(i).getCell(0).getStringCellValue();
		System.out.println(un);
		
		String psd= sheet1.getRow(i).getCell(1).getStringCellValue();
		System.out.println(psd);
		  System.setProperty("webdriver.chrome.driver", "C:\\\\vikasini\\\\chromedriver_win32\\\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("http://newtours.demoaut.com");
		  driver.findElement(By.name("userName")).sendKeys(un);
		  driver.findElement(By.name("password")).sendKeys(psd);
		  driver.findElement(By.name("login")).click();
		  driver.close();
		}
		wb.close();
  }
  
}
