package Pickup_Preorder_Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Enter_PickupZipcode 
{
@FindBy(xpath="//input[@id='loginPhoneNumber-input']")private WebElement Email_ID;
	
	@FindBy(xpath="//input[@id='LoginPassword-button']")private WebElement Password;
	
	@FindBy(xpath="//button[@id='login-button']")private WebElement Login_Button;
	
	@FindBy(xpath="//div[@class='-card']")private WebElement Categories;
	
	@FindBy(xpath="//input[@type='text']")private WebElement Zipcodefiled;
	
	
	
	@FindBy(xpath="//td[@id=\"selectPickup-tab\"]")private WebElement Pickupfulfillment;
	
	@FindBy(xpath="//input[@id=\"inStorePickup-radio\"][1]")private WebElement Pickupshop;
	@FindBy(xpath="//button[@type='button']")private WebElement Continue;
	
	@FindBy(xpath="//button[@type='submit']")private WebElement Submit;
	
	

	public Enter_PickupZipcode(AndroidDriver driver)
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
		Zipcodefiled.sendKeys("78652");
	}
	
	public void ZipcodeButton()
	{
		 Continue.click();
	}
	
	
	public void selectFulfillment()
	{
		Pickupfulfillment.click();	
	}
	
	
	public void selectingRetailLocation()
	{
		Pickupshop.click();
	}
	
	public void ZipcodeButton2()
	{
		Submit.click();
	}
}
