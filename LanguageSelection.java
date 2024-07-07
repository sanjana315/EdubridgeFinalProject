package amazonShoppingProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LanguageSelection extends URL_TitleValidation {
	 
	 @Test(priority=3)
	 public void LanguageSelect() throws Exception 
	 {
		 driver.findElement(By.id("icp-nav-flyout")).click();
		 Thread.sleep(2000);
		 WebElement radioButton=driver.findElement(By.xpath("//*[@id=\"icp-language-settings\"]/div[2]/div/label/i"));
		 
		 // Check radio button is selected
		 radioButton.isSelected();
		 System.out.println("Button is selected");
		 
		 //Select language
		 WebElement radiobuttonHindi=driver.findElement(By.xpath("//*[@id=\"icp-language-settings\"]/div[3]/div/label/i"));
		 radiobuttonHindi.click();
		 Thread.sleep(2000);
		 WebElement radioButtonEnglish=driver.findElement(By.xpath("//*[@id=\"icp-language-settings\"]/div[2]/div/label/i"));
		 radioButtonEnglish.click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id=\"icp-save-button\"]/span/input")).click();
		 System.out.println("English Language Selected Successfully");
		 driver.navigate().back();
	 }
	 
}
