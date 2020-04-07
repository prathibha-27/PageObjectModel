package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//PageFactory - OR;
	
	
	@FindBy(name="username")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement passWord;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement login;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	private WebElement signUpButton;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	private WebElement crmLogo;
	
	//initializing page object
	public LoginPage() 
	{
		PageFactory.initElements(driver,this);//initialize elements, this is pointing to current class object
	}
	
	//Action
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean validateCrmImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage Login(String un, String pw)
	{
		userName.sendKeys(un);
		passWord.sendKeys(pw);
		login.click();
		
		return new HomePage();
		
	}
	
	
	
}
