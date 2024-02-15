package Test_Package;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pom_package.Snap_Kitchen.Snap_pass_onboarding;
import Pom_package.Snap_Kitchen.Zipcode_Popup;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class Test_snap_pass_Eductionalscreen  extends Browser_Package.DesiredCap_Setting
{

	   
	public Utility_Class UT;
	public Snap_pass_onboarding snap;
	 String Popup_title = "Enter Email";
	
	
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		UT = new Utility_Class ();
		Device_setup2();
		snap =new Snap_pass_onboarding ((AndroidDriver)driver);
	}
	
	
	@BeforeMethod
	public void Passing_the_Zipcode() throws InterruptedException
	{
		Thread.sleep(5000);
		snap.Enter_Zipcode();
		snap.ZipcodeButton();

		Thread.sleep(4000);
	    snap.ZipcodeButton2();	
	}
	@Test
	public void Snap_pass_onbordingscreen() throws Throwable
	{	
	     snap.Eductional_screen_1();
	     Thread.sleep(3000);
		  UT.screenshot(driver);

		  Thread.sleep(2000);
		 UT.screenshot(driver);
	    snap.Eductional_screen_2();
	}
	@AfterMethod
	public void closeapp() throws InterruptedException
	{		
		Thread.sleep(4000);
		driver.quit();
		Server.close();
	}
	
	
}
