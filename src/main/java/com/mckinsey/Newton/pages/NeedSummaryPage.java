package com.mckinsey.Newton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NeedSummaryPage extends DesktopBasePage {
	
	@FindBy(id = "advisor-needs-summary-progress-btn")
	WebElement letsMove;
	
	@FindBy(xpath = "//div[@class='expenditure-needs-value']")
	WebElement Amount;
	
	@FindBy(xpath = "//div[@class='advisor-label header selected-header']")
	WebElement window;
	
	@FindBy(xpath = "//div[@class='total-needs-value']")
	WebElement totalneeds;
	
	@FindBy(xpath = "//div[@class='expenditure-needs-value']")
	WebElement expenditure;
	
	@FindBy(xpath = "//*[@id=\"advisor-needs-summary\"]/div[2]/div[2]/div[2]/div[3]/div/div[1]/input")
	WebElement yearstoSupport;
	
	@FindBy(xpath = "//*[@id=\"advisor-needs-summary\"]/div[2]/div[2]/div[2]/div[3]/button")
	WebElement calculate;
	
	 
	public NeedSummaryPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public void clickCalculate() {
		jsClick(calculate);
	}
	
	public void enterYearstoSupport(String textToEnter) {
		sendKeys(yearstoSupport, "Years to Support", textToEnter); 
	}
	
	public void clickLetsMove() {
		try {
		jsClick(letsMove);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public String getAmount() {
		return String.format("%.2f", (Amount.getText().replaceAll(",", "")));
	}
	
	public String getSelectedwindow() {
		return window.getText().trim();
	}
	
	public String getTotalNeeds() {
		return totalneeds.getText().replace(",", "").replace("*", "").replace("$", "").trim();
	}
	
	public String getExpenditure() {
		return expenditure.getText().replace(",", "").replace("*", "").replace("$", "").trim();
	}

	public void clickWindow(String strWindow) {
		try {
		jsClick(driver.findElement(By.xpath("//div[@class='advisor-label header' and contains(text(),'"+strWindow+"')]")));
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}

}
