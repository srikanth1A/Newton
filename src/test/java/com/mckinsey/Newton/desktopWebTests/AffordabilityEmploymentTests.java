package com.mckinsey.Newton.desktopWebTests;

import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.RegularIncomePage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;
import org.testng.annotations.Test;

public class AffordabilityEmploymentTests extends TestSessionInitiator{
	
	@Test
	public void Test() throws Exception {
		
		LandingPage landingPage = new LandingPage(getDriver(), getReport());		
		landingPage.clickStartNow();
						
		WelcomePage welcomePage = new WelcomePage(getDriver(), getReport());		
		welcomePage.clickConfirm();		
		welcomePage.clickLetsGo();
				
		NamePage namePage = new NamePage(getDriver(), getReport());	
		namePage.enterName("Srikanth");	
		namePage.clickNext();
		
		GenderAgePage genderAgePage = new GenderAgePage(getDriver(), getReport());	
		genderAgePage.enterCompleteData("01/01/1992");		
		genderAgePage.clickMale();		
		genderAgePage.clickNext();
		
		DependentsPage dependentsPage = new DependentsPage(getDriver(), getReport());		
		dependentsPage.clickJustMySelf();		
		dependentsPage.clickNext();		
		
		SmokingHabitsPage smokingHabitsPage = new SmokingHabitsPage(getDriver(), getReport());		
		smokingHabitsPage.clickno();		
		smokingHabitsPage.clickNext();		
		
		PrioritiesPage priorityPage = new PrioritiesPage(getDriver(), getReport());		
		priorityPage.selectPriority("1.TPD");		
		priorityPage.clickConsiderations();	
		
		ExistingInsurancePage existInsPage = new ExistingInsurancePage(getDriver(), getReport());
		existInsPage.clicknope();
		
		RegularIncomePage regularincomePage = new RegularIncomePage(getDriver(), getReport());
		assertTrue(regularincomePage.isYesDisplayed(), "Yes is Displayed");
		assertTrue(regularincomePage.isNoDisplayed(), "No is Displayed");
		regularincomePage.isnextDisabled();
		
		regularincomePage.clickYes();
		assertTrue(regularincomePage.isEMPLOYEEDisplayed(), "EMPLOYEE is Displayed");
		assertTrue(regularincomePage.isCONTRACTEMPLOYEEDisplayed(), "CONTRACT EMPLOYEED is Displayed");
		assertTrue(regularincomePage.isSELFEMPLOYEDDisplayed(), "SELF EMPLOYED is Displayed");
		
		regularincomePage.clickYes();
		regularincomePage.isnextDisabled();
		
		regularincomePage.clickNo();
		assertTrue(regularincomePage.ismyownSavingsDisplayed(), "USING MY OWN SAVINGS is Displayed");
		assertTrue(regularincomePage.issomeoneisPayingDisplayed(), "SOMEONE IS PAYING FOR ME is Displayed");
		assertTrue(regularincomePage.isnotsureDisplayed(), "I'M NOT SURE is Displayed");
		
	}

}
