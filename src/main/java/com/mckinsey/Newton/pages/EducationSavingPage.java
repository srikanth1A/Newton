package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EducationSavingPage extends DesktopBasePage {	

	@FindBy(xpath = "//input[@placeholder='Age']")
	WebElement age;
	
	@FindBy(xpath = "//input[@class=' currency-input-field advisor-your-goals-child-education-input-field']")
	WebElement currency;
	
	@FindBy(xpath = "(//button[text()='NEXT'])[1]")
	WebElement next;
	
	@FindBy(xpath = "//*[@id=\"app-top\"]/div[2]/div/div/div[2]/div[1]/div/div/div[1]/span/img")
	WebElement robo;
	
	@FindBy(xpath = "//*[@id=\"app-top\"]/div[2]/div/div/div[2]/div[1]/form/div[2]/div[2]/div")
	WebElement errorlabel;
	
	public EducationSavingPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public void enterAge(String strAge) {
		try {
		sendKeys(age, "AGE", strAge);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isAgeDisplayed() {
		return isElementDisplayed(age);
	}
	
	public String getAge() {
		return age.getAttribute("value");
	}
	
	public void clearAge() {
		age.clear();
	}
	
	public void enterCurrency(String strCurrency) {
		try {
		sendKeys(currency, "CURRENCY", strCurrency);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clearCurrency() {
		currency.clear();
	}
	
	public boolean iscurrencyDisplayed() {
		return isElementDisplayed(currency);
	}
	
	public String getCurrency() {
		return currency.getAttribute("value").replace(",","");
	}
	
	public void clickNext() {
		try {
		jsClick(next);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void isNextDisabled() {
		isElementDisabled(next);
	}
	
	public boolean isRoboDisplayed() {
		return isElementDisplayed(robo);
	}
	
	public boolean isErrorlabelDisplayed() {
		return isElementDisplayed(errorlabel); 
	}

	public void isNextEnabled() {
		isElementEnabled(next);
		
	}
}
