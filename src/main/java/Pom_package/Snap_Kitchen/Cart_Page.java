package Pom_package.Snap_Kitchen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Cart_Page 
{

	@FindBy(xpath="//div[@class='-banner']")private WebElement Disscount_banner;
	@FindBy(xpath="//div[@class='-caption -weekly-snap-pass']")private WebElement Cart_Type;
	@FindBy(xpath="//div[@class='-text']")private WebElement  Product;
	@FindBy(xpath="//div[@class='-quantity']")private WebElement ProductCount;
	@FindBy(xpath="//*[@class='-sticky-container']//button")private WebElement  CheckoutButton;
	
	
	public Cart_Page(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String Page_Banner()
	{
		return Disscount_banner.getText();
	}
	
	public String Product_Type()
	{
		return Cart_Type.getText();
	}
	
	public String Product_name()
	{
		return Product.getText();
	}
	
	public String Product_count()
	{
		return ProductCount.getText();
	}
	
	public String Product_Subtotal()
	{
		return CheckoutButton.getText();
	}
	
	public void Checkoutbutton()
	{
		if(CheckoutButton.isEnabled()==true)
		{
			CheckoutButton.click();
		}
	}
	
	
	
}
