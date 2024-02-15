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
import Pom_package.Snap_Kitchen.RegisterUser_AddProduct;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class  VerifyPlacePreorderProduct_CreateSnapPassOrderTestclass extends DesiredCap_Setting
{

	public Enter_PickupZipcode ZIP;
	public RegisterUser_AddProduct ADD;
	public Pikup_Checkoutinformation_page check;
	public Pikup_Checkoutinformation_page2 check2;
	public Utility_Class UT;
	public ScheduleYourOrder_PopUp SCH;
	public JavascriptExecutor js;
    public  SoftAssert soft ;
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
	String CheckBoxlable2="I Accept the Terms & Conditions";
	String Points ="120";
	
	
	@Test(priority = 1)
	public void Start_appium() throws Throwable
	{
		Device_setup();
		ZIP = new Enter_PickupZipcode ((AndroidDriver) driver);
		ADD =new RegisterUser_AddProduct ((AndroidDriver) driver);
		check = new  Pikup_Checkoutinformation_page((AndroidDriver) driver);
		check2 =new Pikup_Checkoutinformation_page2((AndroidDriver) driver);
		UT= new Utility_Class();
		SCH = new ScheduleYourOrder_PopUp((AndroidDriver)driver);
	    soft=new SoftAssert();
		
	}
	@Test(priority = 2)
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
	
    @Test(priority = 3)
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
    @Test(priority = 4)
    public void VerifySchdeuleYourPopup() throws InterruptedException
    {
    	Thread.sleep(2000);
		check2.Checkoutbutton();
		
		Thread.sleep(2000);
		
		SCH.OpenPreorderDropdown();
		Thread.sleep(3000);
		
		SCH.ClosePreorderDropdown();
		Thread.sleep(1500);
		
		 SCH.ClickPopupAll_Items_Later_button();
		 
		 Thread.sleep(2000);
    }
    @Test(priority = 5)
    public void VerifyCheckoutInformationPage() throws InterruptedException
    {
    	String Title = check.GetPageTitle();
	    soft=new SoftAssert();
		soft.assertEquals(Title, PageTitle,"Page Title is not matching");
		
		
		String Order_Product = check.GetorderSummary();
		System.err.println("Total Order Product and its Price  :"+Order_Product);
		check.OpenOrdersummary();
		
		Thread.sleep(2000);
		
		check.OpenOrdersummary();
    	  
    	  String PickupInfoLable = check.GetPickupInfoFrame();
    	  soft.assertEquals(PickupInfoLable, Frame1);
    }
    
    @Test(priority = 6)
    public void SelectPickupDate_PickupTime() throws InterruptedException
    {
    	Thread.sleep(5000);
  		check.PickupDatePicker();
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
  		Thread.sleep(1000);
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
  		check.OpenPickupTime();
  		Thread.sleep(2000);
       List<WebElement> PikcupTimes = driver.findElements(By.xpath("//div[@class=\"-dropdown-item\"]"));
       
       Thread.sleep(2000);
 	   WebElement Label = driver.findElement(By.xpath("//*[contains(text(),'PickUp Frequency')]"));
	   js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView();", Label);
       
      for(WebElement obj:PikcupTimes)
      {
               
    	  if(obj.getText().contentEquals(Time))
    	  {
 		        obj.click();
 		         break;
    	  }
      }  
    }
	
    @Test(priority = 7)
    public void SelectPickupFreqency_And_EnterSnapPassName() throws InterruptedException
    {
    	Thread.sleep(2000);
  		check.EnterInstuction();
  		
  		String Frequencylabel = check.GetFrequencyLabelName();
  		soft.assertEquals(Frequencylabel,FrequecyType);

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
  		Thread.sleep(1000);
  		
  		String SnapPassTextFieldLabel = check.GetSnapPassTextFieldLabelName();
  		soft.assertEquals(SnapPassTextFieldLabel,"Snap Pass Name (Optional)");
  		
  		check.EnterSnapPassName();
		
    }
	
    @Test(priority = 8)
    public void Verify_And_Selecting_LoyaltyPoints_From_Disccount_Frame() throws InterruptedException
    {
    	WebElement Framename = driver.findElement(By.xpath("//*[contains(text(),'DISCOUNTS')]"));
	    js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Framename);
        
       String DisscountFrame = check2. DiscountFramelabel();
          soft.assertEquals(DisscountFrame, Frame3);
       
        
        boolean apply = check2.Promocodebutton();
        System.err.println(apply);
              
        String Balance = check2. GetLoyaltyPointbalance();
        System.err.println("1"+Balance);
        
        String DisscountText  = check2.GetDisscountText();
        soft.assertEquals(DisscountText, Tag2);

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
      
      //test.log(Status.PASS,"User Sucessfully Added Loyalty Points To Order Total");
    }
    
    @Test(priority = 9)
    public void VerifyPaymentMethodFrame_And_Select_PaymentMethod() throws InterruptedException
    {
    	String PaymentMethodFrame = check2. PaymentFrameLable();
	      soft.assertEquals(PaymentMethodFrame, Frame4);
	        
	        String PaymentTextdata = check2. GetPaymetData();
	        System.err.println("This Payments are available in payment method :"+PaymentTextdata);
	        
	        check2.OpenNewMethod();
	        Thread.sleep(4000);
	        
	        check2. closepayemntMethod();
	        
	        Thread.sleep(4500);
	        WebElement Confrimbutton = driver.findElement(By.xpath("//button[@id='confirmorder-button']"));
		     js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", Confrimbutton);
	        
	       // test.log(Status.PASS,"User Sucessfully Selected Payment Method From Saved Cards");
    }
    
    @Test(priority = 10)
    public void CheckThePageInfo_And_check_TermsConditons() throws InterruptedException
    {
    	
        
        String bottomText = check2. GetCheckoutText();
        System.err.println("This is snap pass user discription text  :"+bottomText);
        
       String checklabel = check2. TermsAndconditionLable();
        soft.assertEquals(checklabel, CheckBoxlable2);
       
       Thread.sleep(2000);
        
        check2. CheckTermsAndConditions();
       // test.log(Status.PASS,"User Sucessfully Checked The Terms and Condition Check Box & Enabled The Confrim Order Button");
    }
    
    
    @Test(priority = 11)
    public void ConfrimTheOrder_and_ThankyouPage() throws Throwable
    {
    	WebElement Confrimbutton = driver.findElement(By.xpath("//button[@id='confirmorder-button']"));
    	Confrimbutton.click();
        Thread.sleep(3500);   
        
       String title = driver.findElement(By.xpath("//h2[contains(text(),'Confirm Order')]")).getText();
       soft.assertEquals(title, "Confirm Order");
       
       WebElement placeOrderbutton = driver.findElement(By.xpath("//button[@id='placeOrder-button']"));
       System.err.println(placeOrderbutton.isEnabled());
       js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", placeOrderbutton);
        
        placeOrderbutton.click();
      
       Thread.sleep(6000);
        UT.screenshot(driver);
       
       soft.assertAll();
       
//       test.log(Status.PASS,"User Sucessfully Placed Order From Confirm Order Page User able see Successfully Place Order Popup On Screen");
//       
//       test.addScreenCaptureFromPath("./Screenshots/"+toString()+".PNG");
//       
//        ext.flush();
    }
    @Test
    public void closeSession()
    {	
    		driver.quit();
    		Server.close();
    }
    
 }
