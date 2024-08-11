import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//p[contains(text(),'You will be limited to only fewer functionalities')]")));
		System.out.println(driver
				.findElement(By.xpath("//p[contains(text(),'You will be limited to only fewer functionalities')]"))
				.getText());
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		driver.findElement(By.xpath("//select/option[3]")).click();
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		int j = 0;
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".navbar-brand")));
//		String[] itemsNeedded = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
//		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));
//		for (int i = 0; i <= products.size(); i++) {
//			List itemsNeededList = Arrays.asList(itemsNeedded);
//			if (itemsNeededList.contains(products)) {
//				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
//				j++;
//			}
//			if (j == itemsNeedded.length) {
//				break;
//			}
//		}
////		w.until(ExpectedConditions.elementToBeClickable(
////				By.xpath("//a[@class='nav-link btn btn-primary']")));
		
		List<WebElement> addButtons= driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		for (WebElement addButton: addButtons) {
			addButton.click();	
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		
		

	}
 
}
