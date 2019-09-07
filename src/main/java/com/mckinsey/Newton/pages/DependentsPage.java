package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DependentsPage extends DesktopBasePage {
    
	
	@FindBy(xpath = "//div[text()='JUST MYSELF']")
	WebElement JustMySelf;
	
	@FindBy(xpath = "//div[text()='JUST MYSELF']/following-sibling::img")
	WebElement JustMySelfimg;
	
	@FindBy(xpath = "//div[text()='SPOUSE']")
	WebElement Spouse;
	
	@FindBy(xpath = "//div[text()='SPOUSE']")
	WebElement Spouseimg;
	
	
	//@FindBy(xpath = "//div[text()='SPOUSE']/following-sibling::img")
	//WebElement Spouseimg;
	
	@FindBy(xpath = "//div[text()='CHILDREN']")
	WebElement Children;
	
	@FindBy(xpath = "//div[text()='CHILDREN']/following-sibling::img")
	WebElement Childrenimg;
	
	@FindBy(xpath = "//div[text()='PARENTS']")
	WebElement Parents;
	
	@FindBy(xpath = "//div[text()='PARENTS']/following-sibling::img")
	WebElement ParentsImg;
	
	@FindBy(id = "advisor-about-you-dependent-progress-btn")
	WebElement Next;


    
    public DependentsPage(WebDriver driver, ExtentTest report) {
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
    
    public void clickJustMySelf() {
    	try{
    	jsClick(JustMySelf);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickSpouse() {
    	try{
    	jsClick(Spouse);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickParents() {
    	try {
    	jsClick(Parents);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickChildren() {
    	try {
    	jsClick(Children);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public boolean isJustMySelfGreyedout() {
    	return isElementDisplayed(JustMySelfimg);
    }
    
    public boolean isSpouseGreyedout() {
    	return isElementDisplayed(Spouseimg);
    }
    
    public boolean isChildrenGreyedout() {
    	return isElementDisplayed(Childrenimg);
    }
    
    public boolean isParentsGreyedout() {
    	return isElementDisplayed(ParentsImg);
    }  
    
    public boolean isDependentsPageDisplayed() {
    	return isElementDisplayed(JustMySelf);
    }
    
    public boolean isJustMySelfDisplayed() {
    	return isElementDisplayed(JustMySelf);
    }
    
    public boolean isSpouseDisplayed() {
    	return isElementDisplayed(Spouse);
    }
    
    public boolean isParentsDisplayed() {
    	return isElementDisplayed(Parents);
    }
    
    public boolean isChildrenDisplayed() {
    	return isElementDisplayed(Children);
    }
    
    public void isNextEnabled() {
    	try {
    	isElementEnabled(Next);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }

}
