package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InputTestCase {
    public static final String INPUT_TEST_CASE_XPATH = "//*[contains(text(),'%s')]/../input[contains(@class,'form-fields')]";
    WebDriver driver;
    String label;

    public InputTestCase(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void inputTestCase(String text) {
        try {
            driver.findElement(By.xpath(String.format(INPUT_TEST_CASE_XPATH, label))).sendKeys(text);
        } catch (NoSuchElementException ex) {
            Assert.fail(String.format("Cannot find option '%s'", label));
        }
    }
}