package Test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	// @BeforeClass
	// public void befoclass() {
	// System.out.println("Before executing any method in the class");
	// }


	@Test()
	@Parameters({ "URL", "APIKey" })
    public void Weblogincarloan(String URL, String APIKey) {
		System.out.println("Weblogincar");
		System.out.println(URL);
		System.out.println(APIKey);

	}

	@AfterClass
	public void afteclas() {
		System.out.println("After executing any method in the class");
	}

	@BeforeSuite
	public void Bfsuite() {
		System.out.println("I am no 1");
	}

	@AfterSuite
	public void Asuite() {
		System.out.println("I am no the last no 1");
	}

	public void Bmethod() {
		System.out.println("Be bo la con cho thui");
	}

	@AfterMethod
	public void Amethod() {
		System.out.println("be bo ngu ngoc nen moi yeu anh Lam");
	}

	@Test(groups = { "Smoke" })
	public void Mobilelogincarloan() {
		System.out.println("Mobilelogincar");

	}

	@Test(dependsOnMethods = { "Weblogincarloan" })
	public void LoginAPIcarloan() {
		System.out.println("LoginAPIcar");
	}

	@Test(dataProvider = "getData")
	public void addThem(String username, String password) {
		System.out.println("ADD them cai gi khong biet nua");
		System.out.println(username);
		System.out.println(password);

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "firstsetusername";
		data[0][1] = "password";
		data[1][0] = "secondsetusername";
		data[1][1] = "secondpassword";
		data[2][0] = "thrirdsetusername";
		data[2][1] = "thirdpassword";
		return data;
	}

}
