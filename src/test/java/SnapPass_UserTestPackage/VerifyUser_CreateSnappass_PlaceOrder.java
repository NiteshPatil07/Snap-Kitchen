package SnapPass_UserTestPackage;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.CheckoutInformation_Page;
import Pom_package.Snap_Kitchen.CheckoutInformation_Page2;
import Pom_package.Snap_Kitchen.LoginUser_Enter_Zipcode;
import Pom_package.Snap_Kitchen.RegisterUser_AddProduct;
import Snappass_User_Pom.SnapPassUserCheckountInformationPage2;
import Snappass_User_Pom.SnapPassUserCheckoutInformationPage;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class VerifyUser_CreateSnappass_PlaceOrder extends DesiredCap_Setting
{

	public LoginUser_Enter_Zipcode ZIP;
	public RegisterUser_AddProduct ADD;
	public SnapPassUserCheckoutInformationPage check;
	public SnapPassUserCheckountInformationPage2 check2;
	public Utility_Class UT;
	public ExtentTest test;
	public JavascriptExecutor js;
	public SoftAssert soft;
	public static ExtentSparkReporter  exreport;
    public static  ExtentReports extent;
	
	String PageTitle="Checkout Information";
	String Frame1 ="DELIVERY ADDRESS";
	String Frame2="DELIVERY INFORMATION";
	String Frame3="DISCOUNTS";
	String Frame4="PAYMENT METHOD";
	 String Tag2="You can use them on this order to get a discount";
	String Tag="We will deliver your items straight to your doorstep on this day.";
	String Textfiledname= "Instructions to Delivery Driver (Optional)";	
	String CheckBoxlable="Leave Delivery at Door / Gate";
	
	String CheckBoxlable2="I Accept the Terms & Conditions";
	String Freq="Weekly";
	String Points ="120";
	
	@Test(priority = 1)
	public void Start_appium() throws Throwable
	{   
		 Device_setup();
		UT= new Utility_Class();
		ZIP = new LoginUser_Enter_Zipcode ((AndroidDriver) driver);
		ADD =new RegisterUser_AddProduct ((AndroidDriver) driver);
		check = new SnapPassUserCheckoutInformationPage((AndroidDriver) driver);
		check2 =new SnapPassUserCheckountInformationPage2((AndroidDriver) driver);
		soft=new SoftAssert();
	}
	@Test(priority = 2)
	public void LoginUser() throws Throwable
	{
		
		Thread.sleep(3000);
		ZIP.Enter_Email();
		ZIP.Enter_password();
		ZIP.login();
		Thread.sleep(6000);
		test.log(Status.PASS,"User is Sucessfully Login");
	
		ZIP.clickOnCategories();
         
		Thread.sleep(2000);
		ZIP.Enter_Zipcode();
		ZIP.ZipcodeButton();
		Thread.sleep(2000);
		ZIP.ZipcodeButton2();
		test.log(Status.PASS,"User Sucessfully Enter Zipcode");
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
		test.log(Status.PASS,"User Select The Category");
		

		Thread.sleep(20000);
		ADD.cart_footer();
		test.log(Status.PASS,"User Sucessfully Product Into Cart Page ");
	}
	
    @Test(priority = 4)
    public void VerifyOrderandSelectAddress() throws Throwable
    {
    	check2.Checkoutbutton();
        Thread.sleep(4000);
       // test.log(Status.PASS,"User Added Product Are Sucessfully Checkout");
		
		
		String Order_Product = check.GetorderSummary();
		System.err.println("Total Order Product and its Price  :"+Order_Product);
		check.OpenOrdersummary();
		
		Thread.sleep(2000);
		
		check.CloseOrderSummary();
		// test.log(Status.PASS,"User Added Product Are Properly Displayed In Order Summary");
		
		String list = check.getAddresslist();
		System.out.println(list);
		
		Thread.sleep(2000);
		check.Select_Address2();
		
		// test.log(Status.PASS,"User Sucessfully Select Address For Delivery ");
    }
    @Test(priority = 5)
    public void SelectDeliverydate_and_DeliveryWinow() throws InterruptedException
    {
    	Thread.sleep(3000);
  		check.DeliveryDatePicker();
  		String Month="Dec";
  		String	Date ="24";
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
  		
  		Thread.sleep(3500);
  	      check.OpenDelieveywindow();
  		Thread.sleep(1000);
  	    check.selectDeliveryWindow();
  	    
  	 // test.log(Status.PASS,"User Sucessfully Selected Delivery Date and Delivery Window");
  	    
    }
    @Test(priority = 6)
    public void SelectDeliveryFreqency_And_EnterSnapPassName() throws InterruptedException
    {
    	 
 	     Thread.sleep(2000);
 	   WebElement Label = driver.findElement(By.xpath("//*[contains(text(),'Deliveries Frequency')]"));
	   js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView();", Label);

	        Thread.sleep(4000);
	        
		check.EnterInstuction();
		
		Thread.sleep(3000);
 		driver.findElement(By.xpath("//input[@placeholder='Select Deliveries Frequency']")).click();
 		List<WebElement> frequency = driver.findElements(By.xpath("//div[@class='-dropdown-item']"));
 		
 		for(WebElement op:frequency)
 		{
 			if(op.getText().contentEquals(Freq))
 			{
 				op.click();
 				break;
 			}
 		}
 		
 		String SnapPassTextFieldLabel = check.GetSnapPassTextFieldLabelName();
  		soft.assertEquals(SnapPassTextFieldLabel,"Snap Pass Name (Optional)");
  		
  		check.EnterSnapPassName();
        Thread.sleep(1000);
        
       // test.log(Status.PASS,"User Sucessfully Selected Delivery Freqency and Enter Snap Pass Name");
        
    }
    @Test(priority = 7)
    public void SelectingCheckboxForDeliveryAtDoor() throws InterruptedException
    {
    	 Thread.sleep(1000);
 		WebElement Checkbox = driver.findElement(By.xpath("//div[@class='-group -delivey-door-or-gate-consent']"));
 		   js = (JavascriptExecutor) driver;
 	        js.executeScript("arguments[0].scrollIntoView();", Checkbox);
 		
 		Thread.sleep(1000);
   		String checklable = check.GetCheckBoxLableName();
   		soft.assertEquals(checklable, CheckBoxlable);
   		check.CheckThebox();
   		
   		//test.log(Status.PASS,"User Sucessfully Check The Box For Delivery At Door/Gate");
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
    @Test(priority = 10)
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
        extent.flush();
    }
 	
}
