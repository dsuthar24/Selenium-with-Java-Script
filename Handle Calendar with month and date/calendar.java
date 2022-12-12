import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\14372\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.airindia.in/");
		driver.findElement(By.cssSelector("div[id='id_1'] img[title='Date Picker']")).click();
		Thread.sleep(3000);
		// while will keep on executing until it is false
		while (!driver.findElement(By.cssSelector(".ui-datepicker-header.ui-widget-header.ui-helper-clearfix.ui-corner-right")).getText().contains("March"))
		{
		
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e"));
		}
		List<WebElement> dates = driver.findElements(By.className("ui-state-default"));

		// Grab the common attribute /put into the list and iterate

		int count = driver.findElements(By.className("ui-state-default")).size();

		for (int i = 0; i < count; i++)
		{
			String text = driver.findElements(By.className("ui-state-default")).get(i).getText();
			if (text.equalsIgnoreCase("21"))
			{
				driver.findElements(By.className("ui-state-default")).get(i).click();
				break;
			}
		}

	}

}
