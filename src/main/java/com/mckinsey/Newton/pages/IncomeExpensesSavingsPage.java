package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class IncomeExpensesSavingsPage extends DesktopBasePage {
	
	@FindBy(xpath = "(//input[@class=' currency-input-field advisor-affordability-financial-details-input-field'])[1]")
	WebElement monthlyTakeHome;
	
	@FindBy(xpath = "(//input[@class=' currency-input-field advisor-affordability-financial-details-input-field'])[2]")
	WebElement monthlySpending;
	
	@FindBy(xpath = "(//input[@class=' currency-input-field advisor-affordability-financial-details-input-field'])[3]")
	WebElement cashSaving;
	
	@FindBy(xpath = "(//input[@class=' currency-input-field advisor-affordability-financial-details-input-field'])[4]")
	WebElement bigExpenses;
	
	@FindBy(xpath = "(//button[contains(text(),'ABOUT RIGHT')])[1]")
	WebElement thatsAboutRight;
	
	@FindBy(xpath = "//div[@class='advisor-affordability-financial-details-calculator-link-button']")
	WebElement helpmecaluclator;
	
	@FindBy(id = "advisor-financial-modal-contact-button")
	WebElement contactOurAdviser;

	public IncomeExpensesSavingsPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public boolean iscontactOurAdviserDisplayed() {
		try{
			return contactOurAdviser.isDisplayed();
		}catch(Exception e){
			return false;
		}
	}
	
	public void clickcontactOurAdviser() {
		jsClick(contactOurAdviser);
	}
	
	public void clickthatsAboutRight() {
		try {
		jsClick(thatsAboutRight);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void isaboutRightDisabled() {
		isElementDisabled(thatsAboutRight);
	}
	
	public void isaboutRightEnabled() {
		isElementEnabled(thatsAboutRight);
	}
	
	public void entermonthlyTakeHome(String strmonthlyTakeHome) {
		try {
		sendKeys(monthlyTakeHome, "Monthly Take Home", strmonthlyTakeHome);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public String getMonthlyTakeHome() {
		return monthlyTakeHome.getAttribute("value").replace(",", "");
	}
	
	public boolean isMonthlyTakeHomeDisplayed() {
		return isElementDisplayed(monthlyTakeHome);
	}
	
	
	
	public void entermonthlySpending(String strmonthlySpending) {
		try {
		sendKeys(monthlySpending, "Monthly Spending", strmonthlySpending);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isMonthlySpendingDisplayed() {
		return isElementDisplayed(monthlySpending);
	}
	public String getMonthlySpending() {
		return monthlySpending.getAttribute("value").replace(",", "");
	}
	
	public void entercashSaving(String strcashSaving) {
		try {
		sendKeys(cashSaving, "Cash Saving", strcashSaving);	
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isCashSavingsDisplayed() {
		return isElementDisplayed(cashSaving);
	}
	public String getCashSavings() {
		return cashSaving.getAttribute("value").replace(",", "");
	}
	
	public void enterbigExpenses(String strbigExpenses) {
		try{
		sendKeys(bigExpenses, "Big Expenses", strbigExpenses);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isBigExpenseDisplayed() {
		return isElementDisplayed(bigExpenses);
	}
	public String getbigExpenses() {
		return bigExpenses.getAttribute("value").replace(",", "");
	}
	
	public void clickHealpMeCalu() {
		try {
		jsClick(helpmecaluclator);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}

}
