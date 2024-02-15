package Test_Package;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Sign_Up_Page;
import Utility_Package.Utility_Class;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Sign_Up_Form_With_Valid_TestData extends DesiredCap_Setting
{
	public Utility_Class UT;
	public Sign_Up_Page SG;

	
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		UT = new Utility_Class ();
		Device_setup();
		 SG=new Sign_Up_Page ((AndroidDriver) driver);
	}
	@BeforeMethod
	public void Hyperlinkredirection()
	{
		SG.Sign_up();
	}
	@Test
	public void Passing_credential_sign_up()
	{
		SG.Enter_Firstname();
		SG.Enterlastname();
		SG.Enter_email();
		SG.Enter_Phonenumber();
	}
	@AfterTest
	public void Verification_button()
	{
		SG.Enter_Password();
		SG.Enter_Confirm_Password();
//		SG.Update_Checkbox();
	}
	@AfterMethod
	public void screenshot() throws Throwable
	{
		SG.Phone_Verify();
		UT.screenshot(driver);
	}
	@AfterClass
	public void closeapp() throws InterruptedException
	{
		
		Thread.sleep(4000);
		driver.quit();
		Server.close();
	}
	
	
	
}
