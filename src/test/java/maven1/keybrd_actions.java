package maven1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class keybrd_actions {
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\vikasini\\chromedriver_win32\\chromedriver.exe");
	  WebDriver ff = new ChromeDriver();
	  ff.get("http://demowebshop.tricentis.com/");
	  Assert.assertTrue(ff.getTitle().contains("demowebshop"));
	  WebElement search = ff.findElement(By.name("q"));
	  //Actions
	  search.sendKeys("computer");
	  Actions act = new Actions(ff);
	 // act.moveToElement(search).sendKeys("computer").build().perform();
	  act.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().build().perform();
	  Thread.sleep(1000);
	  //act.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().build().perform();
	  ff.findElement(By.xpath("//input[@value='Search']")).click();
	  ff.close();
  }
}
