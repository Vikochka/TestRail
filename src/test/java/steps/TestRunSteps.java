package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.NewAddResultModal;
import pages.TestRunAndResultsPage;

public class TestRunSteps {
    WebDriver driver;

    public TestRunSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Add Test run")
    public void addTestRun(String suiteName, String nameRun, String references, String assignTo, String description, String radioButton) {
        TestRunAndResultsPage testRunAndResultsPage = new TestRunAndResultsPage(driver);
        testRunAndResultsPage.openTestRunPage();
        testRunAndResultsPage.clickAddTestRunButton();
        testRunAndResultsPage.selectTestSuite(suiteName);
        testRunAndResultsPage.addTestRunForm(nameRun, references, assignTo, description, radioButton);
    }

    @Step("Add Result")
    public void addResult(String nameRun, String suiteName, String testCaseName, String status, String comment, String assignToOpton, String version, String elapsed, String defects) {
        TestRunAndResultsPage testRunAndResultsPage = new TestRunAndResultsPage(driver);
        testRunAndResultsPage.openTestRunPage();
        testRunAndResultsPage.selectTestRun(nameRun);
        testRunAndResultsPage.selectTestCase(testCaseName);
        testRunAndResultsPage.clickAddResultButton();
        NewAddResultModal newAddResultModal = new NewAddResultModal(driver);
        newAddResultModal.addResultForm(status, comment, assignToOpton, version, elapsed, defects);
    }
}
