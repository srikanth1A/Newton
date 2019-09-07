package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class RetirementLifeStyle extends DesktopBasePage{
	
	@FindBy(xpath = "//*[@id=\"modal\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/span[2]")
	WebElement spentAmount;
	
	@FindBy(id = "advisor-retirement-calculator-modal-submit-button")
	WebElement submit;
	
	@FindBy(xpath = "//*[@id=\"modal\"]/button/svg")
	WebElement x;
	
	public RetirementLifeStyle(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isspentAmountDisplayed() {
		return isElementDisplayed(spentAmount);
	}
	
	public String getAmount() {
		return spentAmount.getText();
	}
	
	public void clickSubmit() {
		jsClick(submit);
	}
	
	public void clickX() {
		jsClick(x);
	}
	

}
