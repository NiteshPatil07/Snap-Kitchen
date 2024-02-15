package Test_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Browser_Package.DesiredCap_Setting;
import Pom_package.Snap_Kitchen.Add_Product_To_Cart;
import Pom_package.Snap_Kitchen.Categories_Page;
import Pom_package.Snap_Kitchen.LoginUser_Enter_Zipcode;
import Pom_package.Snap_Kitchen.RegisterUser_AddProduct;
import Utility_Package.Listners;
import Utility_Package.Utility_Class;
import io.appium.java_client.android.AndroidDriver;


public class RegisterUserAddProductToCartPage_Testclass extends DesiredCap_Setting
{

	public LoginUser_Enter_Zipcode ZIP;
	public RegisterUser_AddProduct ADD;
	
	
	@BeforeClass
	public void Start_appium() throws Throwable
	{
		Device_setup();
		ZIP = new LoginUser_Enter_Zipcode ((AndroidDriver) driver);
		ADD =new RegisterUser_AddProduct ((AndroidDriver) driver);
		
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
	@Test
	public void add_product_cart() throws InterruptedException
	{	
		Thread.sleep(6000);
		ADD.addtocart_button();	
		Thread.sleep(2000);	
		ADD.addone_time_product();	
		Thread.sleep(2000);	
		ADD.cart_footer();
	}
	

	@AfterClass
	public void closeapp() throws InterruptedException
	{
		
		Thread.sleep(4000);
		driver.quit();
		Server.close();
		
		
	}		
}
