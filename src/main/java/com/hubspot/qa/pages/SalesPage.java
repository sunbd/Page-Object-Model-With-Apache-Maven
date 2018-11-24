package com.hubspot.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesPage extends BasePage{
	
	@FindBy(xpath ="//span[text()='Create deal']")
	WebElement createDealBtn;
	
	@FindBy(id = "uid-ctrl-1")
	WebElement dealName;
	
	@FindBy(id = "uid-ctrl-4")
	WebElement amountNumber;
	
	@FindBy(xpath = "//span[text()='Create']")
	WebElement createSecondBtn;
	
	public SalesPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNewDeal(String dealname, String amountnumber){
		WebDriverWait wait =new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createDealBtn));
		createDealBtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(dealName));
		dealName.sendKeys(dealname);
		
		wait.until(ExpectedConditions.elementToBeClickable(amountNumber));
		amountNumber.sendKeys(amountnumber);
		
		wait.until(ExpectedConditions.elementToBeClickable(createSecondBtn));
		createSecondBtn.click();
	}
	

}
