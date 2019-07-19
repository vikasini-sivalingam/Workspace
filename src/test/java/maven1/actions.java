package maven1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class actions {
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\vikasini\\chromedriver_win32\\chromedriver.exe");
	  WebDriver ff = new ChromeDriver();
	  ff.get("https://jqueryui.com/droppable/");
	  // Switching frame
	  ff.switchTo().frame(ff.findElement(By.className("demo-frame")));
	  WebElement src = ff.findElement(By.id("draggable"));
	  WebElement target = ff.findElement(By.id("droppable"));
	  // Drag and drop
	  Actions act = new Actions(ff);
	  act.dragAndDrop(src, target).build().perform();
	  Thread.sleep(2000);
	  // To default action
	  ff.switchTo().defaultContent();
	  ff.findElement(By.linkText("Demos")).click();
	  Assert.assertTrue(ff.getTitle().contains("Demos"));
	  ff.close();
  }
}
