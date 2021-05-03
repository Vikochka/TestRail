package test;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(description = "Add new project and save")
    public void createAndDeleteProject() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectPage.clickAddNewProject();
        addProjectSteps.createProject("TestRail", "Diploma project", "Use multiple test ");
        projectSteps.deleteProject("TestRail");
    }
}