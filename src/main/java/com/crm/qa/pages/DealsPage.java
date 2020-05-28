package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase
{
	
	@FindBy(xpath ="//button[contains(text(),'New')]")
	WebElement NewDeal;
	

	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public DealsPage ClickOnNewDeal()
	{
		NewDeal.click();
		return new DealsPage();
	}
	
	
	
	
	
	

}
