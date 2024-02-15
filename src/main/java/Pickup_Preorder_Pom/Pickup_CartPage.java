package Pickup_Preorder_Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Pickup_CartPage
{


	@FindBy(xpath="//div[@class='-banner']")private WebElement Disscount_banner;
	@FindBy(xpath="//div[@class='-caption -weekly-snap-pass']")private WebElement Cart_Type;
	@FindBy(xpath="//div[@class='-text']")private WebElement  Product;
	@FindBy(xpath="//div[@class='-quantity']")private WebElement ProductCount;
	@FindBy(xpath="//*[@class='-sticky-container']//button")private WebElement  CheckoutButton;
	
	@FindBy(xpath="//div[@class=\"-caption -weekly-snap-pass\"][1]")private WebElement CartPageSnapPasstag;
	@FindBy(xpath="//div[@class=\"-caption -weekly-snap-pass\"][2]")private WebElement PreorderTag;
	@FindBy(xpath="//div[@class=\"-quantity\"][1]")private WebElement Quantitybutton;
	
	@FindBy(xpath="	//button[@class=\"button border-gray-background-white-icon-black full-width instock-items"
			+ " -instock-button\"]")private WebElement InstockButton;
	
	
	public Pickup_CartPage(AndroidDriver driver)
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
	
	public String GetSnapPasstag()
	{
	    return CartPageSnapPasstag.getText();	
	}
	
	public String GetPreorderTag()
	{
		return PreorderTag.getText();
	}
	
	public void clickonQuantitybutton()
	{
	  Quantitybutton.click();
	}
	
	public void clickonInStockButton()
	{
		InstockButton.click();
	}
		
	public void Checkoutbutton()
	{
		if(CheckoutButton.isEnabled()==true)
		{
			CheckoutButton.click();
		}
	}
}
