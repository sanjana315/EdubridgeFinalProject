package amazonShoppingProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class URL_TitleValidation {
     WebDriver driver;
     
     @BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
     @Test(priority=1)
     public void VerifyTitle()
     {
    	 String ActualTitle=driver.getTitle();
    	 String ExpectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    	 
    	 Assert.assertEquals(ActualTitle, ExpectedTitle);
     }
     
     @Test(priority=2)
     public void URLValidation()
     {
    	 String ExpectedURL="https://www.amazon.in/";
    	 String ActualURL=driver.getCurrentUrl();
    	 
    	 if(ExpectedURL.equals(ActualURL))
    	 {
    		 System.out.println("URL Validation is Passed");
    	 }
    	 else 
    	 {
    		 System.out.println("URL Validation is Failed");
    	 }
     }
     
     @AfterClass
	public void close() {
		driver.close();
	}
}
