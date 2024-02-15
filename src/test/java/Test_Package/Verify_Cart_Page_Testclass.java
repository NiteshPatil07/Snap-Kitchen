package Test_Package;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Add_Product_To_Cart;
import Pom_package.Snap_Kitchen.Cart_Page;
import Pom_package.Snap_Kitchen.Categories_Page;
import Pom_package.Snap_Kitchen.Product_listing_page;
import Utility_Package.Utility_Class;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Verify_Cart_Page_Testclass extends DesiredCap_Setting
{

	  public Categories_Page Opt;
	  public Utility_Class UT;
	  public Product_listing_page PLP;	 
	  public  Add_Product_To_Cart ADD;
	  public Cart_Page Cart;
	  public WebDriverWait wait;
	 
	  String Cart_Banner ="You're saving 5% with Snap Pass";
	  String  Added_Product_Type="One Time Add-On (1):";
	  String Cart_Product_Name="baja fish tacos with cilantro crema $0.00";
	  String Count_Product= "1";
	  String Product_Price="Checkout Subtotal $0.00";
	  
	    	  
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		
		UT = new Utility_Class ();
		Device_setup2();
		Opt =new Categories_Page((AndroidDriver)driver);
		ADD =new Add_Product_To_Cart((AndroidDriver)driver);
		 Cart=new Cart_Page((AndroidDriver)driver);
			 
		 
	}
	
	@BeforeMethod(firstTimeOnly = true)
	public void Category_Selection() throws InterruptedException
	{
		Thread.sleep(5000);
		Opt.Enter_Zipcode();
		Opt.ZipcodeButton();
		Thread.sleep(5000);
		Opt.ZipcodeButton2();
		Opt.Eductional_screen_1();
		Opt.Eductional_screen_2();
		Opt.Enter_email();
		Opt.continue_button();
		List<WebElement> Categories_Names = driver.findElements(By.xpath("//div[@class='-card']"));
		for(WebElement op:Categories_Names)
		{
			if(op.getText().contains("Lunch & Dinner"))
			{
				op.click();
			}
		}			
	}
	@BeforeMethod(dependsOnMethods = {"Category_Selection"})
	public void add_product_cart() throws InterruptedException
	{	
		Thread.sleep(10000);
		ADD.addtocart_button();	
		Thread.sleep(2000);	
		ADD.addone_time_product();	
		Thread.sleep(3000);	
		ADD.cart_footer();
	}
	@Test
	public void verify_cart_page()
	{
		SoftAssert soft=new SoftAssert();
		 String Banner = Cart.Page_Banner();		
	     soft.assertEquals(Banner,Cart_Banner,"Cart Page Snap pass banner is not matching");
	     System.err.println("Cart Page Green Header Title is     : "  +Banner);
		
		String Product_Type = Cart.Product_Type();		
		soft.assertEquals(Product_Type, Added_Product_Type,"Product Type catergory is not matching");
		System.err.println("User Add product Type is :"+Product_Type);
		
		
		String Product_Name = Cart.Product_name();
		soft.assertEquals(Product_Name,Cart_Product_Name,"Cart Page Product Name is not macthcing with product added into cart");
		System.err.println("User added product name is "+Product_Name);	
			
		String Prodouct_value = Cart.Product_count();
		soft.assertEquals(Prodouct_value,Count_Product,"Product Quantity is not matching");
		System.err.println("User added product count is :"+Prodouct_value);
		
		
		
		
		String Product_Amount = Cart.Product_Subtotal();
		soft.assertEquals(Product_Amount,Product_Price,"Product Price/Subtotal is not matching");
		System.err.println("Total price of added product is : "+Product_Amount);
		soft.assertAll();
		
		Cart.Checkoutbutton();
				
	}

	@AfterMethod
	public void closeapp() throws InterruptedException
	{
		
		Thread.sleep(4000);
		driver.quit();
		Server.close();
		
		
	}
	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
