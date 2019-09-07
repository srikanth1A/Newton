package com.mckinsey.Newton.desktopWebTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.ALittleHelperPage;
import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.IncomeExpensesSavingsPage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.RegularIncomePage;
import com.mckinsey.Newton.pages.SectionsPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class SpendingCaluclator extends TestSessionInitiator  {
  @Test
  public void f()throws Exception  {
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
		dependentsPage.clickJustMySelf();	
		//dependentsPage.clickChildren();
		dependentsPage.clickNext();		
		
		SmokingHabitsPage smokingHabitsPage = new SmokingHabitsPage(getDriver(), getReport());		
		smokingHabitsPage.clickno();		
		smokingHabitsPage.clickNext();		
		
		PrioritiesPage priorityPage = new PrioritiesPage(getDriver(), getReport());	
		priorityPage.clickOnDearth();	
		
		priorityPage.clickConsiderations();	
		//Thread.sleep(9000);
	    ExistingInsurancePage ExistingInsurancePage = new ExistingInsurancePage(getDriver(), getReport());		
		ExistingInsurancePage.clickIDontHave();
		
		RegularIncomePage regularincomePage = new RegularIncomePage(getDriver(), getReport());
		regularincomePage.clickYes();
		regularincomePage.clickEMPLOYEE();
		regularincomePage.clickNext();
		IncomeExpensesSavingsPage incomepage = new IncomeExpensesSavingsPage(getDriver(), getReport());
		//captureScreen(driver, "Spendind");
		incomepage.clickHealpMeCalu();
		Thread.sleep(5000);
		//assertTrue(regularincomePage.isSideBarDisplayed("A little helper"), "Verify if A little helper pop up is displayed");
		//assertTrue(regularincomePage.isFoodAndGrocriesDisplayed("Food and groceries"), "Verify if Food and groceries option is displayed");
		//assertTrue(regularincomePage.isRentDisplayed("Rent"), "Verify if Rent option displayed");
		//assertTrue(regularincomePage.isLoanDisplayed("Loans and mortgages"), "Verify if Loans and mortgages displayed");
		//assertTrue(regularincomePage.isUtilitiesDisplayed("Utilities"), "Verify if Utilities option is displayed");
		//assertTrue(regularincomePage.ispocketmoneyDisplayed("Pocket money for family members"), "Verify if Pocket money for family members is displayed");
		//assertTrue(regularincomePage.isotherinstallmentDisplayed("Other instalments"), "Verify if Other instalments is displayed");
		//assertTrue(regularincomePage.isOtherExpenseDisplayed("Other expenses"), "Verify if Other expenses is displayed");
		
		
		ALittleHelperPage helperPage = new ALittleHelperPage(getDriver(), getReport());
		//helperPage.enterrent("123");
		
		helperPage.enterrent("asjhfd");
		verifyText(helperPage.getrent(), "", "Verify Expected ::  Actual :: "+helperPage.getrent().length());
		
		helperPage.enterrent("6.9");
		verifyText(helperPage.getrent(), "", "Verify Expected ::  Actual :: "+helperPage.getrent().length());
		
		helperPage.enterrent("12345679");
		verifyText(helperPage.getrent(), "", "Verify Expected ::  Actual :: "+helperPage.getrent().length());
		
		helperPage.enterrent("-33");
		verifyText(helperPage.getrent(), "", "Verify Expected ::  Actual :: "+helperPage.getrent().length());
		//boolean textStatus=regularincomePage.isFoodAndGroceriesTestFilled();
		//System.out.println(textStatus);
		helperPage.enterFood("abc");
		verifyText(helperPage.getfood(), "", "Verify Expected ::  Actual :: "+helperPage.getfood().length());
		
		helperPage.enterFood("9.5");
		verifyText(helperPage.getfood(), "", "Verify Expected ::  Actual :: "+helperPage.getfood().length());
		
		helperPage.enterFood("-1");
		verifyText(helperPage.getfood(), "", "Verify Expected ::  Actual :: "+helperPage.getfood().length());
		
		helperPage.enterFood("12345678");
		verifyText(helperPage.getfood(), "", "Verify Expected ::  Actual :: "+helperPage.getfood().length());
		
		helperPage.enterloan("adcf");
		verifyText(helperPage.getloan(), "", "Verify Expected ::  Actual :: "+helperPage.getloan().length());
		
		helperPage.enterloan("-2");
		verifyText(helperPage.getloan(), "", "Verify Expected ::  Actual :: "+helperPage.getloan().length());
		helperPage.enterloan("5.8");
		verifyText(helperPage.getloan(), "", "Verify Expected ::  Actual :: "+helperPage.getloan().length());
		
		helperPage.enterloan("12345678");
		verifyText(helperPage.getloan(), "", "Verify Expected ::  Actual :: "+helperPage.getloan().length());
		
		helperPage.enterUtilities("qwerr");
		verifyText(helperPage.getUtilities(), "", "Verify Expected ::  Actual :: "+helperPage.getUtilities().length());
		
		helperPage.enterUtilities("-3");
		verifyText(helperPage.getUtilities(), "", "Verify Expected ::  Actual :: "+helperPage.getUtilities().length());
		
		helperPage.enterUtilities("10.5");
		verifyText(helperPage.getUtilities(), "", "Verify Expected ::  Actual :: "+helperPage.getUtilities().length());
		
		helperPage.enterUtilities("123456789");
		verifyText(helperPage.getUtilities(), "", "Verify Expected ::  Actual :: "+helperPage.getUtilities().length());
		
		helperPage.enterpocketMoney("9.6");
		verifyText(helperPage.getPocketMoney(), "", "Verify Expected ::  Actual :: "+helperPage.getPocketMoney().length());
		
		helperPage.enterpocketMoney("poiuy");
		verifyText(helperPage.getPocketMoney(), "", "Verify Expected ::  Actual :: "+helperPage.getPocketMoney().length());
		
		helperPage.enterpocketMoney("-4");
		verifyText(helperPage.getPocketMoney(), "", "Verify Expected ::  Actual :: "+helperPage.getPocketMoney().length());
		
		helperPage.enterpocketMoney("12345678");
		verifyText(helperPage.getPocketMoney(), "", "Verify Expected ::  Actual :: "+helperPage.getPocketMoney().length());
		
		helperPage.enterOtherInstalments("-1");;
		verifyText(helperPage.getOtherInstallments(), "", "Verify Expected ::  Actual :: "+helperPage.getOtherInstallments().length());
		
		helperPage.enterOtherInstalments("2.4");;
		verifyText(helperPage.getOtherInstallments(), "", "Verify Expected ::  Actual :: "+helperPage.getOtherInstallments().length());
		
		helperPage.enterOtherInstalments("zxcvb");;
		verifyText(helperPage.getOtherInstallments(), "", "Verify Expected ::  Actual :: "+helperPage.getOtherInstallments().length());
		
		helperPage.enterOtherInstalments("123456789");
		verifyText(helperPage.getOtherInstallments(), "", "Verify Expected ::  Actual :: "+helperPage.getOtherInstallments().length());
		
		helperPage.enterOtherexpenses("asdfg");
		verifyText(helperPage.getOtherexpenses(), "", "Verify Expected ::  Actual :: "+helperPage.getOtherexpenses().length());
		
		helperPage.enterOtherexpenses("-3");
		verifyText(helperPage.getOtherexpenses(), "", "Verify Expected ::  Actual :: "+helperPage.getOtherexpenses().length());
		
		helperPage.enterOtherexpenses("12345678");
		verifyText(helperPage.getOtherexpenses(), "", "Verify Expected ::  Actual :: "+helperPage.getOtherexpenses().length());
		
		helperPage.enterOtherexpenses("12.4");
		verifyText(helperPage.getOtherexpenses(), "", "Verify Expected ::  Actual :: "+helperPage.getOtherexpenses().length());
  }
  
}
