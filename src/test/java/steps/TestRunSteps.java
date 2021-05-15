package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.TestRunAndResultsPage;

public class TestRunSteps {
    WebDriver driver;

    public TestRunSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Add Test run")
    public void addTestRun(String suiteName,String nameRun, String references, String assignTo, String description, String radioButton) {
        TestRunAndResultsPage testRunAndResultsPage= new TestRunAndResultsPage(driver);
        testRunAndResultsPage.openTestRunPage();
        testRunAndResultsPage.clickAddTestRunButton();
        testRunAndResultsPage.selectTestSuite(suiteName);
        testRunAndResultsPage.addTestRunForm(nameRun,references,assignTo,description,radioButton);
    }
}
