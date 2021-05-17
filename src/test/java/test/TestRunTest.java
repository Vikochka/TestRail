package test;

import org.testng.annotations.Test;

public class TestRunTest extends BaseTest {


    @Test(description = "Create Test Run",priority = 1)
    public void addTestRun() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        //  projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");
        testRunSteps.addTestRun("Login", " ", " ", "Me", "blabla", "Include all test cases");
    }

    @Test(description = "Add test resul",priority =2)
    public void addTestResult() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        //  projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");
        testRunSteps.addResult("Login", "", "TestRun", "Retest", "retest test case", "Me",
                "1.0", "30s", "no");

    }
}