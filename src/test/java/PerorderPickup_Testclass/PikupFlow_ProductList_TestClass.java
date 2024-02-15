package PerorderPickup_Testclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pickup_Preorder_Pom.Enter_PickupZipcode;
import Snappass_User_Pom.LoginUserEnter_Zipcode;
import Snappass_User_Pom.SnapPassUserLogin;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class PikupFlow_ProductList_TestClass extends DesiredCap_Setting
{

    String ProductCategory="Lunch & Dinner";
	
	 public Utility_Class UT;	 
	 public Enter_PickupZipcode ZIP;
	 
	 
	 
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		UT = new Utility_Class ();
		Device_setup();
		ZIP =new Enter_PickupZipcode((AndroidDriver)driver);
	}
	
	@BeforeMethod(firstTimeOnly = true)
	public void Passing_Zipcode_Register_Email() throws InterruptedException
	{
		Thread.sleep(1500);
		ZIP.Enter_Email();
		ZIP.Enter_password();
		ZIP.login();
		Thread.sleep(4000);
		ZIP.clickOnCategories();

		Thread.sleep(1500);
		ZIP.Enter_Zipcode();
		ZIP.ZipcodeButton();
		Thread.sleep(5000);
		ZIP.selectFulfillment();
		Thread.sleep(500);
		ZIP.selectingRetailLocation();
		ZIP.ZipcodeButton2();
	}
	@Test()
	public void verify_Catergory_list () throws Throwable
	{
		List<WebElement> Categories_Names = driver.findElements(By.xpath("//div[@class='-card']"));
		for(WebElement op:Categories_Names)
		{
			System.err.println(op.getText());
			if(op.getText().contains(ProductCategory))
			{			
				op.click();
			}
		}	
	}
	
	@AfterMethod
	public void closeapp() throws InterruptedException
	{
		
		Thread.sleep(4000);
		driver.quit();
		Server.close();
	}
	
	
	
}
