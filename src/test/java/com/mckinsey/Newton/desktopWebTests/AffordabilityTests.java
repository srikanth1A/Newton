package com.mckinsey.Newton.desktopWebTests;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.ALittleHelperPage;
import com.mckinsey.Newton.pages.BudgetPage;
import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.GetInTouchPage;
import com.mckinsey.Newton.pages.IncomeExpensesSavingsPage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.RegularIncomePage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class AffordabilityTests extends TestSessionInitiator{
	
	@Test(groups = "Regression")
	public void AffordabilityEmployment() throws Exception {
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
		
		ExistingInsurancePage tpdPage = new ExistingInsurancePage(getDriver(), getReport());		
		tpdPage.clickIDontHave();
		
		RegularIncomePage regularincomePage = new RegularIncomePage(getDriver(), getReport());
		regularincomePage.clickYes();
		regularincomePage.clickEMPLOYEE();
		regularincomePage.clickNext();
		
		IncomeExpensesSavingsPage incomepage = new IncomeExpensesSavingsPage(getDriver(), getReport());
		incomepage.isaboutRightDisabled();
		assertTrue(incomepage.isBigExpenseDisplayed(), "Big Expense is Displayed");
		assertTrue(incomepage.isCashSavingsDisplayed(),"Cash Saving is Displayed");
		assertTrue(incomepage.isMonthlyTakeHomeDisplayed(),"Monthly TakeHome is Displayed");
		assertTrue(incomepage.isMonthlySpendingDisplayed(),"Monthly Spending is Displayed");
		
		
		incomepage.entermonthlyTakeHome("abcd");
		verifyText(incomepage.getMonthlyTakeHome(), "", "Alphabets Not accepted");
		incomepage.entermonthlyTakeHome("10.56");
		verifyText(incomepage.getMonthlyTakeHome(), "1056", "Decimal Values Not accepted");
		incomepage.entermonthlyTakeHome("-10");
		verifyText(incomepage.getMonthlyTakeHome(), "10", "<=0 Not accepted");
		incomepage.entermonthlyTakeHome("10000000");
		verifyText(""+incomepage.getMonthlyTakeHome().length(), "7", "<=0 Not accepted");
		
		incomepage.entermonthlySpending("abcd");
		verifyText(incomepage.getMonthlySpending(), "", "Alphabets Not accepted");
		incomepage.entermonthlySpending("10.56");
		verifyText(incomepage.getMonthlySpending(), "1056", "Decimal Values Not accepted");
		incomepage.entermonthlySpending("-10");
		verifyText(incomepage.getMonthlySpending(), "10", "<=0 Not accepted");
		incomepage.entermonthlySpending("10000000");
		verifyText(""+incomepage.getMonthlySpending().length(), "7", "<=0 Not accepted");
		
		incomepage.entercashSaving("abcd");
		verifyText(incomepage.getCashSavings(), "", "Alphabets Not accepted");
		incomepage.entercashSaving("10.56");
		verifyText(incomepage.getCashSavings(), "1056", "Decimal Values Not accepted");
		incomepage.entercashSaving("-10");
		verifyText(incomepage.getCashSavings(), "10", "<=0 Not accepted");
		incomepage.entercashSaving("10000000");
		verifyText(""+incomepage.getCashSavings().length(), "7", "<=0 Not accepted");
		
		incomepage.enterbigExpenses("abcd");
		verifyText(incomepage.getbigExpenses(), "", "Alphabets Not accepted");
		incomepage.enterbigExpenses("10.56");
		verifyText(incomepage.getbigExpenses(), "1056", "Decimal Values Not accepted");
		incomepage.enterbigExpenses("-10");
		verifyText(incomepage.getbigExpenses(), "10", "<=0 Not accepted");
		incomepage.enterbigExpenses("10000000");
		verifyText(""+incomepage.getbigExpenses().length(), "7", "<=0 Not accepted");
		
		incomepage.clickHealpMeCalu();
		
		ALittleHelperPage helppage = new ALittleHelperPage(getDriver(), getReport());
		helppage.enterFood("100");
		helppage.enterloan("200");
		helppage.enterOtherexpenses("100");
		helppage.enterOtherInstalments("100");
		helppage.enterpocketMoney("100");
		helppage.enterrent("300");
		helppage.enterUtilities("100");
		verifyText(""+helppage.getTotal(),"1000","Total is currect");
		helppage.clicksumthisUp();
		
		verifyText(incomepage.getMonthlySpending(), "1000", "value came from Help Page");
		
		incomepage.entermonthlyTakeHome("2000");
		incomepage.entermonthlySpending("2000");
		incomepage.entercashSaving("10000");	
		incomepage.enterbigExpenses("");
		incomepage.clickthatsAboutRight();
		
		GetInTouchPage touchPage = new GetInTouchPage(getDriver(), getReport());
		assertTrue(touchPage.isGetInTouchPage(), "GET IN TOUCH Page is Displayed");
		touchPage.clickX();
		
		incomepage.entermonthlyTakeHome("2000");
		incomepage.entermonthlySpending("2000");
		incomepage.entercashSaving("10000");
		incomepage.enterbigExpenses("");
		incomepage.clickthatsAboutRight();
		
		assertTrue(touchPage.isGetInTouchPage(), "GET IN TOUCH Page is Displayed");
		touchPage.clickX();
		
		incomepage.entermonthlyTakeHome("3000");
		incomepage.entermonthlySpending("2000");
		incomepage.entercashSaving("20000");
		incomepage.enterbigExpenses("");
		incomepage.clickthatsAboutRight();
		
		BudgetPage budgetPage = new BudgetPage(getDriver(), getReport());
		assertTrue(budgetPage.isrecurringMonthlyAmountDisplayed(), "Budget Page is Displayed");		
		
	}

}
