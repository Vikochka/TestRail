package test;

import org.testng.annotations.Test;

public class TestRunTest extends BaseTest {

    @Test(description = "Create Test Run")
    public void addTestRun() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        // projectSteps.addProject("Use multiple test", "TestRail", "Diploma project");
        projectPage.clickSmallIcon("TestRail");
        testRunSteps.addTestRun("TestRail", "Login", " ", "Me", "blabla", "Include all test cases");
    }


}