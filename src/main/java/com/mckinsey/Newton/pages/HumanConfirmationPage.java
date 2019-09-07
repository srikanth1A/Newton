package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class HumanConfirmationPage extends DesktopBasePage{
	
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-checkmark']")
	WebElement robot;
	
	public HumanConfirmationPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public void clickrobot() {
		if(isElementDisplayed(robot)) {
			jsClick(robot);
		}
		
	}
	
	

}
