package Test_Package;

import java.util.List;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Log_In_Page_In_Valid_Test_Data;
import Utility_Package.Listners;
import Utility_Package.Utility_Class;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;

public class LogIn_TestClass extends DesiredCap_Setting
{

	  public Log_In_Page_In_Valid_Test_Data log;
	 public Utility_Class UT;
	
	@BeforeClass
	public void Start_appium() throws Throwable
	{ 
		UT = new Utility_Class ();
		Device_setup();
		 log=new Log_In_Page_In_Valid_Test_Data((AndroidDriver) driver);	
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
