package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.ProjectPage;
import steps.*;

import java.util.concurrent.TimeUnit;

@Listeners
public class BaseTest {
    public String login = "vikakatestrail@mailinator.com";
    public String password = "Rs5XGzbZ4VBqS5pnrs.o";
    WebDriver driver;
    LoginSteps loginStep;
    ProjectSteps projectSteps;
    ProjectPage projectPage;
    AdministrationSteps administrationSteps;
    TestCaseSteps testCaseSteps;
    TestRunSteps testRunSteps;

    @BeforeMethod
    public void setup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        loginStep = new LoginSteps(driver);
        administrationSteps = new AdministrationSteps(driver);
        projectSteps = new ProjectSteps(driver);
        projectPage = new ProjectPage(driver);
        testCaseSteps = new TestCaseSteps(driver);
        testRunSteps = new TestRunSteps(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}