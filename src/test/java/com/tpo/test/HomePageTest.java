package com.tpo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {

	WebDriver driver;
	@Test(priority = 1)
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\target\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
	}
	@Test(priority = 2)
	public void searchResult()
	{
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\'twotabsearchtextbox\']"));
		searchBox.sendKeys("iphone" + Keys.ENTER);
	}
	
	@Test(priority = 3)
	public void validateResult()
	{
      WebElement ip = driver.findElement(By.xpath("//*[contains(text(),'Apple iPhone SE 2nd Generation, US Version, 64GB, Black - Unlocked (Renewed)')]"));
      String s=ip.getText();
      String finalString=s.substring(0, 12);
      Assert.assertEquals(finalString, "Apple iPhone");;
	}
	
	@Test(priority = 4)
	public void closeBrowser()
	{
		driver.quit();
	}
}
