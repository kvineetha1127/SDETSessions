package com.SDETSessions.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.SDETSessions.pageObjects.LoginPage;

public class TC_LoginTest_01 extends BaseClass
{
	@Test
	public void loginTest()
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered the user name "+username+" in the edit box");
		lp.setPassword(password);
		logger.info("Enter the password "+password+"in the edit box");
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Logged in to the application successfully");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login failed");
		}
	}
}
