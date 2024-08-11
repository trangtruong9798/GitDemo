
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowActivities {
public static void main(String[] args) {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://www.google.com");
	driver.navigate().to("https://rahulshettyacademy.com/");
	driver.navigate().back();
}
}
