package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath ="//span[@class='user-display']")
	WebElement LoginNametxt;
	
	@FindBy(xpath ="//span[contains(text(),'Contacts')]")
	WebElement ContactLink;
	
	@FindBy(xpath ="//span[contains(text(),'Calendar')]")
	WebElement CalenderLink;
	
	@FindBy(xpath ="//span[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath ="//span[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean VerifyCorrectUserName()
	{
		return LoginNametxt.isDisplayed();
	}
	
	public ContactsPage ClickOnContactLink()
	{
		ContactLink.click();
		return new ContactsPage();
	}
	
	
	public CalenderPage ClickOnCalenderLink()
	{
		CalenderLink.click();
		return new CalenderPage();
	}
	
	public DealsPage ClickOnDealsLink()
	{
		DealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage ClickOnTasksLink()
	{
		TasksLink.click();
		return new TasksPage();
	}
	

}
