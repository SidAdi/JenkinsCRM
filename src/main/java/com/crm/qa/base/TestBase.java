package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;


public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	static FileInputStream ip;
	public static com.crm.qa.util.ExcelReader excel =new com.crm.qa.util.ExcelReader("C:\\Users\\sd25499\\eclipse-workspace\\FreeCRMTest\\src\\main\\resources\\FreeCRMTestData.xlsx");
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() 
	{
		prop =new Properties();
		//FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\sd25499\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initilization()
	{
		String BrowserName =prop.getProperty("browser");
	    if(BrowserName.equalsIgnoreCase("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\sd25499\\drivers\\chrome\\chromedriver.exe");
			driver=new ChromeDriver();
	    }
	    
	    e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	    
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    
	    driver.get(prop.getProperty("url"));
	
	}

}
