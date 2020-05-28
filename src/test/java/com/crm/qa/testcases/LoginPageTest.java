package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		TestBase.initilization();
		 loginpage =new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.ValidatePageTitle();
		Assert.assertEquals(title,"Cogmento CRM");
	}
	
	@Test(priority =2)
	public void validateSignUpTest()
	{
		String signuptext =loginpage.ValidateSignUpText();
		Assert.assertEquals(signuptext, "No Account? Registration takes only a few seconds? Sign Up");
	}
	
	@Test(priority =3)
	public void validateCRMTest()
	{
		String CRMText =loginpage.ValidateClassicCRMText();
		Assert.assertEquals(CRMText, "Classic FreeCRM or CRMPro User? Login to Classic CRM");
	}
	@Test 
	public void ValidateSignUpLinkTest()
	{
		boolean flag =loginpage.ValidateSignUpLink();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void ValidateForgetPasswordLinkTest()
	{
		boolean flag=loginpage.ValidateForgetPasswordLink();
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void ValidateClassicCRMLinkTest()
	{
		boolean flag=loginpage.ValidateClassicCRMLink();
		Assert.assertTrue(flag);
	}
	
	@Test 
	public void loginTest() throws InterruptedException
	{
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
