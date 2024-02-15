package Pom_package.Snap_Kitchen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Reopen_Zipcode_Popup
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
	
	
	
	public Reopen_Zipcode_Popup(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
