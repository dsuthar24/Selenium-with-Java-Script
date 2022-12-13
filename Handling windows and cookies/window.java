import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\14372\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		//Handling windows with scripting 
		
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().fullscreen();
		System.out.println(driver.manage().window().getSize());
		
		// use java script to handle website cookies 
		
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("abcd");
		driver.manage().getCookies();
		
		
	}

}
