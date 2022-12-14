package tests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class javaStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\14372\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		//1) Click on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//2) Capture all WebElements into List
		List<WebElement> elementsList =driver.findElements(By.xpath("//tr/td[1]"));
		
		//3) Capture text from the WebElements list into new(Original)list
		List<String> originalList=elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//4) Sort in the list of Step3--> Sorted list
		List<String> sortredList =originalList.stream().sorted().collect(Collectors.toList());
		
		//5) Compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortredList));
		
		
	}

}
