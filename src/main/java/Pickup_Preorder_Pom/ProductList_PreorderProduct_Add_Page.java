package Pickup_Preorder_Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ProductList_PreorderProduct_Add_Page 
{

	@FindBy(xpath="//div[@class='-card-container']")private WebElement Productlist_Details;
	@FindBy(xpath="//div[@class='-add-to-cart-container']")private WebElement Cart_button;
	@FindBy(xpath="//*[contains(text(),'Pre-order')]")private WebElement Add_PreorderProduct;
	
	@FindBy(xpath="//*[contains(text(),' Add to Snap Pass Order ')]")private WebElement Add_to_snap;
	@FindBy(xpath="//ion-tab-button[@tab='cart']")private WebElement Cart_footer_tab;
	
	
	
	public ProductList_PreorderProduct_Add_Page(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addtocart_button()
	{
		Cart_button.click();
	}
	
	public void addPreorderproduct()
	{
		Add_PreorderProduct.click();
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
