package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.BudgetPage;
import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.FeaturePage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.IncomeExpensesSavingsPage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.NeedSummaryPage;
import com.mckinsey.Newton.pages.OurSuggestionsPage;
import com.mckinsey.Newton.pages.PremiumTermPage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.RegularIncomePage;
import com.mckinsey.Newton.pages.RetirementGoalPage;
import com.mckinsey.Newton.pages.RiskPage;
import com.mckinsey.Newton.pages.SectionsPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class FeatureDifferentiation extends TestSessionInitiator {
	
  @Test
  public void f() throws Exception {
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
		priorityPage.selectPriority("1.TPD");
		priorityPage.selectPriority("5.retirement");
		priorityPage.selectPriority("7.Death");
		priorityPage.clickConsiderations();	
		
		RetirementGoalPage retirementPage = new RetirementGoalPage(getDriver(), getReport());
		retirementPage.enterRetirementAge("60");
		retirementPage.enterstrMonthlySpendings("2000");
		retirementPage.clickNext();
		
	    ExistingInsurancePage ExistingInsurancePage = new ExistingInsurancePage(getDriver(), getReport());		
		ExistingInsurancePage.clickIDontHave();
		
		RegularIncomePage regularincomePage = new RegularIncomePage(getDriver(), getReport());
		regularincomePage.clickYes();
		regularincomePage.clickEMPLOYEE();
		regularincomePage.clickNext();
		
		IncomeExpensesSavingsPage incomepage = new IncomeExpensesSavingsPage(getDriver(), getReport());
		incomepage.entermonthlyTakeHome("2000");
		incomepage.entermonthlySpending("1000");
		incomepage.entercashSaving("20000");
		incomepage.enterbigExpenses("1000");
		incomepage.clickthatsAboutRight();
		
		BudgetPage budgetpage = new BudgetPage(getDriver(), getReport());
		budgetpage.enterrecurringMonthlyAmount("100");
		budgetpage.clickBudget();
		
		PremiumTermPage premiumPage = new PremiumTermPage(getDriver(), getReport());
		premiumPage.enterProtectionYears("10");
		premiumPage.clickRange();
		
		NeedSummaryPage needsummaryPage = new NeedSummaryPage(getDriver(), getReport());
		needsummaryPage.clickLetsMove();
		
		RiskPage RiskPage = new RiskPage(getDriver(), getReport());
		RiskPage.clickAlmost();
		
		FeaturePage featurePage = new FeaturePage(getDriver(), getReport());
		assertTrue(featurePage.geticonsCount(), "Verify if Icons are displayed");
		featurePage.isgetMyresultsDisabled();
		featurePage.isNextEnabled();
		assertTrue(featurePage.geticonsCount(), "Verify if Icons are displayed");
		
		SectionsPage sectionsPage = new SectionsPage(getDriver(), getReport());
		sectionsPage.clickSection("Protection premium term");
		
		premiumPage.enterProtectionYears("");
		premiumPage.enterSavingsYears("10");
		premiumPage.clickRange();
		needsummaryPage.clickLetsMove();
		RiskPage.clickAlmost();
		assertTrue(featurePage.geticonsCount(), "Verify if Icons are displayed");
		featurePage.isgetMyresultsDisabled();
		featurePage.isNextEnabled();
		assertTrue(featurePage.geticonsCount(), "Verify if Icons are displayed");
		
		sectionsPage.clickSection("Savings premium term");
		premiumPage.enterProtectionYears("10");
		premiumPage.clickRange();
		needsummaryPage.clickLetsMove();
		RiskPage.clickAlmost();
		assertTrue(featurePage.geticonsCount(), "Verify if Icons are displayed");
		featurePage.isgetMyresultsDisabled();
		featurePage.isNextEnabled();
		assertTrue(featurePage.geticonsCount(), "Verify if Icons are displayed");
		
		featurePage.selectplan("main plan");
		assertTrue(featurePage.ischecked("main plan"), "Check box is selected after clicking");
		featurePage.isNextEnabled();
		featurePage.isgetMyresultsEnabled();
		
		featurePage.selectplan("main plan");
		assertFalse(featurePage.ischecked("main plan"), "Check box is selected after clicking");
		featurePage.isNextEnabled();
		featurePage.isgetMyresultsDisabled();
		
		featurePage.selectplan("main plan");
		featurePage.selectplan("optional cash payouts");
		featurePage.clickResults();
		
		OurSuggestionsPage suggestionPage = new OurSuggestionsPage(getDriver(), getReport());
		assertTrue(suggestionPage.checkrecommendationSummeryScreen(), "Recommendation Summary Screen is Displayed");
		
		
		
		
  }
}
