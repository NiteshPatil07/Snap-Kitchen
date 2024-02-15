package Test_Package;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Log_In_Page_In_Valid_Test_Data;
import Pom_package.Snap_Kitchen.LoginUser_Enter_Zipcode;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class ResisterUser_EnterZipcode_TestClass extends DesiredCap_Setting
{

	public LoginUser_Enter_Zipcode ZIP;
	@BeforeClass
	public void Start_appium() throws Throwable
	{ 
		Device_setup();
		ZIP = new LoginUser_Enter_Zipcode ((AndroidDriver) driver);
		
	}
	@BeforeMethod
	public void UserLoginSnapKitchen() throws InterruptedException
	{
		Thread.sleep(3000);
		ZIP.Enter_Email();
		ZIP.Enter_password();
		ZIP.login();
		Thread.sleep(6000);
	}
	@Test
	public void EnterZipcode() throws Throwable
	{
		ZIP.clickOnCategories();

		Thread.sleep(5000);
		ZIP.Enter_Zipcode();
		ZIP.ZipcodeButton();
		Thread.sleep(5000);
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
