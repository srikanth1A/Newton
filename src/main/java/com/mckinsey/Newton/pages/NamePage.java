package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NamePage extends DesktopBasePage {
	//DesktopBasePage
	@FindBy(id = "advisor-about-you-name-user-name-input")
	WebElement Name;
	
	@FindBy(id = "advisor-about-you-name-progress-btn")
	WebElement Next;
	
	@FindBy(id = "global-loader")
	WebElement globalLoader;
	
	@FindBy(xpath= "//div[@class='advisor-help-component']")
	WebElement Helptip;
	@FindBy(xpath= "//div[@class='robo-text-contents']")
	WebElement Helptipmesg;
	@FindBy(xpath= "//button[@class='close-button']")
	WebElement Closehelptip;
	
	
	


    public NamePage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
    
    public void enterName(String strName) {
    	try {
    	sendKeys(Name, "Name", strName);
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
    
  
    
    public boolean isNextEnabled() {
    	return isElementPresent(Next);
    }
    
   
    
    public void isEnterNameEnabled() {
    	try {
     isElementEnabled(Name);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void isHelpTipEnabled() {
    	try {
    	isElementEnabled(Helptip);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    public void isHelpTipMsgEnabled() {
    	try {
    	isElementEnabled(Helptipmesg);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    public void clickHelpTip() {
    	try {
    	jsClick(Helptip);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    public void clickCloseTip() {
    	try {
    	jsClick(Closehelptip);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
}
