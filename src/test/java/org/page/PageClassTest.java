package org.page;

import org.base.BassClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClassTest extends BassClass {
	public PageClassTest() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "login")
	private WebElement login;

	public WebElement getUserName() {
		return userName;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLogin() {
		return login;
	}

	public void setUserName(WebElement userName) {
		this.userName = userName;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}
	
}
