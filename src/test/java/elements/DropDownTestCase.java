package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DropDownTestCase {

    WebDriver driver;
    String label;

    public static final String DROPDOWN_TEST_CASE_XPATH = "//*[contains(text(),'%s')]/..//*[@class='chzn-container chzn-container-single']";
    public static final String CLICK_DROPDOWN_XPATH = "//*[@class='chzn-drop']/*/*[contains(text(),'%s')]";


    public DropDownTestCase(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectForTestCase(String selectName) {
        driver.findElement(By.xpath(String.format(DROPDOWN_TEST_CASE_XPATH, label))).click();
        try {
            driver.findElement(By.xpath(String.format(CLICK_DROPDOWN_XPATH, selectName))).click();
        } catch (NoSuchElementException ex) {
            Assert.fail(String.format("Cannot find option '%s'", selectName));
        }
    }
}