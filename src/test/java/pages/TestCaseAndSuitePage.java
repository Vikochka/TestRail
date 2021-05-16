package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class TestCaseAndSuitePage extends BasePage {
    public static final By ADD_TEST_CASE_BUTTON_ID = By.id("sidebar-cases-add");
    public static final By ADD_TEST_SUITE_BUTTON_ID = By.id("navigation-suites-add");
    public static final By TEST_CASE_BUTTON = By.id("navigation-suites");
    public static final String TITLE_TEST_CASE_XPATH = "//*[@class='title'][contains(text(),'%s')]/..";
    public static final By DELETE_BUTTON_ID = By.id("deleteCases");
    public static final By MARK_AS_DELETE_BUTTON = By.xpath("//*[contains(@class,'button-ok')][contains(text(),'Mark as Deleted')]");

    public TestCaseAndSuitePage(WebDriver driver) {
        super(driver);
    }

    public void openTestCasePage() {
        driver.findElement(TEST_CASE_BUTTON).click();
    }

    public void clickAddTestSuite() {
        driver.findElement(ADD_TEST_SUITE_BUTTON_ID).click();
    }

    public void clickAddTestCase() {
        driver.findElement(ADD_TEST_CASE_BUTTON_ID).click();
    }

    public boolean deleteTestCase(String testCaseName) {
        String checkbox = "//span[contains(text(),'%s') and contains(@class,'title')]/ancestor::tr//input";
        driver.findElement(By.xpath(String.format(checkbox, testCaseName))).click();
        driver.findElement(DELETE_BUTTON_ID).click();
        driver.findElement(MARK_AS_DELETE_BUTTON).click();

        try {
            driver.findElement(By.xpath(String.format(TITLE_TEST_CASE_XPATH, testCaseName))).isDisplayed();
            return false;
        } catch (Exception exception) {
            Assert.fail("Test-case did not disappear " + testCaseName);
            log.error(exception.getMessage());
            return true;
        }
    }
}