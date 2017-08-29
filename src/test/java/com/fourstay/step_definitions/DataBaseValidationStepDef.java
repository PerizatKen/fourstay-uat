package com.fourstay.step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.fourstay.pages.GeneralAccountPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.DBUtility;
import com.fourstay.utilities.DBUtility.DBType;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataBaseValidationStepDef {
	WebDriver driver = Driver.getInstance();
	HomePage homePage = new HomePage();
	UserAccountPage userAccountPage = new UserAccountPage();
	GeneralAccountPage generalAccountPage = new GeneralAccountPage();
	String actualName, expectedFirstName;
	String actualLastName, expectedLastName;
	String actualEmail, expectedEmail, capturedEmail;
	String actualPhoneNumber, expectedPhoneNumber;

	@When("^I am entering \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_am_entering_and(String emailFromExamples, String passworFromExamples) throws Throwable {
		Thread.sleep(2000);
		homePage.email.sendKeys(emailFromExamples);
		// sking@testmail.com

		capturedEmail = emailFromExamples.split("@")[0];
		homePage.password.sendKeys(passworFromExamples);
	}

	@When("^I click login button$")
	public void i_click_login_button() throws Throwable {
		homePage.loginLink.click();
	}

	@When("^I click Edit Profile$")
	public void i_click_Edit_Profile() throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(userAccountPage.picture).perform();
		userAccountPage.picture.click();
		Thread.sleep(1000);
		userAccountPage.editProfile.click();
	}

	@When("^I capture first n, last n, email, phone$")
	public void i_capture_first_n_last_n_email_phone() throws Throwable {

		actualName = generalAccountPage.accountFirstN.getAttribute("value");
		actualLastName = generalAccountPage.accountLastN.getAttribute("value");
		actualEmail = generalAccountPage.accountEmail.getAttribute("value");
		actualPhoneNumber = generalAccountPage.accountPhone.getAttribute("value");
		System.out.println("First Name: " + actualName + '\n' + "Last Name: " + actualLastName + '\n' + "Email: "
				+ actualEmail + '\n' + "Phone: " + actualPhoneNumber);

	}

	@When("^I connect database and capture first n, last n, email, phone$")
	public void i_connect_database_and_capture_first_n_last_n_email_phone() throws Throwable {

		String query = "Select first_name, last_name, phone_number, lower(email) from employees";
		DBUtility.establishConnection(DBType.MYSQL);
		List<String[]> databaseValues = DBUtility.runSQLQuery(query);
		DBUtility.closeConnections();

		for (int i = 0; i < databaseValues.size(); i++) {
			if (databaseValues.get(i)[3].equals(capturedEmail)) {
				// abade sking
				expectedFirstName = databaseValues.get(i)[0];
				expectedLastName = databaseValues.get(i)[1];
				expectedPhoneNumber = databaseValues.get(i)[2].replace(".", "");
				expectedEmail = databaseValues.get(i)[3] + "@testmail.com";
			}
			// sking
			// System.out.println(expectedEmail);
		}
	}

	@Then("^Verify the info from UI and DB are the same$")
	public void verify_the_info_from_UI_and_DB_are_the_same() throws Throwable {
		Assert.assertEquals(actualName, expectedFirstName);
		Assert.assertEquals(actualLastName, expectedLastName);
		Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);
		Assert.assertEquals(actualEmail, expectedEmail);
	}

}
