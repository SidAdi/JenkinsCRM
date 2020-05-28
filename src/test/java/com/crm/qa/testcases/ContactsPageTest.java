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

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		TestBase.initilization();
		testutil = new TestUtil();
		contactspage = new ContactsPage();

		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		contactspage = homepage.ClickOnContactLink();

	}

	@Test(priority = 1)
	public void VerifyContactsLabel() {
		boolean flag = contactspage.VerifyContactPage();
		Assert.assertTrue(flag, "contact page not found");
	}
	
	@Test(priority =2)
	public void ClickOnContactPgaeCheckBox()
	{
		contactspage.ClickOnCheckBox();
	}
	
	@Test(priority =3)
	public void ClickonnewContact()
	{
		contactspage.ClickOnNewContactLink();
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
