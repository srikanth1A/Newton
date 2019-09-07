package com.mckinsey.Newton.desktopWebTests;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class AboutYouTests extends TestSessionInitiator{
	
	@Test()
	public void Userwantstogetadvisedonherorhisneeds(ITestContext context) throws InterruptedException {		
		
		LandingPage landingPage = new LandingPage(getDriver(), getReport());
		landingPage.clickStartNow();
		
		WelcomePage welcomePage = new WelcomePage(getDriver(), getReport());
		assertTrue(welcomePage.isLetsGoVisible(), "Verify Lets Go button");
		assertTrue(welcomePage.isConfirmVisible(), "Verify Please confirm that you are fluent in English before proceeding Checkbox");
		welcomePage.verifyConfirm();
		
		welcomePage.clickConfirm();
		welcomePage.verifyConfirm();
		
		welcomePage.clickLetsGo();
		
		NamePage namePage = new NamePage(getDriver(), getReport());
		namePage.isNextEnabled();
		
		namePage.enterName("Srikanth");
		namePage.isNextEnabled();
		
		namePage.clickNext();
		
		GenderAgePage genderAgePage = new GenderAgePage(getDriver(), getReport());
		genderAgePage.isNextEnabled();
		
		//genderAgePage.enterDate("45");		
		//genderAgePage.enterMonth("45");
		//genderAgePage.isErorpopupDisplayed();
		//genderAgePage.clearDay();
		//genderAgePage.clearMonth();

		
		//genderAgePage.enterDate("01");
		//genderAgePage.enterMonth("01");
		//genderAgePage.enterYear("2015");
		
		
		//genderAgePage.isErrorpopupDisplayed();
		//genderAgePage.closeErrorpopup();
		
		genderAgePage.enterDate("01");
		genderAgePage.enterMonth("01");
		genderAgePage.enterYear("1940");
		genderAgePage.clickFemale();
		genderAgePage.clickNext();
		//genderAgePage.isErrorpopupDisplayed();
		verifyText(genderAgePage.clickgetinContactButton(), "https://askdex.sit.income.com.sg/contact-us", 
			"Verify Contact Screen is displayed ");
		
		genderAgePage.closeErrorpopup();
		
		genderAgePage.clickMale();
		genderAgePage.clickNext();
		
		DependentsPage dependentsPage = new DependentsPage(getDriver(), getReport());
		assertTrue(dependentsPage.isDependentsPageDisplayed(), "Verify Contact Screen is displayed ");
	}

}
