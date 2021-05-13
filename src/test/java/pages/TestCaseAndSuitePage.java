package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestCaseAndSuitePage extends BasePage {
    public static final By ADD_TEST_CASE_BUTTON_ID = By.id("sidebar-cases-add");
    public static final By ADD_TEST_SUITE_BUTTON_ID = By.id("navigation-suites-add");
    public static final By TEST_CASE_BUTTON = By.id("navigation-suites");
    public static final String CHECK_BOX_TEST_CASE_CSS = "name=selected-%s";
    public static final String TITLE_TEST_CASE_XPATH = "//*[@class='title'][contains(text(),'%s')]/..";
    public static final By DELETE_BUTTON_ID = By.id("deleteCases");
    public static final By MARK_AS_DELETE_BUTTON = By.xpath("//*[contains(@class,'button-ok')][contains(text(),'Mark as Deleted')]");
    public static final String TEST_SUITE_NAME_XPATH = "//*[contains(@class,'summary-title summary-title-compact text-ppp')]/*[contains(text(),'TestRail')]";

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

    public boolean deleteTestCase(String testSuiteName,String testCaseName) {
        driver.findElement(By.xpath(String.format(TEST_SUITE_NAME_XPATH,testSuiteName))).click();
        WebElement testCase = driver.findElement(By.xpath(String.format(TITLE_TEST_CASE_XPATH, testCaseName)));
        String testCaseId = testCase.getAttribute("href").split("/")[7];
        driver.findElement(By.cssSelector(String.format(CHECK_BOX_TEST_CASE_CSS, testCaseId))).click();
        driver.findElement(DELETE_BUTTON_ID).click();
        driver.findElement(MARK_AS_DELETE_BUTTON).click();

        try {
            driver.findElement(By.xpath(String.format(TITLE_TEST_CASE_XPATH, testCaseName))).isDisplayed();
            return false;
        } catch (Exception exception) {
            Assert.fail("Project was not disappeared!");
            return true;
        }
    }
}