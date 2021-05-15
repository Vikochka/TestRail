package steps;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseSteps {
    WebDriver driver;
    AddProjectPage addProjectPage;
    LoginPage loginPage;
    AdministrationMenu administrationMenu;
    ProjectPage projectPage;
    TestCaseAndSuitePage testCaseAndSuitePage;


    public void setUPSteps() {
        addProjectPage = new AddProjectPage(driver);
        administrationMenu = new AdministrationMenu(driver);
        loginPage = new LoginPage(driver);
        projectPage = new ProjectPage(driver);
        testCaseAndSuitePage = new TestCaseAndSuitePage(driver);
    }
}