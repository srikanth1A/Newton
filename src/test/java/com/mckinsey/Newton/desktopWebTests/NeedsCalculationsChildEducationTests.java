package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.EducationPlanningPage;
import com.mckinsey.Newton.pages.EducationSavingPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.GeneralSavingsPage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.ParentsPage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.RetirementGoalPage;
import com.mckinsey.Newton.pages.SectionsPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class NeedsCalculationsChildEducationTests extends TestSessionInitiator{
	
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
		priorityPage.selectPriority("8.My Children");		
		priorityPage.clickConsiderations();	
		
		EducationSavingPage eduPage = new EducationSavingPage(getDriver(), getReport());
		assertTrue(eduPage.isAgeDisplayed(), " Age of child is displayed");
		assertTrue(eduPage.iscurrencyDisplayed(), " Amount needed is displayed");
		assertTrue(eduPage.isRoboDisplayed(), " Robo is displayed");
		eduPage.isNextDisabled();
		
		eduPage.enterAge("sdfgh");
		verifyText(eduPage.getAge(),"","alphabets Not accepted");
		eduPage.enterAge("@#%^&(");
		verifyText(eduPage.getAge(),"","Special Charecters Not accepted");
		eduPage.enterAge("10.05");
		verifyText(eduPage.getAge(),"10","Decimal values Not accepted");
		eduPage.enterAge("-10");
		verifyText(eduPage.getAge(),"10","<=0 Not accepted");
		eduPage.enterAge("190");
		verifyText(eduPage.getAge(),"19",">=99 Not accepted");
		eduPage.enterAge("30");
		assertTrue(eduPage.isErrorlabelDisplayed(),"Error Label : Please enter a valid age of your child is Displayed");
		eduPage.enterAge("10");
		
		eduPage.enterCurrency("sdfgh");
		verifyText(eduPage.getCurrency(),"","alphabets Not accepted");
		eduPage.enterCurrency("@#%^&(");
		verifyText(eduPage.getCurrency(),"","Special Charecters Not accepted");
		eduPage.enterCurrency("10.05");
		verifyText(eduPage.getCurrency(),"10","Decimal values Not accepted");
		eduPage.enterCurrency("-10");
		verifyText(eduPage.getCurrency(),"10","<=0 Not accepted");
		eduPage.enterCurrency("100000000");
		verifyText(""+eduPage.getCurrency().length(),"7","<=0 Not accepted");
				
		eduPage.enterCurrency("1000");
		eduPage.isNextEnabled();
		eduPage.clearCurrency();
		eduPage.isNextDisabled();
		
		eduPage.enterAge("19");
		eduPage.clickNext();
		EducationPlanningPage eduPlan = new EducationPlanningPage(getDriver(), getReport());
		assertTrue(eduPlan.isReviseDisplayed(), "LET ME REVISE THAT is displayed");
		assertTrue(eduPlan.isGeneralSavingsDisplayed(), "CHANGE TO GENERAL SAVINGS GOAL is displayed");
		eduPlan.clickX();
		
		eduPage.enterAge("25");
		eduPage.clickNext();
		assertTrue(eduPlan.isReviseDisplayed(), "LET ME REVISE THAT is displayed");
		assertTrue(eduPlan.isGeneralSavingsDisplayed(), "CHANGE TO GENERAL SAVINGS GOAL is displayed");
		eduPlan.clickRevise();		
		verifyText(eduPage.getAge(),"","AGE is blank");
		
		eduPage.enterAge("10");
		eduPage.enterCurrency("1000");
		eduPage.clickNext();
		ExistingInsurancePage existPage = new ExistingInsurancePage(getDriver(), getReport());
		assertTrue(existPage.isnopeDisplayed(), "Existing Insurence page is displayed");
		
		SectionsPage sectionsPage = new SectionsPage(getDriver(), getReport());	
		sectionsPage.clickSection("Children Education");
		String[] priorities = {"1.TPD", "2.late critical illness", "3.early critical illness", "4.cancer", "5.retirement", "6.General Savings", "7.Death"};
		for(int i = 0; i<priorities.length; i++) {
			
			priorityPage.remove1stPriority();
			priorityPage.selectPriority(priorities[i]);
			priorityPage.clickConsiderations();
			
			if(i == 0) {				
				assertTrue(existPage.isnopeDisplayed(), "Existing Insurence page is displayed");
				sectionsPage.clickSection("TPD");
			}
			if(i == 1) {				
				assertTrue(existPage.isnopeDisplayed(), "Existing Insurence page is displayed");
				sectionsPage.clickSection("Late CI");
			}
			if(i == 2) {				
				assertTrue(existPage.isnopeDisplayed(), "Existing Insurence page is displayed");
				sectionsPage.clickSection("Early CI");
			}
			if(i == 3) {
				assertTrue(existPage.isnopeDisplayed(), "Existing Insurence page is displayed");
				sectionsPage.clickSection("Cancer");
			}
			if(i == 4) {
				RetirementGoalPage retirementPage = new RetirementGoalPage(getDriver(), getReport());
				assertTrue(retirementPage.isMonthlySpendingsDisplayed(), "Retirement Goal Page is displayed");
				sectionsPage.clickSection("Retirement");
			}
			if(i == 5) {
				GeneralSavingsPage generalSavingsPage = new GeneralSavingsPage(getDriver(), getReport());
				assertTrue(generalSavingsPage.issavingsYearsDisplayed(), "General Savings Page is Displayed");
				sectionsPage.clickSection("General Savings");				
			}
			if(i == 6) {
				ParentsPage parentsPage = new ParentsPage(getDriver(), getReport());
				assertTrue(parentsPage.isCoverMeDisplayed(), "Death Page is Displayed");				
			}
			
		}		
		
		
	}

}
