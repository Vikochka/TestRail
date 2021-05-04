package steps;

import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;

public class AddProjectSteps {
    WebDriver driver;

    public AddProjectSteps(WebDriver driver) {
        this.driver = driver;
    }
    
    public void createProject(String name, String announcement, String radio) {
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.createProject(name, announcement, radio);
        addProjectPage.clickAddProjectButton();
    }
}