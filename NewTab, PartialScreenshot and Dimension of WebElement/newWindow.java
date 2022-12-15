package tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class newWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\14372\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//invoking new windows or Switching to newTab and 
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles=driver.getWindowHandles();
		Iterator<String>it=handles.iterator();
		//Iteration of all available window tab 
		// count of all window and initialize it 
		
		String parentWindowId=it.next();
		String childWindowId=it.next();
		
		//switch to child tab from parents window tab 
		
		driver.switchTo().window(childWindowId);
		
		// send url to child window
		driver.get("https://rahulshettyacademy.com");
		
		// get 1st available course name from child window and get text and save it new variable 
		String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		//switch back to parent window tab and put the course name in name.
		driver.switchTo().window(parentWindowId);
		WebElement name =driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		

		//Screenshot

		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		//Get Height & Width
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		driver.quit();
	}

}
