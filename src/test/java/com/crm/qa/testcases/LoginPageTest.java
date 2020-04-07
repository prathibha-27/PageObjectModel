package com.crm.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase 
{
	public WebDriver driver;
	LoginPage lp;
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		 initialization();
		lp=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() throws InterruptedException
	{
		String title = lp.validateLoginPageTitle();
		Thread.sleep(3000);
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}//title,"CRMPRO  - CRM software for customer relationship management, sales, and support."
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean flag=lp.validateCrmImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		lp.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}
