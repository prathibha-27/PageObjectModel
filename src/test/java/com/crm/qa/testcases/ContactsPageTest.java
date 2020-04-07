package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage lp;
	HomePage  hp;
	TestUtil testutil;
	ContactsPage contact;
	String sheetName="Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testutil=new TestUtil();
		lp=new LoginPage();
		hp=new HomePage();
		contact=new ContactsPage();
		hp=lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contact =hp.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest()
	{
		Assert.assertTrue(contact.verifyContactsLabel(),"Contacts");
		//Assert.assertTrue(contact.verifyContactsLabel(), "Contacts");
		
	}
	
	@Test(priority=2)
	public void selectSingleContactNameTest()
	{
		contact.selectContactByName("Aakash Shah");
	}
	
	@Test(priority=3)
	public void selectMultipleContactNameTest() throws InterruptedException
	{
		contact.selectContactByName("Aakash Shah");
		contact.selectContactByName("A30 ydv");
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String Title, String FirstName,String LastName, String Company)
	{
		hp.clickOnNewContactLink();
		//contact.createNewContact("Miss", "Prathibha", "P", "Google");
		contact.createNewContact(Title, FirstName, LastName, Company);
	}
	
	

	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
