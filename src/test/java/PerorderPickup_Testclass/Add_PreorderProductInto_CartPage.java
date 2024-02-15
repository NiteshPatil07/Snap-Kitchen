package PerorderPickup_Testclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pickup_Preorder_Pom.Add_Preorder_To_Cart;
import Pickup_Preorder_Pom.Enter_PickupZipcode;
import Pom_package.Snap_Kitchen.Add_Product_To_Cart;
import Pom_package.Snap_Kitchen.Categories_Page;
import Pom_package.Snap_Kitchen.Product_listing_page;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;

public class Add_PreorderProductInto_CartPage  extends DesiredCap_Setting
{
	 String ProductCategory="Lunch & Dinner";
    public Enter_PickupZipcode ZIP;
	 public Utility_Class UT;
	 public Product_listing_page PLP;	 
	 public  Add_Preorder_To_Cart ADD;
	 
	 
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		UT = new Utility_Class ();
		Device_setup();
		ZIP =new Enter_PickupZipcode((AndroidDriver)driver);
		ADD =new Add_Preorder_To_Cart((AndroidDriver)driver);
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
	}	
	@Test
	public void add_product_cart() throws InterruptedException
	{	
		Thread.sleep(6000);
		ADD.addtocart_button();	
		Thread.sleep(5000);	
		ADD.Add_Preorderproduct();	
		Thread.sleep(4000);	
		ADD.cart_footer();
	}	
	@AfterMethod
	public void closeapp() throws InterruptedException
	{	
			Thread.sleep(4000);
		   driver.quit();
		   Server.close();
	}
	
	
}
