package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class EducationPlanningPage extends DesktopBasePage {

	@FindBy(xpath = "//*[@id=\"modal\"]/button")
	WebElement X;
	
	@FindBy(xpath = "//*[@id=\"advisor-child-education-revise-button\"]")
	WebElement revise;
	
	@FindBy(xpath = "//*[@id=\"advisor-child-education-progress-button\"]")
	WebElement generalsavings;
	
	public EducationPlanningPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
	}
	
	public void clickX() {
		jsClick(X);
	}
	
	public void clickRevise() {
		jsClick(revise);
	}
	
	public boolean isReviseDisplayed() {
		return isElementDisplayed(revise);
	}
	
	public void clickGeneralSavings() {
		jsClick(generalsavings);
	}
	
	public boolean isGeneralSavingsDisplayed() {
		return isElementDisplayed(generalsavings);
	}
}
