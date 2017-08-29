package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class UserAccountPage {
	private WebDriver driver;

	public UserAccountPage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "h3.user-name")
	public WebElement accountHolderName;

	// write an xpath that matches the message element for both host and guest
	@FindBy(xpath = "//section/div/div/h3[@class='row zrl-margin headings-with-icon ng-binding']")
	public WebElement message;

	@FindBy(css = "li.nav-gravicon .dropdown-toggle")
	public WebElement picture;

	@FindBy(linkText = "Edit Profile")
	public WebElement editProfile;

}
