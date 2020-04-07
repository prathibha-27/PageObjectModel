package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;


public class ContactsPage extends TestBase
{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	private WebElement contactsLabel;
	
	@FindBy(name="title")
	private WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	 
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement save;
	
//	@FindBy(xpath="//a[text()='Aakash Shah']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
//	private WebElement checkBoxLink;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	
	public void createNewContact(String Title,String FirstName,String LastName,String Company)
	{
		Select sel=new Select(title);
		sel.selectByVisibleText(Title);
		
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		company.sendKeys(Company);
		save.click();
		
		
	}
}
