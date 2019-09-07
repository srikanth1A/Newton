package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.GeneralSavingsPage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.RetirementGoalPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class ExisitngPoliciesTests extends TestSessionInitiator{
	
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
			genderAgePage.clickFemale();
			genderAgePage.clickNext();
			
			DependentsPage dependentsPage = new DependentsPage(getDriver(), getReport());		
			dependentsPage.clickJustMySelf();	
			dependentsPage.clickNext();		
			
			SmokingHabitsPage smokingHabitsPage = new SmokingHabitsPage(getDriver(), getReport());		
			smokingHabitsPage.clickno();		
			smokingHabitsPage.clickNext();		
			
			PrioritiesPage priorityPage = new PrioritiesPage(getDriver(), getReport());	
			priorityPage.selectPriority("7.Death");
			priorityPage.selectPriority("6.General Savings");
			priorityPage.selectPriority("5.retirement");
			priorityPage.clickConsiderations();
			
			GeneralSavingsPage generalSavingsPage = new GeneralSavingsPage(getDriver(), getReport());
			generalSavingsPage.entersavingsAmount("10000");
			generalSavingsPage.entersavingsYears("10");
			generalSavingsPage.clickMakethisHappen();
			
			RetirementGoalPage retirementPage = new RetirementGoalPage(getDriver(), getReport());
			retirementPage.enterRetirementAge("60");
			retirementPage.enterstrMonthlySpendings("2000");
			retirementPage.clickNext();
			
			ExistingInsurancePage existInsPage = new ExistingInsurancePage(getDriver(), getReport());
			assertTrue(existInsPage.isnopeDisplayed(), "Nope, I don't have any is displayed");
			assertTrue(existInsPage.isPolicyProtectionDisplayed(), "Checkbox unchecked");
			assertTrue(existInsPage.issavingsProtectionDisplayed(),"Checkbox unchecked");
			existInsPage.clickSavings();
			existInsPage.clickprotection();
			assertTrue(existInsPage.isPolicyProtectionDisplayed(), "Checkbox checked");
			assertTrue(existInsPage.issavingsProtectionDisplayed(),"Checkbox checked");
			assertFalse(existInsPage.isnopeDisplayed(), "Nope, I don't have any is NOT displayed");
			assertTrue(existInsPage.isThatswhatIcurrentlyhavedisplayed(),"Thats what i have currently button is displayed");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.enterpolicyField("adghgf");
			verifyText(existInsPage.getpolicyField(),"" , "Policy Field dint accept alphabets");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.enterpolicyField("%&^&(&(");
			verifyText(existInsPage.getpolicyField(),"" , "Policy Field dint accept special charecters");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.enterpolicyField("10000009");
			verifyText(""+existInsPage.getpolicyField().length(),"7" , "Policy Field dint accept morethan 7 digits");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.enterpolicyField("0");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.enterpolicyField("1000");
			existInsPage.isThatswhatIcurrentlyhaveEnabled();
			
			existInsPage.clickprotection();
			
			assertTrue(existInsPage.issavingplanDisplayed(), "Savings plan is displayed");
			assertTrue(existInsPage.isexistingsavingsDisplayed(), "Existing Savings is displayed");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.entersavings("adghgf");
			verifyText(existInsPage.getentersavings(),"" , "Savings Field dint accept alphabets");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.entersavings("%&^&(&(");
			verifyText(existInsPage.getentersavings(),"" , "Savings Field dint accept special charecters");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.entersavings("10000009");
			verifyText(""+existInsPage.getentersavings().length(),"7" , "Savings Field dint accept morethan 7 digits");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.entersavings("0");
			verifyText(existInsPage.getentersavings(),"" , "Savings Field dint accept 0");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.entersavings("1000");
			existInsPage.isThatswhatIcurrentlyhaveEnabled();
			
			existInsPage.clickSavings();
			existInsPage.clickretirement();
			assertTrue(existInsPage.islumpsumDisplayed(), "LumpSum Field is displayed");
			assertTrue(existInsPage.ismonthlyDisplayed(), "Monthly Field is displayed");
			assertTrue(existInsPage.isretirementSavingsDisplayed(), "Retirement Savings Field is displayed");
			assertTrue(existInsPage.iscpfLifeDisplayed(), "CPF LIFE checkbox is displayed");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.enterlumpsum("adghgf");
			verifyText(existInsPage.getlumpsum(),"" , "LUMP SUM Field dint accept alphabets");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.enterlumpsum("%&^&(&(");
			verifyText(existInsPage.getlumpsum(),"" , "LUMP SUM Field dint accept special charecters");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.enterlumpsum("10000009");
			verifyText(""+existInsPage.getlumpsum().length(),"7" , "LUMP SUM Field dint accept morethan 7 digits");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.enterlumpsum("0");
			verifyText(existInsPage.getlumpsum(),"" , "LUMP SUM Field dint accept 0");
			existInsPage.isThatswhatIcurrentlyhaveDisabled();
			
			existInsPage.enterlumpsum("1000");
			existInsPage.isThatswhatIcurrentlyhaveEnabled();
			
			
			existInsPage.clickcpfLife();
			assertTrue(existInsPage.iscpfLifeselected(), "CPF LIFE is selected");			
			
			existInsPage.clickThatswhatIcurrentlyhave();
	}

}
