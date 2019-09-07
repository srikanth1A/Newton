package com.mckinsey.Newton.desktopWebTests;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.BudgetPage;
import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.FeaturePage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.IncomeExpensesSavingsPage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.MyPreferrencePage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.NeedSummaryPage;
import com.mckinsey.Newton.pages.OurSuggestionsPage;
import com.mckinsey.Newton.pages.PremiumTermPage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.RegularIncomePage;
import com.mckinsey.Newton.pages.RiskPage;
import com.mckinsey.Newton.pages.SectionsPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class JourneyGuideTests extends TestSessionInitiator {
	
	@Test(dataProvider = "testdata")
	public void JourneyGuide(Hashtable<String, String> data) throws Exception {
		LandingPage landingPage = new LandingPage(getDriver(), getReport());		
		landingPage.clickStartNow();
		
		SectionsPage sectionsPage = new SectionsPage(getDriver(), getReport());		
		assertTrue(sectionsPage.isSideBarDisplayed("ABOUT YOU"), "Verify if ABOUT YOU is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("YOUR GOALS"), "verify if YOUR GOALS is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("AFFORDABILITY"), "verify if AFFORDABILITY is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("NEEDS SUMMARY"), "verify if NEEDS SUMMARY is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("FEATURES"), "verify if FEATURES is displayed");
				
		WelcomePage welcomePage = new WelcomePage(getDriver(), getReport());		
		welcomePage.clickConfirm();		
		welcomePage.clickLetsGo();
				
		assertTrue(sectionsPage.isSideBarDisplayed("Name"), "verify if Name is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("Age, Gender"), "verify if Gender, Age is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("Your dependents"), "verify if Your dependents is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("Smoking habits"), "verify if Smoking Habits is displayed");
		
		NamePage namePage = new NamePage(getDriver(), getReport());	
		namePage.enterName("Srikanth");
		//namePage.enterName(data.get("Name"));		
		namePage.clickNext();
		
		GenderAgePage genderAgePage = new GenderAgePage(getDriver(), getReport());	
		genderAgePage.enterCompleteData(data.get("Date"));		
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
		priorityPage.selectPriority("2.illness");		
		priorityPage.selectPriority("3.critical illness");		
		priorityPage.clickConsiderations();	
		
		//assertTrue(sectionsPage.isSideBarSisplayedwithValue("TPD"), "verify if TPD is displayed");
		//assertTrue(sectionsPage.isSideBarSisplayedwithValue("Late CI"), "verify if Late CI is displayed");
		//assertTrue(sectionsPage.isSideBarSisplayedwithValue("Early CI"), "verify if Early CI is displayed");
		//assertTrue(sectionsPage.isSideBarDisplayed("Existing insurance"), "verify if Existing Insurance is displayed");
		
		ExistingInsurancePage tpdPage = new ExistingInsurancePage(getDriver(), getReport());		
		//tpdPage.clicktotalPermanentDisability();
		
		tpdPage.enterPermanentDisabilityCoverage(data.get("Coverage1"));		
	
		tpdPage.clickearlyCriticalIllness();
		
		tpdPage.enterearlyCriticalIllnessCoverage(data.get("Coverage2"));
		
		tpdPage.clicklateCriticalIllness();
	
		tpdPage.enterlateCriticalIllnessCoverage(data.get("Coverage3"));
		
		tpdPage.clickThatswhatIcurrentlyhave();
		
		assertTrue(sectionsPage.isSideBarDisplayed("Employment"), "verify if Employment is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("Income, expenses, savings"), "verify if Income, expenses, savings is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("Budget"), "verify if Your Budget is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("Premium Term"), "verify if Premium Term is displayed");
		
		RegularIncomePage regularincomePage = new RegularIncomePage(getDriver(), getReport());
		regularincomePage.clickYes();
		regularincomePage.clickEMPLOYEE();
		regularincomePage.clickNext();
		
		IncomeExpensesSavingsPage incomepage = new IncomeExpensesSavingsPage(getDriver(), getReport());
		incomepage.entermonthlyTakeHome(data.get("TakeHome"));
		incomepage.entermonthlySpending(data.get("MonthlySpending"));
		incomepage.entercashSaving(data.get("CashSavings"));
		incomepage.enterbigExpenses(data.get("BigExpenses"));
		incomepage.clickthatsAboutRight();
		
		BudgetPage budgetpage = new BudgetPage(getDriver(), getReport());
		budgetpage.enteroneTimeAmount(data.get("BudgetAmount"));
		budgetpage.clickBudget();
		
		PremiumTermPage premiumPage = new PremiumTermPage(getDriver(), getReport());
		premiumPage.enterProtectionYears(data.get("Duration"));
		premiumPage.clickRange();
		
		NeedSummaryPage needsummaryPage = new NeedSummaryPage(getDriver(), getReport());
		needsummaryPage.clickLetsMove();
		
		assertTrue(sectionsPage.isSideBarDisplayed("Risks"), "verify if Risks is displayed");
		assertTrue(sectionsPage.isSideBarDisplayed("Feature Differentiation"), "verify if Feature Differentiation is displayed");
		
		RiskPage RiskPage = new RiskPage(getDriver(), getReport());
		RiskPage.clickAlmost();
		
		FeaturePage featurePage = new FeaturePage(getDriver(), getReport());
		featurePage.clickSkip();
		
		OurSuggestionsPage suggestionPage = new OurSuggestionsPage(getDriver(), getReport());
		suggestionPage.clickMyPreference();
		
		MyPreferrencePage myprefPage = new MyPreferrencePage(getDriver(), getReport());
		Thread.sleep(15000);
		/*myprefPage.verifySections();
		
		String strSectionOne = myprefPage.getSectionsData();
		String[] SectionOne = strSectionOne.split(";");
		verifyText(SectionOne[1], data.get("Name"), "Verify if Name is "+ data.get("Name"));
		verifyText(SectionOne[2], "Male", "Verify if Gender is MALE");
		verifyText(SectionOne[2], data.get("Date"), "Verify if Age is "+ data.get("Date"));
		verifyText(SectionOne[3], "Just Myself", "Verify if Dependencies is Just Myself");
		verifyText(SectionOne[4], "Does Not Smoke", "Verify if Smoking is NO ");
		myprefPage.clickExpand(1);
		String strSectionTwo = myprefPage.getSectionsData();
		String[] SectionTwo = strSectionTwo.split(";");
		verifyText(SectionTwo[1], "TPD", "Verify if 1st Priority is TPD");
		verifyText(SectionTwo[1], "Late CI", "Verify if 2nd Priority is LATE CI");
		verifyText(SectionTwo[1], "Early CI", "Verify if 3rd Priority is EARLY CI");
		verifyText(SectionTwo[2], "Has existing insurance", "Verify if Has existing insurance");
		myprefPage.clickExpand(2);
		String strSectionThree = myprefPage.getSectionsData();
		String[] SectionThree = strSectionThree.split(";");
		System.out.println(SectionThree[2]);
		verifyText(SectionThree[1], "Regular Income, Employee", "Verify if Regular Income, Employee is displayed");
		verifyText(SectionThree[2].replace(",", ""), data.get("TakeHome"), "Verify if INCOME is "+data.get("TakeHome"));
		verifyText(SectionThree[2].replace(",", ""), data.get("MonthlySpending"), "Verify if EXPENSES is "+data.get("MonthlySpending"));
		verifyText(SectionThree[2].replace(",", ""), data.get("CashSavings"), "Verify if CASH SAVINGS is "+data.get("CashSavings"));
		verifyText(SectionThree[2].replace(",", ""), data.get("BigExpenses"), "Verify if BIG EXPENSES is "+data.get("BigExpenses"));
		verifyText(SectionThree[3].replace(",", ""), data.get("BudgetAmount"), "Verify if LUMPSUM BUDGET is "+data.get("BudgetAmount"));
		verifyText(SectionThree[4], data.get("Duration"), "Verify if PREMIUM TERM is "+data.get("Duration"));
		myprefPage.clickExpand(3);
		String strSectionFour = myprefPage.getSectionsData();
		String[] SectionFour = strSectionFour.split(";");
		myprefPage.getSectionsData();
		verifyText(SectionFour[1], "Needs Summary", "Verify if NEEDS SUMMARY is displayed");
		myprefPage.clickExpand(4);
		String strSectionFive = myprefPage.getSectionsData();
		String[] SectionFive = strSectionFive.split(";");
		verifyText(SectionFive[1], "Moderately conservative", "Verify if Moderately conservative is displayed");
		verifyText(SectionFive[2], "Feature Differentiation", "Verify if Feature Differentiation is displayed");
				
		myprefPage.clickFeatureDifferentiation();
		assertTrue(featurePage.isPageDisplayed(), "Verify if Feature Differentiation page is displayed");
		featurePage.clickSkip();
		
		//suggestionPage.clickMyPreference();*/
		
		
	}

}
