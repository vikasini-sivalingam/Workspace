package casestudy;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class onlineShoppingTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
  @BeforeTest
  public void f()
  {
	  System.setProperty("webdriver.chrome.driver","C:\\vikasini\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  report = new ExtentReports("C:\\vikasini\\report.html",false);
	  test=report.startTest("onlineShoppingTest");
  }
  
  @AfterTest
  public void afterTest()
  {
	  driver.close();
	  report.flush();
	  report.endTest(test);
  }
  @Test (priority=1)
  public void testRegistration() throws InterruptedException
  {
	  driver.findElement(By.linkText("SignUp")).click();
	  driver.findElement(By.name("userName")).sendKeys("Johann27");
	  driver.findElement(By.name("firstName")).sendKeys("Johann");
	 
	  driver.findElement(By.name("lastName")).sendKeys("Mathew");
	  driver.findElement(By.id("password")).sendKeys("john123");
	  driver.findElement(By.name("confirmPassword")).sendKeys("john123");
	  driver.findElement(By.xpath("//input[@value='Male']")).click();
	  driver.findElement(By.id("emailAddress")).sendKeys("johnmathew@gmail.com");
	  driver.findElement(By.id("mobileNumber")).sendKeys("9876543216");
	  driver.findElement(By.id("dob")).sendKeys("25/05/1990");
	  driver.findElement(By.id("address")).sendKeys("Perungalathur");
	  Select ques = new Select(driver.findElement(By.name("securityQuestion")));
	  ques.selectByIndex(1);
	  Thread.sleep(7000);
	  String avail= driver.findElement(By.id("err")).getText();
	  Assert.assertEquals(avail,"Available");
	  driver.findElement(By.name("answer")).sendKeys("Pink"); 
	  driver.findElement(By.name("Submit")).click();
  }
  
  @Test (priority=2)
  public void testLogin()
  {
	  driver.findElement(By.name("userName")).sendKeys("Johann");
	  driver.findElement(By.id("password")).sendKeys("john123");
	  driver.findElement(By.name("Login")).click();
  }
  
  @Test (priority=3)
  public void testCart() throws InterruptedException {
	  driver.findElement(By.name("products")).sendKeys("Headphone");
	  driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
	  Thread.sleep(7000);
	  driver.findElement(By.partialLinkText( "Add to cart")).click();
	  driver.findElement(By.partialLinkText( "Cart")).click();
	  driver.findElement(By.partialLinkText( "Checkout")).click();
  }
  @Test (priority=4)
  public void testPayment() throws InterruptedException{
	  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	  Thread.sleep(7000);
	  driver.findElement(By.cssSelector("#swit > div:nth-child(1) > div > label > i")).click();
	  driver.findElement(By.id("btn")).click();
	  driver.findElement(By.name("username")).sendKeys("123456");
	  driver.findElement(By.name("password")).sendKeys("Pass@456");
	  driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	  driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
	  driver.findElement(By.xpath("//input[@value='PayNow']")).click();
  }
  
 // @AfterMethod
 /* public void getResultAfterMethod()
  {
	if(result.getStatus==.SUCCESS)
	{
		test.log(LogStatus.PASS, "Login Passed", "Login is successful");
	}
	else
	{
		test.log(LogStatus.PASS, "Login Failed", "Login is not successful");
	}
  }*/
}
