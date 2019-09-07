package com.mckinsey.Newton.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.xml.XmlTest;
import com.mckinsey.Newton.utils.ExcelsUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * This is core of framework wherein all the initializations are done.
 * Including browser configuration, page objects, config and yaml.
 */
public class TestSessionInitiator {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest logger;
    
    public WebDriver getDriver() {
        return driver;
    }
    
    public ExtentTest getReport() {
		return logger;

	}
    
    protected void verifyDecimalText(String strActual, String strExpected, String strlog) {
    	if(Integer.parseInt(""+strExpected.charAt(strExpected.indexOf(".")+3)) >= 5) {
    		strExpected = ""+(Double.parseDouble(strExpected.substring(0, strExpected.indexOf(".")+3))+0.01);
    	}else {
    		strExpected = strExpected.substring(0, strExpected.indexOf(".")+3);
    	}
		if(strExpected.substring(0, strExpected.indexOf(".")+3).equals(strActual)){
			logger.log(LogStatus.PASS, strlog);
		}else {
			logger.log(LogStatus.FAIL, strlog+logger.addBase64ScreenShot(CaptureScreen()));
		}
	}
    
    protected void verifyText(String strActual, String strExpected, String strlog) {
		if(strActual.contains(strExpected)) {
			logger.log(LogStatus.PASS, strlog);
		}else {
			logger.log(LogStatus.FAIL, strlog+logger.addBase64ScreenShot(CaptureScreen()));			
		}
	}
    
    public String CaptureScreen(){
        TakesScreenshot newScreen = (TakesScreenshot) driver;
        String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
        return "data:image/jpg;base64, " + scnShot ;
   }
    
   public String getRandomNumber() {
	   Date date = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhmmss");	   
	   return sdf.format(date);
   }
    
    protected void assertTrue(boolean bool, String strlog) {
		if(bool) {
			logger.log(LogStatus.PASS, strlog);
		}else {
			logger.log(LogStatus.FAIL, strlog+logger.addBase64ScreenShot(CaptureScreen()));
		}
	}
    
    protected void assertFalse(boolean bool, String strlog) {
		if(!bool) {
			logger.log(LogStatus.PASS, strlog);
		}else {
			logger.log(LogStatus.FAIL, strlog);
		}
		
	}

    @BeforeSuite
    public void beforeSuit() {
    	extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Result.html");
    	extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
    	
    }

    @BeforeMethod(groups = "Regression")
    public void launchDriver(Method M) {
        System.out.println("BeforeTest Method");
        if(!M.getName().equals("MasterAlgo")) {
        	logger = extent.startTest(M.getName());
        }        
        //String jobName = testContext.getName() + "_" + new Timestamp(System.currentTimeMillis()).toString();
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver=new ChromeDriver();
		//driver.get("https://askdex.uat.income.com.sg");
		driver.get("https://askdex.sit.income.com.sg/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
    }

    @DataProvider(name="testdata")
    public static Iterator<Object[]>getData(Method M)throws Exception{
    	List<Hashtable<String, String>> a = ExcelsUtils.readFile(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\MasterTestData.xlsx","TestData",M.getName());
    	List<Object[]> testdata = new ArrayList<Object[]>();
    	Iterator<Hashtable<String, String>> dataIterator= a.iterator();
    	while(dataIterator.hasNext()) {
    		Hashtable<String,String> dataset = dataIterator.next();
    		if(!(dataset.get("RunRow").equalsIgnoreCase("True"))) {
    			dataIterator.remove();			
    		}else {
    			Object[] obj= {dataset};
    			testdata.add(obj);    			
    		}
    	}
    	return testdata.iterator();
    }
    
    @DataProvider(name="algotestdata")
    public static Iterator<Object[]>getAlgoData(Method M)throws Exception{
    	List<Hashtable<String, String>> a = ExcelsUtils.readFile(System.getProperty("user.dir")+"/src/main/resources/TestData/MasterTestData.xlsx","AlgoTest",M.getName());
    	List<Object[]> testdata = new ArrayList<Object[]>();
    	Iterator<Hashtable<String, String>> dataIterator= a.iterator();
    	while(dataIterator.hasNext()) {
    		Hashtable<String,String> dataset = dataIterator.next();
    		if(!(dataset.get("RunRow").equalsIgnoreCase("True"))) {
    			dataIterator.remove();			
    		}else {
    			Object[] obj= {dataset};
    			testdata.add(obj);    			
    		}
    	}
    	return testdata.iterator();
    }
    
    @AfterMethod(groups = "Regression")
    public void quitSession(ITestContext testContext, XmlTest xmlTest, Method method, Object[] testArgs, ITestResult result) {
        if (getDriver() != null)
            getDriver().quit();
        if(!method.getName().equals("MasterAlgo")) {
        	extent.endTest(logger);
        }
    }

    @AfterSuite
    public void afterSuite(ITestContext context) {
        extent.close();

    }
    public void captureScreen(WebDriver driver, String tname) throws IOException  {
    	
    	String screenShotPath=System.getProperty("user.dir")+"/Screenshots/newton"+getcurrentDateTime()+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		//File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		//FileUtils.copyFile(source, target);
		FileHandler.copy(src, new File(screenShotPath));
		System.out.println("Screenshot taken");
	}
    
    public String getcurrentDateTime() {
		DateFormat custom_format= new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		Date currentDate= new Date();
		return custom_format.format(currentDate);
	}
    
    
    
}
