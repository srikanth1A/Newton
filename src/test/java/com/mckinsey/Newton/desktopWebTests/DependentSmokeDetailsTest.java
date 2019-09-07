package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class DependentSmokeDetailsTest extends TestSessionInitiator{
	
	@Test(groups = {}, description = "Dependents Screen")
	public void DependentSmokeDetailsTest001() throws InterruptedException {		
		
		LandingPage landingPage =  new LandingPage(getDriver(), getReport());
		landingPage.clickStartNow();
		
		WelcomePage welcomePage = new WelcomePage(getDriver(), getReport());
		Thread.sleep(1000);
		welcomePage.clickConfirm();
		welcomePage.clickLetsGo();
		Thread.sleep(1000);
		NamePage namePage = new NamePage(getDriver(), getReport());
		Thread.sleep(1000);
		namePage.enterName("sss");
		Thread.sleep(1000);
		namePage.clickNext();
		
		GenderAgePage genderAgePage = new GenderAgePage(getDriver(), getReport());
		genderAgePage.enterDate("11");
		Thread.sleep(1000);
		genderAgePage.enterMonth("07");
		Thread.sleep(1000);
		genderAgePage.enterYear("1992");
		Thread.sleep(1000);
		
		genderAgePage.clickMale();
		Thread.sleep(1000);
		genderAgePage.clickNext();
		
		DependentsPage dependentsPage = new DependentsPage(getDriver(), getReport());
		
		assertTrue(dependentsPage.isJustMySelfDisplayed(), "Verify Just Myself Button ");
		Thread.sleep(1000);
		assertTrue(dependentsPage.isChildrenDisplayed(), "Verify Children Button ");
		Thread.sleep(1000);
		assertTrue(dependentsPage.isSpouseDisplayed(), "Verify Spouse Button ");
		assertTrue(dependentsPage.isParentsDisplayed(), "Verify Parents Button ");
		dependentsPage.isNextEnabled();
		Thread.sleep(1000);
		
		dependentsPage.clickJustMySelf();
		Thread.sleep(1000);
		assertTrue(dependentsPage.isJustMySelfGreyedout(), "Verify Just Myself Button Greyed Out ");
		dependentsPage.isNextEnabled();
		
		dependentsPage.clickSpouse();
		Thread.sleep(1000);
		assertTrue(dependentsPage.isSpouseGreyedout(), "Verify Spouse Button Greyed Out ");
		dependentsPage.clickChildren();
		assertTrue(dependentsPage.isChildrenGreyedout(), "Verify Children Button Greyed Out ");
		dependentsPage.clickParents();
		assertTrue(dependentsPage.isParentsGreyedout(), "Verify Spouse Button Greyed Out ");
		
		dependentsPage.clickJustMySelf();
		//assertTrue(dependentsPage.isSpouseGreyedout(), "Verify Spouse Button Greyed Out ");
		//assertTrue(dependentsPage.isChildrenGreyedout(), "Verify Children Button Greyed Out ");
		//assertTrue(dependentsPage.isParentsGreyedout(), "Verify Spouse Button Greyed Out ");
				
		dependentsPage.clickNext();
		SmokingHabitsPage SmokingHabitsPage = new SmokingHabitsPage(getDriver(), getReport());
		assertTrue(SmokingHabitsPage.isSmokingHabitsPageDisplayed(), "Verify Smoking Habits Page ");
		//dependentsPage.isNextEnabled();
		Thread.sleep(1000);
		
		SmokingHabitsPage.clickyes();	
		Thread.sleep(1000);
		SmokingHabitsPage.clickNext();
		Thread.sleep(1000);
		assertFalse(SmokingHabitsPage.isNoHilighted(), "Verify NO Hilighted ");
		assertTrue(SmokingHabitsPage.isYesHilighted(), "Verify Yes Hilighted ");
		dependentsPage.isNextEnabled();
		
		SmokingHabitsPage.clickno();
		Thread.sleep(1000);
		assertTrue(SmokingHabitsPage.isNoHilighted(), 
				"Verify NO Hilighted ");
		assertFalse( SmokingHabitsPage.isYesHilighted(), "Verify Yes Hilighted ");		
		dependentsPage.isNextEnabled();
		//SmokingHabitsPage.clickNext();
		dependentsPage.clickNext();
		PrioritiesPage prioritiesPage = new PrioritiesPage(getDriver(), getReport());
		  prioritiesPage.isPrioritiesEnabled();
		
		//assertTrue(prioritiesPage.isPrioritiesEnabled("priorities"), "Verify Priorities Page");
		//assertTrue(prioritiesPage.VerifyPriority("1.Death"), "Verify Priorities Page");
		//assertTrue(prioritiesPage.VerifyPriority("2.I suffer from TPD"), "Verify Priorities Page");
		
	}

	

}
