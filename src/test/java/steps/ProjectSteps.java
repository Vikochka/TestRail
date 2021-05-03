package steps;

import org.openqa.selenium.WebDriver;
import pages.ProjectPage;

/*НЕ РАБОТАЕТ addProject()*/
public class ProjectSteps extends AddProjectSteps {

    public ProjectSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void addProject(String labelName, String radio, String projectName, String announcement) {
        projectPage = new ProjectPage(driver);
        projectPage.clickAddNewProject();
        projectPage.isPageOpen(labelName);
        addProjectSteps.createProject(projectName, announcement, radio);
        projectPage.validationProject(projectName);
    }

    public void deleteProject(String projectName) {
        projectPage = new ProjectPage(driver);
        projectPage.validationProject(projectName);
        projectPage.DeleteProject(projectName);
        projectPage.okDeleteButton(projectName);
    }
}