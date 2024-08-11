import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Testing {
	 public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	 WebDriver driver = new ChromeDriver(options);
	driver.get("https://rahulshettyacademy.com");	
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	}
	}



