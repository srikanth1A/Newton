package com.mckinsey.Newton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegularIncomePage extends DesktopBasePage {
	
	@FindBy(xpath = "//div[text()='YES']")
	WebElement yes;
	
	@FindBy(xpath = "//div[text()='NO']")
	WebElement no;
	
	@FindBy(xpath = "//div[text()='SELF-EMPLOYED']")
	WebElement SELFEMPLOYED;
	
	@FindBy(xpath = "//div[text()='EMPLOYEE']")
	WebElement EMPLOYEE;
	
	@FindBy(xpath = "//div[text()='CONTRACT EMPLOYEE']")
	WebElement CONTRACTEMPLOYEE;
	
	@FindBy(id = "advisor-affordability-employment-progress-btn")
	WebElement Next;
	
	@FindBy(xpath = "//div[text()='USING MY OWN SAVINGS']")
	WebElement myownSavings;
	
	@FindBy(xpath = "//div[text()='SOMEONE IS PAYING FOR ME']")
	WebElement someoneisPaying;
	
	@FindBy(xpath = "//div[contains(text(),'NOT SURE')]")
	WebElement notsure;
	
	@FindBy(xpath="(//input[@class=' currency-input-field advisor-affordability-financial-details-input-field'])[1]")
	WebElement foodAndGroceries;
	
	
	public RegularIncomePage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public void clickNext() {
		try {
		jsClick(Next);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickCONTRACTEMPLOYEE() {
		try {
		clickOnButton(CONTRACTEMPLOYEE);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickEMPLOYEE() {
		try {
		jsClick(EMPLOYEE);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickSELFEMPLOYED() {
		try {
		clickOnButton(SELFEMPLOYED);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickYes() {
		try {
		jsClick(yes);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickNo() {
		try {
		clickOnButton(no);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clicksomeoneisPaying() {
		try {
		jsClick(someoneisPaying);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickmyownSavings() {
		try {
		jsClick(myownSavings);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isSideBarDisplayed(String strCalPopUp) {
		return isElementDisplayed(driver.findElement(By.xpath("//div[@class='advisor-affordability-financial-details-calculator-heading' and text()='"+strCalPopUp+"']")));
	}

	public boolean isFoodAndGrocriesDisplayed(String strCalPopUp) {
		return isElementDisplayed(driver.findElement(By.xpath("//div[@class='advisor-affordability-financial-details-calculator-row-main-text' and text()='"+strCalPopUp+"']")));
	}
	
	public boolean isRentDisplayed(String strCalPopUp) {
		return isElementDisplayed(driver.findElement(By.xpath("//div[@class='advisor-affordability-financial-details-calculator-row-main-text' and text()='"+strCalPopUp+"']")));
	}
	
	public boolean isLoanDisplayed(String strCalPopUp) {
		return isElementDisplayed(driver.findElement(By.xpath("//div[@class='advisor-affordability-financial-details-calculator-row-main-text' and text()='"+strCalPopUp+"']")));
	}
	public boolean isUtilitiesDisplayed(String strCalPopUp) {
		return isElementDisplayed(driver.findElement(By.xpath("//div[@class='advisor-affordability-financial-details-calculator-row-main-text' and text()='"+strCalPopUp+"']")));
	}
	
	public boolean ispocketmoneyDisplayed(String strCalPopUp) {
		return isElementDisplayed(driver.findElement(By.xpath("//div[@class='advisor-affordability-financial-details-calculator-row-main-text' and text()='"+strCalPopUp+"']")));
	}
	
	public boolean isotherinstallmentDisplayed(String strCalPopUp) {
		return isElementDisplayed(driver.findElement(By.xpath("//div[@class='advisor-affordability-financial-details-calculator-row-main-text' and text()='"+strCalPopUp+"']")));
	}
	
	public boolean isOtherExpenseDisplayed(String strCalPopUp) {
		return isElementDisplayed(driver.findElement(By.xpath("//div[@class='advisor-affordability-financial-details-calculator-row-main-text' and text()='"+strCalPopUp+"']")));
	}
	
	public void sendFoodAndGrocriesValues(String value) {
		//String text=Integer.toString(value);
		//foodAndGroceries.sendKeys(text);
		//sendKeys(foodAndGroceries, "Name", value);
		driver.findElement(By.xpath("//*[@id=\"modal\"]/div/form/div[3]/div[2]/div/input")).sendKeys("123");
		
	}
	
	public boolean isFoodAndGroceriesTestFilled() {
		String textStatus=foodAndGroceries.getText();
		if(textStatus==null) {
			return true;
		}
		else 
			return false;
	}

	
	public boolean isYesDisplayed() {
		return isElementDisplayed(yes);
	}
	
	public boolean isNoDisplayed() {
		return isElementDisplayed(no);
	}
	
	public boolean isSELFEMPLOYEDDisplayed() {
		return isElementDisplayed(SELFEMPLOYED);
	}
	public boolean isEMPLOYEEDisplayed() {
		return isElementDisplayed(EMPLOYEE);
	}
	public boolean isCONTRACTEMPLOYEEDisplayed() {
		return isElementDisplayed(CONTRACTEMPLOYEE);
	}
	public boolean ismyownSavingsDisplayed() {
		return isElementDisplayed(myownSavings);
	}
	public boolean issomeoneisPayingDisplayed() {
		return isElementDisplayed(someoneisPaying);
	}
	public boolean isnotsureDisplayed() {
		return isElementDisplayed(notsure);
	}

	public void isnextDisabled() {
		isElementDisabled(Next);
		
	}
	
	
	
	
	
}
