package org.testNG08;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNgBase {

	@Test(priority=-2)
	private void tc01() {

		System.out.println("Test passed-1");
	}
@Parameters({"username","password"})
	@Test(priority=1, invocationCount= 10)
	private void tc02(String user, String pass) {
		System.out.println(user);
		System.out.println(pass);
	}

	@Test(priority=3)
	private void tc03() {

		System.out.println("Test passed-3");
	}

	@Test(priority= 2, enabled = false)
	private void tc04() {

		System.out.println("Test passed-4");
	}

	@Test(priority=5)
	private void tc05() {

		System.out.println("Test passed-5");
	}
}
