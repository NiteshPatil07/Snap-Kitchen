package Test_Package;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Categories_Page;
import Pom_package.Snap_Kitchen.Product_listing_page;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class Add_to_Cart_Button_testclass extends DesiredCap_Setting
{

     public Categories_Page Opt;
	 public Utility_Class UT;
	 public Product_listing_page PLP;	 
	 public String  One_Time_order =  "One-Time Add-on";
	 public String  Add_to_Snap_pass= "Add to Snap Pass Order";
	  
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		UT = new Utility_Class ();
		Device_setup2();
		Opt =new Categories_Page((AndroidDriver)driver);
		
		 PLP=new Product_listing_page((AndroidDriver)driver);
	}
	@BeforeMethod(firstTimeOnly = true)
	public void Passing_Zipcode_Register_Email() throws InterruptedException
	{
		Thread.sleep(5000);
		Opt.Enter_Zipcode();
		Opt.ZipcodeButton();
		Thread.sleep(4000);
		Opt.ZipcodeButton2();
		Opt.Eductional_screen_1();
		Opt.Eductional_screen_2();
		Opt.Enter_email();
		Opt.continue_button();
		
	}
	@BeforeMethod(dependsOnMethods = {"Passing_Zipcode_Register_Email"})
	public void verify_Catergory_list () throws Throwable
	{
		List<WebElement> Categories_Names = driver.findElements(By.xpath("//div[@class='-card']"));
		for(WebElement op:Categories_Names)
		{
			if(op.getText().contains("Lunch & Dinner"))
			{
				op.click();
			}
		}	
	}	
	@Test(priority = 1)
	public void product_details() throws InterruptedException
	{	
		Thread.sleep(5000);	
		boolean Buttonvalue = PLP.Add_to_cart_button();
		assertEquals(Buttonvalue, true,"Add to cart button is dissable ");
		if(Buttonvalue==true)
		{
			PLP.Add_to_cart_button_click();
		}
		
		 Thread.sleep(4000);
	     String Button_value_1 = PLP.Add_to_cart_dropdow_value1();
	     assertEquals(Button_value_1,One_Time_order,"Add to cart one time drop value text is not matching");
	     System.out.println(Button_value_1);
	     

//           Thread.sleep(3000);
//           WebElement Product_data = driver.findElement(By.xpath("//div[@class='-text-container']//h3[contains(text(),'Grilled Bbq Chicken Tenders With Mac & Cheese')]//parent::div")); 
//	       String data = Product_data.getText();
//	  	   
//		  System.err.println(data+"<=========================");	
	}
	
	@AfterMethod
	public void closeapp() throws InterruptedException
	{
		
		Thread.sleep(4000);
		driver.quit();
		Server.close();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
