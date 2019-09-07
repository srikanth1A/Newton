package com.mckinsey.Newton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PrioritiesPage extends DesktopBasePage {	
    
	@FindBy(id = "advisor-your-goals-priorities-progress-btn")
	WebElement takeConsiderations;
	
	@FindBy(xpath="(//button[text()='ADD'])[1]")
	WebElement add1;
	
	@FindBy(xpath="(//div[text()='1'])[1]")
	WebElement toppriority;
	
	@FindBy(xpath="(//div[text()='2'])[1]")
	WebElement secondprioritybox;
	
	@FindBy(xpath="(//div[text()='3'])[1]")
	WebElement thirdprioritybox;
	
	@FindBy(xpath="//button[@class='common-button advisor-next-button primary']")
	WebElement takeintoconsideration;
	
	@FindBy(xpath="//div[text()='I encounter early critical illness']/../following-sibling::div[2]/button")
	WebElement earlyCriticalIllness;
	
	@FindBy(xpath="//div[text()='Other Goals (General Savings)']/../following-sibling::div[2]/button")
	WebElement othergoals;
	
	@FindBy(xpath="(//img[@class='swap-button-icon'])[1]")
	WebElement swapbutton;
	
	@FindBy(xpath="//img[@alt='delete priority']")
	WebElement deletebutton;
	
	@FindBy(xpath="//div[text()='I pass away (Death)']/../following-sibling::div[2]/button")
	WebElement dearth;
	
	@FindBy(xpath="//div[text()='Other Goals (General Savings)']/../following-sibling::div[2]/button")
	WebElement genralsavings;
	
	@FindBy(xpath="//div[@class='advisor-heading']")
	WebElement priorities;
	
	//div[@class='advisor-heading']
	
	@FindBy(xpath = "//*[@id=\"advisor-your-goals-priorities\"]/div[3]/div[1]/div[1]/div[2]/img")
	WebElement x1;
	
	
    public PrioritiesPage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
    
    public void clickConsiderations() {
    	try {
    	jsClick(takeConsiderations);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void isConsiderationsEnabled() {
    	try {
    	isElementEnabled(takeConsiderations);
    	}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
    
    public void selectPriority(String strPriority) throws Exception {
    	Thread.sleep(1000);
    	if(strPriority.contains(".")) {
    		jsClick(driver.findElement(By.xpath("//div[@class='priorities-index' and text() = '"+strPriority.substring(0,1)+"']/preceding-sibling::div/div[contains(text(),'"+strPriority.substring(2, strPriority.length())+"')]/../following-sibling::div/button[text()='ADD']")));
    	}else {
    		jsClick(driver.findElement(By.xpath("//div/div[contains(text(),'"+strPriority+"')]/../following-sibling::div/button[text()='ADD']")));
    	}
    }
    
    public boolean VerifyPriority(String strPriority) {
    	String[] priority = strPriority.split(".");
    	return isElementDisplayed(driver.findElement(By.xpath("//div[@class='priorities-index' and text() = '"+priority[0]+"']/preceding-sibling::div/div[contains(text(),'"+priority[1]+"')]/../following-sibling::div/button[text()='ADD']")));
    }
    
    public boolean priorityGrayedOut(String strPriority) {
    	return isElementDisplayed(driver.findElement(By.xpath("//div[@id='priority-item-death']//div[contains(text(),'"+strPriority+"')]")));
    }
    
  

	public void selectFirstOption() {
		// TODO Auto-generated method stub
		//add1.click();
		jsClick(add1);
	}
	
	public boolean isTopPriorityEnabled() {
    	//isElementEnabled(toppriority);
		return  toppriority.isSelected();
    }
	
	public void isSecondPriorityBoxEnabled() {
		try {
    	isElementEnabled(secondprioritybox);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
	
	public void isThirdPriorityBoxEnabled() {
		try {
    	isElementEnabled(thirdprioritybox);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
	

	
	public void isTakeIntoConsiderationEnabled() {
		try {
    	isElementEnabled(takeintoconsideration);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
	public boolean isTakeIntoConsiderationdisable() {
		//return takeintoconsideration.isSelected();
		return takeintoconsideration.isEnabled();
		
	}
	
	public void selectSecondOption() {
		try {
		clickOnButton(earlyCriticalIllness);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		
    }
	public void clickOnCross() {
		try {
		jsClick(deletebutton);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		
    }
	public void selectThirdOption() {
		clickOnButton(othergoals);
		
    }
	
	public void isSwapButtonEnabled() {
		try {
    	isElementEnabled(swapbutton);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
	public void clickOnSwapButton() {
		try {
		jsClick(swapbutton);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
    }
	
	public void clickOnDearth() {
		try {
		jsClick(dearth);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		
    }
	public void clickOnGeneralSavings() {
		try {
		clickOnButton(genralsavings);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		
    }
	public void isPrioritiesEnabled() {
		try {
    	isElementEnabled(priorities);
	}catch(Exception e) {
		report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
		driver.quit();
	}
    }

	public void remove1stPriority() {
		jsClick(x1);
	}
	
	

}
