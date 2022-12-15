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
		List<Object>price;
		
		//6) Scan the veg column and get text -> Rice -> print the price of the Rice
		do

		{List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		price = rows.stream().filter(s -> s.getText().contains("Rice"))
				.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a -> System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);
	}

	private static Object getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

	
}