package steps;

import org.openqa.selenium.WebDriver;
import pages.AdministrationMenu;

public class AdministrationSteps {
    WebDriver driver;

    public AdministrationSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void admin(String name) {
        AdministrationMenu administrationMenu = new AdministrationMenu(driver);
        administrationMenu.clickAdmin();
        administrationMenu.menu(name);
        administrationMenu.isTransition(name);
    }
}