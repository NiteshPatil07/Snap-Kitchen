package PerorderPickup_Testclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browser_Package.DesiredCap_Setting;
import Pickup_Preorder_Pom.Enter_PickupZipcode;
import Pickup_Preorder_Pom.Pikup_Checkoutinformation_page;
import Pickup_Preorder_Pom.Pikup_Checkoutinformation_page2;
import Pickup_Preorder_Pom.ScheduleYourOrder_PopUp;
import Pom_package.Snap_Kitchen.LoginUser_Enter_Zipcode;
import Pom_package.Snap_Kitchen.RegisterUser_AddProduct;
import Snappass_User_Pom.SnapPassUserCheckountInformationPage2;
import Snappass_User_Pom.SnapPassUserCheckoutInformationPage;
import io.appium.java_client.android.AndroidDriver;

public class PikupFlow_ChekoutInfo_page2_Testclass extends DesiredCap_Setting
{

	    public Enter_PickupZipcode ZIP;
		public RegisterUser_AddProduct ADD;
		public Pikup_Checkoutinformation_page check;
		public SoftAssert soft;
		public Pikup_Checkoutinformation_page2 check2;
		public JavascriptExecutor js;	
		public ScheduleYourOrder_PopUp SCH;
		
		String PageTitle="Checkout Information";
		String Frame1 ="PICKUP LOCATION";
		String Frame2="PICKUP INFORMATION";
		String Frame3="DISCOUNTS";
		String Frame4="PAYMENT METHOD";
		String Tag2="You can use them on this order to get a discount";
		String Textfiledname= "Order Notes (optional)";	
		String Freq="Weekly";
		String Time="2 PM";
		String FrequecyType ="PickUp Frequency";
		String Points ="120";
	    String Checklabelname="I Accept the Terms & Conditions";		
		@BeforeClass
		public void Start_appium() throws Throwable
		{
			Device_setup();
			ZIP = new Enter_PickupZipcode((AndroidDriver) driver);
			ADD =new RegisterUser_AddProduct ((AndroidDriver) driver);
			check = new  Pikup_Checkoutinformation_page((AndroidDriver) driver);
			check2 =new Pikup_Checkoutinformation_page2((AndroidDriver) driver);
			SCH =new ScheduleYourOrder_PopUp((AndroidDriver) driver);		
			soft=new SoftAssert();
			
			
			
		}
		@BeforeMethod(firstTimeOnly = true)
		public void LoginUser() throws Throwable
		{
			Thread.sleep(1500);
			ZIP.Enter_Email();
			ZIP.Enter_password();
			ZIP.login();
			Thread.sleep(4000);
			ZIP.clickOnCategories();

			Thread.sleep(1500);
			ZIP.Enter_Zipcode();
			ZIP.ZipcodeButton();
			Thread.sleep(5000);
			ZIP.selectFulfillment();
			Thread.sleep(500);
			ZIP.selectingRetailLocation();
			ZIP.ZipcodeButton2();
		}
		
	    @BeforeMethod(dependsOnMethods = {"LoginUser"})
		public void  verify_Catergory_list () throws Throwable
		{
			List<WebElement> Categories_Names = driver.findElements(By.xpath("//div[@class='-card']"));
			for(WebElement op:Categories_Names)
			{
				if(op.getText().contains("Lunch & Dinner"))
				{
					op.click();
				}
			}
			Thread.sleep(20000);
			ADD.cart_footer();
		}
	    @Test
	    public void verifyCheckoutPage2() throws InterruptedException
	    {
	    	
	    	check2.Checkoutbutton();
            Thread.sleep(4000);
            
            Thread.sleep(2000);
    		
    		SCH.OpenPreorderDropdown();
    		Thread.sleep(3000);
    		
    		SCH.ClosePreorderDropdown();
    		Thread.sleep(1500);
    		
    		 SCH.ClickPopupAll_Items_Later_button();
    		 
    		 Thread.sleep(2000);
                     
			WebElement Framename = driver.findElement(By.xpath("//*[contains(text(),'DISCOUNTS')]"));
		    js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", Framename);
	        
	       String ExFrame3 = check2. DiscountFramelabel();
	       soft.assertEquals(ExFrame3, Frame3);
	       
	        
	        boolean apply = check2.Promocodebutton();
		       soft.assertEquals(apply,"true","Promo Code Button is dissabled");
	        
	        Thread.sleep(1000);
	        check.OpenLoyaltyPointDropdown();
	        
	        List<WebElement> PointsValue = driver.findElements(By.xpath("//*[@class=\"-dropdown-item\"]"));
	      for(WebElement obj:PointsValue)
	      {
	    	  if(obj.getText().contentEquals(Points))
	    	  {
	    		  obj.click();
	    		  break;
	    	  }
	      }	             
	       String Balance = check2. GetLoyaltyPointbalance();
	       System.err.println(Balance);
	        
	        String DropdownText = check2. GetDropdownText();	        
	        soft.assertEquals(DropdownText, Tag2);
	        
	       String EXFrame4 = check2. PaymentFrameLable();
	          soft.assertEquals(Frame4, Frame4);
	        
	        String PaymentTextdata = check2. GetPaymetData();
	        System.err.println(PaymentTextdata);
	        
	        check2.OpenNewMethod();
	        Thread.sleep(4000);
	        
	        check2. closepayemntMethod();
	        
	        Thread.sleep(4500);
	        WebElement Confrimbutton = driver.findElement(By.xpath("//button[@id='confirmorder-button']"));
		     js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", Confrimbutton);
	        
	        String bottomText = check2. GetCheckoutText();
	        System.err.println(bottomText);
	        
	       String checklabel = check2. TermsAndconditionLable();
	       soft.assertEquals(checklabel,Checklabelname);
	       
	       Thread.sleep(2000);   
	        check2. CheckTermsAndConditions();
	        
	    }
	    @AfterMethod
		public void closeapp() throws InterruptedException
		{		
			Thread.sleep(4000);
			driver.quit();
			Server.close();

		}
}
