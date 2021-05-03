package steps;

import modals.TestCase;
import org.openqa.selenium.WebDriver;
import pages.NewTestCaseModalPage;
import pages.TestCaseAndSuitePage;

public class TestCaseSteps extends BaseSteps {

    public TestCaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void createTestCaseAndClickSaveButton(TestCase testCase){
        TestCaseAndSuitePage testCaseAndSuitePage = new TestCaseAndSuitePage(driver);
        testCaseAndSuitePage.openTestCasePage();
        testCaseAndSuitePage.clickAddTestCase();
        NewTestCaseModalPage newTestCaseModalPage=new NewTestCaseModalPage(driver);
        newTestCaseModalPage.createTestCase(testCase);
        newTestCaseModalPage.clickSaveTestCase();
    }

    public void createTestCaseAndClickSaveAndNextButton(TestCase testCase){
        TestCaseAndSuitePage testCaseAndSuitePage = new TestCaseAndSuitePage(driver);
        testCaseAndSuitePage.openTestCasePage();
        testCaseAndSuitePage.clickAddTestCase();
        NewTestCaseModalPage newTestCaseModalPage=new NewTestCaseModalPage(driver);
        newTestCaseModalPage.createTestCase(testCase);
        newTestCaseModalPage.clickSaveAndNextTestCase();
    }

    public void createTestCaseAndClickCancelButton(TestCase testCase){
        TestCaseAndSuitePage testCaseAndSuitePage = new TestCaseAndSuitePage(driver);
        testCaseAndSuitePage.openTestCasePage();
        testCaseAndSuitePage.clickAddTestCase();
        NewTestCaseModalPage newTestCaseModalPage=new NewTestCaseModalPage(driver);
        newTestCaseModalPage.createTestCase(testCase);
        newTestCaseModalPage.clickCancelTestCase();
    }

}
