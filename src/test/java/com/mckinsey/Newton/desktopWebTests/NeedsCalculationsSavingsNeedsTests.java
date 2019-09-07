package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.GeneralSavingsPage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class NeedsCalculationsSavingsNeedsTests extends TestSessionInitiator{
	
	@Test
	public void test() throws Exception {
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
		priorityPage.selectPriority("6.General Savings");		
		priorityPage.clickConsiderations();	
		
		GeneralSavingsPage generalSavingsPage = new GeneralSavingsPage(getDriver(), getReport());
		generalSavingsPage.ismakethishappenDisabled();
		assertTrue(generalSavingsPage.isroboDisplayed(), "ROBO is Displayed");
		assertTrue(generalSavingsPage.issavingsYearsDisplayed(), "Savings Years is displayed");
		assertTrue(generalSavingsPage.isSavingsAmountdisplayed(), "Savings Amount is displayed");
		
		generalSavingsPage.entersavingsYears("ssfh");
		verifyText(generalSavingsPage.getsavingYears(), "", "Alphabets not accepted");
		generalSavingsPage.entersavingsYears("@@$$))");
		verifyText(generalSavingsPage.getsavingYears(), "", "Special Charecters not accepted");
		generalSavingsPage.entersavingsYears("10.30");
		verifyText(generalSavingsPage.getsavingYears(), "10", "Decimal values not accepted");
		generalSavingsPage.entersavingsYears("-10");
		verifyText(generalSavingsPage.getsavingYears(), "10", "<=0 not accepted");
		generalSavingsPage.entersavingsYears("109");
		verifyText(generalSavingsPage.getsavingYears(), "10", "morethan 2 digits not accepted");
		
		generalSavingsPage.entersavingsAmount("ssfh");
		verifyText(generalSavingsPage.getsavingsAmount(), "", "Alphabets not accepted");
		generalSavingsPage.entersavingsAmount("1.88");
		verifyText(generalSavingsPage.getsavingsAmount(), "188", "Decimal values not accepted");
		generalSavingsPage.entersavingsAmount("-10");
		verifyText(generalSavingsPage.getsavingsAmount(), "10", "<=0 not accepted");
		generalSavingsPage.entersavingsAmount("1000000000");
		verifyText(""+generalSavingsPage.getsavingsAmount().length(), "7", "more than 7 digits not accepted");
		generalSavingsPage.entersavingsAmount("100000");
		verifyText(generalSavingsPage.getactualsavingsAmount(), "100,000", "Alphabets not accepted");
		
		generalSavingsPage.entersavingsAmount("");
		generalSavingsPage.entersavingsYears("");
		generalSavingsPage.ismakethishappenDisabled();
		
		generalSavingsPage.entersavingsAmount("2000");
		generalSavingsPage.entersavingsYears("60");
		generalSavingsPage.ismakethishappenEnabled();
		
		generalSavingsPage.clickMakethisHappen();
		ExistingInsurancePage existPage = new ExistingInsurancePage(getDriver(), getReport());
		assertTrue(existPage.isnopeDisplayed(), "Existing Insurence page is displayed");
	}

}
