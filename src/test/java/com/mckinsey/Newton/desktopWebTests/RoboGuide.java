package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class RoboGuide extends TestSessionInitiator{
  @Test
  public void Userwanttoseerobotip() throws InterruptedException {
	  
	  LandingPage landingPage = new LandingPage(getDriver(), getReport());
		landingPage.clickStartNow();
		WelcomePage welcomePage = new WelcomePage(getDriver(), getReport());
		welcomePage.clickConfirm();
		
		
		welcomePage.clickLetsGo();
		
		NamePage namePage = new NamePage(getDriver(), getReport());
		namePage.isHelpTipEnabled();
		namePage.clickHelpTip();
		namePage.isHelpTipMsgEnabled();
		namePage.clickCloseTip();
		Thread.sleep(6000);
  }
}
