package com.mckinsey.Newton.desktopWebTests;


import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mckinsey.Newton.pages.BudgetPage;
import com.mckinsey.Newton.pages.DependentsPage;
import com.mckinsey.Newton.pages.EducationSavingPage;
import com.mckinsey.Newton.pages.GenderAgePage;
import com.mckinsey.Newton.pages.GeneralSavingsPage;
import com.mckinsey.Newton.pages.IncomeExpensesSavingsPage;
import com.mckinsey.Newton.pages.LandingPage;
import com.mckinsey.Newton.pages.MyPreferrencePage;
import com.mckinsey.Newton.pages.NamePage;
import com.mckinsey.Newton.pages.NeedSummaryPage;
import com.mckinsey.Newton.pages.ParentsPage;
import com.mckinsey.Newton.pages.PremiumTermPage;
import com.mckinsey.Newton.pages.PrioritiesPage;
import com.mckinsey.Newton.pages.RegularIncomePage;
import com.mckinsey.Newton.pages.RetirementGoalPage;
import com.mckinsey.Newton.pages.RiskPage;
import com.mckinsey.Newton.pages.SmokingHabitsPage;
import com.mckinsey.Newton.pages.ExistingInsurancePage;
import com.mckinsey.Newton.pages.FeaturePage;
import com.mckinsey.Newton.pages.WelcomePage;
import com.mckinsey.Newton.tests.TestSessionInitiator;

public class MasterAlgoTest extends TestSessionInitiator{
	
	public LandingPage landingPage;
	public WelcomePage welcomePage;
	public NamePage namePage;
	public GenderAgePage genderAgePage;
	public DependentsPage dependentsPage;
	public SmokingHabitsPage smokingHabitsPage;
	public PrioritiesPage priorityPage;
	public RetirementGoalPage retirementPage;
	public ParentsPage parentsPage;
	public EducationSavingPage eduPage;
	public GeneralSavingsPage generalSavingsPage;
	public ExistingInsurancePage existInsPage;
	public RegularIncomePage regularincomePage;
	public IncomeExpensesSavingsPage incomepage;
	public BudgetPage budgetpage;
	public PremiumTermPage premiumPage;
	public NeedSummaryPage needsummaryPage;
	public RiskPage RiskPage;
	public FeaturePage featurePage;
	public MyPreferrencePage myprefPage;
	
	@BeforeMethod(groups = "MasterAlgo")
    public void launchDriver(Method M) {        
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver=new ChromeDriver();
		driver.get("https://askdex.sit.income.com.sg/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
    }
	
	@Test(groups = "MasterAlgo", dataProvider = "algotestdata")
	public void MasterAlgo(Hashtable<String, String> data) throws Exception {
		logger = extent.startTest(data.get("PrimaryKey")+data.get("RowNum"));
		landingPage = new LandingPage(driver, logger);
		landingPage.clickStartNow();
				
		welcomePage = new WelcomePage(driver, logger);
		welcomePage.clickConfirm();
		welcomePage.clickLetsGo();
				
		namePage = new NamePage(driver, logger);
		namePage.enterName("Srikanth");
		namePage.clickNext();
		
		genderAgePage = new GenderAgePage(driver, logger);
		genderAgePage.enterCompleteData(data.get("DOB"));
		if(data.get("Gender").equals("F")) {
			genderAgePage.clickFemale();
		}else if(data.get("Gender").equals("M")){
			genderAgePage.clickMale();
		}
		genderAgePage.clickNext();

		dependentsPage = new DependentsPage(driver, logger);
		
		if(data.get("Myself").equals("1")) {
			dependentsPage.clickJustMySelf();
		}
		if(data.get("Spouse").equals("1")) {
			dependentsPage.clickSpouse();
		}
		if(data.get("Children").equals("1")) {
			dependentsPage.clickChildren();
		}
		if(data.get("Parents").equals("1")) {
			dependentsPage.clickParents();
		}		
		dependentsPage.clickNext();
		
		smokingHabitsPage = new SmokingHabitsPage(driver, logger);
		if(data.get("Smoker").equals("Y")) {
			smokingHabitsPage.clickyes();
		}else if(data.get("Smoker").equals("N")){
			smokingHabitsPage.clickno();
		}		
		smokingHabitsPage.clickNext();
		
		priorityPage = new PrioritiesPage(driver, logger);
		String dependencies[] = new String[3];
		if(data.get("Death").equals("1") || data.get("Death").equals("2") || data.get("Death").equals("3")) {
			dependencies[Integer.parseInt(data.get("Death")) - 1] = "I pass away";
		}
		if(data.get("TPD").equals("1") || data.get("TPD").equals("2") || data.get("TPD").equals("3")) {
			dependencies[Integer.parseInt(data.get("TPD")) - 1] = "total & permanent disability";
		}
		if(data.get("Late CI").equals("1") || data.get("Late CI").equals("2") || data.get("Late CI").equals("3")) {
			dependencies[Integer.parseInt(data.get("Late CI")) - 1] = "advanced stage critical illness";
		}
		if(data.get("Early CI").equals("1") || data.get("Early CI").equals("2") || data.get("Early CI").equals("3")) {
			dependencies[Integer.parseInt(data.get("Early CI")) - 1] = "early stage critical illness";
		}
		if(data.get("Cancer").equals("1") || data.get("Cancer").equals("2") || data.get("Cancer").equals("3")) {
			dependencies[Integer.parseInt(data.get("Cancer")) - 1] = "cancer";
		}
		if(data.get("Retirement").equals("1") || data.get("Retirement").equals("2") || data.get("Retirement").equals("3")) {
			dependencies[Integer.parseInt(data.get("Retirement")) - 1] = "retirement";
		}
		if(data.get("General Savings").equals("1") || data.get("General Savings").equals("2") || data.get("General Savings").equals("3")) {
			dependencies[Integer.parseInt(data.get("General Savings")) - 1] = "savings goals";
		}
		if(data.get("Children's Education").equals("1") || data.get("Children's Education").equals("2") || data.get("Children's Education").equals("3")) {
			dependencies[Integer.parseInt(data.get("Children's Education")) - 1] = "s university education";
		}	
		
		for(int i = 0; i < dependencies.length; i++) {
			try {
				if(!(dependencies[i].isEmpty() && dependencies[i] == null)) {
					priorityPage.selectPriority(dependencies[i]);
				}
			}catch(Exception e) {
				break;
			}
		}		
		priorityPage.clickConsiderations();
		
		for(int i = 0; i < 3; i++) {
			if(dependencies[i]!= null) {				
				if(dependencies[i].contains("retirement")) {
					retirementPage = new RetirementGoalPage(driver, logger);
					retirementPage.enterRetirementAge(data.get("Age to retire"));
					retirementPage.enterstrMonthlySpendings(data.get("Monthly retirement spend"));
					retirementPage.clickHelpMe();
					if(Integer.parseInt(data.get("Age to retire")) > 62) {
						retirementPage.clickYesImSure();
					}					
				}else if(dependencies[i].contains("I pass away")) {
					parentsPage = new ParentsPage(driver, logger);
					if(!data.get("Amount Spouse").equals("x")) {
						parentsPage.enterAmount("Spouse", data.get("Amount Spouse"));
					}
					if(!data.get("Amount Children").equals("x")) {
						parentsPage.enterAmount("Children", data.get("Amount Children"));
					}
					if(!data.get("Amount Parents").equals("x")) {
						parentsPage.enterAmount("Parents", data.get("Amount Parents"));
					}
					parentsPage.clickCoverMe();
				}else if(dependencies[i].contains("s university education")) {
					eduPage = new EducationSavingPage(driver, logger);
					eduPage.enterAge(data.get("Age of child"));
					eduPage.enterCurrency(data.get("Amount for university"));
					eduPage.clickNext();
				}else if(dependencies[i].contains("savings goals")) {
					generalSavingsPage = new GeneralSavingsPage(driver, logger);
					generalSavingsPage.entersavingsAmount(data.get("General savings goal"));
					generalSavingsPage.entersavingsYears(data.get("No. of Years to goal"));
					generalSavingsPage.clickMakethisHappen();
				}
			}		
			
		}
		
			
		existInsPage = new ExistingInsurancePage(driver, logger);
		if(data.get("Existing policy for Death").equals("") &&
				data.get("Existing policy for TPD").equals("") &&
				data.get("Existing policy for late CI").equals("") &&
				data.get("Existing policy for early CI").equals("") &&
				data.get("Existing policy for Cancer").equals("") &&
				data.get("Existing policy for general savings").equals("") &&
				data.get("Existing savings for general savings").equals("") &&
				data.get("Existing policy for retirement (lump sum)").equals("") &&
				data.get("Existing policy for retirement (monthly)").equals("") &&
				data.get("Existing savings for retirement").equals("") &&
				data.get("CPF LIFE payout for retirement").equals("") &&
				data.get("Existing policy for child education").equals("") &&
				data.get("Existing savings for child education").equals(""))
				existInsPage.clicknope();
		else {
				if(!data.get("Existing policy for retirement (lump sum)").equals("") ||
				   !data.get("Existing policy for retirement (monthly)").equals("") ||
				   !data.get("Existing savings for retirement").equals("") ||
				   !data.get("CPF LIFE payout for retirement").equals("")) {
					existInsPage.selectExistingPolicy("Growing money for my retirement");
					if(!data.get("Existing policy for retirement (lump sum)").equals(""))
						existInsPage.enterDatainField("Lump Sum", data.get("Existing policy for retirement (lump sum)"));
					if(!data.get("Existing policy for retirement (monthly)").equals(""))
						existInsPage.enterDatainField("Monthly", data.get("Existing policy for retirement (monthly)"));
					if(!data.get("Existing savings for retirement").equals(""))
						existInsPage.enterDatainField("I already have retirement savings of", data.get("Existing savings for retirement"));
					if(!data.get("CPF LIFE payout for retirement").equals(""))
						existInsPage.selectCheckBox("I want to include my CPF LIFE payout");
					}
					
					if(!data.get("Existing policy for Death").equals("")) {
						existInsPage.selectExistingPolicy("Financial Protection if I pass away");
						existInsPage.enterDatainField("Financial Protection if I pass away", "I already have coverage of", data.get("Existing policy for Death"));
					}
					
					if(!data.get("Existing policy for general savings").equals("") ||
							!data.get("Existing savings for general savings").equals("")) {
						existInsPage.selectExistingPolicy2("Growing money for other savings goals");
						existInsPage.enterDatainField2("Growing money for other savings goals", "I have savings plans that will pay me", data.get("Existing policy for general savings"));
						existInsPage.enterDatainField2("Growing money for other savings goals", "I already have existing savings of", data.get("Existing savings for general savings"));
					}
					
					if(!data.get("Existing policy for child education").equals("") ||
							!data.get("Existing savings for child education").equals("")) {
						existInsPage.selectExistingPolicy2("Growing money for my child");
						existInsPage.enterDatainField("I have savings plans that will pay me", data.get("Existing policy for child education"));
						existInsPage.enterDatainField("I already have existing savings of", data.get("Existing savings for child education"));
					}
					
					if(!data.get("Existing policy for TPD").equals("")) {
						existInsPage.selectExistingPolicy("Financial Protection if I suffer from total & permanent disability");
						existInsPage.enterDatainField("Financial Protection if I suffer from total & permanent disability", "I already have coverage of", data.get("Existing policy for TPD"));
					}
					
					if(!data.get("Existing policy for late CI").equals("")) {
						existInsPage.selectExistingPolicy("Financial Protection if I encounter late critical illness");
						existInsPage.enterDatainField("Financial Protection if I encounter late critical illness", "I already have coverage of", data.get("Existing policy for late CI"));
					}
					
					if(!data.get("Existing policy for early CI").equals("")) {
						existInsPage.selectExistingPolicy("Financial Protection if I encounter early critical illness");
						existInsPage.enterDatainField("Financial Protection if I encounter early critical illness" ,"I already have coverage of", data.get("Existing policy for early CI"));
					}
					 
					if(!data.get("Existing policy for Cancer").equals("")) {
						existInsPage.selectExistingPolicy("Financial Protection if I am diagnosed with cancer");
						existInsPage.enterDatainField("Financial Protection if I am diagnosed with cancer" ,"I already have coverage of", data.get("Existing policy for Cancer"));
					}
			
			existInsPage.clickThatswhatIcurrentlyhave();	
		}
		
		regularincomePage = new RegularIncomePage(driver, logger);
		if(data.get("Regular income").equals("Y")) {
			regularincomePage.clickYes();
			if(data.get("Employment type").equals("Employee")) {
				regularincomePage.clickEMPLOYEE();
			}else if(data.get("Employment type").equals("Contract employee")) {
				regularincomePage.clickCONTRACTEMPLOYEE();
			}else if(data.get("Employment type").equals("Self employed")) {
				regularincomePage.clickSELFEMPLOYED();			
			}
		}else if(data.get("Regular income").equals("N")) {
			regularincomePage.clickNo();
			if(data.get("How are you paying").equals("Savings")) {
				regularincomePage.clickmyownSavings();
			}else if(data.get("How are you paying").equals("Someone is paying")) {
				regularincomePage.clicksomeoneisPaying();
			}
		}
		regularincomePage.clickNext();
		
		incomepage = new IncomeExpensesSavingsPage(driver, logger);
		incomepage.entermonthlyTakeHome(data.get("Monthly take home pay"));
		incomepage.entermonthlySpending(data.get("Monthly spending"));
		incomepage.entercashSaving(data.get("Cash savings"));
		incomepage.enterbigExpenses(data.get("Big expense"));
		incomepage.clickthatsAboutRight();
		
		budgetpage = new BudgetPage(driver, logger);
		if(budgetpage.isNextDisplayed()) {
			if(!data.get("Budget (lump sum)").trim().equals("") ||
					!data.get("Budget (monthly)").trim().equals("")) {
				if(!data.get("Budget (lump sum)").trim().equals(""))
						budgetpage.enteroneTimeAmount(data.get("Budget (lump sum)"));
				if(!data.get("Budget (monthly)").trim().equals(""))
						budgetpage.enterrecurringMonthlyAmount(data.get("Budget (monthly)"));
				budgetpage.clickBudget();		
			}else {
				budgetpage.clickSkip();
			}
			
			premiumPage = new PremiumTermPage(driver, logger);
			if(!data.get("Premium Term (protection)").trim().equals("")){
				System.out.println(data.get("Premium Term (protection)").trim());
				premiumPage.enterProtectionYears(data.get("Premium Term (protection)"));			
			}
			if(!data.get("Premium Term (savings)").trim().equals("")) {
				premiumPage.enterSavingsYears(data.get("Premium Term (savings)"));
			}
			
			if(data.get("Premium Term (protection)").trim().equals("") &&
					data.get("Premium Term (savings)").trim().equals("")) {
				premiumPage.clickskip();
			}else {
				premiumPage.clickRange();
				if(premiumPage.iswarningPopupExists()) {
					premiumPage.clickYesSure();
				}
			}
			
			needsummaryPage = new NeedSummaryPage(driver, logger);
			if(!data.get("Death needs total").equals("NA")) {
					//&& !data.get("Death existing").equals("NA") && !data.get("Death needs shortfall").equals("NA")) {
				if(!needsummaryPage.getSelectedwindow().equals("Death")) {
					needsummaryPage.clickWindow("Death");
				} 			
				needsummaryPage.enterYearstoSupport(data.get("Years to support"));
				needsummaryPage.clickCalculate();
				verifyDecimalText(needsummaryPage.getTotalNeeds(), data.get("Death needs total"), "Verify Death Needs Expected :: "+data.get("Death needs total")+" Actual :: "+needsummaryPage.getTotalNeeds());
				verifyDecimalText(needsummaryPage.getExpenditure(), data.get("Death needs shortfall"), "Verify Death shortfall Expected :: "+data.get("Death needs shortfall")+" Actual :: "+needsummaryPage.getExpenditure());			
			}
			
			if(!data.get("TPD needs total").equals("NA")) {
					//&& !data.get("TPD existing").equals("NA") && !data.get("TPD needs shortfall").equals("NA")) {
				if(!needsummaryPage.getSelectedwindow().equals("Total & Permanent Disability")) {
					needsummaryPage.clickWindow("Total & Permanent Disability");
				}			
				verifyDecimalText(needsummaryPage.getTotalNeeds(), data.get("TPD needs total"), "Verify TPD needs total Expected :: "+data.get("TPD needs total")+" Actual :: "+needsummaryPage.getTotalNeeds());
				verifyDecimalText(needsummaryPage.getExpenditure(), data.get("TPD needs shortfall"), "Verify TPD needs shortfall Expected :: "+data.get("TPD needs shortfall")+" Actual :: "+needsummaryPage.getExpenditure());				
			}
			
			if(!data.get("Late CI needs total").equals("NA")) { 
					//&& !data.get("Late CI existing").equals("NA") && !data.get("Late CI needs shortfall").equals("NA")) {
				if(!needsummaryPage.getSelectedwindow().equals("Advanced Stage Critical Illness")) {
					needsummaryPage.clickWindow("Advanced Stage Critical Illness");
				}	
				verifyDecimalText(needsummaryPage.getTotalNeeds(), data.get("Late CI needs total"), "Verify Late CI needs total Expected :: "+data.get("Late CI needs total")+" Actual :: "+needsummaryPage.getTotalNeeds());
				verifyDecimalText(needsummaryPage.getExpenditure(), data.get("Late CI needs shortfall"), "Verify Late CI needs shortfall Expected :: "+data.get("Late CI needs shortfall")+" Actual :: "+needsummaryPage.getExpenditure());
			}
			
			if(!data.get("Early CI needs total").equals("NA")) {
				// && !data.get("Early CI  existing").equals("NA") && !data.get("Early CI  needs shortfall").equals("NA")
				if(!needsummaryPage.getSelectedwindow().equals("Early Stage Critical Illness")) {
					needsummaryPage.clickWindow("Early Stage Critical Illness");
				}			
				verifyDecimalText(needsummaryPage.getTotalNeeds(), data.get("Early CI needs total"), "Verify Early CI needs Expected :: "+data.get("Early CI needs total")+" Actual :: "+needsummaryPage.getTotalNeeds());
				verifyDecimalText(needsummaryPage.getExpenditure(), data.get("Early CI  needs shortfall"), "Verify Early CI shortfall Expected :: "+data.get("Early CI  needs shortfall")+" Actual :: "+needsummaryPage.getExpenditure());	
			}
			
			if(!data.get("Cancer  needs total").equals("NA")) {
					//&& !data.get("Cancer existing").equals("NA") && !data.get("Cancer needs shortfall").equals("NA")) {
				if(!needsummaryPage.getSelectedwindow().equals("Cancer")) {
					needsummaryPage.clickWindow("Cancer");
				}			
				verifyDecimalText(needsummaryPage.getTotalNeeds(), data.get("Cancer  needs total"), "Verify Cancer Needs Expected :: "+data.get("Cancer  needs total")+" Actual :: "+needsummaryPage.getTotalNeeds());
				verifyDecimalText(needsummaryPage.getExpenditure(), data.get("Cancer needs shortfall"), "Verify Cancer shortfall Expected :: "+data.get("Cancer needs shortfall")+" Actual :: "+needsummaryPage.getExpenditure());
				
			}
			
			if(!data.get("General savings  needs total").equals("NA")) {
					//&& !data.get("General savings   existing").equals("NA") && !data.get("General savings   needs shortfall").equals("NA")) {
				if(!needsummaryPage.getSelectedwindow().equals("General savings")) {
					needsummaryPage.clickWindow("General savings");
				}			
				verifyDecimalText(needsummaryPage.getTotalNeeds(), data.get("General savings  needs total"), "Verify General savings Needs Expected :: "+data.get("General savings  needs total")+" Actual :: "+needsummaryPage.getTotalNeeds());
				verifyDecimalText(needsummaryPage.getExpenditure(), data.get("General savings   needs shortfall"), "Verify General savings shortfall Expected :: "+data.get("General savings   needs shortfall")+" Actual :: "+needsummaryPage.getExpenditure());
			}
			
			if(!data.get("Retirement needs total").equals("NA")) {
				//&& !data.get("Retirement existing").equals("NA") && !data.get("Retirement needs shortfall").equals("NA")
				if(!needsummaryPage.getSelectedwindow().equals("Retirement")) {
					needsummaryPage.clickWindow("Retirement");
				}			
				verifyDecimalText(needsummaryPage.getTotalNeeds(), data.get("Retirement needs total"), "Verify Retirement Needs Expected :: "+data.get("Retirement needs total")+" Actual :: "+needsummaryPage.getTotalNeeds());
				verifyDecimalText(needsummaryPage.getExpenditure(), data.get("Retirement needs shortfall"), "Verify Retirement shortfall Expected :: "+data.get("Retirement needs shortfall")+" Actual :: "+needsummaryPage.getExpenditure());
			}
			
			if(!data.get("Child edu  needs total").equals("NA")) {
					//&& !data.get("Child edu existing").equals("NA") && !data.get("Child edu needs shortfall").equals("NA")) {
				if(!needsummaryPage.getSelectedwindow().equals("Child's education")) {
					needsummaryPage.clickWindow("s education");
				}			
				verifyDecimalText(needsummaryPage.getTotalNeeds(), data.get("Child edu  needs total"), "Verify Child edu Needs Expected :: "+data.get("Child edu  needs total")+" Actual :: "+needsummaryPage.getTotalNeeds());
				verifyDecimalText(needsummaryPage.getExpenditure(), data.get("Child edu needs shortfall"), "Verify Child edu shortfall Expected :: "+data.get("Child edu  needs shortfall")+" Actual :: "+needsummaryPage.getExpenditure());
			}
			
			needsummaryPage.clickLetsMove();
			RiskPage = new RiskPage(driver, logger);
			RiskPage.clickAlmost();
			
			boolean bool = false;
			featurePage = new FeaturePage(driver, logger);
			
			if(data.get("Product recommendation P1").equals("No product recommendation") || data.get("Product recommendation P1").equals("")) {
				assertTrue(true, "No product recommendation is Displayed");
			}else {
				if(featurePage.isgetMyresultsDisabled()) {			
					
					if(data.get("Term").equals("Y")) {
						featurePage.selectplan("term");
						bool = true;
					}
					
					if(data.get("Cash Value").equals("Y")) {
						featurePage.selectplan("cash value");
						bool = true;
					}
			
					if(data.get("Retrenchment").equals("Y")) {
						featurePage.selectplan("retrenchment");
						bool = true;
					}
			
					if(data.get("Accidental Death").equals("Y")) {
						featurePage.selectplan("accidental death");
						bool = true;
					}
			
					if(data.get("Accidental TPD").equals("Y")) {
						featurePage.selectplan("Accidental TPD");
						bool = true;
					}
			
					if(data.get("Disability Care Benefit").equals("Y")) {
						featurePage.selectplan("disability care benefit");
						bool = true;
					}
			
					if(data.get("Optional cash payouts before maturity").equals("Y")) {
						featurePage.selectplan("optional cash payouts before maturity");
						bool = true;
					}
			
					if(data.get("Retrenchment").equals("Y")) {
						featurePage.selectplan("retrenchment");
						bool = true;
					}
					
					if(data.get("Regular retirement income").equals("Y")) {
						featurePage.selectplan("retirement income");
						bool = true;
					}
					
					if(data.get("Capital guarantee").equals("Y")) {
						featurePage.selectplan("capital guarantee");
						bool = true;
					}
					
					if(bool) {
						featurePage.clickResults();
					}else {
						featurePage.clickSkip();
					}

				}else {
						assertTrue(false,"No Plans are DISPLAYED");			
				}	
				
				MyPreferrencePage myprefPage = new MyPreferrencePage(driver, logger);					
				verifyText(myprefPage.get1ProductRecommendtion(), data.get("Product recommendation P1"), "Verify Product recommendation P1 Expected :: "+data.get("Product recommendation P1")+" Actual :: "+myprefPage.get1ProductRecommendtion());
				verifyText(myprefPage.getProductValue(), data.get("Total Premium"), "Verify Total Premium Expected :: "+data.get("Total Premium")+" Actual :: "+myprefPage.getProductValue());

				//Priorities Verification
				//myprefPage.verifyPriorities(data.get("Coverage on Priority 1 O1"), data.get("Coverage on Priority 2 O1"), data.get("Coverage on Priority 3 O1"));					
				if(!data.get("Product recommendation  P2").equals("")) {
					verifyText(myprefPage.get2ProductRecommendtion(), data.get("Product recommendation  P2"), "Verify Expected :: "+data.get("Product recommendation  P2")+" Actual :: "+myprefPage.get2ProductRecommendtion());
				}
				
				myprefPage.verifysuggestionPriorities(data);
				
			}
		}else {
			assertTrue(false, "Monthly take home pay :: "+data.get("Monthly take home pay")
								+"Monthly spending :: "+data.get("Monthly spending")
								+"Cash savings :: "+data.get("Cash savings")
								+"Big expense :: "+data.get("Big expense"));
		}
		
		
					
	}
	
	@AfterMethod(groups = "MasterAlgo",alwaysRun=true)
    public void quitSession() {
        if (driver != null)
        	driver.quit();
        extent.endTest(logger);
        landingPage = null;
    	welcomePage = null;
    	namePage = null;
    	genderAgePage = null;
    	dependentsPage = null;
    	smokingHabitsPage = null;
    	priorityPage = null;
    	retirementPage = null;
    	parentsPage = null;
    	eduPage = null;
    	generalSavingsPage = null;
    	existInsPage = null;
    	regularincomePage = null;
    	incomepage = null;
    	budgetpage = null;
    	premiumPage = null;
    	needsummaryPage = null;
    	RiskPage = null;
    	featurePage = null;
    	myprefPage = null;
        System.gc();    
    }
}
