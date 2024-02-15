package Pom_package.Snap_Kitchen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginUser_Enter_Zipcode 
{
  

	@FindBy(xpath="//input[@id='loginPhoneNumber-input']")private WebElement Email_ID;
	
	@FindBy(xpath="//input[@id='LoginPassword-button']")private WebElement Password;
	
	@FindBy(xpath="//button[@id='login-button']")private WebElement Login_Button;
	
	@FindBy(xpath="//div[@class='-card']")private WebElement Categories;
	
	@FindBy(xpath="//input[@type='text']")private WebElement Zipcodefiled;
	
	@FindBy(xpath="//button[@type='button']")private WebElement Continue;
	
	@FindBy(xpath="//button[@type='submit']")private WebElement Submit;
	
	

	public LoginUser_Enter_Zipcode(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void Enter_Email()
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
	
	public void clickOnCategories()
	{
		Categories.click();
	}
	
	
	public void Enter_Zipcode()
	{
		Zipcodefiled.sendKeys("67037");
	}
	
	public void ZipcodeButton()
	{
		 Continue.click();
	}
	
	public void ZipcodeButton2()
	{
		Submit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
