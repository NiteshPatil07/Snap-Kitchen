package PerorderPickup_Testclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pickup_Preorder_Pom.Enter_PickupZipcode;
import Pickup_Preorder_Pom.Pikup_Checkoutinformation_page;
import Pickup_Preorder_Pom.Pikup_Checkoutinformation_page2;
import Pickup_Preorder_Pom.ScheduleYourOrder_PopUp;
import Pom_package.Snap_Kitchen.LoginUser_Enter_Zipcode;
import Pom_package.Snap_Kitchen.RegisterUser_AddProduct;
import Snappass_User_Pom.SnapPassUserCheckountInformationPage2;
import Snappass_User_Pom.SnapPassUserCheckoutInformationPage;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class ProrderProduct_PlacedByUser_Testclass extends DesiredCap_Setting
{
	public Enter_PickupZipcode ZIP;
	public RegisterUser_AddProduct ADD;
	public Pikup_Checkoutinformation_page check;
	public Pikup_Checkoutinformation_page2 check2;
	public Utility_Class UT;
	public ScheduleYourOrder_PopUp SCH;
	public JavascriptExecutor js;
	
	String PageTitle="Checkout Information";
	String Frame1 ="PICKUP LOCATION";
	String Frame2="PICKUP INFORMATION";
	String Textfiledname= "Order Notes (optional)";	
	String Freq="Weekly";
	String Time="2 PM";
	String FrequecyType ="PickUp Frequency";
	
	
	
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		Device_setup();
		ZIP = new Enter_PickupZipcode ((AndroidDriver) driver);
		ADD =new RegisterUser_AddProduct ((AndroidDriver) driver);
		check = new  Pikup_Checkoutinformation_page((AndroidDriver) driver);
		check2 =new Pikup_Checkoutinformation_page2((AndroidDriver) driver);
		UT= new Utility_Class();
		SCH = new ScheduleYourOrder_PopUp((AndroidDriver)driver);
		
		
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
    public void PlaceOrderFromCheckoutToThankyouPage() throws Throwable
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
        	
		String Order_Product = check.GetorderSummary();
		System.err.println("Total Order Product and its Price  :"+Order_Product);
		check.OpenOrdersummary();	
		Thread.sleep(2000);	
		check.CloseOrderSummary();
		
		
		
		//Need to put a code about pickup location information.
		
  		Thread.sleep(3000);
  		check.PickupDatePicker();;
  		String Month="Dec";
  		String	Date ="8";
  		while(true)
  		{
  			String text = driver.findElement(By.xpath("//div[@class='-month-container']")).getText();
  			if(text.equals(Month))
  			{
  				break;
  			}
  			else
  			{
  				driver.findElement(By.xpath("//button[@class='button border-gray-background-white-color-black-icon-black square-48px -right-button']")).click();
  			}
  		}	
  		List<WebElement> Alldates = driver.findElements(By.xpath("//div[@class='-cell']"));
  		for(WebElement op:Alldates)
  		{
  			if(op.getText().equals(Date))
  			{
  				op.click();
  				check.ApplyDatepicker();
  				break;
  			}
  		}
  		
  		 Thread.sleep(2000);
  	   WebElement OrderNotes = driver.findElement(By.xpath("//*[contains(text(),'Pickup Time')]"));
  	   js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView();", OrderNotes);
	
  		check.OpenPickupTime();
  		Thread.sleep(3500);
 	   
        List<WebElement> PikcupTimes = driver.findElements(By.xpath("//div[@class=\"-dropdown-item\"]"));
      for(WebElement obj:PikcupTimes)
      {
    	  if(obj.getText().contentEquals(Time))
    	  {
    		  obj.click();
    		  break;
    		  
    	  }
      }  
  		
      
      Thread.sleep(2000);
	   WebElement Label = driver.findElement(By.xpath("//*[contains(text(),'PickUp Frequency')]"));
	   js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView();", Label);
      

	        Thread.sleep(4000);
	        
		check.EnterInstuction();
		
		Thread.sleep(3000);
  		driver.findElement(By.xpath("//input[@placeholder='Select PickUp Frequency']")).click();
  		List<WebElement> frequency = driver.findElements(By.xpath("//div[@class='-dropdown-item']"));
  		
  		for(WebElement op:frequency)
  		{
  			if(op.getText().contentEquals(Freq))
  			{
  				op.click();
  				break;
  			}
  		}
  		
		 Thread.sleep(2000);
			WebElement Framename = driver.findElement(By.xpath("//*[contains(text(),'DISCOUNTS')]"));
		    js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", Framename);
	       
	        
	       String Balance = check2. GetLoyaltyPointbalance();
	       System.err.println(Balance);
	        
	        //check2.OpenDropdown();
	        
	        String PaymentTextdata = check2. GetPaymetData();
	        System.err.println(PaymentTextdata);
	
	        Thread.sleep(4500);
	        WebElement Confrimbutton = driver.findElement(By.xpath("//button[@id='confirmorder-button']"));
		     js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", Confrimbutton);
  
	       Thread.sleep(2000);
	        
	        check2. CheckTermsAndConditions();
	        
	        Confrimbutton.click();
	        Thread.sleep(3500);   
	        
	       String title = driver.findElement(By.xpath("//h2[contains(text(),'Confirm Order')]")).getText();
	       System.err.println(title);
	       
	       WebElement placeOrderbutton = driver.findElement(By.xpath("//button[@id='placeOrder-button']"));
	       System.err.println(placeOrderbutton.isEnabled());
	       js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", placeOrderbutton);
	        
	        placeOrderbutton.click();
	      
	       Thread.sleep(6000);
	       UT.screenshot(driver);

    }
}
