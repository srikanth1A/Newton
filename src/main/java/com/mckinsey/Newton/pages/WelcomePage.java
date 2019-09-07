package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WelcomePage extends DesktopBasePage{
	
	@FindBy(xpath = "//span[@class='checkmark']")
	WebElement confirm;
	
	@FindBy(id = "advisor-about-you-begin-progress-btn")
	WebElement LetsGo;
	
	@FindBy(xpath = "//div[text()='You are interested in:']")
	WebElement limitations;
	
	public WelcomePage(WebDriver driver, ExtentTest report) {
		super(driver, report);
	}
	
	public void clickConfirm() {
		try {
		jsClick(confirm);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		//confirm.click();
	}
	public void dontclickConfirm() {
		try {
		//jsClick(confirm);
		confirm.isSelected();
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickLetsGo() {
		try {
	jsClick(LetsGo);	
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void verifyConfirm() {
		try {
		isElementEnabled(confirm);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isLetsGoVisible() {
		return isElementDisplayed(LetsGo);
	}
	
	public boolean isConfirmVisible() {
		return isElementDisplayed(confirm);
	}
	
	public boolean isLimitationsVisible() {
		return isElementDisplayed(limitations);
	}

}
