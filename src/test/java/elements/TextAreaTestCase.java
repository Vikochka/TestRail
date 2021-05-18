package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TextAreaTestCase {
    WebDriver driver;
    String label;
    public static final String TEXT_AREA_TEST_CASE_XPATH = "//*[@class='form-description form-description-full' and contains(text(),'%s')]/..//*[contains(@class,'form-control ')]";

    public TextAreaTestCase(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void textAreaTestCase(String text) {
        try {
            driver.findElement(By.xpath(String.format(TEXT_AREA_TEST_CASE_XPATH, label))).sendKeys(text);
        } catch (NoSuchElementException ex) {
            Assert.fail(String.format("Cannot find option '%s'", label));
        }
    }
}