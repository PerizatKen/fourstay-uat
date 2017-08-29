package com.fourstay.step_definitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStepDef {

	HomePage homePage = new HomePage();

	@Given("^As user, I am  on the fourstay homepage$")
	public void as_user_I_am_on_the_fourstay_homepage() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
	}

	@Given("^I search my university Name$")
	public void i_search_my_university_Name() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);

		wait.until(ExpectedConditions.visibilityOf(homePage.title));
		homePage.schoolName.click();
		homePage.schoolName.sendKeys("George Mason University");

	}

	@Given("^I should be able select the move out date$")
	public void i_should_be_able_select_the_move_out_date() throws Throwable {
		homePage.moveOutBtn.click();
		homePage.moveOutDate.click();

	}

	@Then("^I should be able to see the result$")
	public void i_should_be_able_to_see_the_result() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);
		homePage.search.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.listLink));
		homePage.listLink.isDisplayed();

	}

	@Then("^I should be able select the move in date$")
	public void i_should_be_able_select_the_move_in_date() throws Throwable {
		homePage.moveInBtn.click();

	}

	@When("^I click beds button,I should be able select the quantity of bed$")
	public void i_click_beds_button_I_should_be_able_select_the_quantity_of_bed() throws Throwable {
		homePage.Beds.click();
		homePage.bedsQuantity.click();

	}

}
