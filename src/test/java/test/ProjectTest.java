package test;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(description = "Add new project and save")
    public void createProjectTest() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectSteps.addProject("Use multiple test suites to manage cases", "TestRail",
                "Test Case Management");
    }

    @Test(description = "Delete project ")
    public void deleteProjectTest() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectSteps.addProject("Use a single repository for all cases", "DeleteTestRail",
                "Test Case Management");
        projectSteps.deleteProject("DeleteTestRail");
    }
}