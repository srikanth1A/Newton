package com.mckinsey.Newton.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FeaturePage extends DesktopBasePage {
	
	@FindBy(xpath = "//button[@class='common-button skip-button primary']")
	WebElement skip;
	
	@FindBy(id = "next-button")
	WebElement results;
	
	@FindBys( {
		   @FindBy(xpath = "//img[@class = 'feature-info-icon']")
		} )
	List<WebElement> icons;
	
	@FindBys( {
		   @FindBy(xpath = "//*[@id='feature-row-input']")
		} )
	List<WebElement> checkboxes;
	
	@FindBy(xpath = "//div[text() = 'Oh no, we could not find a plan for you!']")
	WebElement noplansFound;
	

	public FeaturePage(WebDriver driver, ExtentTest report) {
		super(driver, report);
	}
	
	public boolean isnoplansFoundDisplayed() {
		try {
			return noplansFound.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void isNextEnabled() {
		try {
		isElementEnabled(skip);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isgetMyresultsDisabled() {
		try {
			return results.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void isgetMyresultsEnabled() {
		try {
		isElementEnabled(results);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickSkip() {
		try {
			jsClick(skip);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}

	public boolean isPageDisplayed() {
		
		return isElementDisplayed(skip);
		
	}
	
	public void clickResults() {
		try {
		jsClick(results);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void selectplan(String strPlan) throws Exception {
		try {
		
		jsClick(driver.findElement(By.xpath("//div[contains(text(),'"+strPlan+"')]/preceding-sibling::div/span")));
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean geticonsCount() {
		if(icons.size() > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean getcheckboxesCount() {
		if(checkboxes.size() > 0) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean ischecked(String strPlan) {
		return driver.findElement(By.xpath("//div[contains(text(),'"+strPlan+"')]/preceding-sibling::div/span")).isSelected();
	}
	
	
	
	

}
