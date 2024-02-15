package Test_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Add_Product_To_Cart;
import Pom_package.Snap_Kitchen.Categories_Page;
import Pom_package.Snap_Kitchen.Product_listing_page;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class Demo_Testclass extends DesiredCap_Setting
{
	 public Categories_Page Opt;
	 public Utility_Class UT;
	 public Product_listing_page PLP;	 
	 public  Add_Product_To_Cart ADD;
	 
	 
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		UT = new Utility_Class ();
		Device_setup2();
		Opt =new Categories_Page((AndroidDriver)driver);
		ADD =new Add_Product_To_Cart((AndroidDriver)driver);
	}
	
	@BeforeMethod(firstTimeOnly = true)
	public void Passing_Zipcode_Register_Email() throws InterruptedException
	{
		Thread.sleep(5000);
		Opt.Enter_Zipcode();
		Opt.ZipcodeButton();
		Thread.sleep(4000);
		Opt.ZipcodeButton2();
		Opt.Eductional_screen_1();
		Opt.Eductional_screen_2();
		Opt.Enter_email();
		Opt.continue_button();
		
	}
	@BeforeMethod(dependsOnMethods = {"Passing_Zipcode_Register_Email"})
	public void verify_Catergory_list () throws Throwable
	{
		List<WebElement> Categories_Names = driver.findElements(By.xpath("//div[@class='-card']"));
		for(WebElement op:Categories_Names)
		{
			if(op.getText().contains("Lunch & Dinner"))
			{
				op.click();
			}
		}	
	}
	@Test
	public void scrlling_the_page() throws InterruptedException
	{
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(8000);
		// js.executeScript("window.scrollBy(0, 500)");
		
       WebElement element = driver.findElement(By.xpath("/html/body/app-root/ion-app/ion-router-outlet/flo-tabs/ion-tabs/div/ion-router-outlet/flo-menu-products/ion-content/div[10]/div[3]/div[5]/button"));
	        js.executeScript("arguments[0].scrollIntoView();", element);


		
		
		
	}
	
	
	@AfterMethod
	public void closeapp() throws InterruptedException
	{	
			Thread.sleep(4000);
		   driver.quit();
		   Server.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
