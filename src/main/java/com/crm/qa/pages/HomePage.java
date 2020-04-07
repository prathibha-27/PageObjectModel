package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	private WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	private WebElement newContactLink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	private WebElement tasksLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	private WebElement dealsLink;
	
	//initializing page object
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String VerifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	
	public TasksPage clickOnTaskLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions act=new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	
		
	}

}
