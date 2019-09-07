package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class OurSuggestionsPage extends DesktopBasePage {
	
	@FindBy(xpath = "//span[text()='Change my preference']")
	WebElement myPreference;

	public OurSuggestionsPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
	}
	
	public void clickMyPreference() {
		jsClick(myPreference);
	}
	
	public boolean checkrecommendationSummeryScreen() {
		return isElementDisplayed(myPreference);
	}

}
