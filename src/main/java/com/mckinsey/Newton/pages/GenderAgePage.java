package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenderAgePage extends DesktopBasePage {
	
	@FindBy(id = "about-you-age-gender-dob-date-input")
	WebElement Date;
	
	@FindBy(id = "about-you-age-gender-dob-month-input")
	WebElement Month;
	
	@FindBy(id = "about-you-age-gender-dob-year-input")
	WebElement Year;
	
	@FindBy(xpath = "//div[text()='FEMALE']")
	WebElement FemaleImg;
	
	@FindBy(xpath = "//div[text()='MALE']")
	WebElement MaleImg;
	
	@FindBy(id = "advisor-about-you-age-gender-progress-btn")
	WebElement Next;
	
	@FindBy(xpath = "//div[text()='Please enter a valid number']")
	WebElement ErrorMsg;
	
	@FindBy(xpath = "//h1[text()='As you are below 18 we would suggest to reach out to our adviser to assist you! ']")
	WebElement Errorpopup;
	
	@FindBy(id = "advisor-about-you-age-modal-contact-button")
	WebElement getinContactButton;
	
	@FindBy(xpath = "//span[text()='Close']")
	WebElement closeErrorpopup;
	
	@FindBy(xpath = "//div[text()='Please enter a valid number']")
	WebElement Erorpopup;
	
	
    
    public GenderAgePage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
    
    public void enterDate(String strDate) {
    	try {
    	sendKeys(Date, "Date", strDate);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void enterMonth(String strMonth) {
    	try {
    	sendKeys(Month, "Month", strMonth);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void enterYear(String strYear) {
    	try {
    	sendKeys(Year, "Year", strYear);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void enterCompleteData(String strDate) {
    	String[] date = strDate.split("/");
    	enterDate(date[0]);
    	enterMonth(date[1]);
    	enterYear(date[2]);    	
    }
    
    public void clickFemale() {
    	try {
    	jsClick(FemaleImg);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickMale() {
    	try {
    	jsClick(MaleImg);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickNext() {
    	try {
    	jsClick(Next);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void isNextEnabled() {
    	try {
    	isElementEnabled(Next);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public boolean isErrorMessageDisplayed() {
    	return isElementDisplayed(ErrorMsg);
    }
    
    public boolean isErrorpopupDisplayed() {
    	return isElementDisplayed(Errorpopup);
    }
    
    public boolean isErorpopupDisplayed() {
    	return isElementDisplayed(Erorpopup);
    }
    
    public void closeErrorpopup() {
    	try {
    	jsClick(closeErrorpopup);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public String clickgetinContactButton() {
    	
    jsClick(getinContactButton);
    	return closeCurrentWindow(driver);
    	
    }
    public void clearDay() {
      try {
    	Date.clear();
      }catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    public void clearMonth() {
    	try {
    	Month.clear();
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
}
