package com.mckinsey.Newton.desktopWebTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class NewtonStory  extends TestSessionInitiator {
  @Test
  public void OurStory() throws InterruptedException {
	  
	  LandingPage landingPage =  new LandingPage(getDriver(), getReport());
		Thread.sleep(3000);
		
		landingPage.clickOurStory();
		Thread.sleep(2000);
		
		boolean  our_story=landingPage.isOurStoryVisible();
		System.out.println(our_story);
		
		boolean Enable_status=landingPage.isReadMorevisible();
		Thread.sleep(1000);
		System.out.println("Is read more is enable"+Enable_status);
	
		Thread.sleep(1000);
		landingPage.clickReadMore();
		Thread.sleep(1000);
		boolean ReadLess_status=landingPage.isReadLessvisible();
		Thread.sleep(1000);
		System.out.println("Is read less is enable"+Enable_status);
		Thread.sleep(1000);
		landingPage.clickReadLess();
		Thread.sleep(1000);
		
		boolean Enable_statuss=landingPage.isReadMorevisible();
		Thread.sleep(1000);
		System.out.println("Is read more is enable"+Enable_status);
	
		
		
		
		
  }
}
