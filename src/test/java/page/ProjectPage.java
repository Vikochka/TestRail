package page;

import elemtnts.AddProject;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public void addNewProject() {
        new AddProject(driver,"Add Project").addProjectButton();
    }

}
