package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ALittleHelperPage extends DesktopBasePage{
	
	@FindBy(xpath = "//*[@id='modal']/div/form/div[3]/div[2]/div/input")
	WebElement food;
	
	@FindBy(xpath = "//*[@id='modal']/div/form/div[4]/div[2]/div/input")
	WebElement rent;
	
	@FindBy(xpath = "//*[@id='modal']/div/form/div[5]/div[2]/div/input")
	WebElement loan;
	
	@FindBy(xpath = "//*[@id='modal']/div/form/div[6]/div[2]/div/input")
	WebElement utilities;
	
	@FindBy(xpath = "//*[@id='modal']/div/form/div[7]/div[2]/div/input")
	WebElement pocketMoney;
	
	@FindBy(xpath = "//*[@id='modal']/div/form/div[8]/div[2]/div/input")
	WebElement otherInstallments;
	
	@FindBy(xpath = "//*[@id='modal']/div/form/div[9]/div[2]/div/input")
	WebElement otherExpenses;
	
	@FindBy(xpath = "//*[@id='modal']/div/form/div[11]/div[2]")
	WebElement total;
	
	@FindBy(xpath = "//*[@id=\"financial-details-calculator-button\"]")
	WebElement sum;

	public ALittleHelperPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public void enterFood(String strFood) {
		try {
			sendKeys(food,"Food and groceries", strFood);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void enterrent(String strRent) {
		try {
		sendKeys(rent,"Rent", strRent);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void enterloan(String strFood) {
		try {
		sendKeys(loan,"Loans and mortgages", strFood);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		
	}
	
	public void enterUtilities(String strUtilities) {
		try {
		sendKeys(utilities,"Utilities", strUtilities);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void enterpocketMoney(String strpocketMoney) {
		try {
		sendKeys(pocketMoney,"Pocket money for family members", strpocketMoney);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void enterOtherInstalments(String strOtherInstalments) {
		try {
		sendKeys(otherInstallments,"Other instalments", strOtherInstalments);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void enterOtherexpenses(String strOtherexpenses) {
		try {
		sendKeys(otherExpenses,"Other expenses", strOtherexpenses);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public String getTotal() {
		
		return total.getText().replace("$", "").replace(",", "").trim();
	}
	
	public void clicksumthisUp() {
		try {
		jsClick(sum);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}

	public String getrent() {
		return rent.getText().replace(",", "").trim();		
	}
	public String getfood() {
		return food.getText().replace(",", "").trim();		
	}
	public String getloan() {
		return loan.getText().replace(",", "").trim();		
	}
	public String getUtilities() {
		return utilities.getText().replace(",", "").trim();		
	}
	public String getPocketMoney() {
		return pocketMoney.getText().replace(",", "").trim();		
	}
	public String getOtherInstallments() {
		return otherInstallments.getText().replace(",", "").trim();		
	}
	
	public String getOtherexpenses() {
		return otherExpenses.getText().replace(",", "").trim();		
	}
	public String getSum() {
		return sum.getText().replace(",", "").trim();		
	}
	

}
