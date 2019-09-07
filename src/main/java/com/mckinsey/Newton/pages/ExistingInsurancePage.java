package com.mckinsey.Newton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExistingInsurancePage extends DesktopBasePage {
	
	@FindBy(xpath = "((//span[@class='slider round'])[1]")
	WebElement totalPermanentDisability;
	
	@FindBy(xpath = "(//*[@id=\"policies-protection\"]/div[1]/label/input)[2]")
	WebElement lateCriticalIllness;
	
	@FindBy(xpath = "(//*[@id=\"policies-protection\"]/div[1]/label/input)[3]")
	WebElement earlyCriticalIllness;
	
	@FindBy(xpath = "(//*[@id='policies-protection']/div[2]/div/div[2]/input)[1]")
	WebElement PermanentDisabilityCoverage;
	
	@FindBy(xpath = "(//*[@id='policies-protection']/div[2]/div/div[2]/input)[2]")
	WebElement lateCriticalIllnessCoverage;
	
	@FindBy(xpath = "(//*[@id='policies-protection']/div[2]/div/div[2]/input)[3]")
	WebElement earlyCriticalIllnessCoverage;
	
	@FindBy(id = "advisor-existing-policies-progress-btn-mobile")
	WebElement ThatswhatIcurrentlyhave;
	
	@FindBy(xpath= "//button[@id='advisor-existing-policies-progress-btn-mobile']")
	WebElement idonthave;
	
	@FindBy(xpath= "(//div[@class='advisor-your-goals-death-needs-input-field-area'])[1]")
	WebElement Enteramount1;
	
	@FindBy(xpath= "(//div[@class='advisor-your-goals-death-needs-input-field-area'])[2]")
	WebElement Enteramount2;
	
	@FindBy(id = "advisor-existing-policies-progress-btn-mobile")
	WebElement nope;
	
	@FindBy(xpath = "//*[@id=\"policies-savings\"]/div[1]/label/input")
	WebElement savingsProtection;
	
	@FindBy(xpath = "//*[@id=\"policies-protection\"]/div[1]/label/input")
	WebElement PolicyProtection;
	
	@FindBy(xpath = "//*[@id=\"policies-protection\"]/div[2]/div/div[2]/input")
	WebElement policyField;
	
	@FindBy(xpath = "//*[@id=\"policies-savings\"]/div[2]/div[1]/div[2]/input")
	WebElement savingsPlan;
	
	@FindBy(xpath = "//*[@id=\"policies-savings\"]/div[2]/div[2]/div[2]/input")
	WebElement existingSavings;
	
	@FindBy(xpath = "//*[@id=\"policies-retirement\"]/div[1]/label/input")
	WebElement retirement;
	
	@FindBy(xpath = "//*[@id=\"policies-retirement\"]/div[2]/div[2]/div[1]/div[2]/input")
	WebElement lumpsum;
	
	@FindBy(xpath = "//*[@id=\"policies-retirement\"]/div[2]/div[2]/div[3]/div[2]/input")
	WebElement monthly;
	
	@FindBy(xpath = "//*[@id=\"policies-retirement\"]/div[2]/div[3]/div[2]/input")
	WebElement retirementSavings;
	
	@FindBy(xpath = "//*[@id=\"policies-retirement\"]/div[2]/div[4]/div[1]/div[1]/span")
	WebElement cpfLife;	
	
	
	
	public ExistingInsurancePage(WebDriver driver, ExtentTest report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}	
	
	public boolean islumpsumDisplayed() {
		return isElementDisplayed(lumpsum);
	}
	
	public boolean ismonthlyDisplayed() {
		return isElementDisplayed(monthly);
	}
	
	public boolean isretirementSavingsDisplayed() {
		return isElementDisplayed(retirementSavings);
	}
	
	public boolean iscpfLifeDisplayed() {
		return isElementDisplayed(cpfLife);
	}
	
	public String getpolicyField() {
		return policyField.getText();
	}
	
	public void selectExistingPolicy(String strPolicyName) {
		jsClick(driver.findElement(By.xpath("//div/p[contains(text(),'"+strPolicyName+"')]/../label/input")));
		
	}
	
	public void selectExistingPolicy2(String strPolicyName) {
		jsClick(driver.findElement(By.xpath("//div[contains(text(),'"+strPolicyName+"')]/label/input")));
	}
	
	public void enterDatainField2(String strFieldName, String strData) {
		sendKeys(driver.findElement(By.xpath("//div[contains(text(),'"+strFieldName+"')]/../following-sibling::div/input")), strFieldName, strData);
	}
	
	public void enterDatainField(String strFieldName, String strData) {
		sendKeys(driver.findElement(By.xpath("//div[contains(text(),'"+strFieldName+"')]/following-sibling::div/input")), strFieldName, strData);
	}
	
	public void enterDatainField(String strCheckboxName, String strFieldName, String strData) {
		WebElement ele = driver.findElement(By.xpath("//div/p[contains(text(),'"+strCheckboxName+"')]/../following-sibling::div/div/div[contains(text(),'"+strFieldName+"')]/following-sibling::div/input"));
		sendKeys(ele,strFieldName, strData);
	}
	
	public void enterDatainField2(String strCheckboxName, String strFieldName, String strData) {
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+strCheckboxName+"')]/following-sibling::div/div/div[contains(text(),'"+strFieldName+"')]/following-sibling::div/input"));
		sendKeys(ele,strFieldName, strData);
	}
	
	public void selectCheckBox(String strName) {
		jsClick(driver.findElement(By.xpath("//div[contains(text(),'"+strName+"')]/../div/span")));
	}
	
	public void enterpolicyField(String strData) {
		try {
		sendKeys(policyField, "policy Field", strData);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickprotection() {
		try {
		jsClick(PolicyProtection);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickSavings() {
		try {
		jsClick(savingsProtection);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean issavingsProtectionDisplayed() {
		return isElementDisplayed(savingsProtection);
	}
	
	public boolean isPolicyProtectionDisplayed() {
		return isElementDisplayed(PolicyProtection);
	}
	
	public void clickThatswhatIcurrentlyhave() {
		try {
			jsClick(ThatswhatIcurrentlyhave);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clicknope() {
		try {
		jsClick(nope);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean isnopeDisplayed() {
		return isElementDisplayed(nope);
	}
	
	public void clickIDontHave() {
		try {
		jsClick(idonthave); 
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void enterlateCriticalIllnessCoverage(String strValue) {
		try {
		sendKeys(lateCriticalIllnessCoverage, "Late Critical Illness Coverage", strValue);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void enterearlyCriticalIllnessCoverage(String strValue) {
		try {
		sendKeys(earlyCriticalIllnessCoverage, "Early Critical Illness Coverage", strValue);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void enterPermanentDisabilityCoverage(String strValue) {
		try {
		sendKeys(PermanentDisabilityCoverage, "Permanent Disability Coverage", strValue);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clicktotalPermanentDisability() {
		try {
		jsClick(totalPermanentDisability);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clicklateCriticalIllness() {
		try {
		jsClick(lateCriticalIllness);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public void clickearlyCriticalIllness() {
		try {
		jsClick(earlyCriticalIllness);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}
	
	public boolean spouseAmountFieldEnabled() {
		//return takeintoconsideration.isSelected();
		return Enteramount1.isEnabled();
		
	}
	
	public boolean childrenAmountFieldEnabled() {
		
		return Enteramount2.isEnabled();
		
	}
	
	public void enterAmountField1(String stramount) {
		try {
		sendKeys(Enteramount1, " amount", stramount);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}

	public boolean isThatswhatIcurrentlyhavedisplayed() {
		return isElementDisplayed(ThatswhatIcurrentlyhave);
	}

	public void isThatswhatIcurrentlyhaveDisabled() {
		isElementDisabled(ThatswhatIcurrentlyhave);		
	}

	public void isThatswhatIcurrentlyhaveEnabled() {
		isElementEnabled(ThatswhatIcurrentlyhave);
		
	}

	public void entersavings(String string) {
		try {
		sendKeys(savingsPlan,"I already have savings plans that will pay me", string);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
	}

	public boolean issavingplanDisplayed() {
		return isElementDisplayed(savingsPlan);
		
	}

	public boolean isexistingsavingsDisplayed() {
		return isElementDisplayed(existingSavings);		
	}

	public String getentersavings() {
		return savingsPlan.getText().replace(",", "");
	}

	public void clickretirement() {
		try {
		jsClick(retirement);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		
	}

	public void enterlumpsum(String string) {
		try {
		sendKeys(lumpsum,"LUMP SUM",string);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		
	}
	
	public String getlumpsum() {
		return lumpsum.getText().replace(",", "");
		
	}

	public void clickcpfLife() {
		try {
		jsClick(cpfLife);
		}catch(Exception e) {
			report.log(LogStatus.FAIL, "EXCEPTION :: "+e.getLocalizedMessage()+report.addScreenCapture(CaptureScreen()));
			driver.quit();
		}
		
	}
	
	public boolean iscpfLifeselected() {
		return cpfLife.isSelected();
	}


	
}
