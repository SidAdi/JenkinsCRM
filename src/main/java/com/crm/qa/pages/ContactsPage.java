package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath ="//div[@class='ui header item mb5 light-black']")
	WebElement PhoneText;
	
	@FindBy(xpath ="//div[@class='ui fitted checkbox']//input")
	WebElement ContactsPageCheckBox;
	
	@FindBy(xpath ="//button[contains(text(),'New')]")
	WebElement ClickOnNewContact;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyContactPage()
	{
		return PhoneText.isDisplayed();
	}
	

	public ContactsPage ClickOnCheckBox()
	{
		ContactsPageCheckBox.click();
		return new ContactsPage();
	}
	
	public ContactsPage ClickOnNewContactLink()
	{
		ClickOnNewContact.click();
		return new ContactsPage();
		
	}

}
