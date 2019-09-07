package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RetirementGoalPage extends DesktopBasePage{
	
	@FindBy(xpath = "//input[@class=' currency-input-field advisor-your-goals-retirement-needs-age-input-field']")
	WebElement age;
	
	@FindBy(xpath = "//input[@class=' currency-input-field undefined']")
	WebElement monthlyspendings;
	
	@FindBy(xpath = "//*[@id='app-top']/div[3]/div/div/div[2]/div[1]/form/div[3]/div[2]/button")
	WebElement next;
	
	@FindBy(xpath = "//button[@class='common-button advisor-next-button primary']")
	WebElement helpme;
	
	@FindBy(xpath = "//*[@id=\"app-top\"]/div[2]/div/div/div[2]/div[1]/div/div/div[1]/span/img")
	WebElement robo;
	
	@FindBy(xpath = "//*[@id=\"app-top\"]/div[2]/div/div/div[2]/div[1]/form/div[2]/div[2]/div")
	WebElement ageError;
	
	@FindBy(xpath = "//*[@id=\"app-top\"]/div[2]/div/div/div[2]/div[1]/form/div[2]/div[4]/div/span")
	WebElement lnknotsure;
	
	@FindBy(id = "retirement-needs-warning-progress-button")
	WebElement yesImSure;

	public RetirementGoalPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public void clickYesImSure() {
		jsClick(yesImSure);
	}
	
	public void enterRetirementAge(String strAge) {
		try {
		sendKeys(age, "RETIREMENT AGE", strAge);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void enterstrMonthlySpendings(String strMonthlySpendings) {
		try {
		sendKeys(monthlyspendings, "RETIREMENT MONTHLY SPENDINGS", strMonthlySpendings);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickNext() {
		try {
		jsClick(next);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
		public void clickHelpMe() {
			try {
			jsClick(helpme);
			}catch(Exception e) {
				report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
				driver.quit();
			}
	}
	
	public boolean isRetirementAgeDisplayed() {
		return isElementDisplayed(age);
	}
	
	public boolean isMonthlySpendingsDisplayed() {
		return isElementDisplayed(monthlyspendings);
	}
	
	public void isNextEnabled() {
		isElementDisabled(next);
	}
	
	public boolean isRoboDisplayed() {
		return isElementDisplayed(robo);
	}

	public String getAge() {
		// TODO Auto-generated method stub
		return age.getText();
	}
	
	public boolean isageErrorDisplayed() {
		return isElementDisplayed(ageError);
	}

	public String getmonthlyAge() {
		// TODO Auto-generated method stub
		return monthlyspendings.getText();
	}
	
	public void clicklnknotsure() {
		jsClick(lnknotsure);
	}
	
}
