package Pom_package.Snap_Kitchen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Log_In_Page_In_Valid_Test_Data 
{


	@FindBy(xpath="//input[@id='loginPhoneNumber-input']")private WebElement Email_ID;
	
	@FindBy(xpath="//input[@id='LoginPassword-button']")private WebElement Password;
	
	@FindBy(xpath="//button[@id='login-button']")private WebElement Login_Button;
	
	
	public Log_In_Page_In_Valid_Test_Data(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public void Enter_Enail()
	{
		Email_ID.sendKeys("stefan123@gmail.com");
	}
	
	public void Enter_password()
	{
		Password.sendKeys("Pslv@123");
	}
	
	public void login()
	{
		Login_Button.click();
	}
	
}
