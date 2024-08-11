import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//1.Give me the coount of links on the page	
	//a
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver = driver.findElement(By.cssSelector("div[id='gf-BIG']"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
	WebElement columndriver =	footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
	System.out.println(columndriver.findElements(By.tagName("a")).size());
	for (int i=0;i<columndriver.findElements(By.tagName("a")).size();i++) {
		String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
		Thread.sleep(5000L);}//open all the tabs
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it =abc.iterator();
		while (it.hasNext()){// hasNext: tell whether next index is present or not
	driver.switchTo().window(it.next());
	System.out.println(driver.getTitle());
	
	}
	
	}

}
