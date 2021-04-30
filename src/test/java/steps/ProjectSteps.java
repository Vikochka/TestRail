package steps;

import org.openqa.selenium.WebDriver;
import page.ProjectPage;

/*НЕ РАБОТАЕТ*/
public class ProjectSteps extends BaseSteps {

    public ProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void addProject( String labelName, String radio, String projectName, String announcement) {
        projectPage = new ProjectPage(driver);
        projectPage.clickAddNewProject();
        projectPage.isAddPageOpen(labelName);
        addProjectSteps.createProject(projectName, announcement, radio);
        projectPage.validationProject(projectName);
    }

    public void addProjectAndClose(String name, String radio, String projectName, String announcement) {
        projectPage = new ProjectPage(driver);
        projectPage.clickAddNewProject();
        projectPage.isAddPageOpen(name);
        addProjectSteps.createProject(radio, projectName, announcement);
        projectPage.validationProject(projectName);
    }

    public void deleteProject(String projectName){
        projectPage = new ProjectPage(driver);
        projectPage.validationProject(projectName);
        projectPage.DeleteProject(projectName);
        projectPage.okDeleteButton(projectName);
    }
}