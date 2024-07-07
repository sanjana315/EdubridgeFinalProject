package amazonShoppingProject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchFunctionality extends LoginwithValidInvalidCredentials{
	
	 @Test(priority=6)
	 public void SelectShoesUsingFilter() throws Exception
	 {
		 Select s = new Select (driver.findElement(By.id("searchDropdownBox")));
		 s.selectByVisibleText("Shoes & Handbags");
		 Thread.sleep(2000);
		 System.out.println("Successfully Shoes & Handbags category selected");
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sports shoes for women");
		 Thread.sleep(2000);
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		 Thread.sleep(2000);
		 System.out.println("Product search successfully");
		 
		// Mouse hover
		Actions actions=new Actions(driver);
		WebElement BrandsNames=driver.findElement(By.xpath("(//input[@type='checkbox'])[4]"));
	    actions.moveToElement(BrandsNames).perform();
		Thread.sleep(3000);
		System.out.println("Completed Hover Action"); 
				 
				 
		 // Select "SPARX" BrandName
		 driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[4]")).click();
		 Thread.sleep(5000);
		 System.out.println("Brand name selected successfully");
		 
		 // Select "Shoe Size"
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,500)");
		 Thread.sleep(2000);
		  
		  driver.findElement(By.xpath("//button[@value='5']")).click();
		  Thread.sleep(5000);
		  System.out.println("Shoe Size selected successfully");
		  
		  // window handling
		  String parentWindowID=driver.getWindowHandle();
		  System.out.println("Parent Window ID:"+parentWindowID);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//img[@alt='SPARX Womens Sl-170Sneaker']")).click();
		  Thread.sleep(2000);
		  Set<String> childWindowID=driver.getWindowHandles();
		  
		  for(String i:childWindowID)
		  {
			  System.out.println("Child Window ID:"+childWindowID);
			  
			  // Apply condition  >> Check only child window
			  if(!i.equals(parentWindowID))
			  {
				  driver.switchTo().window(i); // switch it child window
				  Thread.sleep(3000);
				  JavascriptExecutor js2 = (JavascriptExecutor)driver;
				  js2.executeScript("window.scrollBy(0,300)");
				  Thread.sleep(2000);
				  
				  Select quantity = new Select (driver.findElement(By.xpath("//select[@id='quantity']")));
				  quantity.selectByValue("2");
				  Thread.sleep(2000);
				  System.out.println("Quantity selected Successfully");
				  driver.findElement(By.id("add-to-cart-button")).click();
				  System.out.println("Add to cart product successfully");
				  Thread.sleep(2000);
				  driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
				  Thread.sleep(2000);
				  
				  // Increase the quantity of product
				  Select quantity1 = new Select (driver.findElement(By.xpath("//select[@id='quantity']")));
				  quantity1.selectByValue("3");
				  System.out.println("Quantity added and also price increases");
				  Thread.sleep(2000);
				 
				  // Delete the product
				  driver.findElement(By.xpath("//input[@value='Delete']")).click();
				  Thread.sleep(2000);
				  System.out.println("Selected product was removed from shopping card");
				 
			  }
			  
		  }
		  
		  Thread.sleep(2000);
		  driver.switchTo().window(parentWindowID);
		  Thread.sleep(2000);
		 
	 }
	 
}
