package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuiteListPage extends BasePage {
    public static final By SUITE_NAME_ID = By.id("name");
    public static final By DESCRIPTION_SUITE_ID = By.id("description_display");
    public static final By SAVE_SUITE_BUTTON = By.id("accept");
    public static final By CANCEL_SUITE_BUTTON_XPATH = By.xpath("//*[@class='button-group form-buttons']/*[contains(@class,'button-cancel')]");

    public SuiteListPage(WebDriver driver) {
        super(driver);
    }

    public void openSuiteListPage() {
        driver.get("https://vikaka1.testrail.io/index.php?/suites/edit/6");
    }

    public void createSuite(String nameSuite, String descriptionSuite) {
        driver.findElement(SUITE_NAME_ID).sendKeys(nameSuite);
        driver.findElement(DESCRIPTION_SUITE_ID).sendKeys(descriptionSuite);
    }

    public void saveSuite() {
        driver.findElement(SAVE_SUITE_BUTTON).click();
    }

    public void cancelSuite() {
        driver.findElement(CANCEL_SUITE_BUTTON_XPATH).click();
    }
}