package com.mckinsey.Newton.pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.commons.io.FileUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DesktopBasePage {

    protected static WebDriver driver;
    protected ExtentTest report;

    public DesktopBasePage(WebDriver driver, ExtentTest report) {
        this.driver = driver;
		this.report = report;
		PageFactory.initElements(driver, this);
    }
    
    public String CaptureScreen(){
        TakesScreenshot newScreen = (TakesScreenshot) driver;
        String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
        return "data:image/jpg;base64, " + scnShot ;
   }
    
    /**
	 * Check if the element is present in the page
	 * 
	 * @param element
	 *            WebElement need to check
	 * @return True if present
	 */
	protected boolean isElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		} catch (StaleElementReferenceException ex2) {
			return false;
		}
	}
	
	/***
	 * Method to click on a link(WebElement button)
	 * 
	 * @param :
	 *            Element Name
	 ***/
	public void clickOnButton(WebElement button) {
		String btn = button.getText();
		try {
			waitForElement(button);
			if (isElementPresent(button)) {
				button.click();
				report.log(LogStatus.INFO, "ClickOn" + btn, "Successfully clicked on button " + btn);
			}
		} catch (RuntimeException ex) {
				report.log(LogStatus.ERROR, "Click" + btn,
						btn + " is NOT clicked successfully, EXCEPTION CAUGHT : " + ex.getMessage());
		}
	}
	
	/**
	 * Method to wait for element to load in the page
	 * 
	 * @param WebElement
	 */

	protected Boolean waitForElement(WebElement we) {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(we));
			return true;
		} catch (RuntimeException ex) {
			return false;
		}
	}
	
	/**
	 * Method to click on a button(WebElement button)
	 * 
	 * @param :
	 *            Element Name
	 */
	protected void jsClickButton(WebElement button) {
		String btnText = button.getText();
		try {
			if ("".equalsIgnoreCase("iexplore")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
				report.log(LogStatus.INFO, "ClickOnButton" + btnText, "Successfully clicked on button " + btnText);
			} else {
				button.click();
			}
		} catch (RuntimeException ex) {
			report.log(LogStatus.ERROR, "Click" + btnText,
					btnText + " is NOT clicked successfully, EXCEPTION CAUGHT : " + ex.getMessage());
		}
	}
	
	/***
	 * Method to click on a link(WebElement link)
	 * 
	 * @param :
	 *            Element Name
	 * @author : Shilpa (sshank001c)
	 ***/
	public void clickOnLink(WebElement link) {
		try {
			waitForElement(link);
			String linkText = link.getText();
			if (isElementPresent(link)) {
				// link.click();
				jsClick(link);
				report.log(LogStatus.INFO, "ClickOn" + linkText, "Successfully clicked on link " + linkText);
			}
		} catch (Exception ex) {
			report.log(LogStatus.ERROR, "ClickÖnLink", "Link is not displayed, EXCEPTION CAUGHT : " + ex.getMessage());
		}
	}
	
	protected void jsClick(WebElement link) {
		try {
			//sleep(3000);
			String linkText = link.getText().trim();
			System.out.println("linkText: " + linkText);
			//if ((new TestSettings()).getBrowser().equalsIgnoreCase("iexplore")) {
			//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
			//} else if ((new TestSettings()).getBrowser().equalsIgnoreCase("chrome")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
				//sleep(500);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);

			//} else {
			//	link.click();

			//}
		} catch (RuntimeException ex) {
			report.log(LogStatus.ERROR, "ClickOnLink", "Unable to click on Link ->" + ex.getMessage());
		}
	}

	/**
	 * Method to sroll down to find element
	 * 
	 * @param :
	 *            Element Name
	 */

	public Object scrollElementIntoView(WebElement element) {
		return ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/***
	 * Method to check if element is enabled(element_name)
	 * 
	 * @param :
	 *            Element Name
	 * @return :
	 * @author : Shabana (sshaik002c)
	 ***/
	public void isElementEnabled(WebElement element) {
		try {
			if (isElementPresent(element)) {
				if (element.isEnabled()) {
					report.log(LogStatus.PASS,"IsElementEnabled", element.getText() + "is enabled"+report.addScreenCapture(TakeFullScreenshot()));
				} else {
					report.log(LogStatus.FAIL, "IsElementEnabled", element.getText() + "is not enabled"+report.addScreenCapture(TakeFullScreenshot()));
				}

			}
		} catch (RuntimeException ex) {
			report.log(LogStatus.ERROR, "ElementIsNotAvailable", element.getText() + "is not available");
		}
	}
	
	public void isElementDisabled(WebElement element) {
		try {
				if (element.isEnabled()) {
					report.log(LogStatus.FAIL,"IsElementEnabled", element.getText() + "is enabled"+report.addScreenCapture(TakeFullScreenshot()));
				} else {
					report.log(LogStatus.PASS, "IsElementEnabled", element.getText() + "is not enabled"+report.addScreenCapture(TakeFullScreenshot()));
				}
		} catch (RuntimeException ex) {
			report.log(LogStatus.ERROR, "ElementIsNotAvailable", element.getText() + "is not available");
		}
	}
	
	public String TakeFullScreenshot() {
		try {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
			//FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"ScreenShots/shot.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return System.getProperty("user.dir")+"ScreenShots/shot.png";
	}

	/**
	 * Method to check Element id displayed in the page
	 * 
	 * @param ElementName
	 */

	protected boolean isElementDisplayed(WebElement we) {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(we));
		} catch (RuntimeException ex) {
			return false;
		}
		return true;
	}
	
	/***
	 * Method to Enter text in the field specified
	 * 
	 * @param :
	 * @return :
	 * @author : Shravanth PAV (sarago001) Modified By :
	 ***/
	public void sendKeys(WebElement we, String fieldName, String textToEnter) {
		try {
			waitForElement(we);
		} catch (RuntimeException re) {
			report.log(LogStatus.ERROR, "Wait For Element " + fieldName, "Element failed to Load" + re.getMessage());
		}
		try {
			we.clear();
			we.sendKeys(textToEnter);
			report.log(LogStatus.INFO, "Enter data to field:" + fieldName, "Data entered:" + textToEnter);
			//report.updateTestLog("Enter data to field:" + fieldName, "Data entered:" + textToEnter, Status.SCREENSHOT);
		} catch (RuntimeException re) {
			report.log(LogStatus.ERROR, "Enter data to field:" + fieldName, "Failed entering data." + re.getMessage());
		}

	}
	
	public static String closeCurrentWindow(WebDriver driver) {
        switchToLatestWindow(driver);
        String url = driver.getCurrentUrl();

        driver.close();

        switchToLatestWindow(driver);
        return url;
    }
	
	private static void switchToLatestWindow(WebDriver driver) {
        Iterator<String> iterator = driver.getWindowHandles().iterator();
        while (iterator.hasNext())
            driver.switchTo().window(iterator.next());
    }
    
   public static String getRandomNumber() {
	   Date date = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhmmss");	   
	   return sdf.format(date);
   }
}
