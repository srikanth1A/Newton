package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RiskPage extends DesktopBasePage {
	
	@FindBy(xpath = "//*[@id='app-top']/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div/button[1]")
	WebElement Conservative;
	
	@FindBy(xpath = "//*[@id='app-top']/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div/button[2]")
	WebElement moderatelyConservative;
	
	@FindBy(xpath = "//*[@id='app-top']/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div/button[3]")
	WebElement moderatelyAggressive;
	
	@FindBy(xpath = "//*[@id='app-top']/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div/button[4]")
	WebElement Aggressive;
	
	@FindBy(xpath = "//button[contains(text(),'ABOUT RIGHT')]")
	WebElement right;
	
	@FindBy(xpath = "//button[@class='common-button advisor-next-button primary']")
	WebElement almost;
	
	@FindBy(xpath = "//button[@class='common-button skip-button primary']")
	WebElement skip;
	
	
	public RiskPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void clickConservative() {
		try {
		jsClick(Conservative);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickmoderatelyConservative() {
		try {
		jsClick(moderatelyConservative);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickmoderatelyAggressive() {
		try {
		jsClick(moderatelyAggressive);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickAggressive() {
		try {
		jsClick(Aggressive);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickThatsAboutRight() {
		try {
		jsClick(right);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	public void clickAlmost() {
		try {
		jsClick(almost);
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

}
