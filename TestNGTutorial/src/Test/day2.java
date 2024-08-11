package Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {
	@Test
	public void ThirdTest() {
		System.out.println("Mama");
		Assert.assertTrue(false);
	}
	@AfterTest
	public void after() {
		System.out.println("I will excute last");
	}
	@BeforeTest
	public void prerequiste() {
		System.out.println("I will execute first");
	}

}
