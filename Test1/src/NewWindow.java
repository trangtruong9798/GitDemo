import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class NewWindow {
	public static void main(String[] arg) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
driver.get("https://rahulshettyacademy.com/angularpractice/");
driver.switchTo().newWindow(WindowType.TAB);// open a new blank tab

Set<String> handles = driver.getWindowHandles();
Iterator<String> it= handles.iterator();
String parentWindowId = it.next();
String childWindowId = it.next();
driver.switchTo().window(childWindowId);
driver.get("https://rahulshettyacademy.com/");
 String courseName =driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
 driver.switchTo().window(parentWindowId);
 driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
 //driver.quit();

}}
