package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BudgetPage extends DesktopBasePage {

	@FindBy(xpath = "//*[@id='affordability-monthly-budget-section']/div[2]/div/input")
	WebElement recurringMonthlyAmount;
	
	@FindBy(xpath = "//*[@id='affordability-lumpsum-budget-section']/div[2]/div/input")
	WebElement oneTimeAmount;
	
	@FindBy(xpath = "(//button[text()='SKIP THIS FOR NOW'])[1]")
	WebElement skip;
	
	@FindBy(xpath = "(//button[text()='THIS IS MY BUDGET'])[1]")
	WebElement budget;
	
	public BudgetPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isNextDisplayed() {
		try {
			return skip.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void enterrecurringMonthlyAmount(String strrecurringMonthlyAmount) {
		try {
		sendKeys(recurringMonthlyAmount, "Recurring Monthly Amount", strrecurringMonthlyAmount);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isrecurringMonthlyAmountDisplayed() {
		return isElementDisplayed(recurringMonthlyAmount);
	}
	
	public void enteroneTimeAmount(String stroneTimeAmount) {
		try {
		sendKeys(oneTimeAmount, "One Time Amount", stroneTimeAmount);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickSkip() {
		try {
		jsClick(skip);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickBudget() {
		try {
		jsClick(budget);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}

}
