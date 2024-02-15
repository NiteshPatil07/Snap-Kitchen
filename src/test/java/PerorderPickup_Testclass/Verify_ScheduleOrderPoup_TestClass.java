package PerorderPickup_Testclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browser_Package.DesiredCap_Setting;
import Pickup_Preorder_Pom.Add_Preorder_To_Cart;
import Pickup_Preorder_Pom.Enter_PickupZipcode;
import Pickup_Preorder_Pom.Pikup_Checkoutinformation_page2;
import Pickup_Preorder_Pom.ScheduleYourOrder_PopUp;
import Pom_package.Snap_Kitchen.Product_listing_page;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class Verify_ScheduleOrderPoup_TestClass extends DesiredCap_Setting
{
	 String ProductCategory="Lunch & Dinner";
	 String  ExpectedPopupTitle = "Schedule your Order";
	 String  ExpectedSubtitle ="Items listed below aren’t available.";
	 String Expectedsubtext = "Select the later date option if you want the item below included in your order.";
	 String  ExpectedInstockButtonText = "In-Stock Items Today";
	 String  ExpectedAllItemsLButtonText = " All Items Later";
	 
	

	public Enter_PickupZipcode ZIP;
	public Utility_Class UT;
	public Product_listing_page PLP;	 
    public  Add_Preorder_To_Cart ADD;
    public ScheduleYourOrder_PopUp SCH;
	public  Pikup_Checkoutinformation_page2 check2;
	SoftAssert soft;
		 
		@BeforeClass
		public void Start_appium() throws Throwable
		{
			UT = new Utility_Class ();
			Device_setup();
			ZIP =new Enter_PickupZipcode((AndroidDriver)driver);
			ADD =new Add_Preorder_To_Cart((AndroidDriver)driver);
			SCH = new ScheduleYourOrder_PopUp((AndroidDriver)driver);
			check2 =new Pikup_Checkoutinformation_page2((AndroidDriver)driver);
			soft =new SoftAssert();
		}
		
		@BeforeMethod(firstTimeOnly = true)
		public void Passing_Zipcode_Register_Email() throws InterruptedException
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
		@BeforeMethod(dependsOnMethods = {"Passing_Zipcode_Register_Email"})
		public void verify_Catergory_list () throws Throwable
		{
			List<WebElement> Categories_Names = driver.findElements(By.xpath("//div[@class='-card']"));
			for(WebElement op:Categories_Names)
			{
				if(op.getText().contains(ProductCategory))
				{
					op.click();
				}
			}
			Thread.sleep(20000);
			ADD.cart_footer();
		}
		
		
		@Test
		public void verify_ScheduleYourOrderPopup() throws Throwable
		{
			Thread.sleep(2000);
			check2.Checkoutbutton();
			
			String Title = SCH.GetPopupTitle();
			soft.assertEquals(Title, ExpectedPopupTitle);
		   
			
			String SubTitle = SCH.GetPopupSubTitle();
			soft.assertEquals(SubTitle, ExpectedSubtitle);
	
			String SubText = SCH.GetPopupSubtext();
			soft.assertEquals(SubText, Expectedsubtext);
			
			
			String ProductCount = SCH.GetPreorderProductCount();
		     System.out.println(ProductCount);
			
			SCH.OpenPreorderDropdown();
			Thread.sleep(3000);
			
			SCH.ClosePreorderDropdown();
			
			
			String button1 = SCH.GetPopupInstockbutton();
			soft.assertEquals(button1, ExpectedInstockButtonText);
			
			String button2 = SCH.GetPopupAll_Items_Later_button();
		     soft.assertEquals(button2, ExpectedAllItemsLButtonText);
	
			 SCH.ClickPopupAll_Items_Later_button();
			
			
		}
}
