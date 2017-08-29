package com.fourstay.step_definitions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchResultsPage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DisplayingUserInformationStepDefs {
	HomePage homePage = new HomePage();

	@Given("^I am on the fourstay login dialog$")
	public void i_am_on_the_fourstay_login_dialog() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));

		homePage.loginLink.click();

	}

	@Given("^I enter email \"([^\"]*)\"$")
	public void i_enter_email(String email) throws Throwable {
		Thread.sleep(2000);
		homePage.email.sendKeys(email);

	}

	@Given("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String password) throws Throwable {
		homePage.password.sendKeys(password);

	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		homePage.loginEnter.click();

	}

	@Then("^the user name should be \"([^\"]*)\"$")
	public void the_user_name_should_be(String expectedName) throws Throwable {
		BrowserUtilities.waitForPageLoad();
		UserAccountPage userAccountPage = new UserAccountPage();
		String actual = userAccountPage.accountHolderName.getText();
		Assert.assertEquals(expectedName, actual);
	}

	@Given("^I enter school name \"([^\"]*)\"$")
	public void i_enter_school_name(String school) throws Throwable {
		homePage.schoolName.sendKeys(school);

	}

	@Given("^I enter dates \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_dates_and(String start, String end) throws Throwable {
		homePage.moveInBtn.sendKeys(start);
		homePage.moveOutBtn.sendKeys(end);

	}

	@Given("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		homePage.search.click();
		Thread.sleep(5000);

	}

	@Then("^the results should contain$")
	public void the_results_should_contain(List<String> states) throws Throwable {
		BrowserUtilities.switchTabs("search");
		BrowserUtilities.waitForPageLoad();

		SearchResultsPage resultpage = new SearchResultsPage();
		Set<String> actualStates = new HashSet<>();

		for (WebElement element : resultpage.allStates) {
			actualStates.add(element.getText());
		}
		System.out.println(actualStates);
		Assert.assertTrue(actualStates.containsAll(states));
	}

	@When("^I enter this search criteria$")
	public void i_enter_this_search_criteria(List<Map<String, String>> searchCriteria) throws Throwable {
		Map<String, String> input = searchCriteria.get(0);
		homePage.schoolName.sendKeys(input.get("school"));
		homePage.schoolName.sendKeys(input.get("start"));
		homePage.schoolName.sendKeys(input.get("end"));
		homePage.search.click();

	}

}
