package trangacademy.trangselenium.pageobjects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Trang.Testcomponent.BaseTest;
import trangacademy.trangselenium.pageobjects.CartPage;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		LandingPage landingPage = launchApplication();

		launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.gotToCheckOutPage();
		checkoutPage.selectCountry("india");

		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	// to verify Zara coat 3 is displaying in Oerder page
	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("trangtruong9798@gmail.com", "P@ssw0rd");
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		

		List <HashMap<String, String>> data = getJasonDataToMap(System.getProperty("user.dir")+ "\\src\\test\\java\\Trang\\data\\PurchaseOrder.json");
		
		return new Object [][] {{data.get(0)},{data.get(1)}};
	}
	
	
	//@DataProvider
	//public Object[][] getData(){
	//return new Object [][] {{"trangtruong9798@gmail.com","P@ssw0rd","ZARA COAT 3" },{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
//	HashMap<String, String> map = new HashMap<String, String>();
//	map.put("email","trangtruong9798@gmail.com");
//	map.put("password","P@ssw0rd");
//	map.put("product", "ZARA COAT 3");
//	
//	HashMap<String, String> map1 = new HashMap<String, String>();
//	map1.put("email","shetty@gmail.com");
//	map1.put("password","Iamking@000");
//	map1.put("product", "ADIDAS ORIGINAL");
	
	
//}
}
