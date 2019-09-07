package com.mckinsey.Newton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ParentsPage extends DesktopBasePage {
	
	@FindBy(xpath = "//button[@class='common-button advisor-next-button primary']")
	WebElement coverMe;

	public ParentsPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public void enterAmount(String strDepType, String strAmount) {
		try {
		sendKeys(driver.findElement(By.xpath("//div[text()='"+strDepType+"']/following-sibling::div/div/input")), strDepType.toUpperCase()+" AMOUNT", strAmount);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	public void clickCoverMe() {
		try {
		jsClick(coverMe);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isCoverMeDisplayed() {
		return isElementDisplayed(coverMe);
	}
}
