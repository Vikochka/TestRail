package test;

import io.qameta.allure.Step;
import modals.TestCase;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test(description = "Create one test-case")
    public void createOneTestcase() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
       // projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");
        TestCase testCase = new TestCase("TestRun", "Test Case", "Test Case (Text)", "Automated", "High", "",
                "-", "None", "Быть зарегистрированным пользователем", "steps", "Open Dashboard page");
        testCaseSteps.createTestSuite("Login", " ");
        testCaseSteps.createTestCase(testCase);
        testCaseSteps.saveButton();
    }

    @Test(description = "Create test-cases")
    public void createTestcases() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
       //  projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");

        TestCase testCase = new TestCase("Create new  test case", "Test Case", "Test Case (Text)", "Automated",
                "High", "",
                "-", "None", "Быть зарегистрированным пользователем",
                "1.Открыть страницу Test Cases. 2.Кликнуть add Test Case 3.Заполнить фору. 4.Кликнуть конпку add",
                "Проект добавился");
        testCaseSteps.createTestSuite("Test Case", " ");
        testCaseSteps.createTestCase(testCase);
        testCaseSteps.saveAndNextButton();

        TestCase testCase2 = new TestCase("Удалить проект", "Test Case", "Test Case (Text)",
                "Automated", "Low", "", "-", "None",
                "Быть авторезированным пользователем",
                "1.Открыть страницу Test Cases. 2.Кликнуть add Test Case 3.Заполнить фору. 4.Кликнуть конпку add 5.Удалить проект.",
                "Откроется Projects page");
        testCaseSteps.addTestCase(testCase2);
        testCaseSteps.saveButton();
    }

    @Test(description = "Delete test-case")
    public void deleteTestCase() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
         //  projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");
        TestCase testCase = new TestCase("TestRunDelete", "Test Case", "Test Case (Text)", "Automated", "High", "",
                "-", "None", "Быть зарегистрированным пользователем", "steps", "Open Dashboard page");
        testCaseSteps.createTestSuite("Project", " ");
        testCaseSteps.createTestCase(testCase);
        testCaseSteps.saveButton();
        testCaseSteps.goToSection("Test Cases");
        testCaseSteps.delete(testCase.getTitle());
    }
}