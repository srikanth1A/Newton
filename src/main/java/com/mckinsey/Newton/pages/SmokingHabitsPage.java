package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SmokingHabitsPage extends DesktopBasePage {	
	
	@FindBy(xpath = "//div[text()='YES']")
	WebElement yes;
	
	@FindBy(xpath = "//div[text()='NO']")
	WebElement no;
	
	@FindBy(id = "advisor-about-you-smoking-habits-progress-btn")
	WebElement Next;
	
	@FindBy(xpath = "//div[text()='YES']/following-sibling::img")
	WebElement YesImg;
	
	@FindBy(xpath ="//div[text()='NO']/following-sibling::img")
	WebElement NoImg;

    
    public SmokingHabitsPage(WebDriver driver, ExtentTest report) {
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
    
    public void clickyes() {
    	try {
    	jsClick(yes);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickno() {
    	try {
    	jsClick(no);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public boolean isSmokingHabitsPageDisplayed() {
    	return isElementDisplayed(yes);
    }
    
    public void isNextEnabled() {
    	try {
    	isElementEnabled(Next);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }

	public boolean isNoHilighted() {
		return isElementDisplayed(NoImg);
		
	}
	
	public boolean isYesHilighted() {
		return isElementDisplayed(YesImg);
		
	}
    
}
