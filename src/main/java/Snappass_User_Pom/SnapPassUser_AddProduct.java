package Snappass_User_Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SnapPassUser_AddProduct
{


	@FindBy(xpath="//div[@class='-card-container']")private WebElement Productlist_Details;

	@FindBy(xpath="//div[@class='-add-to-cart-container']")private WebElement Cart_button;
	
	@FindBy(xpath="//div//span[contains(text(),'One-Time Add-on')]")private WebElement Add_one_Time;
	
	@FindBy(xpath="//div[@class='-item -border-top'][contains(text(),' Add to Snap Pass Order ')]")private WebElement Add_to_snap;

	@FindBy(xpath="//div[@class='-text-container\"]//h3[contains(text(),'Grilled Bbq Chicken Tenders With Mac & Cheese')]//parent::div")private WebElement product_details;
	
	
	public SnapPassUser_AddProduct(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean Add_to_cart_button()
	{
		return Cart_button.isEnabled();
	}
	
	public void Add_to_cart_button_click()
	{
		if(Add_to_cart_button()==true)
		{
			Cart_button.click();
		}
	}
	public String Add_to_cart_dropdow_value1()
	{
		
		String Value1 = Add_one_Time.getText();
		
		return Value1;
	}
	
	
	public String  Add_to_cart_dropdow_value2()
	{
		String Value2 = Add_to_snap.getText();
        
		return Value2;
	}
	
	public void Cart_snap_product()
	{
		 Add_to_snap.click();
	}
	
}
