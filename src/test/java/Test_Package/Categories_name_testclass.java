package Test_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Categories_Page;
import Pom_package.Snap_Kitchen.Snap_Pass_Registration;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class Categories_name_testclass extends DesiredCap_Setting
{

	 public Categories_Page Opt;
	 public Utility_Class UT;
	 
	 
	
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		UT = new Utility_Class ();
		Device_setup2();
		Opt =new Categories_Page((AndroidDriver)driver);
	}
	
	@BeforeMethod()
	public void Passing_the_Zipcode() throws InterruptedException
	{
		Thread.sleep(5000);
		Opt.Enter_Zipcode();
		Opt.ZipcodeButton();

		Thread.sleep(4000);
		Opt.ZipcodeButton2();
		Opt.Eductional_screen_1();
		Opt.Eductional_screen_2();		
	}
	@BeforeMethod(dependsOnMethods = {"Passing_the_Zipcode"})
	public void  Register_Email() throws Throwable
	{
		Opt.Enter_email();
		Opt.continue_button();	
	}
	
	@Test
	public void verify_Catergory_list()
	{
		List<WebElement> Categories_Names = driver.findElements(By.xpath("//div[@class='-card']"));
		
		for(WebElement op:Categories_Names)
		{
			System.err.println(op.getText());
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
