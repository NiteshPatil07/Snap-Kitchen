package Utility_Package;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;


import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;


import Browser_Package.DesiredCap_Setting;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import net.bytebuddy.utility.RandomString;

public class Utility_Class extends DesiredCap_Setting
{
  
    
	public  void screenshot(AppiumDriver driver) throws Throwable
	{

		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String rstring = RandomString.make(); 		
		 File dest=new File("./Screenshots/"+rstring+".PNG");
	     FileHandler.copy(source, dest);
	     
	}
		
	public void Scroll_To_Option(AppiumDriver driver)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new Uiscrollable(new UiSelector()).ScrollIntoview(text(\"Bison Quinoa Bowl with Peppers & Onions\"));"));
	}
	
	public void scrollAndClick(AppiumDriver driver) 
	{
	     
	 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
	 		+ "instance(0)).scrollIntoView(new UiSelector().textContains(\"Chicken Biryani with Ginger Raita Cream\").instance(0))")).click();
	        
	
	}

  
    
    public void Capturescreenshot(AppiumDriver driver ,String filename) throws Throwable
	{

		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		
		 File dest=new File("./Screenshots/"+filename);
	     FileHandler.copy(source, dest);
   
	}
    
	
}
