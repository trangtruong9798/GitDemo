package trangacademy.trangselenium.pageobjects;

import org.testng.annotations.Test;



import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Trang.Testcomponent.BaseTest;
import Trang.Testcomponent.Retry;
import trangacademy.trangselenium.pageobjects.LandingPage;
@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
public class ErrorValidation extends BaseTest {
	public void LoginErrorValidation() throws IOException, InterruptedException {

	
		String productName = "ZARA COAT 3";
		
		landingPage.loginApplication("trangtruong9798@gmail.com", "123");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
		
		
	}
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		LandingPage landingPage = launchApplication();

		launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication("trangtruong9798@gmail.com", "P@ssw0rd");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.gotToCheckOutPage();
		checkoutPage.selectCountry("india");

		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();

		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}


}
