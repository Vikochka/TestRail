package steps;

import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.ProjectPage;

public class ProjectSteps {
    WebDriver driver;

    public ProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void addProject(String radio, String projectName, String announcement) {
        ProjectPage projectPage = new ProjectPage(driver);
        projectPage.clickAddNewProject();

        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.isPageOpen();
        addProjectPage.createProject(projectName, announcement, radio);
        addProjectPage.clickAddProjectButton();
        projectPage.validationProject(projectName);
    }

    public void deleteProject(String projectName) {
        ProjectPage projectPage = new ProjectPage(driver);
        projectPage.validationProject(projectName);
        projectPage.DeleteProject(projectName);
        projectPage.okDeleteButton(projectName);
    }
}