package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class DeathNeeds extends TestSessionInitiator {
  @Test
  public void verifycontentsondeathneeds() throws Exception {
	  LandingPage landingPage = new LandingPage(getDriver(), getReport());
		landingPage.clickStartNow();
		WelcomePage welcomePage = new WelcomePage(getDriver(), getReport());
		welcomePage.clickConfirm();
		welcomePage.clickLetsGo();
		NamePage namePage = new NamePage(getDriver(), getReport());
		namePage.enterName("Srikanth");
		namePage.clickNext();
		GenderAgePage genderAgePage = new GenderAgePage(getDriver(), getReport());
		genderAgePage.enterDate("01");
		genderAgePage.enterMonth("01");
		genderAgePage.enterYear("1992");
		genderAgePage.clickFemale();
		genderAgePage.clickNext();
		DependentsPage dependentsPage = new DependentsPage(getDriver(), getReport());		
		dependentsPage.clickParents();	
		dependentsPage.clickChildren();
		dependentsPage.clickNext();		
		
		SmokingHabitsPage smokingHabitsPage = new SmokingHabitsPage(getDriver(), getReport());		
		smokingHabitsPage.clickno();		
		smokingHabitsPage.clickNext();		
		
		PrioritiesPage priorityPage = new PrioritiesPage(getDriver(), getReport());	
		priorityPage.clickOnDearth();	
		
		priorityPage.clickConsiderations();	
		Thread.sleep(9000);
		ExistingInsurancePage tpdPage = new ExistingInsurancePage(getDriver(), getReport());		
		tpdPage.spouseAmountFieldEnabled();
		tpdPage.childrenAmountFieldEnabled();
		tpdPage.enterAmountField1("200");//unable to enter amount
		Thread.sleep(9000);
		//DependentsPage dependentsPagee = new DependentsPage(getDriver(), getReport());
		//dependentsPage.clickJustMySelf();
		
		
	  
	  
  }
}
