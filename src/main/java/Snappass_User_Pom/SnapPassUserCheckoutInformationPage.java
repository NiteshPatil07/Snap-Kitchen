package Snappass_User_Pom;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.utility.RandomString;

public class SnapPassUserCheckoutInformationPage 
{
	  @FindBy(xpath="//*[@class='-sticky-container']//button")private WebElement  CheckoutButton;
	  @FindBy(xpath = "//h2[@class='-dialog-title']")private WebElement CheckoutTitle;
	  
	  @FindBy(xpath="//div[@class='flex-grow']")private WebElement OrderSummary;
	  @FindBy(xpath="//button[@id='orderSummaryButton']")private WebElement OrderSummary_Dropdown;
	  
	  @FindBy(xpath="//div[@class='-group-caption']")private WebElement  AddressLable;
	  @FindBy(xpath="//div[@class='-group-container']")private WebElement AddressList;
	  
	  @FindBy(xpath="//input[@id='address-0-redio']")private WebElement  AddressRadiobutton1;
	  @FindBy(xpath="//input[@id='address-1-redio']")private WebElement  AddressRadiobutton2;
	  @FindBy(xpath="//label[@id='newAddress-link']")private WebElement NewAddressTab;
	  
	
	  @FindBy(xpath="//*[@class='button border-gray-background-white-color-black-icon-black full-width']")private WebElement CancelButton;
	  @FindBy(xpath="//input[@placeholder='Select Delivery Window']")private WebElement DeliveryWindow;
	  
	  @FindBy(xpath="//div[@class='-dropdown-item']")private WebElement DeliveryWindowselect;
	  @FindBy(xpath="//button[@class='button border-black-background-black-color-white-icon-white full-width']")private WebElement ApplyButton;
	  
	  @FindBy(xpath="//div[@class='-group-caption -checkout-group']")private WebElement DeliveryInformationLable;
	  @FindBy(xpath="//*[@class='-delivery-info-disclaimer']")private WebElement DeliveryTagInfo;
	  
	  @FindBy(xpath="//input[@id='undefined']")private WebElement DeliveryDate;
	  @FindBy(xpath="//*[@class=\"button border-gray-background-white-color-black-icon-black full-width\"]")private WebElement DiscardButton;
	  
	  @FindBy(xpath="//*[contains(text(),'Instructions to Delivery Driver (Optional)')]")private WebElement InstructionText; 
	  @FindBy(xpath="//textarea[@placeholder='Enter instructions to Delivery Driver']")private WebElement InstructionTextFiled;
	  
	
	  @FindBy(xpath="//*[contains(text(),'Deliveries Frequency')]")private WebElement FrequencyLableName;
	  
	  @FindBy(xpath="//*[contains(text(),'Snap Pass Name (Optional)' )]")private WebElement SnapPassNamelablel;
	  @FindBy(xpath="//input[@id=\"planname-input\"]")private WebElement SnapPasstextfield;
	  
	  @FindBy(xpath="//div[@class='-group -delivey-door-or-gate-consent']")private WebElement LeaveDeliveryAtDoorLabel;
	  @FindBy(xpath="//input[@id='deliveryDoorGateConsent-checkbox']")private WebElement LeaveDeliveryAtDoorCheckbox;
	  
	  @FindBy(xpath="//input[@placeholder=\"Redeem Loyalty Points\"]")private WebElement LoyaltyPointsUsecase;

	  public SnapPassUserCheckoutInformationPage(AndroidDriver driver)
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
	  
	  public String GetAddressFrame()
	  {
		  return AddressLable.getText();
	  }
	  public String getAddresslist()
	  {
		return AddressList.getText();
	  }
	  
	  public void Select_Address1()
	  {
		  AddressRadiobutton1.click();
	  }

	  public void Select_Address2()
	  {
		  AddressRadiobutton2.click();
	  }
	  public void NewAddressTab()
	  {
		  NewAddressTab.click();
	  }
	  
	  public void CloseNewAddress()
	  {
		  CancelButton.click();
	  }
	  
	  public String GetDeliveryInfoFrame()
	  {
		  return DeliveryInformationLable.getText();
	  }
	  
	  public String GetDeliveryTag()
	  {
		  return DeliveryTagInfo.getText();
	  }
	  
	  public void DeliveryDatePicker()
	  {
		  DeliveryDate.click();
	  }
	  public void closeDatePicker()
	  {
		  DiscardButton.click();
	  }
	  public void OpenDelieveywindow()
	  {
		  DeliveryWindow.click();
	  }
	  public void selectDeliveryWindow()
	  {
		  DeliveryWindowselect.click();
	  }
	  
	  public void ApplyDatepicker()
	  {
		  ApplyButton.click();
	  }
	  public String TextFieldName()
	  {
		  return InstructionText.getText();
	  }
	  
	  public void EnterInstuction()
	  {
		  InstructionTextFiled.sendKeys("Test Order for Delivery");
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
	  
	  public String GetCheckBoxLableName()
	  {
		  return LeaveDeliveryAtDoorLabel.getText();
	  }
	  
	  public void CheckThebox()
	  {
		  LeaveDeliveryAtDoorCheckbox.click();
	  }
	  
	  public void OpenLoyaltyPointDropdown()
	  {
		  LoyaltyPointsUsecase.click();
	  }
	  
	  
}
