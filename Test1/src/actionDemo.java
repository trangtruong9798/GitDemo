import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class actionDemo {
public static void main (String [] arg) {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(options);
	driver.get("https://www.amazon.com/?&tag=googleglobalp-20&ref=pd_sl_7nnedyywlk_e&adgrpid=159651196451&hvpone=&hvptwo=&hvadid=675114638367&hvpos=&hvnetw=g&hvrand=1093491299341089526&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9047170&hvtargid=kwd-10573980&hydadcr=2246_13468515");
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).
			pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id='nav-link-accountList']")));
	
	WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
	Actions a= new Actions(driver);
	a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
	//a.moveToElement(null)
	a.moveToElement(move).contextClick().build().perform();
}

}
