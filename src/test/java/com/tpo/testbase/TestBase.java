package com.tpo.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties property;
	public static FileInputStream fis;
	@BeforeSuite(enabled=true)
	public void beforeSuite() {
		RestAssured.baseURI = "https://reqres.in/";
	}
	public Properties getPropertyData()
	{
		property = new Properties();
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\com\\tpo\\config\\config.properties");
			try {
				property.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return property;	
	}
	
	  @AfterSuite public void closeDriver() { driver.close(); }
	 
}

