package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;



import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class InfoAboutNewton extends TestSessionInitiator {


  @Test
  public void InfoAbout() throws InterruptedException {
	  LandingPage landingPage =  new LandingPage(getDriver(), getReport());
	  Thread.sleep(3000);
	  landingPage.clickStartNow();
	  Thread.sleep(3000);
	  WelcomePage welcomePage = new WelcomePage(getDriver(), getReport());
	  
	 // boolean Enable_statuss=welcomePage.isLimitationsVisible();
		Thread.sleep(1000);
		assertFalse(welcomePage.isLimitationsVisible(), "Verify if Limitations are visible");
		//System.out.println("Is limitations enable"+Enable_statuss);
		Thread.sleep(1000);
		welcomePage.dontclickConfirm();
		Thread.sleep(1000);
		welcomePage.clickLetsGo();
		Thread.sleep(1000);
		welcomePage.isLetsGoVisible();
		//boolean statuss=welcomePage.isLetsGoVisible();
		//Thread.sleep(1000);
		//System.out.println("Is letsgo disable"+statuss);
		Thread.sleep(1000);
		welcomePage.clickConfirm();
		Thread.sleep(1000);
		welcomePage.clickLetsGo();
		Thread.sleep(1000);
		
		NamePage namePage = new NamePage(getDriver(), getReport());
		Thread.sleep(1000);
		namePage.isEnterNameEnabled();
		Thread.sleep(1000);	
	  
	  
  }
  
  
	
}
