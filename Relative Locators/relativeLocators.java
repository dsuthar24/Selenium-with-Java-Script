package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Without import this package it relative locators can not invoke.
// It can not be import through normal method or hovering cursor because this package is Static.

import static org.openqa.selenium.support.locators.RelativeLocator.*;



public class relativeLocators {

public static void main(String[] args) {

		// TODO Auto-generated method stub
		// For Selenium Relative locators 
	
		// Generic Syntax for relative locators 
	
		//driver.findElement(withTagName("").above(WebElement)
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\14372\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
		
		//driver.findElement(withTagName("").above(WebElement)
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		
		//driver.findElement(withTagName("").below(WebElement)
		
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
		WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		
		//driver.findElement(withTagName("").toLeftof(WebElement)
		
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		
		//driver.findElement(withTagName("").toRightof(WebElement)
		
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());

}

}

