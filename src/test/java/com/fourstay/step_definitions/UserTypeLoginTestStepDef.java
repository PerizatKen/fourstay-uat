package com.fourstay.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserTypeLoginTestStepDef {

	HomePage homePage = new HomePage();

	@Given("^I am on the fourstay homepage$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {

		Driver.getInstance().get(ConfigurationReader.getProperty("url"));

	}

	@When("^I login as a host$")
	public void i_login_as_a_host() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".not-login")));
		homePage.loginLink.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		homePage.email.sendKeys(ConfigurationReader.getProperty("host.username"));

		// Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(homePage.password));
		homePage.password.sendKeys(ConfigurationReader.getProperty("host.password"));

		// Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(homePage.loginEnter));
		homePage.loginEnter.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='user-name ng-binding']")));
		System.out.println("This is a host's account: " + homePage.accountHolderName.getText());

	}

	@Then("^I should be able verify I am logged in$")
	public void i_should_be_able_verify_I_am_logged_in() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);

		wait.until(ExpectedConditions.urlContains("dashboard"));
		Assert.assertTrue(Driver.getInstance().getCurrentUrl().contains("dashboard"));

	}

	@When("^I login as a guest$")
	public void i_login_as_a_guest() throws Throwable {

		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".not-login")));
		homePage.loginLink.click();

		// Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

		homePage.email.sendKeys(ConfigurationReader.getProperty("guest.username"));

		wait.until(ExpectedConditions.visibilityOf(homePage.password));
		homePage.password.sendKeys(ConfigurationReader.getProperty("guest.password"));

		wait.until(ExpectedConditions.visibilityOf(homePage.loginEnter));
		homePage.loginEnter.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='user-name ng-binding']")));
		System.out.println("This is a host's account: " + homePage.accountHolderName.getText());

	}

}
