package Pom_package.Snap_Kitchen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Add_Product_To_Cart
{

	@FindBy(xpath="//div[@class='-card-container']")private WebElement Productlist_Details;
	@FindBy(xpath="//div[@class='-add-to-cart-container']")private WebElement Cart_button;
	@FindBy(xpath="//div//span[contains(text(),'One-Time Add-on')]")private WebElement Add_one_Time;
	
	@FindBy(xpath="//*[contains(text(),' Add to Snap Pass Order ')]")private WebElement Add_to_snap;
	@FindBy(xpath="//ion-tab-button[@tab='cart']")private WebElement Cart_footer_tab;
	
	
	
	public Add_Product_To_Cart(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addtocart_button()
	{
		Cart_button.click();
	}
	
	public void addone_time_product()
	{
		Add_one_Time.click();
	}
	
	public void add_snap_pass_product()
	{
		Add_to_snap.click();
	}
	
	public void cart_footer()
	{
		Cart_footer_tab.click();
	}
	
	
	
	
	
	
	
	
	
	
}
