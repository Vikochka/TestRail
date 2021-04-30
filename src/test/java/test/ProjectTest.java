package test;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(description = "Add new project and save")
    public void addProjectTest() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectPage.clickAddNewProject();
        addProjectSteps.createProject("TestRail", "Diploma project", "Use multiple test ");
        projectSteps.deleteProject("TestRail");
    }

    /*НЕ РАБОТАТЕ projectSteps*/
    @Test(description = "Add new project and close")
    public void negativeProjectTest() {
        loginStep.login(login, password);
        administrationSteps.admin("Project");
        projectSteps.addProjectAndClose("Add Project", "Use multiple ", "TestRailClose",
                "Should be invisibility");
    }
}