package Pom_package.Snap_Kitchen;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Demo1 
{
  
	@Test
	public void desiredcap_set() throws Throwable
	{
	                
	                
	                DesiredCapabilities capabilities = new DesiredCapabilities();
	                capabilities.setCapability("automationName", "UiAutomator2");
	                capabilities.setCapability("platformName", "Android");
	                capabilities.setCapability("deviceName", "Mark");
	                capabilities.setCapability("app", "C:\\Users\\Admin\\Desktop\\Get Prado Apk\\Snap App-6-Nov .apk");
	          
	                URL url=new URL("http://127.0.0.1:4723");
	                AppiumDriver driver = new AndroidDriver(url,capabilities);
	                
	                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	                
	                
	                
	                Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
	                System.out.println(contextNames.size());
	                for (String contextName : contextNames) 
	                {
                      System.out.println(contextName);
	                  if (contextName.contains("WEBVIEW_com.prado.snapapp"))
	                  {
                        ((SupportsContextSwitching) driver).context(contextName); 
	                  } 
	               }
	                
	                     
	                Thread.sleep(5000);
	                WebElement Login_Hyperlink = driver.findElement(By.xpath("//a[@id='alreadyHaveAccount-link']"));    
	                String text1 = Login_Hyperlink.getText();
	                Login_Hyperlink.click();
	                System.err.println(text1);
	          
	                
	                
	
	          
	
	       
	
	
     }
	
	
	
	
	
	
	
	
}	
	
	
	
	
	
