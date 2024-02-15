package SnapPass_UserTestPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.LoginUser_Enter_Zipcode;
import Snappass_User_Pom.LoginUserEnter_Zipcode;
import io.appium.java_client.android.AndroidDriver;

public class SnapUser_EnterZipcode_TestClasss extends DesiredCap_Setting
{
	public LoginUserEnter_Zipcode ZIP;
	@BeforeClass
	public void Start_appium() throws Throwable
	{ 
		Device_setup();
		ZIP = new LoginUserEnter_Zipcode ((AndroidDriver) driver);
		
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
