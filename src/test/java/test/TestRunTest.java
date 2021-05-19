package test;

import modals.TestCase;
import org.testng.annotations.Test;

public class TestRunTest extends BaseTest {

    @Test(description = "Create Test Run")
    public void addTestRun() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");
        TestCase testCase = new TestCase("TestRun", "Test Case", "Test Case (Text)", "Automated", "High", "",
                "-", "None", "Быть зарегистрированным пользователем", "steps", "Open Dashboard page");
        testCaseSteps.createTestSuite("Login", " ");
        testCaseSteps.createTestCase(testCase);
        testCaseSteps.saveButton();
        testRunSteps.addTestRun("Login", " ", " ", "Me", "blabla",
                "Include all test cases");
        testRunSteps.addTestRun("Login", " ", " ", "Me", "blabla",
                "Include all test cases");
        administrationSteps.admin("Projects");
        projectSteps.deleteProject("TestRail");
    }

    @Test(description = "Add test result")
    public void addTestResultTest () {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");
        TestCase testCase = new TestCase("TestRun", "Test Case", "Test Case (Text)", "Automated", "High", "",
                "-", "None", "Быть зарегистрированным пользователем", "steps", "Open Dashboard page");
        testCaseSteps.createTestSuite("Login", " ");
        testCaseSteps.createTestCase(testCase);
        testCaseSteps.saveButton();
        testRunSteps.addTestRun("Login", " ", " ", "Me", "blabla",
                "Include all test cases");
        testRunSteps.addResult("Login", "", "TestRun", "Blocked",
                "retest test case", "Me",
                "1.0", "30s", "no");
        administrationSteps.admin("Projects");
        projectSteps.deleteProject("TestRail");
    }
}