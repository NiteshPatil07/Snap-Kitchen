package Snappass_User_Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SnapPassUserCheckountInformationPage2 
{

	  @FindBy(xpath="//*[@class='-sticky-container']//button")private WebElement  CheckoutButton;
	
	  @FindBy(xpath="//*[contains(text(),'DISCOUNTS')]")private WebElement Discountframe;
	  @FindBy(xpath="//input[@id='promocode-input']")private WebElement Promocode;
	  @FindBy(xpath="//button[@id='applyPromo-button']")private WebElement PromoApply;	
	  @FindBy(xpath="//*[contains(text(),'You have ')]")private WebElement LoyaltyPointsBalance;
	  @FindBy(xpath="//div[@class='-discount-text']")private WebElement PointsDisscountText;	
	  @FindBy(xpath="//input[@placeholder='Redeem Loyalty Points']")private WebElement LoyaltyDropDownText;	  
	  @FindBy(xpath="//input[@placeholder='Redeem Loyalty Points']|//div[@class='-icon'][3]")private WebElement LoyaltyDropDown;
	  @FindBy(xpath="//*[contains(text(),'PAYMENT METHOD')]")private WebElement PaymentFrameName;
	  @FindBy(xpath="//div[@class='-group-container'][4]")private WebElement Paymentmethods;
	  @FindBy(xpath="//label[@id='addcard=link']")private WebElement NewMethodTab;
	
	  @FindBy(xpath="//button[@id=\"cancel-button\"]")private WebElement CloseNewPopupButton;
	  @FindBy(xpath="//*[contains(text(),' *With your Snap Pass membership,')]")private WebElement CheckoutText;
	  @FindBy(xpath="//*[contains(text(),'I Accept the Terms & Conditions')]")private WebElement Termsconditonslable;
	  @FindBy(xpath="//input[@id='termNcon-checkbox']")private WebElement TermsconditonsCheckbox;
	  @FindBy(xpath="//button[@id=\"placeOrder-button\"]")private WebElement Placeorderbutton;
	  @FindBy(xpath="//h2[contains(text(),'Confirm Order')]")private WebElement ConfrimOrderpage ;
	
	  
	  public SnapPassUserCheckountInformationPage2(AndroidDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
	

	  public void Checkoutbutton()
		{
			if(CheckoutButton.isEnabled()==true)
			{
				CheckoutButton.click();
			}
		}  
	 public String DiscountFramelabel()
	 {
		 return Discountframe.getText();
	 }
	 
	 public String PromoCodeTextFiled()
	 {
		 return Promocode.getText();
	 }
	 
	public boolean Promocodebutton()
	{
		return PromoApply.isEnabled();
	}
	
	public String GetLoyaltyPointbalance()
	{
		return LoyaltyPointsBalance.getText();
	}
	
	public String GetDisscountText()
	{
		return PointsDisscountText.getText();
	}
	
	public String GetDropdownText()
	{
		return LoyaltyDropDownText.getText();
	}
	
	
	public void OpenDropdown()
	{
		LoyaltyDropDown.click();
	}
	
	public String PaymentFrameLable()
	{
		return PaymentFrameName.getText();
		
	}
	public String GetPaymetData()
	{
		return Paymentmethods.getText();
	}
	public void OpenNewMethod()
	{
		NewMethodTab.click();
	}
	public void closepayemntMethod()
	{
		CloseNewPopupButton.click();
	}
	public String GetCheckoutText()
	{
		return CheckoutText.getText();
		
	}
	public String TermsAndconditionLable()
	{
		return Termsconditonslable.getText();
		
	}
	
	public void CheckTermsAndConditions()
	{
		TermsconditonsCheckbox.click();
	}
	
	public void PlaceOrder()
	{
		if("Confirm Order"==ConfrimOrderpage.getText())
		{
			Placeorderbutton.click();
		}
	}
}
