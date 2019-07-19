package maven1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testcase {
  @Test
  public void f() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\vikasini\\chromedriver_win32\\chromedriver.exe");
	  WebDriver ff = new ChromeDriver();
	  String loginpagetitle = ff.getTitle();
	  System.out.println(loginpagetitle);
	  ff.get("http://www.newtours.demoaut.com/");
	  //ff.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  ff.findElement(By.name("userName")).sendKeys("mercury");
	  ff.findElement(By.name("password")).sendKeys("mercury");
	  ff.findElement(By.name("login")).click();
	  String bookpagetitle = ff.getTitle();
	  System.out.println(bookpagetitle);
	  ff.findElement(By.xpath("\\input[@value='oneway']")).click();
	  Select passenger = new Select(ff.findElement(By.name("passCount")));
	  passenger.selectByIndex(1);
	  ff.findElement(By.linkText("SIGN-OFF")).click();
	  Assert.assertEquals(ff.getTitle(),"Sign-on : Mercury Tour");
	  ff.close();
  }


}
