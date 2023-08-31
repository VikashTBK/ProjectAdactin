package org.test;

import java.util.Date;

import org.base.BassClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.page.PageClassTest;

public class TestingClass extends BassClass {
	public static PageClassTest p = new PageClassTest();

	@BeforeClass
	public static void tc01() {

		try {
			getDriver("Chrome", "http://adactinhotelapp.com/");

			Date d = new Date();
			System.out.println("browser launched on " + d);
			p = new PageClassTest();
			// user name
			WebElement userName = p.getUserName();
			Assert.assertEquals(true, userName.isDisplayed());
			enterText(userName, readTheExcelDatas(1, 0));

			// Password
			WebElement password = p.getPassword();
			if (password.isDisplayed())
				enterText(password, readTheExcelDatas(1, 1));

			System.out.println("valid credential");

			// login
			p.getLogin().click();

			System.out.println("login is succesfull on  " + d);

		} catch (Exception e) {

			System.out.println("invalid login");
		}

		
	}

	@Before
	public void tc02() {
		System.out.println();

	}

	@Test
	public void tc03() {
		p = new PageClassTest();

		try {
			Date d = new Date();
			
			System.out.println("booking details " + d);
			WebElement location = locaterId("location");
			byIndex(location, 6);
			
			WebElement hdgd = locaterId("kudftfk");
			byIndex(hdgd, 2);
			   
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

	@After
	public void tc04() {
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
	    buttonclick(bookNow);
	    
	    System.out.println("basic details passed:" + d);
			
		} catch (Exception e) {

			System.out.println("invalid details");
		}
	}

	@AfterClass
	public static void tc05() {
		
		Date d = new Date();
		
		 WebElement bookNow = locaterName("book_now");
		    bookNow.click();
		    
		    System.out.println("Test completed:" + d);
		    
	}

}
