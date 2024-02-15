package Test_Package;

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
import Pom_package.Snap_Kitchen.CheckoutInformation_Page;
import Pom_package.Snap_Kitchen.CheckoutInformation_Page2;
import Pom_package.Snap_Kitchen.LoginUser_Enter_Zipcode;
import Pom_package.Snap_Kitchen.RegisterUser_AddProduct;
import io.appium.java_client.android.AndroidDriver;

public class VerifyCheckoutInfromationPage2_TestClass extends DesiredCap_Setting
{

	 public LoginUser_Enter_Zipcode ZIP;
		public RegisterUser_AddProduct ADD;
		public CheckoutInformation_Page check;
		public SoftAssert soft;
		CheckoutInformation_Page2 check2;
		JavascriptExecutor js;
		
		
		
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
			check2 =new CheckoutInformation_Page2((AndroidDriver) driver);
			
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
	    public void verifyCheckoutPage2() throws InterruptedException
	    {
	    	
	    	check2.Checkoutbutton();
            Thread.sleep(4000);
			WebElement Framename = driver.findElement(By.xpath("//*[contains(text(),'DISCOUNTS')]"));
		    js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", Framename);
	        
	       String Frame3 = check2. DiscountFramelabel();
	       System.err.println(Frame3);
	        
	       String PromoText = check2.PromoCodeTextFiled();
	       System.err.println(PromoText);
	        
	        boolean apply = check2.Promocodebutton();
	        System.err.println(apply);
	        
	       String Balance = check2. GetLoyaltyPointbalance();
	       System.err.println(Balance);
	        
	        String DisscountText  = check2.GetDisscountText();
	        System.err.println();
	        
	        String DropdownText = check2. GetDropdownText();
	        System.err.println(DisscountText);
	        
	        check2.OpenDropdown();
	  
	        
	       String Frame4 = check2. PaymentFrameLable();
	       System.err.println(Frame4);
	        
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
	       System.err.println(checklabel);
	       
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
