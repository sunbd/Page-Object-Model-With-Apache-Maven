package com.hubspot.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hubspot.qa.utilites.Contants;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sun\\Desktop\\Naveen\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Contants.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Contants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		
		return driver;
		
	}
	
	public Properties  init_properties(){
		prop = new Properties();
		try{
			//FileInputStream ip = new FileInputStream(System.setProperty("user.dir","\\src\\main\\java\\com\\hubspot\\qa\\config\\File.config.Properties"));
			FileInputStream ip = new FileInputStream("C:\\Automation\\workspace\\NaveenPOMSession\\src\\main\\java\\com\\hubspot\\qa\\config\\File.config.Properties");
			prop.load(ip);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
