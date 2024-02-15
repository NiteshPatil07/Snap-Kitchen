package SnapPass_UserTestPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.CheckoutInformation_Page;
import Pom_package.Snap_Kitchen.LoginUser_Enter_Zipcode;
import Pom_package.Snap_Kitchen.RegisterUser_AddProduct;
import Snappass_User_Pom.SnapPassUserCheckoutInformationPage;
import io.appium.java_client.android.AndroidDriver;

public class SnapPassUser_CheckoutInfoPage_1 extends DesiredCap_Setting
{

    public LoginUser_Enter_Zipcode ZIP;
	public RegisterUser_AddProduct ADD;
	public SnapPassUserCheckoutInformationPage check;
	public SoftAssert soft;
	
	
	String PageTitle="Checkout Information";
	String Frame1 ="DELIVERY ADDRESS";
	String Frame2="DELIVERY INFORMATION";
	String Tag="We will deliver your items straight to your doorstep on this day.";
	String Textfiledname= "Instructions to Delivery Driver (Optional)";	
	String CheckBoxlable="Leave Delivery at Door / Gate";
	String Freq="Weekly";
	
	
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		Device_setup();
		ZIP = new LoginUser_Enter_Zipcode ((AndroidDriver) driver);
		ADD =new RegisterUser_AddProduct ((AndroidDriver) driver);
		check = new  SnapPassUserCheckoutInformationPage((AndroidDriver) driver);
	}
	@BeforeMethod(firstTimeOnly = true)
	public void LoginUser() throws Throwable
	{
		Thread.sleep(3000);
		ZIP.Enter_Email();
		ZIP.Enter_password();
		ZIP.login();
		Thread.sleep(6000);
		ZIP.clickOnCategories();

		Thread.sleep(1500);
		ZIP.Enter_Zipcode();
		ZIP.ZipcodeButton();
		Thread.sleep(5000);
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
		
		check.Checkoutbutton();
		Thread.sleep(1000);
		String Title = check.GetPageTitle();
	    soft=new SoftAssert();
		soft.assertEquals(Title, PageTitle,"Page Title is not matching");
		
		
		String Order_Product = check.GetorderSummary();
		System.err.println("Total Order Product and its Price  :"+Order_Product);
		check.OpenOrdersummary();
		
		Thread.sleep(2000);
		
		check.OpenOrdersummary();
		
		
		String frame = check.GetAddressFrame();
		soft.assertEquals(frame,Frame1);

		String list = check.getAddresslist();
		System.out.println(list);
		
		Thread.sleep(6000);
		check.Select_Address2();
		
		
		check.NewAddressTab();
		Thread.sleep(6000);
		
		
		WebElement CancelButton = driver.findElement(By.xpath("//*[@class='button border-gray-background-white-color-black-icon-black full-width']"));
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", CancelButton);
        Thread.sleep(1500);
        check.CloseNewAddress();
        
	
    	  
    	  String DeliveryInfoLable = check.GetDeliveryInfoFrame();
    	  soft.assertEquals(DeliveryInfoLable, Frame2);
    	  
    	 String DTag = check.GetDeliveryTag();
    	 soft.assertEquals(DTag, Tag);
    	 
  		Thread.sleep(5000);
  		check.DeliveryDatePicker();
  		String Month="Dec";
  		String	Date ="26";
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
  		
  	  
 	     Thread.sleep(2000);
 	   WebElement Label = driver.findElement(By.xpath("//*[contains(text(),'Deliveries Frequency')]"));
	   js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView();", Label);

	 
  		Thread.sleep(2000);
  		check.EnterInstuction();
  		
  		String Frequencylabel = check.GetFrequencyLabelName();
  		soft.assertEquals(Frequencylabel,"Deliveries Frequency");

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
  		Thread.sleep(1000);
  		
  		String SnapPassTextFieldLabel = check.GetSnapPassTextFieldLabelName();
  		soft.assertEquals(SnapPassTextFieldLabel,"Snap Pass Name (Optional)");
  		
  		check.EnterSnapPassName();
        Thread.sleep(1000);
		WebElement Checkbox = driver.findElement(By.xpath("//div[@class='-group -delivey-door-or-gate-consent']"));
		   js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", Checkbox);
		
		Thread.sleep(1000);
  		String checklable = check.GetCheckBoxLableName();
  		soft.assertEquals(checklable, CheckBoxlable);
  		check.CheckThebox();
  		
  		soft.assertAll();
  		
      }

}
