package test;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(description = "Add new project and save")
    public void createProjectTest() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectSteps.addProject("Use a single repository for all cases", "TestRail25",
                "Test Case Management");
        // projectPage.clickAddNewProject();
        // addProjectSteps.createProject("TestRail", "Diploma project", "Use multiple test ");
        // projectSteps.deleteProject("TestRail");
    }

    @Test(description = "Add new project and save")
    public void deleteProjectTest() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectSteps.addProject("Use a single repository for all cases", "1TestRailDelete",
                "Test Case Management");
        projectSteps.deleteProject("1TestRailDelete");
    }
}