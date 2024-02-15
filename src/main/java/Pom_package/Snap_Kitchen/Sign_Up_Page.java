package Pom_package.Snap_Kitchen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Sign_Up_Page 
{
	
	@FindBy(xpath="//a[@id='signUp-link']")private WebElement Sign_uplink;
	
	@FindBy(xpath="//input[@id='firstName-input']")private WebElement FirstName;
	
	@FindBy(xpath="//input[@id='lastName-input']")private WebElement LastName;
	
	@FindBy(xpath="//input[@id='emailAddress-input']")private WebElement Email;
	
	@FindBy(xpath="//input[@id='phoneNumber-input']")private WebElement PhoneNumber;
	
	@FindBy(xpath="//button[@id='sendVerificationCode-button']")private WebElement Verify_Button;
	
	@FindBy(xpath="//input[@id='password-input']")private WebElement Password;
	
	@FindBy(xpath="//input[@id='confirmPassword-input']")private WebElement Confirm_Password;
	
	@FindBy(xpath="//div//flo-checkbox[@name='sendSmsMarketingUpdates']")private WebElement SMS_Update;
	
	@FindBy(xpath="//div//flo-checkbox[@name='sendEmailMarketingUpdates']")private WebElement Email_Update;
	
	@FindBy(xpath="//button[@id='cancelSignUp-button']")private WebElement Cancel_Button;
	
	@FindBy(xpath="//button[@id='submitSignup-button']")private WebElement Sign_up_Button;
	
	public Sign_Up_Page(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void Sign_up()
	{
		Sign_uplink.click();
	}
	
	public void Enter_Firstname()
	{
		FirstName.sendKeys("Jason Mark");
	}
	
	public void  Enterlastname()
	{
		LastName.sendKeys("Smith");
	}
	
	public void Enter_email()
	{
		Email.sendKeys("Mark04@yopmail.com");
	}
	
	public void Enter_Phonenumber()
	{
		PhoneNumber.sendKeys("2048003600");
	}
	
	public void Phone_Verify()
	{
		Verify_Button.click();
	}
	
	public void Enter_Password()
	{
		Password.sendKeys("P@ssw0rd");
	}
	
	public void Enter_Confirm_Password()
	{
		Confirm_Password.sendKeys("P@ssw0rd");
	}
	
	public void Update_Checkbox()
	{
		SMS_Update.click();
		Email_Update.click();
	}
	
	public void Cancel_Button()
	{
		Cancel_Button.click();
	}
	
	public void Sign_up_button()
	{
		Sign_up_Button.click();
	}
	

	
	
}
