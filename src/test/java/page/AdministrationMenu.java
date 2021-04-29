package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AdministrationMenu extends BasePage {
    public static final String PROJECT_ID="navigation-sub-projects";

    public AdministrationMenu(WebDriver driver) {
        super(driver);
    }
    public void projectButton(){
        driver.findElement(By.xpath(PROJECT_ID)).click();
    }

    public void isProjectPageOpen() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(); /**TODO как сюда прокинуть обертку?*/
        } catch (Exception ex) {
            Assert.fail("ProjectPage was not opened");
        }
    }
}
