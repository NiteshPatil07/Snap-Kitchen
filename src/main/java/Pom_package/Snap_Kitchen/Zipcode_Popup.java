package Pom_package.Snap_Kitchen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Zipcode_Popup 
{
	   @FindBy(xpath="//h2['How would you like to receive your food?']")private WebElement Popuptitle;
	   
		@FindBy(xpath="//input[@type='text']")private WebElement Zipcodefiled;
		
		@FindBy(xpath="//button[@type='button']")private WebElement Continue;
		
		@FindBy(xpath="//td[@id='selectDilivery-tab']")private WebElement Deliverytab;
		
		@FindBy(xpath="//button[@type='submit']")private WebElement Submit;
		
		
		public Zipcode_Popup(AndroidDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public String Popup_Verification()
		{
			return Popuptitle.getText();
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
		
		
}
