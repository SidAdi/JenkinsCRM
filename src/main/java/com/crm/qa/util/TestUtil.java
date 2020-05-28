package com.crm.qa.util;

import java.io.IOException;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT =20;

	
	public void SwitchToFrame()
	{
	 driver.switchTo().frame("");
	}
	
	
	/*
	 * public static void takeScreenshotAtEndOfTest() throws IOException { File
	 * scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); String
	 * currentDir = System.getProperty("user.dir"); FileUtils.copyFile(scrFile, new
	 * File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png")); }
	 */
}
