package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class HomePage {

	public HomePage() {

		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(id = "key")
	public WebElement password;

	@FindBy(id = "btn-login")
	public WebElement loginEnter;

	@FindBy(css = ".not-login")
	public WebElement loginLink;

	@FindBy(xpath = "//form[@id='login-form']//div/span")
	public WebElement incorrectPasswordMessage;

	@FindBy(id = "hLocName")
	public WebElement accountHolderPage;

	@FindBy(xpath = "//h3[@class='user-name ng-binding']")
	public WebElement accountHolderName;

	// @FindBy(xpath = "//input[@id='iLocName']")
	// public WebElement schoolName;

	@FindBy(xpath = "//input[@name='move_in']")
	public WebElement moveInBtn;

	@FindBy(xpath = "//div//td[@class='new day'][1]")
	public WebElement moveInDate;

	@FindBy(xpath = "//input[@name='move_out']")
	public WebElement moveOutBtn;

	@FindBy(xpath = "//tbody/tr[1]/td[7]")
	public WebElement moveOutDate;

	@FindBy(xpath = "//button[@id='themates']")
	public WebElement Beds;

	@FindBy(xpath = "//ul[@id='theoption']/li[2]")
	public WebElement bedsQuantity;

	// @FindBy(id = "search")
	// public WebElement searchBtn;

	@FindBy(xpath = "//h1[@class='title-page']")
	public WebElement title;

	@FindBy(linkText = "LIST YOUR STAY")
	public WebElement listLink;

	@FindBy(id = "iLocName")
	public WebElement schoolName;

	@FindBy(id = "rentoutfrom2")
	public WebElement startDate;

	@FindBy(id = "rentoutto2")
	public WebElement endDate;

	@FindBy(id = "search")
	public WebElement search;
}
