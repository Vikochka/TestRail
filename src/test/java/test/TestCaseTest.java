package test;

import modals.TestCase;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test(description = "Create test-case")
    public void createTestcaseTest() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectPage.clickAddNewProject();
        addProjectSteps.createProject("TestRail", "Diploma project", "Use multiple test ");
        projectPage.clickSmallIcon("TestRail"); //не кликает на саму иконку
        TestCase testCase = new TestCase("TestRail", "Login", "Test Cese(Text)", "Automated", "High", "-",
                "-", "None", "-", "1.Открыть страницу логина. 2.Ввести логин 3.Ввести пароль." +
                " 4.Кликнуть конпку Логин", "Откроется Dashboard page");
        testCaseSteps.createTestCaseAndClickSaveButton(testCase);
    }
}