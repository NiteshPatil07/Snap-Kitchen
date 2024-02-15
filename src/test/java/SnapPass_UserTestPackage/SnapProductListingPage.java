package SnapPass_UserTestPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Snappass_User_Pom.LoginUserEnter_Zipcode;
import Snappass_User_Pom.SnapPassUserLogin;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class SnapProductListingPage extends DesiredCap_Setting
{


    
	 public Utility_Class UT;	 
	 public LoginUserEnter_Zipcode ZIP;
	 public SnapPassUserLogin log;
	 
	 
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		UT = new Utility_Class ();
		Device_setup();
		ZIP =new LoginUserEnter_Zipcode((AndroidDriver)driver);
		log=new  SnapPassUserLogin ((AndroidDriver)driver);
	}
	
	@BeforeMethod(firstTimeOnly = true)
	public void Passing_Zipcode_Register_Email() throws InterruptedException
	{
		Thread.sleep(3000);
		log.Enter_Enail();
		log.Enter_password();
		log.login();
		Thread.sleep(6000);

		ZIP.clickOnCategories();

		Thread.sleep(3000);
		ZIP.Enter_Zipcode();
		ZIP.ZipcodeButton();
		Thread.sleep(5000);
		ZIP.ZipcodeButton2();
	
	
	}
	@Test()
	public void verify_Catergory_list () throws Throwable
	{
		List<WebElement> Categories_Names = driver.findElements(By.xpath("//div[@class='-card']"));
		for(WebElement op:Categories_Names)
		{
			System.err.println(op.getText());
			if(op.getText().contains("Lunch & Dinner"))
			{
				
				op.click();
			}
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
