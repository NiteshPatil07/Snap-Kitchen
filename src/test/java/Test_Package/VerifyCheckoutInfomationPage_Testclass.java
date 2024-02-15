package Test_Package;

import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.CheckoutInformation_Page;
import Pom_package.Snap_Kitchen.LoginUser_Enter_Zipcode;
import Pom_package.Snap_Kitchen.RegisterUser_AddProduct;
import io.appium.java_client.android.AndroidDriver;

public class VerifyCheckoutInfomationPage_Testclass extends DesiredCap_Setting
{

    public LoginUser_Enter_Zipcode ZIP;
	public RegisterUser_AddProduct ADD;
	public CheckoutInformation_Page check;
	public SoftAssert soft;
	
	
	String PageTitle="Checkout Information";
	String Frame1 ="DELIVERY ADDRESS";
	String Frame2="DELIVERY INFORMATION";
	String Tag="We will deliver your items straight to your doorstep on this day.";
	String Textfiledname= "Instructions to Delivery Driver (Optional)";	
	String CheckBoxlable="Leave Delivery at Door / Gate";
	
	
	
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		Device_setup();
		ZIP = new LoginUser_Enter_Zipcode ((AndroidDriver) driver);
		ADD =new RegisterUser_AddProduct ((AndroidDriver) driver);
		check = new  CheckoutInformation_Page((AndroidDriver) driver);
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

		Thread.sleep(5000);
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
		

		Thread.sleep(6000);
		ADD.addtocart_button();	
		Thread.sleep(5000);	
		ADD.addone_time_product();	
		Thread.sleep(4000);	
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
		
		Thread.sleep(4000);
		
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
  		Thread.sleep(4000);
  		WebElement Checkbox = driver.findElement(By.xpath("//div[@class='-group -delivey-door-or-gate-consent']"));
	        js.executeScript("arguments[0].scrollIntoView();", Checkbox);
	        
	        Thread.sleep(4000);
	        
  		
  		Thread.sleep(2000);
  		check.EnterInstuction();
  		
  		String checklable = check.GetCheckBoxLableName();
  		soft.assertEquals(checklable, CheckBoxlable);
  		
  		Thread.sleep(1000);
  		check.CheckThebox();
  		
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
