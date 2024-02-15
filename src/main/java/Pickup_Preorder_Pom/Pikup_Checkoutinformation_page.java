package Pickup_Preorder_Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.utility.RandomString;

public class Pikup_Checkoutinformation_page 
{
	 @FindBy(xpath="//*[@class='-sticky-container']//button")private WebElement  CheckoutButton;
	  @FindBy(xpath = "//*[contains(text(),'Checkout Information')]")private WebElement CheckoutTitle;
	  
	  @FindBy(xpath="//div[@class='flex-grow']")private WebElement OrderSummary;
	  @FindBy(xpath="//button[@id='orderSummaryButton']")private WebElement OrderSummary_Dropdown;
	  
	
	  @FindBy(xpath="//*[contains(text(),'PICKUP LOCATION')]")private WebElement PickupLocationFrameName;
	  
	
	  @FindBy(xpath="//*[@class=\"-group-container\"][1]")private WebElement PickupAddress;
	  
	  @FindBy(xpath="//input[@placeholder=\"Select Pickup Time\"]")private WebElement PickupDropdown;
	  
	  @FindBy(xpath="//div[@class='-dropdown-item']")private WebElement PickupDropdownValue;
	  
	  @FindBy(xpath="//button[@class='button border-black-background-black-color-white-icon-white full-width']")private WebElement ApplyButton;
	  
	  @FindBy(xpath="//div[@class='-group-caption -checkout-group']")private WebElement DeliveryInformationLable;
	  @FindBy(xpath="//*[@class='-delivery-info-disclaimer']")private WebElement DeliveryTagInfo;
	  
	  @FindBy(xpath="//input[@id='undefined']")private WebElement DeliveryDate;
	  @FindBy(xpath="//*[@class=\"button border-gray-background-white-color-black-icon-black full-width\"]")private WebElement DiscardButton;
	  
	  @FindBy(xpath="//*[contains(text(),'Order Notes (optional)')]")private WebElement OrderNotesLabel; 
	  @FindBy(xpath="//textarea[@placeholder='Enter Order Notes']")private WebElement OrderNotesTextFiled;
	  
	
	  @FindBy(xpath="//*[contains(text(),'PickUp Frequency')]")private WebElement FrequencyLableName;
	  
	  @FindBy(xpath="//*[contains(text(),'Snap Pass Name (Optional)' )]")private WebElement SnapPassNamelablel;
	  @FindBy(xpath="//input[@id='planName-input']")private WebElement SnapPasstextfield;

	  @FindBy(xpath="//input[@placeholder=\"Redeem Loyalty Points\"]")private WebElement LoyaltyPointsUsecase;

	  public Pikup_Checkoutinformation_page(AndroidDriver driver)
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
	  public String GetPageTitle()
	  {
		  return CheckoutTitle.getText();
	  }
	  
	  public String GetorderSummary()
	  {
		 return  OrderSummary.getText();
	  }
	  public void  OpenOrdersummary()
	  {
		  OrderSummary_Dropdown.click();
	  }
	  public void CloseOrderSummary()
	  {
		  OrderSummary_Dropdown.click();
	  }
	  
	  public String GetPickupInfoFrame()
	  {
		  return PickupLocationFrameName.getText();
	  }
	  
	  public String GetPickupInfo()
	  {
		  return PickupAddress.getText();
	  }
	  
	  public void PickupDatePicker()
	  {
		  DeliveryDate.click();
	  }
	  public void closeDatePicker()
	  {
		  DiscardButton.click();
	  }
	  public void OpenPickupTime()
	  {
		  PickupDropdown.click();
	  }
	 
	  
	  public void ApplyDatepicker()
	  {
		  ApplyButton.click();
	  }
	  public String TextFieldName()
	  {
		  return OrderNotesLabel.getText();
	  }
	  
	  public void EnterInstuction()
	  {
		  OrderNotesTextFiled.sendKeys("Test Order for Pickup");
	  }
	  
	  public String GetFrequencyLabelName()
	  {
		  return FrequencyLableName.getText();
	  }
	  
	  public String GetSnapPassTextFieldLabelName()
	  {
		  return SnapPassNamelablel.getText();
	  }
	  
	  public void EnterSnapPassName()
	  {
		  String SnapID = RandomString.make();
		  SnapPasstextfield.sendKeys("Snap"+SnapID);
	  }
	  
	  public void OpenLoyaltyPointDropdown()
	  {
		  LoyaltyPointsUsecase.click();
	  }
}
