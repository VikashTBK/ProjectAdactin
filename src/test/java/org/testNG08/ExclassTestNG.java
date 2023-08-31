package org.testNG08;

import java.util.Date;

import org.base.BassClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.page.PageClassTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExclassTestNG extends BassClass {
	public static PageClassTest p = new PageClassTest();

	// launch the browser
	@Test
	private void tc01() {
		getDriver("Chrome", "http://adactinhotelapp.com/");

		Date d = new Date();
		System.out.println("browser launched on " + d);

	}
	@Parameters({ "username", "password" })
	@Test
	private void tc02(String user, String pass) {
		try {
			p = new PageClassTest();
// user name
			WebElement userName = p.getUserName();
			Assert.assertEquals(true, userName.isDisplayed());
			enterText(userName, user);

// Password
			WebElement password = p.getPassword();
			if (password.isDisplayed())
				enterText(password, pass);

			System.out.println("valid credential");

// login
			p.getLogin().click();

		} catch (Exception e) {
			System.out.println("login failed ");
		}

	}

	@Test
	private void tc03() {

		p = new PageClassTest();

		try {
			Date d = new Date();
			
			System.out.println("booking details " + d);
			WebElement location = locaterId("location");
			byIndex(location, 6);
			   
			    WebElement hotels = locaterName("hotels");
			    byText(hotels, "Hotel Sunshine");
			    
			    WebElement room = locaterId("room_type");
			    byValue(room, "Super Deluxe");
			    
			    WebElement roomNos = locaterId("room_nos");
			    byValue(roomNos, "2");
			    
			    WebElement checkInDate = locaterId("datepick_in");
			    checkInDate.clear();
      		    enterText(checkInDate, "10/06/2023");
      		    WebElement checkOutDate = locaterId("datepick_out");
      		    checkOutDate.clear();
      		    enterText(checkOutDate, "20/06/2023");

      		    WebElement adultroom = locaterId("adult_room");
      		    byValue(adultroom, "4");
      		    WebElement childroom = locaterId("child_room");
      		    byValue(childroom, "1");
      		    
      		    locaterId("Submit").click();
      		    
      		    System.out.println("valid booking details passed:" + d);
		
		} catch (Exception e) {
			System.out.println("invalid details ");
		}
	}

	@Test
	private void tc04() {

		p = new PageClassTest();

		try { 
			Date d = new Date();
			System.out.println("radio:" + d);
			//radio
			WebElement radiobutton = locaterId("radiobutton_0");
		    radiobutton.click();
		    locaterId("continue").click();
		    
		    // to enter the final credential 
		    WebElement firstame = locaterId("first_name");
		    enterText(firstame, "Vikash");
		    WebElement lastName = locaterId("last_name");
		    enterText(lastName, "TBK");
		    WebElement address = locaterId("address");
		    enterText(address, "7/369 St. Georges Homes Ketti The Nilgiris- 643215");
		    
		    WebElement ccNo = locaterId("cc_num");
		    enterText(ccNo, "1234567891012345");
		    WebElement ccType = locaterId("cc_type");
		    byValue(ccType, "AMEX");
		    WebElement ccExpMonth = locaterId("cc_exp_month");
		    byValue(ccExpMonth, "12");
		    WebElement ccExpYear = locaterId("cc_exp_year");
		    byValue(ccExpYear, "2030");
		    WebElement ccCvv = locaterId("cc_cvv");
		    enterText(ccCvv, "125");
		    
		    WebElement bookNow = locaterName("book_now");
	    bookNow.click();
	    
	    System.out.println("basic details passed:" + d);
			
		} catch (Exception e) {

			System.out.println("invalid details");
		}

	}

	@Test
	private void tc05() {



		 WebElement bookNow = locaterName("book_now");
		    bookNow.click();
	}

}
