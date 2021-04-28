package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import page.LoginPage;
import steps.LoginSteps;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;
@Listeners
public class BaseTest {
    public String login = "erviktoria19@gmail.com";
    public String password = "Hipstr19";
    WebDriver driver;
    LoginPage loginPage;
    LoginSteps loginStep;

    @BeforeMethod
    public void setup(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
      //  WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
        loginPage = new LoginPage(driver);
        loginStep =new LoginSteps(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
