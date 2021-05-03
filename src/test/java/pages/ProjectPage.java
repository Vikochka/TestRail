package pages;
/*FOR RADIO BUTTON
 *Use multiple test suites to manage cases
 *Use a single repository with baseline support
 *Use a single repository for all cases (recommended)
 */

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static elemtnts.CheckLabel.CHECK_LABEL_XPATH;

public class ProjectPage extends BasePage {
    public static final String ADD_PROJECT_BUTTON_XPATH = "//*[@class='button-group grid-buttons bottom']/*[contains(text(),'Add Project')]";
    public static final String PROJECT_VALIDATION_XPATH = "//*[@class='hidden hoverAction']/../a[text()='%s']";
    // public static final String SMALL_ICON_BUTTON_XPATH = "//*[text()='%s']/../*/a/div[@class='icon-small-openswindow']";
    public static final By SMALL_ICON_CSS = By.cssSelector(".icon-small-openswindow");
    public static final String PAGE_TITLE_XPATH = "//*[@id='content-header']//*[@class='content-header-title page_title'][contains(text(),'%s')]";
    public static final String DELETE_ICON_XPATH = "//*[text()='%s']/../..//*[@class='icon-small-delete']";
    public static final By CONFIRMATION_ID = By.id("ui-dialog-title-deleteDialog");
    public static final By CHECKBOX_CONFIRMATION_XPATH = By.xpath("//*[contains(@class,'ui-dialog-content')]//*[@name='deleteCheckbox']");
    public static final By OK_BUTTON_CONFIRMATION_XPATH = By.xpath("//*[contains(@class,'ui-dialog-content')]//*[contains(@class,'button-ok')]");
    public static final By SUCCESS_DELETE_MESSAGE_CSS = By.cssSelector(".message-success");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }


    @Step("Click on add project")
    public void clickAddNewProject() {
        driver.findElement(By.xpath(String.format(ADD_PROJECT_BUTTON_XPATH))).click();
    }


    @Step("Click at small icon")
    public void clickSmallIcon(String projectName) {
        try {
            Actions action = new Actions(driver);
            WebElement moveProject = driver.findElement(By.xpath(String.format(PROJECT_VALIDATION_XPATH, projectName)));
            action.moveToElement(moveProject).build().perform();
            action.moveToElement(moveProject).moveToElement(driver.findElement(SMALL_ICON_CSS)).clickAndHold();
            try {
                driver.findElement(By.xpath(String.format(PAGE_TITLE_XPATH, projectName))).isDisplayed();
            } catch (Exception exception) {
                Assert.fail("Page was not opened");
            }
        } catch (Exception exception) {
            Assert.fail("Icon was not appeared");
        }
        // driver.findElement(By.xpath(String.format(SMALL_ICON_BUTTON_XPATH, projectName))).click();
    }

    @Step("Click delete project")
    public void DeleteProject(String projectName) {
        driver.findElement(By.xpath(String.format(DELETE_ICON_XPATH, projectName))).click();
        isConfirmationAppeared();
        driver.findElement(CHECKBOX_CONFIRMATION_XPATH).click();
        driver.findElement(CHECKBOX_CONFIRMATION_XPATH).isSelected();

    }

    @Step("Click OK button")
    public boolean okDeleteButton(String projectName) {
        driver.findElement(OK_BUTTON_CONFIRMATION_XPATH).click();
        driver.findElement(SUCCESS_DELETE_MESSAGE_CSS).isDisplayed();
        try {
            driver.findElement(By.xpath(String.format(PROJECT_VALIDATION_XPATH, projectName))).isDisplayed();
            return false;
        } catch (Exception exception) {
            Assert.fail("Project was not disappeared!");
            return true;
        }
    }

    @Step("Check that project was added")
    public void validationProject(String name) {
        try {
            driver.findElement(By.xpath(String.format(PROJECT_VALIDATION_XPATH, name))).isDisplayed();
        } catch (Exception exception) {
            Assert.fail("Project was not added");
        }

    }

    @Step("Check that Add Project page open")
    public void isPageOpen(String labelName) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(CHECK_LABEL_XPATH, labelName))));
        } catch (Exception ex) {
            Assert.fail("Add page was not opened");
        }
    }

    @Step("Check that Confirmation window appeared")
    private void isConfirmationAppeared() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRMATION_ID));
        } catch (Exception ex) {
            Assert.fail("Confirmation window was not appeared!");
        }
    }
}