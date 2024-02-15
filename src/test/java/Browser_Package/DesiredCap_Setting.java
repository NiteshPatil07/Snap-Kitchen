package Browser_Package;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DesiredCap_Setting
{


	public static AndroidDriver driver;
	public static AppiumDriverLocalService Server;
	public UiAutomator2Options options;
	
    public static	URL url;
    public static DesiredCapabilities capabilities;
	
 
	public void Device_setup() throws Throwable 
	{
		
		Server= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
		Server.start();
		   
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Mark");
        capabilities.setCapability("app", "C:\\Users\\Admin\\Desktop\\Snap app files\\Snap app 17 Nov V2 (Last).apk");
        capabilities.setCapability("hideKeyboard", true);
     
        url=new URL("http://127.0.0.1:4723");
        
       driver = new AndroidDriver(url,capabilities);       
        driver.manage().timeouts().implicitlyWait(8000,TimeUnit.SECONDS);  
        

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
	
	
	
	
	
	
	
	public void Device_setup2() throws Throwable 
	{
		Server= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
				 Server.start();
				   
		   
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Mark");
        capabilities.setCapability("app", "C:\\Users\\Admin\\Desktop\\Snap app files\\Snap app 17 Nov V2 (Last).apk");
        capabilities.setCapability("hideKeyboard", true);
        url=new URL("http://127.0.0.1:4723");
        
       driver = new AndroidDriver(url,capabilities);       
        driver.manage().timeouts().implicitlyWait(8000,TimeUnit.SECONDS);  

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

	}	
}
