package Test_Package;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Sign_Up_Page;
import Pom_package.Snap_Kitchen.Zipcode_Popup;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class Zipcode_Popup_TestClass extends DesiredCap_Setting
{
   
	public Utility_Class UT;
	public Zipcode_Popup Zip;
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		UT = new Utility_Class ();
		Device_setup2();
		Zip=new Zipcode_Popup((AndroidDriver)driver);
	}
	
	
	@BeforeMethod
	public void Passing_the_Zipcode() throws InterruptedException
	{

		Thread.sleep(5000);
		Zip.Enter_Zipcode();
		Zip.ZipcodeButton();
	}
	@Test
	public void select_fulfillment() throws Throwable
	{
		Thread.sleep(4000);
		Zip.ZipcodeButton2();
		
		Thread.sleep(4000);
		UT.screenshot(driver);
	}
//	
//	@Test(priority =2 )
//	public void Fulfillment_option()
//	{
//	   
//	   String Option = Zip.delivery_fullfilment();
//	   assertEquals(Option, "Delivery","Delivery Fulfillment is not displayed"); 
//	}
//	


	@AfterMethod
	public void closeapp() throws InterruptedException
	{
		
		System.out.print(234344);
		Thread.sleep(4000);
		driver.quit();
		Server.close();
		
		
	}
	
	
	
	
}
