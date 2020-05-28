package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealPageTest  extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	DealsPage dealspage;
	
	public DealPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		TestBase.initilization();
		testutil = new TestUtil();
		dealspage = new DealsPage();

		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		dealspage = homepage.ClickOnDealsLink();

	}
	
	@Test(priority =1)
	public void ClickOnDealsLink()
	{
		dealspage=homepage.ClickOnDealsLink();
	}
	
	@Test(priority =2)
	public void ClickOnNewDeal()
	{
		dealspage.ClickOnNewDeal();	
	}
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName ="DealData";
		int rows =excel.getRowCount(sheetName);
		int cols =excel.getColumnCount(sheetName);
		
		Object[][] data =new Object[rows-1][cols];
		
		for(int rowNum =2;rowNum<=rows;rowNum++)
		{
			for (int colNum =0;colNum<cols;colNum++)
			{
				data[rowNum-2][colNum]=excel.getCellData(sheetName,colNum,rowNum);
			}
			
		}
		return data;
		
	}
	
	
	@AfterMethod
	public void quit() {
		//driver.quit();
	}
}
