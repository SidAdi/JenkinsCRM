package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory
	@FindBy(name ="email")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath ="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath ="//a[contains(text(),'Sign Up')]")
	WebElement SignUpLink;
	
	@FindBy(xpath ="//a[contains(text(),'Forgot your password?')]")
	WebElement ForgotPasswordLink;
	
	@FindBy(xpath ="//a[contains(text(),'Classic CRM')]")
	WebElement ClassicCRMLink;
	
	@FindBy(xpath ="//div[contains(text(),'Login to')]")
	WebElement ClassicCRMText;
	
	@FindBy(xpath ="//div[contains(text(),'No Account? Registration takes only a few seconds?')]")
	WebElement SignUpText;
	
	
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidatePageTitle()
	{
		return driver.getTitle();
	}
	 
	public String ValidateSignUpText()
	{
		 return SignUpText.getText();
	}
	
	public String ValidateClassicCRMText()
	{
		return ClassicCRMText.getText();
	}
	
	public boolean ValidateSignUpLink()
	{
		return SignUpLink.isDisplayed();
	}
	public boolean ValidateForgetPasswordLink()
	{
		return ForgotPasswordLink.isDisplayed();
	}
	public boolean ValidateClassicCRMLink()
	{
		return ClassicCRMLink.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) throws InterruptedException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	

}
