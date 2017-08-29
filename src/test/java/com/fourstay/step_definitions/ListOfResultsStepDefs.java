package com.fourstay.step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ListOfResultsStepDefs {
	WebDriver driver;
	HomePage homePage = new HomePage();

	@Given("^Navigate to the home page of the fourstay application$")
	public void navigate_to_the_home_page_of_the_fourstay_application() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
	}

	@When("^Input search criteria, specify date in \"([^\"]*)\" and date out \"([^\"]*)\"$")
	public void input_search_criteria_specify_date_in_and_date_out(String arg1, String arg2) throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);

		wait.until(ExpectedConditions.visibilityOf(homePage.title));
		homePage.schoolName.click();
		homePage.schoolName.sendKeys("Tysons Corner Center");

		homePage.moveInBtn.click();
		homePage.moveInBtn.sendKeys("03/01/2018");
		homePage.moveOutBtn.click();
		homePage.moveOutBtn.sendKeys("03/02/2018");

		homePage.Beds.click();
		homePage.bedsQuantity.click();
		homePage.search.click();

	}

	@Then("^Result page should will give a list of stays that meet searching criteria$")
	public void result_page_should_will_give_a_list_of_stays_that_meet_searching_criteria() throws Throwable {

	}

}
