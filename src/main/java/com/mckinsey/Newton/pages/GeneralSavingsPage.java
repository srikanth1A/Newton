package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GeneralSavingsPage extends DesktopBasePage {
	
	@FindBy(xpath = "//input[@class = ' currency-input-field undefined']")
	WebElement savingsAmount;
	
	@FindBy(xpath = "//input[@class = 'saving-needs-input-years-text-field']")
	WebElement savingsYears;
	
	@FindBy(xpath = "(//button[text()='MAKE THIS HAPPEN FOR ME'])[1]")
	WebElement makethisHappen;
	
	@FindBy(xpath = "//*[@id=\"app-top\"]/div[2]/div/div/div[2]/div[1]/div/div/div[1]/span/img")
	WebElement robo;
	
	public GeneralSavingsPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
	}
	
	public void entersavingsAmount(String strAmount) {
		try {
		sendKeys(savingsAmount, "SAVING AMOUNT", strAmount);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void entersavingsYears(String strYears) {
		try {
		sendKeys(savingsYears, "SAVING YEARS", strYears);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickMakethisHappen() {
		try {
		jsClick(makethisHappen);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void ismakethishappenDisabled() {
		isElementDisabled(makethisHappen);
	}
	
	public void ismakethishappenEnabled() {
		isElementEnabled(makethisHappen);
	}
	
	public boolean isSavingsAmountdisplayed() {
		return isElementDisplayed(savingsAmount);		
	}
	
	public boolean issavingsYearsDisplayed() {
		return isElementDisplayed(savingsYears);
	}
	
	public boolean isroboDisplayed() {
		return isElementDisplayed(robo);
	}

	public String getsavingYears() {
		return savingsYears.getAttribute("value");
	}

	public String getsavingsAmount() {
		return savingsAmount.getAttribute("value").replace(",", "");
	}
	
	public String getactualsavingsAmount() {
		return savingsAmount.getAttribute("value");
	}

}
