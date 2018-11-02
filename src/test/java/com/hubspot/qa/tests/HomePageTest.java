package com.hubspot.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.qa.pages.BasePage;
import com.hubspot.qa.pages.HomePage;
import com.hubspot.qa.pages.LoginPage;
import com.hubspot.qa.utilites.Contants;

import bsh.org.objectweb.asm.Constants;

public class HomePageTest {
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeMethod
	public void setup(){
		
		basePage = new BasePage();
		driver = basePage.init();
		prop = basePage.init_properties();
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageHeaderTest(){
		Assert.assertEquals(homePage.checkhomePageHeader(),Contants.HOME_PAGE_HEADER);
	}
	
	@Test(priority=2)
	public void homePageTitleTest(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title Is: " + title);
		Assert.assertEquals(title, Contants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=3)
	public void accountNameTest(){
		String accountName = homePage.getLoggedInAccountName();
		System.out.println("Logged In User Account Name is: "+ accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
