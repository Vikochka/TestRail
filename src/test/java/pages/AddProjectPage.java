package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static elements.CheckLabel.CHECK_LABEL_XPATH;

public class AddProjectPage extends BasePage {

    public static final By NAME_INPUT_ID = By.id("name");
    public static final By ANNOUNCEMENT_TEXTAREA_ID = By.id("announcement");
    public static final By ANNOUNCEMENT_CHECKBOX_ID = By.id("show_announcement");
    public static final String RADIO_BUTTON_XPATH = "//*[@type='radio']/../strong[contains(text(),'%s')]";
    public static final By ADD_PROJECT_BUTTON_XPATH = By.xpath("//*[@class='button-group form-buttons']/*[contains(@class,'button-ok')]");
    public static final By CANCEL_BUTTON_XPATH = By.xpath("//*[@class='button-group form-buttons']/*[contains(@class,'button-cancel')]");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public void createProject(String projectName, String announcement, String radio) {
        driver.findElement(NAME_INPUT_ID).sendKeys(projectName);
        driver.findElement(ANNOUNCEMENT_TEXTAREA_ID).sendKeys(announcement);
        driver.findElement(ANNOUNCEMENT_CHECKBOX_ID).click();
        driver.findElement(ANNOUNCEMENT_CHECKBOX_ID).isSelected();
        driver.findElement(By.xpath(String.format(RADIO_BUTTON_XPATH, radio))).click();
    }

    public void clickAddProjectButton() {
        driver.findElement(ADD_PROJECT_BUTTON_XPATH).click();
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON_XPATH).click();
    }

    public void isPageOpen() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(CHECK_LABEL_XPATH, "Add Project"))));
        } catch (Exception ex) {
            Assert.fail("Add page was not opened");
        }
    }
}