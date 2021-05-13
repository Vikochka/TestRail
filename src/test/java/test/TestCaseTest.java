package test;

import io.qameta.allure.Step;
import modals.TestCase;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test(description = "Create one test-case")
    public void createOneTestcaseTest() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
     //   projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");
        TestCase testCase = new TestCase("TestRail", "Test Case", "Test Case(Text)", "Automated", "High", "",
                "-", "None", "Быть зарегистрированным пользователем", "1.Открыть страницу логина. " +
                "2.Ввести логин " +
                "3.Ввести пароль." +
                " 4.Кликнуть конпку Логин", "Откроется Dashboard page");
        testCaseSteps.createTestSuite("Login", " ");
        testCaseSteps.createTestCase(testCase);
        testCaseSteps.saveButton();
    }

    @Test(description = "Create test-cases")
    public void createTestcaseTest() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");

        TestCase testCase = new TestCase("Login", "Test Case", "Test Case(Text)", "Automated",
                "High", "",
                "-", "None", "Быть зарегистрированным пользователем",
                "1.Открыть страницу логина.2.Ввести логин 3.Ввести пароль. 4.Кликнуть конпку Логин",
                "Откроется Dashboard page");
        testCaseSteps.createTestSuite("TestRail", " ");
        testCaseSteps.createTestCase(testCase);
        testCaseSteps.saveAndNextButton();

        TestCase testCase2 = new TestCase("Create new project", "Test Case", "Test Case(Text)",
                "Automated", "Low", "","-", "None",
                "Быть авторезированным пользователем",
                "1.кликнуть administration. " +
                "2.выбрать projects " +
                "3. кликнуть add project" +
                "4.заполнить форму" +
                "5.кликнуть add project", "Откроется Projects page");
        testCaseSteps.addTestCase(testCase2);
        testCaseSteps.saveButton();
    }


    @Test(description = "Delete test-case:{testCaseName}")
    public void deleteTestCaseTest(){
        loginStep.login(login, password);
        administrationSteps.admin("Project");
      //  projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");
        testCaseSteps.delete("TestRail","Login");
    }
}