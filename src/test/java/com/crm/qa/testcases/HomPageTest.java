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

public class HomPageTest extends TestBase
{
	LoginPage lp;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	public HomPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testutil=new TestUtil();
		lp=new LoginPage();
		homePage=lp.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.VerifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page Title is not matching");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test
	public void verifyContactsLinkTest()
	{
		testutil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
}
