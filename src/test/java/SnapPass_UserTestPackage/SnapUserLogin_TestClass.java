package SnapPass_UserTestPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Log_In_Page_In_Valid_Test_Data;
import Snappass_User_Pom.SnapPassUserLogin;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class SnapUserLogin_TestClass extends DesiredCap_Setting
{

	  public SnapPassUserLogin log;
	 public Utility_Class UT;
	
	@BeforeClass
	public void Start_appium() throws Throwable
	{ 
		UT = new Utility_Class ();
		Device_setup();
		 log=new SnapPassUserLogin((AndroidDriver) driver);	
	}	
		

	
	@Test
	public void login_snap_ktichen() throws Throwable
	{
		
		Thread.sleep(3000);
		log.Enter_Enail();
		log.Enter_password();
		log.login();
		Thread.sleep(6000);
		
	}
	
	@AfterMethod
	public void closeapp() throws InterruptedException 
	{
		
		Thread.sleep(4000);
		driver.quit();
		Server.close();
		
		
	}

}
