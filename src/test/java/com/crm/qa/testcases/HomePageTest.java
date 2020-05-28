package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		TestBase.initilization();
		testutil=new TestUtil();
		 contactspage=new ContactsPage();
		
		 loginpage =new LoginPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 
	}
	
    @Test(priority =1)
	public void VerifyHomePageTitle()
	{
		String homepagetitle=homepage.validateHomePageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM","Home Page Title not Matched");
	}
    
    @Test(priority =2)
    public void VerifyCorrectUserName()
    {
    	
    	boolean flag=homepage.VerifyCorrectUserName();
    	Assert.assertTrue(flag);
    }
    
    
    @Test(priority =3)
    public void VerifyClickOnContactLink()
    {
    	contactspage=homepage.ClickOnContactLink();
    	
    }
   
	
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
}
