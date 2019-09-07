package com.mckinsey.Newton.pages;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyPreferrencePage extends DesktopBasePage {

    @FindBy(xpath = "//div[@class='product-suggestion-item-1']")
    WebElement oneProductRecommendtion;

    @FindBy(xpath = "//div[@class='product-suggestion-item-2']")
    WebElement twoProductRecommendtion;

    @FindBy(xpath = "//div[@class='product-amount-amount']")
    WebElement ProductAmount;

    @FindBys({
            @FindBy(xpath = "//span[@class='category-value']")
    })
    List<WebElement> sections;

    @FindBys({
            @FindBy(xpath = "//a[@class='page-value link']")
    })
    List<WebElement> subsections;

    @FindBys({
            @FindBy(xpath = "//div[@class='toggle-category']")
    })
    List<WebElement> expandSections;

    @FindBys({
            @FindBy(xpath = "//div[@class='recommendations-priority-details']/div[3]")
    })
    List<WebElement> mainpriorities;

    @FindBy(xpath = "(//div[contains(@class,'recommendations-section-table-component')])[2]")
    WebElement mcoverageP1;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[1]/div[3]/div[1]/div/div[1]/div[3]")
    WebElement coverageP1;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]")
    WebElement product1RecomO1;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[3]")
    WebElement product2RecomO1;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[1]/div[2]/div[3]")
    WebElement PremiumO1;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[1]/div[3]/div[1]/div/div[1]/div[3]")
    WebElement CoverageonPriority1O1;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[1]")
    WebElement productRecomO2;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[2]")
    WebElement PremiumO2;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[3]")
    WebElement CoverageonPriority1O2;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[3]/div[2]/div[1]")
    WebElement productRecomO3;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[3]/div[2]/div[2]")
    WebElement PremiumO3;

    @FindBy(xpath = "//*[@id='app-top']/div[2]/div/div[3]/div[2]/div[3]/div[3]/div[1]/div/div[1]/div[3]")
    WebElement CoverageonPriority1O3;


    public MyPreferrencePage(WebDriver driver, ExtentTest report) {
        super(driver, report);
        // TODO Auto-generated constructor stub
    }

    public void verifyPriorities(String strP1, String strP2, String strP3) {
        String[] strPriority = {strP1, strP2, strP3};
        System.out.println(strP2);
        int j = 0;
        for (int i = 0; i < strPriority.length; i++) {
            if (((strPriority[i] == "") || (strPriority[i] == null) || (strPriority[i] == "0"))) {
                System.out.println(strPriority[i]);
                System.out.println(mainpriorities.get(j).getText().replace("COVERAGE: $", "").replace(",", ""));
                if (mainpriorities.get(j).getText().replace("COVERAGE: $", "").replace(",", "").equals(strPriority[i])) {
                    report.log(LogStatus.PASS, "Verify Priority " + (j + 1) + " EXPECTED :: " + strPriority[i] + " ACTUAL ::" + mainpriorities.get(j).getText().replace("COVERAGE: $", "").replace(",", ""));
                } else {
                    report.log(LogStatus.FAIL, "Verify Priority " + (j + 1) + " EXPECTED :: " + strPriority[i] + " ACTUAL ::" + mainpriorities.get(j).getText().replace("COVERAGE: $", "").replace(",", ""));
                }
                j++;
            }

        }
    }

    protected void verifyText(String strActual, String strExpected, String strlog) {
        if (strActual.contains(strExpected)) {
            report.log(LogStatus.PASS, strlog);
        } else {
            report.log(LogStatus.FAIL, strlog + report.addBase64ScreenShot(CaptureScreen()));
        }
    }

    public void verifysuggestionPriorities(Hashtable<String, String> data) {


        //if(!(data.get("Coverage on Priority 1 O1").equals("")) || !(data.get("Coverage on Priority 2 O1").equals("")) || !(data.get("Coverage on Priority 3 O1").equals(""))
        //	&&
        //(data.get("Coverage on Priority 1 O2").equals("") &&
        //data.get("Coverage on Priority 2 O2").equals("") &&
        //data.get("Coverage on Priority 3 O2").equals("") &&
        //data.get("Coverage on Priority 1 O3").equals("") &&
        //data.get("Coverage on Priority 2 O3").equals("") &&
        //data.get("Coverage on Priority 3 O3").equals(""))
        //) {

        //if((!data.get("Coverage on Priority 1 O1").equals("")) || (!data.get("Coverage on Priority 1 O1").equals("0"))) {
        //WebElement p1o1 = driver.findElement(By.xpath("(//div[contains(@class,'table-suggestions-priority-coverage-amount') and @id = 'option1-priority1-coverage'])[2]"));
        //verifyText(p1o1.getText().replace("COVERAGE: $", "").replace(",", ""), data.get("Coverage on Priority 1 O1"), "Verify Option 1 Priority 1 --  Expected:: "+data.get("Coverage on Priority 1 O1")+" Actual:: "+p1o1.getText());
        //}

        //if((!data.get("Coverage on Priority 2 O1").equals("")) || (!data.get("Coverage on Priority 2 O1").equals("0"))) {
        //WebElement p2o1 = driver.findElement(By.xpath("(//div[contains(@class,'table-suggestions-priority-coverage-amount') and @id = 'option1-priority2-coverage'])[2]"));
        //verifyText(p2o1.getText().replace("COVERAGE: $", "").replace(",", ""), data.get("Coverage on Priority 2 O1"), "Verify Option 1 Priority 2 --  Expected:: "+data.get("Coverage on Priority 2 O1")+" Actual:: "+p2o1.getText());
        //}


        //if((!data.get("Coverage on Priority 3 O1").equals("")) || (!data.get("Coverage on Priority 3 O1").equals("0"))) {
        //WebElement p3o1 = driver.findElement(By.xpath("(//div[contains(@class,'table-suggestions-priority-coverage-amount') and @id = 'option1-priority3-coverage'])[2]"));
        //verifyText(p3o1.getText().replace("COVERAGE: $", "").replace(",", ""), data.get("Coverage on Priority 3 O1"), "Verify Option 1 Priority 3 --  Expected:: "+data.get("Coverage on Priority 3 O1")+" Actual:: "+p3o1.getText());
        //}

        //}else {


        //Option 1
        String option1Priority1Coverage = data.get("Coverage on Priority 1 O1");
        if (!(option1Priority1Coverage.equals("") || option1Priority1Coverage.equals("0"))) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
            WebElement coverageElement = driver.findElement(By.xpath("//div[@class='slick-list']//div[@id='option1-priority1-coverage']"));
            String coverage = coverageElement.getAttribute("innerHTML");
            String alterredCoverage = coverage.replace("COVERAGE: $", "").replace(",", "");
            verifyText(alterredCoverage, option1Priority1Coverage, "Verify Option 1 Priority 1 --  Expected:: " + option1Priority1Coverage + " Actual:: " + alterredCoverage);
        }

        String option1Priority2Coverage = data.get("Coverage on Priority 2 O1");
        if (!(option1Priority2Coverage.equals("") || option1Priority2Coverage.equals("0"))) {
            WebElement coverageElement = driver.findElement(By.xpath("//div[@class='slick-list']//div[@id='option1-priority2-coverage']"));
            String coverage = coverageElement.getAttribute("innerHTML");
            String alterredCoverage = coverage.replace("COVERAGE: $", "").replace(",", "");
            verifyText(alterredCoverage, option1Priority2Coverage, "Verify Option 1 Priority 2 --  Expected:: " + option1Priority2Coverage + " Actual:: " + alterredCoverage);
        }

        String option1Priority3Coverage = data.get("Coverage on Priority 3 O1");
        if (!(option1Priority3Coverage.equals("") || option1Priority3Coverage.equals("0"))) {
            WebElement coverageElement = driver.findElement(By.xpath("//div[@class='slick-list']//div[@id='option1-priority3-coverage']"));
            String coverage = coverageElement.getAttribute("innerHTML");
            String alterredCoverage = coverage.replace("COVERAGE: $", "").replace(",", "");
            verifyText(alterredCoverage, option1Priority3Coverage, "Verify Option 1 Priority 3 --  Expected:: " + option1Priority3Coverage + " Actual:: " + alterredCoverage);
        }

        //Option2
        String option2Priority1Coverage = data.get("Coverage on Priority 1 O2");
        if (!(option2Priority1Coverage.equals("") || option2Priority1Coverage.equals("0"))) {
            WebElement coverageElement = driver.findElement(By.xpath("//div[@class='slick-list']//div[@id='option2-priority1-coverage']"));
            String coverage = coverageElement.getAttribute("innerHTML");
            String alterredCoverage = coverage.replace("COVERAGE: $", "").replace(",", "");
            verifyText(alterredCoverage, option2Priority1Coverage, "Verify Option 2 Priority 1 --  Expected:: " + option2Priority1Coverage + " Actual:: " + alterredCoverage);

        }

        String option2Priority2Coverage = data.get("Coverage on Priority 2 O2");
        if (!(option2Priority2Coverage.equals("") || option2Priority2Coverage.equals("0 "))) {
            WebElement coverageElement = driver.findElement(By.xpath("//div[@class='slick-list']//div[@id='option2-priority2-coverage']"));
            String coverage = coverageElement.getAttribute("innerHTML");
            String alterredCoverage = coverage.replace("COVERAGE: $", "").replace(",", "");
            verifyText(alterredCoverage, option2Priority2Coverage, "Verify Option 2 Priority 2 --  Expected:: " + option2Priority2Coverage + " Actual:: " + alterredCoverage);
        }

        String option2Priority3Coverage = data.get("Coverage on Priority 3 O2");
        if (!(option2Priority3Coverage.equals("") || option2Priority3Coverage.equals("0"))) {
            WebElement coverageElement = driver.findElement(By.xpath("//div[@class='slick-list']//div[@id='option2-priority3-coverage']"));
            String coverage = coverageElement.getAttribute("innerHTML");
            String alterredCoverage = coverage.replace("COVERAGE: $", "").replace(",", "");
            verifyText(alterredCoverage, option2Priority3Coverage, "Verify Option 2 Priority 3 --  Expected:: " + option2Priority3Coverage + " Actual:: " + alterredCoverage);
        }

        //Option 3
        String option3Priority1Coverage = data.get("Coverage on Priority 1 O3");
        if (!(option3Priority1Coverage.equals("") || option3Priority1Coverage.equals("0"))) {
            WebElement coverageElement = driver.findElement(By.xpath("//div[@class='slick-list']//div[@id='option3-priority1-coverage']"));
            String coverage = coverageElement.getAttribute("innerHTML");
            String alterredCoverage = coverage.replace("COVERAGE: $", "").replace(",", "");
            verifyText(alterredCoverage, option3Priority1Coverage, "Verify Option 3 Priority 1 --  Expected:: " + option3Priority1Coverage + " Actual:: " + alterredCoverage);
        }

        String option3Priority2Coverage = data.get("Coverage on Priority 2 O3");
        if (!(option3Priority2Coverage.equals("") || option3Priority2Coverage.equals("0"))) {
            WebElement coverageElement = driver.findElement(By.xpath("//div[@class='slick-list']//div[@id='option3-priority2-coverage']"));
            String coverage = coverageElement.getAttribute("innerHTML");
            String alterredCoverage = coverage.replace("COVERAGE: $", "").replace(",", "");
            verifyText(alterredCoverage, option3Priority2Coverage, "Verify Option 3 Priority 2 --  Expected:: " + option3Priority2Coverage + " Actual:: " + alterredCoverage);
        }

        String option3Priority3Coverage = data.get("Coverage on Priority 3 O3");
        if (!(option3Priority3Coverage.equals("") || option3Priority3Coverage.equals("0"))) {
            WebElement coverageElement = driver.findElement(By.xpath("//div[@class='slick-list']//div[@id='option3-priority3-coverage']"));
            String coverage = coverageElement.getAttribute("innerHTML");
            String alterredCoverage = coverage.replace("COVERAGE: $", "").replace(",", "");
            verifyText(alterredCoverage, option3Priority3Coverage, "Verify Option 3 Priority 3 --  Expected:: " + option3Priority3Coverage + " Actual:: " + alterredCoverage);
        }
        //}


    }

    public String getcoverageP1() {
        return coverageP1.getText().replace("COVERAGE: $", "").replace(",", "");
    }

    public String getmcoverageP1() {
        return mcoverageP1.getText().replace("COVERAGE: $", "").replace(",", "");
    }

    public String getproduct1RecomO1() {
        return product1RecomO1.getText();
    }

    public String getproduct2RecomO1() {
        return product2RecomO1.getText();
    }

    public String getproductRecomO2() {
        return productRecomO2.getText();
    }

    public String getproductRecomO3() {
        return productRecomO3.getText();
    }

    public String getPremiumO1() {
        return PremiumO1.getText().replace(" / MONTH", "").replace("$ ", "");
    }

    public String getPremiumO2() {
        return PremiumO2.getText().replace(" / MONTH", "").replace("$ ", "");
    }

    public String getPremiumO3() {
        return PremiumO3.getText().replace(" / MONTH", "").replace("$ ", "");
    }

    public String getCoverageonPriority1O3() {
        return CoverageonPriority1O3.getText().replace("COVERAGE: $", "").replace(",", "");
    }

    public String getCoverageonPriority1O2() {
        return CoverageonPriority1O2.getText().replace("COVERAGE: $", "").replace(",", "");
    }

    public String getCoverageonPriority1O1() {
        return CoverageonPriority1O1.getText().replace("COVERAGE: $", "").replace(",", "");
    }

    public void verifySections() {
        int i = 0;
        String[] strSections = {"ABOUT YOU", "YOUR GOALS", "AFFORDABILITY", "NEEDS SUMMARY", "FEATURES"};
        for (WebElement sec : sections) {
            if (sec.getText().trim().equals(strSections[i])) {
                report.log(LogStatus.PASS, "Verify if " + strSections[i] + " is Displayed");
            } else {
                report.log(LogStatus.FAIL, "Verify if " + strSections[i] + " is Displayed");
            }
            i++;
        }

    }

    public String getSectionsData() {
        String strResult = null;
        List<WebElement> subsections = driver.findElements(By.xpath("//a[@class='page-value link']"));
        for (WebElement ele : subsections) {
            strResult = strResult + ";" + ele.getText();
        }
        return strResult;
    }

    public void clickExpand(int index) {
        jsClick(expandSections.get(index));
    }

    public void clickFeatureDifferentiation() {
        jsClick(expandSections.get(5));
        List<WebElement> subsections = driver.findElements(By.xpath("//a[@class='page-value link']"));
        jsClick(subsections.get(1));
    }

    public String get1ProductRecommendtion() {
        try {
            return oneProductRecommendtion.getText().trim();
        } catch (Exception e) {
            report.log(LogStatus.FAIL, "Product Recommendation page not displayed :: " + e.getMessage() + report.addBase64ScreenShot(CaptureScreen()));
            driver.quit();
            return "";
        }
    }

    public String getProductValue() {
        try {
            return ProductAmount.getText().replace("$ ", "");
        } catch (Exception e) {
            report.log(LogStatus.FAIL, "Product Recommendation page not displayed :: " + e.getMessage() + CaptureScreen());
            driver.quit();
            return "";
        }
    }

    public String get2ProductRecommendtion() {


        return twoProductRecommendtion.getText().trim();
    }

}
