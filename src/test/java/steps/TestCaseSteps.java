package steps;

import io.qameta.allure.Step;
import modals.TestCase;
import org.openqa.selenium.WebDriver;
import pages.NewTestCaseModalPage;
import pages.SuiteListPage;
import pages.TestCaseAndSuitePage;

/**
 * TODO ДОБАВИТЬ STEPS
 */
public class TestCaseSteps extends BaseSteps {

    WebDriver driver;
    TestCaseAndSuitePage testCaseAndSuitePage;
    NewTestCaseModalPage newTestCaseModalPage;

    public TestCaseSteps(WebDriver driver) {
        this.driver = driver;
        testCaseAndSuitePage = new TestCaseAndSuitePage(driver);
        newTestCaseModalPage = new NewTestCaseModalPage(driver);

    }

    @Step("Create test-suite")
    public void createTestSuite(String suiteName, String descriptionSuite) {
        testCaseAndSuitePage.openTestCasePage();
        testCaseAndSuitePage.clickAddTestSuite();
        SuiteListPage suiteListPage = new SuiteListPage(driver);
        suiteListPage.createSuite(suiteName, descriptionSuite);
        suiteListPage.saveSuite();
    }

    @Step("Create test-case")
    public void createTestCase(TestCase testCase) {
        testCaseAndSuitePage.clickAddTestCase();
        newTestCaseModalPage.createTestCase(testCase);
    }

    @Step("Add next test case")
    public void addTestCase(TestCase testCase) {
        newTestCaseModalPage.createTestCase(testCase);
    }

    @Step("Click on Save button")
    public void saveButton() {
        newTestCaseModalPage.clickSaveTestCase();
    }

    @Step("Click on Save And Next button")
    public void saveAndNextButton() {
        newTestCaseModalPage.clickSaveAndNextTestCase();
    }

    @Step("Click on Cancel button")
    public void cancelButton() {
        newTestCaseModalPage.clickCancelTestCase();
    }

    @Step("Click breadcrumb")
    public void goToSection(String sectionName) {
        testCaseAndSuitePage.clickBreadCrumb(sectionName);
    }

    @Step("Delete Test-case")
    public void delete(String testCaseName) {
        testCaseAndSuitePage.deleteTestCase(testCaseName);
    }
}