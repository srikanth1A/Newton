package com.mckinsey.Newton.desktopWebTests;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.SectionsPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class PrioritiesTests extends TestSessionInitiator{
	
	@Test
	public void Priorities01() throws InterruptedException {
		LandingPage landingPage =  new LandingPage(getDriver(), getReport());
		
		
		landingPage.clickStartNow();
		
		
		
		WelcomePage welcomePage = new WelcomePage(getDriver(), getReport());
		welcomePage.clickConfirm();
		Thread.sleep(1000);
		
		welcomePage.clickLetsGo();
		
		
		NamePage namePage = new NamePage(getDriver(), getReport());
		namePage.enterName("sss");
	
		namePage.clickNext();
		
		GenderAgePage genderAgePage = new GenderAgePage(getDriver(), getReport());
		genderAgePage.enterDate("11");
		
		genderAgePage.enterMonth("07");
	
		genderAgePage.enterYear("1992");
	
		genderAgePage.clickMale();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		genderAgePage.clickNext();
	
		DependentsPage dependentsPage = new DependentsPage(getDriver(), getReport());
		dependentsPage.clickJustMySelf();
	
		dependentsPage.clickNext();
		
		
		SmokingHabitsPage SmokingHabitsPage = new SmokingHabitsPage(getDriver(), getReport());
		SmokingHabitsPage.clickyes();
		
		SmokingHabitsPage.clickNext();
	
		
		SectionsPage sectionpage= new SectionsPage(driver, getReport());
		
		
		sectionpage.To_Support_Just_Myself();
		
		
		
		dependentsPage.clickSpouse();
		
		
		dependentsPage.clickNext();
		
		SmokingHabitsPage.clickyes();
	
		
		

		SmokingHabitsPage.clickNext();
	
		PrioritiesPage priorityPage = new PrioritiesPage(getDriver(), getReport());
		priorityPage.selectFirstOption();
		
		Thread.sleep(1000);
		boolean toppriority_Status=priorityPage.isTopPriorityEnabled();
		if(toppriority_Status==true) {
			Thread.sleep(1000);
			priorityPage.isTakeIntoConsiderationEnabled();
		}
		
		
		
		
		boolean Enable_status=priorityPage.isTakeIntoConsiderationdisable();
		
		//System.out.println("Is Take into considration is enable"+Enable_status);
		priorityPage.selectSecondOption();
		
		
		priorityPage.isSecondPriorityBoxEnabled();
	
		priorityPage.isSwapButtonEnabled();
		
		priorityPage.selectThirdOption();
	
		priorityPage.isThirdPriorityBoxEnabled();
	
		priorityPage.isSwapButtonEnabled();
		
		priorityPage.clickOnCross();
	
		priorityPage.clickOnCross();
	
		priorityPage.clickOnCross();
		
		priorityPage.clickOnDearth();
		
		priorityPage.clickOnGeneralSavings();
	
		priorityPage.clickOnSwapButton();
		
		priorityPage.isTopPriorityEnabled();
	
		priorityPage.isSecondPriorityBoxEnabled();
		
		priorityPage.clickOnCross();
	
		priorityPage.clickOnCross();
		
		priorityPage.isTakeIntoConsiderationEnabled();
		
		boolean status=priorityPage.isTakeIntoConsiderationdisable();
		
		System.out.println("Is Take into considration is disable"+status);
		
	
		/*
		PrioritiesPage priorityPage = new PrioritiesPage(getDriver(), getReport());
		priorityPage.VerifyPriority("1.TPD");
		priorityPage.VerifyPriority("2.Late CI");
		priorityPage.VerifyPriority("3.Early CI");
		priorityPage.VerifyPriority("4.Cancer");
		priorityPage.VerifyPriority("5.Retirement");
		priorityPage.VerifyPriority("6.General savings");
		priorityPage.VerifyPriority("7.Death");
		
		priorityPage.VerifyPriority("8.Children's education");
		Thread.sleep(1000);
		*/
		
		
		
		
		
		/*
		
		
		SectionsPage sectionsPage = new SectionsPage(getDriver(), getReport());
		sectionsPage.clickDependents();
		Thread.sleep(1000);
		dependentsPage.clickParents();
		Thread.sleep(1000);
		dependentsPage.clickChildren();
		Thread.sleep(1000);
		dependentsPage.clickSpouse();
		Thread.sleep(1000);
		dependentsPage.clickNext();
		Thread.sleep(1000);
		SmokingHabitsPage.clickno();
		Thread.sleep(1000);
		SmokingHabitsPage.clickNext();
		Thread.sleep(1000);
		priorityPage.VerifyPriority("1.Death");
		Thread.sleep(1000);
		priorityPage.VerifyPriority("2.TPD");
		Thread.sleep(1000);
		priorityPage.VerifyPriority("3.Late CI");
		Thread.sleep(1000);
		priorityPage.VerifyPriority("4.Early CI");
		Thread.sleep(1000);
		priorityPage.VerifyPriority("5.Cancer");
		Thread.sleep(1000);
		priorityPage.VerifyPriority("6.Retirement");
		Thread.sleep(1000);
		priorityPage.VerifyPriority("7.Children's education");
		Thread.sleep(1000);
		priorityPage.VerifyPriority("8.General savings");
		
		priorityPage.selectPriority("1.Death");
		priorityPage.priorityGrayedOut("Death");
		
		priorityPage.isConsiderationsEnabled();
		
		priorityPage.clickConsiderations();
		
		*/
		
		
	}
	
	/*
	@Test
	public void Priorities02() {
		
	}
*/
}
