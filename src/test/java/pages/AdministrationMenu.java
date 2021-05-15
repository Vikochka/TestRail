package pages;
/*global settings
 *Overview
 * Projects
 * Users & Roles
 * Customizations
 * Integration
 * Data Management
 * Site Settings
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static elements.CheckLabel.CHECK_LABEL_XPATH;

public class AdministrationMenu extends BasePage {
    public static final By ADMIN_BUTTON_XPATH = By.id("navigation-admin");
    public static final String MENU_XPATH = "//*[contains(@id,'navigation-sub')]/../*[contains(text(),'Projects')]";


    public AdministrationMenu(WebDriver driver) {
        super(driver);
    }

    public void clickAdmin() {
        driver.findElement(ADMIN_BUTTON_XPATH).click();
    }

    public void menu(String name) {
        driver.findElement(By.xpath(String.format(MENU_XPATH, name))).click();
    }

    public void isTransition(String name) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(CHECK_LABEL_XPATH, name))));
        } catch (Exception ex) {
            Assert.fail("Page was not opened");
        }
    }
}