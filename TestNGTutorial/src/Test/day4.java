package Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class day4 {
	@Test
	public void Webloginhomeloan() {
		System.out.println("Webloginhome");
		
	}

	@Test(enabled=false)
	public void Mobileloginhomeloan() {
		System.out.println("Mobileloginhome");
		
	}
	@Test(timeOut=4000)
	public void LoginAPIhomeloan() {
		System.out.println("LoginAPIhome");
	}
}

