package steps;

import io.qameta.allure.Step;
import modals.TestCase;
import org.openqa.selenium.WebDriver;
import pages.NewTestCaseModalPage;
import pages.ProjectPage;
import pages.SuiteListPage;
import pages.TestCaseAndSuitePage;

/**
 * TODO ДОБАВИТЬ STEPS
 */
public class TestCaseSteps extends BaseSteps {

    public TestCaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Create test-suite")
    public void createTestSuite(String suiteName, String descriptionSuite) {
        ProjectPage projectPage=new ProjectPage(driver);
        TestCaseAndSuitePage testCaseAndSuitePage = new TestCaseAndSuitePage(driver);
        testCaseAndSuitePage.openTestCasePage();
        testCaseAndSuitePage.clickAddTestSuite();
        SuiteListPage suiteListPage = new SuiteListPage(driver);
        suiteListPage.createSuite(suiteName, descriptionSuite);
        suiteListPage.saveSuite();
    }

    @Step("Create test-case")
    public void createTestCase(TestCase testCase) {
        TestCaseAndSuitePage testCaseAndSuitePage = new TestCaseAndSuitePage(driver);
        testCaseAndSuitePage.clickAddTestCase();
        NewTestCaseModalPage newTestCaseModalPage = new NewTestCaseModalPage(driver);
        newTestCaseModalPage.createTestCase(testCase);
    }

    @Step("Add next test case")
    public void addTestCase(TestCase testCase){
        NewTestCaseModalPage newTestCaseModalPage = new NewTestCaseModalPage(driver);
        newTestCaseModalPage.createTestCase(testCase);
    }
    @Step("Click on Save button")
    public void saveButton() {
        NewTestCaseModalPage newTestCaseModalPage = new NewTestCaseModalPage(driver);
        newTestCaseModalPage.clickSaveTestCase();
    }

    @Step("Click on Save And Next button")
    public void saveAndNextButton() {
        NewTestCaseModalPage newTestCaseModalPage = new NewTestCaseModalPage(driver);
        newTestCaseModalPage.clickSaveAndNextTestCase();
    }

    @Step("Click on Cancel button")
    public void cancelButton() {
        NewTestCaseModalPage newTestCaseModalPage = new NewTestCaseModalPage(driver);
        newTestCaseModalPage.clickCancelTestCase();
    }

    @Step("Delete Test-case")
    public void delete(String testSuiteName,String testCaseName){
        TestCaseAndSuitePage testCaseAndSuitePage = new TestCaseAndSuitePage(driver);
        testCaseAndSuitePage.openTestCasePage();
        testCaseAndSuitePage.openTestCasePage();
        testCaseAndSuitePage.deleteTestCase(testSuiteName, testCaseName);
    }
}