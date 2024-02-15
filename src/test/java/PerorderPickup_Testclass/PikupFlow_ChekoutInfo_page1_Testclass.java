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
import Snappass_User_Pom.SnapPassUserCheckoutInformationPage;
import io.appium.java_client.android.AndroidDriver;

public class PikupFlow_ChekoutInfo_page1_Testclass extends DesiredCap_Setting
{

    public Enter_PickupZipcode ZIP;
	public RegisterUser_AddProduct ADD;
	public Pikup_Checkoutinformation_page  check;
	Pikup_Checkoutinformation_page2 check2 ;
	ScheduleYourOrder_PopUp SCH;
	public SoftAssert soft;
	JavascriptExecutor js;
	
	String PageTitle="Checkout Information";
	String Frame1 ="PICKUP LOCATION";
	String Frame2="PICKUP INFORMATION";
	String Textfiledname= "Order Notes (optional)";	
	String Freq="Weekly";
	String Time="2 PM";
	String FrequecyType ="PickUp Frequency";
	
	String CheckBoxlable2="I Accept the Terms & Conditions";
	String Points ="120";
	
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		Device_setup();
		ZIP = new Enter_PickupZipcode ((AndroidDriver) driver);
		ADD =new RegisterUser_AddProduct ((AndroidDriver) driver);
		check = new  Pikup_Checkoutinformation_page ((AndroidDriver) driver);
		check2 = new Pikup_Checkoutinformation_page2((AndroidDriver) driver);
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
	public void VerifyCheckoutInfoPage() throws InterruptedException
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
  		
        Thread.sleep(1000);
		WebElement GIFTCARD = driver.findElement(By.xpath("//*[contains(text(),'GIFT CARD')]"));
		   js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", GIFTCARD);
		
		Thread.sleep(1000);
  		
  		soft.assertAll();
  		
      }
	@AfterMethod
	public void closeapp() throws InterruptedException
	{		
		Thread.sleep(4000);
		driver.quit();
		Server.close();

	}

}
