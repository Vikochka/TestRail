package pages;

import elemtnts.DropDownTestCase;
import elemtnts.InputTestCase;
import elemtnts.TextAreaTestCase;
import modals.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//MASSAGE FOR CREATING TEST CASE "Successfully added the new test case."

public class NewTestCaseModalPage extends BasePage {
    public static final By ADD_TEST_CASE_BUTTON_ID = By.id("accept");
    public static final By ADD_AND_NEXT_TEST_CASE_BUTTON_ID = By.id("accept_and_next");
    public static final By CANCEL_TEST_CASE_BUTTON_ID = By.id("accept_and_next");
    public static final By SUCCESS_CREATE_TEST_CASE_MESSAGE = By.xpath("//*[contains(@class,'message-success')][contains(text(),'Successfully added')]");

    public NewTestCaseModalPage(WebDriver driver) {
        super(driver);
    }

    public void createTestCase(TestCase testCase) {
        new InputTestCase(driver, "Title").inputTestCase(testCase.getTitle());
        new DropDownTestCase(driver, "Section").selectForTestCase(testCase.getSection());
        new DropDownTestCase(driver, "Template").selectForTestCase(testCase.getTemplate());
        new DropDownTestCase(driver, "Type").selectForTestCase(testCase.getType());
        new DropDownTestCase(driver, "Priority").selectForTestCase(testCase.getPriority());
        new InputTestCase(driver, "Estimate").inputTestCase(testCase.getEstimate());
        new InputTestCase(driver, "References").inputTestCase(testCase.getReferences());
        new DropDownTestCase(driver, "Automation Type").selectForTestCase(testCase.getAutomationType());
        new TextAreaTestCase(driver, "Preconditions").textAreaTestCase(testCase.getPreconditions());
        new TextAreaTestCase(driver, "Steps").textAreaTestCase(testCase.getSteps());
        new TextAreaTestCase(driver, "Expected Result").textAreaTestCase(testCase.getExpectedResult());
    }

    public void clickSaveTestCase() {
        driver.findElement(ADD_TEST_CASE_BUTTON_ID).click();
        try {
            driver.findElement(SUCCESS_CREATE_TEST_CASE_MESSAGE).isDisplayed();
        } catch (Exception e) {
            Assert.fail("Test case was not added");
        }
    }

    public void clickSaveAndNextTestCase() {
        driver.findElement(ADD_AND_NEXT_TEST_CASE_BUTTON_ID).click();
        try {
            driver.findElement(SUCCESS_CREATE_TEST_CASE_MESSAGE).isDisplayed();
        } catch (Exception e) {
            Assert.fail("Message was not appeared");
        }
    }

    public void clickCancelTestCase() {
        driver.findElement(CANCEL_TEST_CASE_BUTTON_ID).click();
    }
}