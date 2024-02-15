package Test_Package;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Snap_Pass_Registration;
import Pom_package.Snap_Kitchen.Snap_pass_onboarding;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class Snap_Resister_testclass extends DesiredCap_Setting
{
	 public Snap_Pass_Registration	Snap;
	 public Utility_Class UT;
	 String Popup_title = "Enter Email";	
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		UT = new Utility_Class ();
		Device_setup2();
		Snap =new Snap_Pass_Registration((AndroidDriver)driver);
	}
	
	@BeforeMethod
	public void Passing_the_Zipcode() throws InterruptedException
	{

		Thread.sleep(5000);
		Snap.Enter_Zipcode();
		Snap.ZipcodeButton();

		Thread.sleep(4000);
	    Snap.ZipcodeButton2();
	    Snap.Eductional_screen_1();
	    Snap.Eductional_screen_2();
		
	}
	@Test(priority = 1)
	public void Register_Email() throws Throwable
	{
		    UT.screenshot(driver);
		 String Resister_email_popup = driver.findElement(By.xpath("//h1[@class='-over-ride-title-h1']")).getText();  
		   assertEquals(Resister_email_popup, Popup_title,"Snap pass resister email popup title is not matching");
		   
		   Snap.Enter_email();
		   UT.screenshot(driver);
		  Snap.continue_button();
		
	}
	@Test (priority = 2)
	public void Home_Screen() throws Throwable
	{
		String Home_screen_Header = driver.findElement(By.xpath("//div[@class='subtext']")).getText();	
		assertEquals(Home_screen_Header,"Editing your Snap Pass","User is not able to join the snanp pass");
		
		Thread.sleep(3000);
		UT.screenshot(driver);	
	}
	

	@AfterMethod
	public void closeapp() throws InterruptedException
	{	
		Thread.sleep(4000);
		driver.quit();
		Server.close();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
