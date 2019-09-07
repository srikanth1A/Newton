package com.mckinsey.Newton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LandingPage extends DesktopBasePage {	
	
	@FindBy(xpath = "//div[@class = 'header-options' and text()='HOW DOES IT WORK']")
	WebElement howdoesitwork;
	
	@FindBy(xpath = "//div[@class = 'header-options' and text()='LIFE INSURANCE 101']")
	WebElement LifeInsurance101;
	
	@FindBy(xpath = "//div[@class = 'header-options' and text()='REVIEWS']")
	WebElement Reviews;
	
	@FindBy(xpath = "//div[@class = 'header-options' and text()='OUR STORY']")
	WebElement OurStory;
	
	@FindBy(xpath = "//div[text()='Enter your personal details']")
	WebElement PersonalDetails;
	
	@FindBy(xpath = "//div[contains(text(),'Why do I need life insurance?')]")
	WebElement txtLifeInsurance;
	
	@FindBy(xpath = "//div[text()='What others are saying']")
	WebElement WhatSaying;
	
	@FindBy(xpath = "//div[text()='The story of Dex']")
	WebElement Story;
	
	@FindBy(xpath = "(//div[text()='START NOW'])[1]")
	WebElement StartNow;
	
	@FindBy(xpath = "//a/div[text()='Health Insurance']")
	WebElement HealthInsurance;
	
	@FindBy(xpath = "//a/div[text()='Life Insurance']")
	WebElement LifeInsurance;
	
	@FindBy(xpath = "//a/div[text()='General Insurance']")
	WebElement GeneralInsurance;
	
	@FindBy(xpath = "//a/div[text()='Privacy Policy']")
	WebElement PrivacyPolicy;
	
	@FindBy(xpath = "//a/div[text()='Security Policy']")
	WebElement SecurityPolicy;
	
	@FindBy(xpath = "//a/div[text()='Terms & Conditions']")
	WebElement TermsConditions;
	
	@FindBy(xpath = "//div[text()='Why do I need Life Insurance?']/span[text()='+']")
	WebElement expand;
	
	@FindBy(xpath = "(//span[@role='button'])[1]")
	WebElement minimize;
	
	@FindBy(xpath = "//i[@class='fab fa-facebook socialMedia-icons']")
	WebElement facebook;
	
	@FindBy(xpath = "//i[@class='fab fa-instagram socialMedia-icons']")
	WebElement instagram;
	
	@FindBy(xpath = "//i[@class='fab fa-linkedin socialMedia-icons']")
	WebElement linkedin;
	
	@FindBy(xpath = "//i[@class='fab fa-youtube socialMedia-icons']")
	WebElement youtube;
	
	@FindBy(xpath = "//div[text()='READ MORE']")
	WebElement readmore;
	
	@FindBy(xpath = "//div[text()='READ LESS']")
	WebElement readless;


    public LandingPage(WebDriver driver, ExtentTest report) {
        super(driver, report);
    }

    public boolean isLifeInsurance101visible() {
    	return isElementPresent(LifeInsurance101);
    }
    
    public boolean ishowdoesitworkvisible() {
    	return isElementPresent(howdoesitwork);
    }
    
    public boolean isPersonalDetailsvisible() {
    	return isElementPresent(PersonalDetails);
    }
    
    public void clickhowdoesitwork() {
    	try {
    	clickOnLink(howdoesitwork);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickLifeInsurance101() {
    	try {
    	clickOnLink(LifeInsurance101);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickReview() {
    	try {
    	clickOnLink(Reviews);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickOurStory() {
    	try {
    	clickOnLink(OurStory);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public boolean isReviewVisible() {
    	return isElementPresent(Reviews);
    }

    public boolean isOurStoryVisible() {
        return isElementPresent(OurStory);
    }
    
    public boolean isLifeInsurencevisible() {
		return isElementPresent(txtLifeInsurance);
	}
    
    public boolean isWhatSayingVisible() {
    	return isElementPresent(WhatSaying);
    }
    
    public boolean isStoryNewtonVisible() {
		return isElementPresent(Story);		
	}
    
    public void clickStartNow() {
    	try {
    	jsClick(StartNow);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    	//StartNow.click();
    }
    
    public String HealthInsurance() {
    	clickOnLink(HealthInsurance);
    	return closeCurrentWindow(driver);        
    }
    
    public String LifeInsurance() {
    	clickOnLink(LifeInsurance);
    	return closeCurrentWindow(driver);        
    }
    
    public String GeneralInsurance() {
    	clickOnLink(GeneralInsurance);
    	return closeCurrentWindow(driver);        
    }
    
    public String PrivacyPolicy() {
    	clickOnLink(PrivacyPolicy);
    	return closeCurrentWindow(driver);        
    }
    
    public String SecurityPolicy() {
    	clickOnLink(SecurityPolicy);
    	return closeCurrentWindow(driver);        
    }
    
    public String TermsConditions() {
    	clickOnLink(TermsConditions);
    	return closeCurrentWindow(driver);        
    }
    
    public void clickexpand(){
    	try {
    	clickOnLink(expand);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickminimise(){
    	try {
    	clickOnLink(minimize);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public String facebook() {
    	clickOnLink(facebook);
    	return closeCurrentWindow(driver);        
    }
    
    public String instagram() {
    	clickOnLink(instagram);
    	return closeCurrentWindow(driver);        
    }
    
    public String linkedin() {
    	clickOnLink(linkedin);
    	return closeCurrentWindow(driver);        
    }
    
    public String youtube() {
    	clickOnLink(TermsConditions);
    	return closeCurrentWindow(driver);        
    }
    
    public String display_the_story_desk() {
    	String te=driver.findElement(By.xpath("//p")).getText();
		return te;
    }
    public boolean isReadMorevisible() {
    	return isElementPresent(readmore);
    }
    
    public boolean isReadLessvisible() {
    	return isElementPresent(readless);
    }
    public void clickReadMore() {
    	try {
    	jsClick(readmore);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void clickReadLess() {
    	try {
    	jsClick(readless);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
}
