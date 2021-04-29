package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import page.AdministrationMenu;
import page.LoginPage;
import page.ProjectPage;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

@Listeners
public class BaseTest {
    public String login = "erviktoria19@gmail.com";
    public String password = "Hipstr19";
    WebDriver driver;
    LoginPage loginPage;
    LoginSteps loginStep;
    ProjectPage projectPage;
    AdministrationMenu administrationMenu;

    @BeforeMethod
    public void setup(ITestContext context) {
        // driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        WebDriverManager.chromedriver().driverVersion("90.0.4430.24").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
        loginPage = new LoginPage(driver);
        loginStep = new LoginSteps(driver);
        projectPage = new ProjectPage(driver);
        administrationMenu=new AdministrationMenu(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
