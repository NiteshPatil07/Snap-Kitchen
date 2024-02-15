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
import Pickup_Preorder_Pom.Pickup_CartPage;
import Pickup_Preorder_Pom.Pikup_Checkoutinformation_page;
import Pickup_Preorder_Pom.Pikup_Checkoutinformation_page2;
import Pickup_Preorder_Pom.ScheduleYourOrder_PopUp;
import Pom_package.Snap_Kitchen.RegisterUser_AddProduct;
import io.appium.java_client.android.AndroidDriver;

public class Pickup_Select_InstockItems_Cart_Testclass  extends DesiredCap_Setting
{

	
    public Enter_PickupZipcode ZIP;
	public RegisterUser_AddProduct ADD;
	public Pickup_CartPage PIC;
	public Pikup_Checkoutinformation_page  check;
	public Pikup_Checkoutinformation_page2 check2 ;
	public ScheduleYourOrder_PopUp SCH;
	public SoftAssert soft;
	public JavascriptExecutor js;
	
	String PageTitle="Checkout Information";

	
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		Device_setup();
		ZIP = new Enter_PickupZipcode ((AndroidDriver) driver);
		ADD =new RegisterUser_AddProduct ((AndroidDriver) driver);
		check = new  Pikup_Checkoutinformation_page ((AndroidDriver) driver);
		check2 = new Pikup_Checkoutinformation_page2((AndroidDriver) driver);
		SCH = new ScheduleYourOrder_PopUp((AndroidDriver)driver);
		  PIC = new  Pickup_CartPage ((AndroidDriver)driver);
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
	public void VerifyCheckoutInfoPage() throws InterruptedException
	{	
         String ProrderTagText = PIC.GetPreorderTag();
         
		 System.err.println(ProrderTagText);
		
		 String SnapPassTagText =PIC.GetSnapPasstag();
		
		 System.err.println(SnapPassTagText);
		 
		 List<WebElement> CartPageList = driver.findElements(By.xpath("//div[@class=\"-text\"]"));
		 
		 for(WebElement OP:CartPageList)
		 {
			 System.out.println(OP.getText());
		 }
		
		 PIC.clickonQuantitybutton();
		 
		Thread.sleep(2000);
		check2.Checkoutbutton();
		
		Thread.sleep(2000);
		
		SCH.OpenPreorderDropdown();
		Thread.sleep(3000);
		
		SCH.ClosePreorderDropdown();
		Thread.sleep(2000);
		
		SCH.ClickPopupInstockbutton();

		 Thread.sleep(6000);
		 	 
		 Thread.sleep(2000);
		check2.Checkoutbutton();

		String Title = check.GetPageTitle();
	    soft=new SoftAssert();
		soft.assertEquals(Title, PageTitle,"Page Title is not matching");
			
		String Order_Product = check.GetorderSummary();
		System.err.println("Total Order Product and its Price  :"+Order_Product);
		check.OpenOrdersummary();
		
		Thread.sleep(2000);		
		check.OpenOrdersummary();

	}
	@AfterMethod
	public void closeapp() throws InterruptedException
	{		
		Thread.sleep(4000);
		driver.quit();
		Server.close();

	}
		
}
