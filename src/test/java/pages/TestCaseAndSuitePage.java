package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseAndSuitePage extends BasePage {
    public static final By ADD_TEST_CASE_BUTTON_ID = By.id("sidebar-cases-add");
    public static final By TEST_CASE_BUTTON = By.id("navigation-suites");

    public TestCaseAndSuitePage(WebDriver driver) {
        super(driver);
    }

    public void openTestCasePage() {
        driver.findElement(TEST_CASE_BUTTON).click();
    }

    public void clickAddTestCase() {
        driver.findElement(ADD_TEST_CASE_BUTTON_ID).click();
    }
}