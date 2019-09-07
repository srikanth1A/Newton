package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.*;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class LandingTest extends TestSessionInitiator {

   @Test(priority = 0)
    public void Verifylandingpagelinks() throws InterruptedException {

        LandingPage landingPage = new LandingPage(getDriver(), getReport());
       
        
        landingPage.isLifeInsurance101visible();
        landingPage.isOurStoryVisible();
        landingPage.isReviewVisible();
        landingPage.isOurStoryVisible();
        
       landingPage.clickhowdoesitwork();
        Thread.sleep(1000);
        landingPage.isPersonalDetailsvisible();
        
      landingPage.clickLifeInsurance101();
        Thread.sleep(1000);
        landingPage.isLifeInsurencevisible();
        
        landingPage.clickReview();
        Thread.sleep(1000);
        landingPage.isWhatSayingVisible();
        
      landingPage.clickOurStory();
        Thread.sleep(1000);
        landingPage.isStoryNewtonVisible();
        Thread.sleep(1000);
        landingPage.clickStartNow();
        //landingPage.clickStartNow();
        //Thread.sleep(1000);
        
        WelcomePage welcomePage = new WelcomePage(getDriver(), getReport());
        welcomePage.verifyConfirm();        
        welcomePage.isLetsGoVisible();
        
        welcomePage.clickConfirm();
        welcomePage.isLetsGoVisible();     

    }

	@Test(priority = 1)
    public void ChecklinksandcontentsunderWhatandWhyLifeInsurancesectionarecorrect() throws InterruptedException {

        LandingPage landingPage = new LandingPage(getDriver(), getReport());
        Thread.sleep(1000);
        landingPage.clickLifeInsurance101();
        //Thread.sleep(1000);
        landingPage.clickminimise();
        Thread.sleep(1000);
        landingPage.clickminimise();
       //landingPage.clickexpand(); 
        //Thread.sleep(1000);
        
        verifyText(landingPage.HealthInsurance(), "https://healthinsurance.income.com.sg/",
                "Verified the Page URL as ");
        Thread.sleep(1000);
        //verifyText(landingPage.LifeInsurance(), "https://healthinsurance.income.com.sg/",
         //       "Verified the Page URL as ");
        Thread.sleep(1000);
        verifyText(landingPage.GeneralInsurance(), "https://insurance.income.com.sg/",
                "Verified the Page URL as ");
        Thread.sleep(1000);
        //verifyText(landingPage.PrivacyPolicy(), "https://www.income.com.sg/privacy-policy",
        //        "Verified the Page URL as ");
        Thread.sleep(1000);
        verifyText(landingPage.SecurityPolicy(), "https://www.income.com.sg/security-policy",
                "Verified the Page URL as ");
        Thread.sleep(1000);
        verifyText(landingPage.TermsConditions(), "https://www.income.com.sg/terms-of-use",
                "Verified the Page URL as ");
        Thread.sleep(1000);
        verifyText(landingPage.instagram(), "https://www.instagram.com/travelmadedifferent/",
                "Verified the Page URL as ");
        Thread.sleep(1000);
        verifyText(landingPage.facebook(), "https://www.facebook.com/NTUCIncomeInsurance",
                "Verified the Page URL as ");
        Thread.sleep(1000);
        verifyText(landingPage.linkedin(), "https://www.linkedin.com/company/income",
                "Verified the Page URL as ");
        Thread.sleep(1000);
        verifyText(landingPage.youtube(), "https://www.youtube.com/you/ntucincomeinsurance",
                "Verified the Page URL as ");
        Thread.sleep(1000);
        
        landingPage.clickStartNow();
        Thread.sleep(1000);
        
        WelcomePage welcomePage = new WelcomePage(getDriver(), getReport());
        assertTrue(welcomePage.isLetsGoVisible(), "Verify Welcome Page");
        
    }

	
    
}
