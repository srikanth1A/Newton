package com.mckinsey.Newton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class GetInTouchPage extends DesktopBasePage {
	
	@FindBy(xpath = "//*[@id=\"modal\"]/button")
	WebElement X;
	
	@FindBy(id = "advisor-financial-modal-contact-button")
	WebElement contactUs;
	
	public GetInTouchPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	public void clickX() {
		jsClick(X);
	}
	
	public void clickcontactUs() {
		jsClick(contactUs);
	}
	
	public boolean isGetInTouchPage() {
		return isElementDisplayed(contactUs);
	}

	

}
