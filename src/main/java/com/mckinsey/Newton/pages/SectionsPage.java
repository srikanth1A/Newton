package com.mckinsey.Newton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SectionsPage extends DesktopBasePage{
	
	@FindBy(xpath = "//*[@id='app-top']/div[2]/div/div/div[1]/div/div[2]/div[1]/div/div[4]/a")
	WebElement Dependents;
	
	@FindBy(xpath="//a[text()='To support Just Myself']")
	WebElement To_Support_Just_Myself;
	
	public SectionsPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
	}
	
	public void clickDependents() {
		try {
		jsClick(Dependents);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isSideBarDisplayed(String strMenuName) {
		return isElementDisplayed(driver.findElement(By.xpath("//span[@class='advisor-tracker-value' and text()='"+strMenuName+"']")));
	}
	
	public boolean isSideBarSisplayedwithValue(String strMenuName) {
		return isElementDisplayed(driver.findElement(By.xpath("//a[@class='advisor-tracker-value link' and contains(text(),'"+strMenuName+"')]")));
	}
	
	public void To_Support_Just_Myself() {
		try {
		//To_Support_Just_Myself.click();
		jsClick(To_Support_Just_Myself);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}

	public void clickSection(String strName) {
		try {
		jsClick(driver.findElement(By.xpath("//span[@class = 'advisor-tracker-value link' and contains(text(),'"+strName+"')]")));
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		
	}
}
