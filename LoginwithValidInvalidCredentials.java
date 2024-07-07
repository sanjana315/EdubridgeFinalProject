package amazonShoppingProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginwithValidInvalidCredentials extends LanguageSelection{
    
    @Test(priority=4)
    public void LoginInvalidCredential() throws Exception
    {
    	driver.findElement(By.id("nav-link-accountList")).click();
    	System.out.println("Click successfully");
    	
    	 WebElement Email=driver.findElement(By.xpath("//input[@id='ap_email_login']"));
    	 Email.sendKeys("sanjanagaikwad31052002");
    	 Thread.sleep(3000);
    	   	 
    	 // Click on confirm button
    	 driver.findElement(By.xpath("//input[@type='submit']")).click();
    	   	
    	 // Error message
    	   	
    	 String ActualError=driver.findElement(By.xpath("//*[@id=\"invalid-email-alert\"]/div/div")).getText();
    	 Thread.sleep(2000);
    	 String ExpectedError="Invalid email address.";
    	 Assert.assertEquals(ActualError, ExpectedError,"Error message matched");
    	 System.out.println("Error message matched");
    	 driver.navigate().back();
    	
    }
    
    @Test(priority=5)
    public void LoginValidCredentials() throws Exception
    {
   	     driver.findElement(By.id("nav-link-accountList")).click();
   	     System.out.println("Click successfully");
   	 
   	     WebElement Email=driver.findElement(By.xpath("//input[@id='ap_email_login']"));
   	     Email.sendKeys("sanjanagaikwad31052002@gmail.com");
   	     Thread.sleep(3000);
   	 
   	     // Click on confirm button
   	     driver.findElement(By.xpath("//input[@type='submit']")).click();
   	     System.out.println("Continue click successfully");
   	 
   	     WebElement Password=driver.findElement(By.id("ap_password"));
   	     Password.sendKeys("Sanjana@2002");
   	     Thread.sleep(3000);
   	 
   	     // Click on sign in button
   	     driver.findElement(By.id("signInSubmit")).click();
   	     driver.navigate().to("https://www.amazon.in/");
   	     System.out.println("Login Successfully");
   	 
    }
    
}
