package Pickup_Preorder_Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ScheduleYourOrder_PopUp 
{


         @FindBy(xpath="//h2[contains(text(),'Schedule your Order')]")private WebElement PopupTitle;
	     @FindBy(xpath="//div[@class=\"-question_background\"]")private WebElement PopupSubtitle;
	    @FindBy(xpath="//div[@class=\"question_para\"]")private WebElement  Subtext;
      	@FindBy(xpath="//div[@class=\"flex-grow\"]")private WebElement PreorderProductCount;
	     @FindBy(xpath="//button[@id=\"orderSummaryButton\"]")private WebElement PreorderProductDropDown;
	     @FindBy(xpath="//button[@class=\"button border-gray-background-white-icon-black full-width instock-items "
	     + "-instock-button\"]")private WebElement InstockToday;
	       @FindBy(xpath="//button[@class=\"button border-black-background-black-color-white-icon-white full-width"
		    + " -allitem-button\"]")private WebElement AllItemsLater;
	       @FindBy(xpath="//*[@class='-sticky-container']//button")private WebElement  CheckoutButton;
	
                public ScheduleYourOrder_PopUp(AndroidDriver driver)
	           	{
	           		PageFactory.initElements(driver,this);
	           	}
	                    
	                    
	         public String GetPopupTitle()
	         {
	        	 return PopupTitle.getText(); 
	         }
	                    
	         public String GetPopupSubTitle()
	         {
	        	 return PopupSubtitle.getText();
	         }  
	         
	         public String GetPopupSubtext()
	         {
	        	 return Subtext.getText();
	         }
	         
	         public String GetPreorderProductCount()
	         {
	        	 return PreorderProductCount.getText() ;
	         }
	         
	         public void OpenPreorderDropdown()
	         {
	        	 PreorderProductDropDown.click();
	         }
	         
	         public void ClosePreorderDropdown()
	         {
	        	 PreorderProductDropDown.click();
	         }
	         
	         public String GetPopupInstockbutton()
	         {
	        	 return InstockToday.getText();
	         }
	         
	         public String GetPopupAll_Items_Later_button()
	         {
	        	 return AllItemsLater.getText();
	         }
	         

	         public void ClickPopupInstockbutton()
	         {
	        	 InstockToday.click();
	         }
	         
	         public void ClickPopupAll_Items_Later_button()
	         {
	        	 AllItemsLater.click();
	         }
	         
	
}
