import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment7 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size() - 1;
		int columns =driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size();

		System.out.println("Number of rows: " + rows);
		System.out.println("Number of columns: " + columns);
		System.out.println(driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[2]/td[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[2]/td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[2]/td[3]")).getText());
	}
}