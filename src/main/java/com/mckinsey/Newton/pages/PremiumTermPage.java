package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PremiumTermPage extends DesktopBasePage {
	
	@FindBy(xpath = "//*[@id='affordability-protection-term-section']/div[3]/input")
	WebElement protectionYears;
	
	@FindBy(xpath = "//*[@id='affordability-savings-term-section']/div[3]/input")
	WebElement savingsYears;
	
	@FindBy(xpath = "(//button[text()='THIS IS MY RANGE'])[1]")
	WebElement range;
	
	@FindBy(xpath = "//button[text()='SKIP THIS FOR NOW']")
	WebElement skip;
	
	@FindBy(xpath = "//*[@id='modal-container']/div[2]/div/div/div[1]")
	WebElement warningPopup;
	
	@FindBy(id = "advisor-affordability-premium-term-progress-button")
	WebElement yesSure;
	
	@FindBy(id = "advisor-affordability-premium-term-revise-button")
	WebElement revise;

	public PremiumTermPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public void clickskip() {
		try {
		jsClick(skip);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickRange() {
		try {
		jsClick(range);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		//range.click();
	}
	
	public void enterProtectionYears(String strprotectionYears) {
		try {
		sendKeys(protectionYears, "PROTECTION YEARS", strprotectionYears);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}

	public void enterSavingsYears(String strSavingsYears) {
		try {
		sendKeys(savingsYears, "SAVINGS YEARS", strSavingsYears);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean iswarningPopupExists() {
		boolean bool;
		try {
			bool = warningPopup.isDisplayed();
		}catch(Exception e) {
			bool = false;
		}
		return bool;
		//return warningPopup.isDisplayed();
	}
	
	public void clickRevise() {
		try {
		jsClick(revise);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickYesSure() {
		try {
		jsClick(yesSure);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
}
