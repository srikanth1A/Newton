package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.RetirementGoalPage;
import com.mckinsey.Newton.pages.RetirementLifeStyle;
import com.mckinsey.Newton.pages.SectionsPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class NeedsCalculationsRetirementSummaryTests extends TestSessionInitiator{
	
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
		priorityPage.selectPriority("5.retirement");		
		priorityPage.clickConsiderations();	
		
		RetirementGoalPage retirementPage = new RetirementGoalPage(getDriver(), getReport());
		assertTrue(retirementPage.isRetirementAgeDisplayed(), "Retirement age is Displayed");
		assertTrue(retirementPage.isMonthlySpendingsDisplayed(), "Monthly Spending is Displayed");
		assertTrue(retirementPage.isRoboDisplayed(), "ROBO is Displayed");
		retirementPage.isNextEnabled();
		
		retirementPage.enterRetirementAge("asdfg");
		verifyText(retirementPage.getAge(), "", "Alpha numeric Charecters are not accepted");
		retirementPage.enterRetirementAge("@$%&)");
		verifyText(retirementPage.getAge(), "", "Special Charecters are not accepted");
		retirementPage.enterRetirementAge("60.10");
		verifyText(retirementPage.getAge(), "60", "Decimal values are not accepted");
		retirementPage.enterRetirementAge("-60");
		verifyText(retirementPage.getAge(), "60", "Negitive values are not accepted");
		retirementPage.enterRetirementAge("75");
		assertTrue(retirementPage.isageErrorDisplayed(), "Error on Age is Displayed");
		retirementPage.enterRetirementAge("60");
		
		retirementPage.enterstrMonthlySpendings("asdfg");
		verifyText(retirementPage.getmonthlyAge(), "", "Alpha numeric Charecters are not accepted");
		retirementPage.enterstrMonthlySpendings("@$%&)");
		verifyText(retirementPage.getmonthlyAge(), "", "Special Charecters are not accepted");
		retirementPage.enterRetirementAge("60.10");
		verifyText(retirementPage.getAge(), "60", "Decimal values are not accepted");
		retirementPage.enterRetirementAge("-60");
		verifyText(retirementPage.getAge(), "60", "Negitive values are not accepted");
		retirementPage.enterRetirementAge("12345678");
		verifyText(""+retirementPage.getAge().length(), "7", "Length Not morethan 7 digits");
		
		retirementPage.enterRetirementAge("60");
		retirementPage.enterstrMonthlySpendings("1000");
		retirementPage.isNextEnabled();
		retirementPage.clicklnknotsure();
		
		RetirementLifeStyle lifestylePage = new RetirementLifeStyle(getDriver(), getReport());
		assertTrue(lifestylePage.isspentAmountDisplayed(), "Retirement Life Style Page is displayed");
		String strAmount = lifestylePage.getAmount();
		lifestylePage.clickSubmit();		
		verifyText(retirementPage.getAge(), strAmount, "Values are taken from Life style screen");
		retirementPage.enterstrMonthlySpendings("1000");
		retirementPage.clicklnknotsure();
		lifestylePage.clickX();
		verifyText(retirementPage.getAge(), "1000", "Values are taken NOT from Life style screen");
		retirementPage.clickNext();
		
		ExistingInsurancePage existPage = new ExistingInsurancePage(getDriver(), getReport());
		assertTrue(existPage.isnopeDisplayed(), "Existing Insurence page is displayed");
		
	}

}
