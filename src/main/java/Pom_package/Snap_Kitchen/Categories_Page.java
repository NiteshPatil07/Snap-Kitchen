package Pom_package.Snap_Kitchen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Categories_Page
{

	@FindBy(xpath="//input[@type='text']")private WebElement Zipcodefiled;
	@FindBy(xpath="//button[@type='button']")private WebElement Continue;
	@FindBy(xpath="//td[@id='selectDilivery-tab']")private WebElement Deliverytab;	
	@FindBy(xpath="//button[@type='submit']")private WebElement Submit;	
	@FindBy(xpath="//button[@type='button']")private WebElement Next_button;
	@FindBy(xpath="//button[@type='button']")private WebElement Next_button2;
	@FindBy(xpath="//h1[@class='-over-ride-title-h1']")private WebElement Emailpopup;
	@FindBy(xpath="//input[@type='email']")private WebElement Email_textbox;
	@FindBy(xpath="//button[@class='button border-black-background-black-color-white-icon-white full-width']")private WebElement Emailcontinue;
	
	
	public Categories_Page(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void Enter_Zipcode()
	{
		Zipcodefiled.sendKeys("67037");
	}
	
	public void ZipcodeButton()
	{
		 Continue.click();
	}
	
	public String  delivery_fullfilment()
	{
		return Deliverytab.getText();
	}
	
	public void ZipcodeButton2()
	{
		Submit.click();
	}
	
	public  void Eductional_screen_1()
	{
			Next_button.click();
	}
	
	
	public  void Eductional_screen_2()
	{
		Next_button2.click();
	}
	
	public String verification_email_popup()
	{
		  
		return Emailpopup.getText();
	}
	public void  Enter_email()
	{
		Email_textbox.sendKeys("test123@yopmail.com");
	}

	
	public void  continue_button()
	{
		 boolean Button_value = Emailcontinue.isEnabled();
		 
		 if(Button_value==true)
		 {
			 Emailcontinue.click();
		 }
	}
	
	
	
	
	
	
	
	
}
