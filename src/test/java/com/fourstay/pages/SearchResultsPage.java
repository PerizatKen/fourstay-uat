package com.fourstay.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class SearchResultsPage {
	public SearchResultsPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = ".col-md-12>p")
	public List<WebElement> allStates;

}
