package Pom_package.Snap_Kitchen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Snap_pass_onboarding
{

	  
			@FindBy(xpath="//input[@type='text']")private WebElement Zipcodefiled;
			
			@FindBy(xpath="//button[@type='button']")private WebElement Continue;
			
			@FindBy(xpath="//td[@id='selectDilivery-tab']")private WebElement Deliverytab;
			
			@FindBy(xpath="//button[@type='submit']")private WebElement Submit;
			
			@FindBy(xpath="//button[@type='button']")private WebElement Next_button;
			
			@FindBy(xpath="//button[@type='button']")private WebElement Next_button2;
			
			public Snap_pass_onboarding(AndroidDriver driver)
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
				if(Next_button.getText().equals("Next"))
				{
					Next_button.click();
				}
			}
			
			
			public  void Eductional_screen_2()
			{
				if(Next_button.getText().equals("Start Free Membership"))
				{
					Next_button2.click();
				}
			}
			
	
}
