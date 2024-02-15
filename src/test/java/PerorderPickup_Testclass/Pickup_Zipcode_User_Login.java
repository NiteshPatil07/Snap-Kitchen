package PerorderPickup_Testclass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pickup_Preorder_Pom.Enter_PickupZipcode;
import Snappass_User_Pom.LoginUserEnter_Zipcode;
import io.appium.java_client.android.AndroidDriver;

public class Pickup_Zipcode_User_Login extends DesiredCap_Setting
{

	public Enter_PickupZipcode ZIP;
	@BeforeClass
	public void Start_appium() throws Throwable
	{ 
		Device_setup();
		ZIP = new Enter_PickupZipcode ((AndroidDriver) driver);
		
	}
	@BeforeMethod
	public void UserLoginSnapKitchen() throws InterruptedException
	{

		Thread.sleep(1500);
		ZIP.Enter_Email();
		ZIP.Enter_password();
		ZIP.login();
		Thread.sleep(4000);
	}
	@Test
	public void EnterZipcode() throws Throwable
	{
		ZIP.clickOnCategories();

		Thread.sleep(2000);
		ZIP.Enter_Zipcode();
		ZIP.ZipcodeButton();
		Thread.sleep(5000);
		ZIP.selectFulfillment();
		Thread.sleep(500);
		ZIP.selectingRetailLocation();
		ZIP.ZipcodeButton2();	
	}
	
	@AfterMethod
	public void closeapp() throws InterruptedException
	{
		
		Thread.sleep(4000);
		driver.quit();
		Server.close();
	}
}
