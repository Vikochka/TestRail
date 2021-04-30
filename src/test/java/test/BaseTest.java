package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import page.AddProjectPage;
import page.ProjectPage;
import steps.AddProjectSteps;
import steps.AdministrationSteps;
import steps.LoginSteps;
import steps.ProjectSteps;

import java.util.concurrent.TimeUnit;

@Listeners
public class BaseTest {
    public String login = "erviktoria19@gmail.com";
    public String password = "TmUJjovDfbb3qcsznogR";
    WebDriver driver;
    LoginSteps loginStep;
    ProjectSteps projectSteps;
    AdministrationSteps administrationSteps;
    ProjectPage projectPage;
    AddProjectPage addProjectPage;
    AddProjectSteps addProjectSteps;

    @BeforeMethod
    public void setup(ITestContext context) {
        WebDriverManager.chromedriver().driverVersion("90.0.4430.24").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
        loginStep = new LoginSteps(driver);
        administrationSteps = new AdministrationSteps(driver);
        projectSteps = new ProjectSteps(driver);
        projectPage = new ProjectPage(driver);
        addProjectPage = new AddProjectPage(driver);
        addProjectSteps = new AddProjectSteps(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}