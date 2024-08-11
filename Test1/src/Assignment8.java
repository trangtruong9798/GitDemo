import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;

public class Assignment8 {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
            "D:\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement autocompleteField = driver.findElement(By.id("autocomplete"));

        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(2000);

        List < WebElement > dropdownlist = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
        System.out.println(dropdownlist.size());
        // Store the text of each suggestion in a list
        List < String > suggestionTexts = new ArrayList < > ();
        for (WebElement suggestion: dropdownlist) {
            String suggestionText = suggestion.getText();
            suggestionTexts.add(suggestionText);
            System.out.println(suggestionText);

        }

        for (int j = 0; j < dropdownlist.size(); j++) {
            autocompleteField.sendKeys(Keys.DOWN);
            Thread.sleep(500);
            String currentValue = driver.findElement(By.id("autocomplete")).getAttribute("value");
            System.out.println("Value after Keys.DOWN " + (j + 1) + ": " + currentValue);
            Assert.assertEquals(suggestionTexts.get(j), currentValue, "Value did not match expected suggestion.");
        }
    }
}