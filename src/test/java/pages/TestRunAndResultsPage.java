package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static elements.CheckLabel.CHECK_LABEL_XPATH;

public class TestRunAndResultsPage extends BasePage {
    public static final By TEST_RUN_PAGE_ID = By.id("navigation-runs");
    public static final By ADD_TEST_RUN_BUTTON_ID = By.id("navigation-runs-add");
    public static final By SELECT_TEST_SUITE_WINDOW_ID = By.id("ui-dialog-title-chooseSuiteDialog");
    public static final By DROPDOWN_ID = By.id("choose_suite_id");
    public static final String SELECT_SUITE_XPATH = "//*[@id='choose_suite_id']/*[text()='%s']";
    public static final By OK_BUTTON_XPATH = By.xpath("//*[contains(@class,'positive button-ok')][contains(text(),'OK')]");
    public static final By DESCRIPTION_ID = By.id("description_display");
    public static final By NAME_ID = By.id("name");
    public static final By REFERENCES_ID = By.id("refs");
    public static final By MILESTONE_ID = By.id("milestone_id_chzn");
    public static final By ASSIGN_TO_ID = By.id("assignedto_id_chzn");
    public static final String SEARCH_DROP_XPATH = "//*[@class='chzn-search']/../../../..//*[contains(text(),'Assign To')]";
    public static final String SELECT_DROP_XPATH = "//*[@class='chzn-search']/../../../..//*[contains(@class,'active-result')][contains(text(),'%s')]";
    public static final String RADIO_BUTTON_XPATH = "//*[@class='radio']//*[contains(text(),'%s')]";
    public static final By ADD_TEST_RUN_FORM_BUTTON_ID = By.id("accept");

    public TestRunAndResultsPage(WebDriver driver) {
        super(driver);
    }

    public void openTestRunPage() {
        driver.findElement(TEST_RUN_PAGE_ID).click();
    }

    public void clickAddTestRunButton() {
        driver.findElement(ADD_TEST_RUN_BUTTON_ID).click();
        try {
            driver.findElement(SELECT_TEST_SUITE_WINDOW_ID).isDisplayed();
        } catch (Exception e) {
            Assert.fail("Window was not opened");
        }
    }

    public void selectTestSuite(String suiteName) {
        driver.findElement(DROPDOWN_ID).click();
        driver.findElement(By.xpath(String.format(SELECT_SUITE_XPATH, suiteName))).click();
        driver.findElement(OK_BUTTON_XPATH).click();
        isAddRunPageOpen();
    }

    public void addTestRunForm(String nameRun, String references, String assignTo, String description, String radioButton) {
        driver.findElement(NAME_ID).sendKeys(nameRun);
        driver.findElement(REFERENCES_ID).sendKeys(references);
        driver.findElement(MILESTONE_ID);
        driver.findElement(ASSIGN_TO_ID).click();
        driver.findElement(By.xpath(String.format(SELECT_DROP_XPATH, assignTo))).click();
        driver.findElement(DESCRIPTION_ID).sendKeys(description);
        driver.findElement(By.xpath(String.format(RADIO_BUTTON_XPATH, radioButton)));
        driver.findElement(ADD_TEST_RUN_FORM_BUTTON_ID).click();
    }

    private void isAddRunPageOpen() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(CHECK_LABEL_XPATH, "Add Test Run"))));
        } catch (Exception ex) {
            Assert.fail("Add page was not opened");
        }
    }
}