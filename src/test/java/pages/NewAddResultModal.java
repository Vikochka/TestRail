package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static elements.DropDownTestCase.CLICK_DROPDOWN_XPATH;

public class NewAddResultModal extends BasePage {
    public static final String INPUT_FORM_XPATH = "//label[contains(text(),'%s')]/..//*[contains(@class,'form-control-full')]";
    public static final String DROP_DOWN_FORM_XPATH = "//label[contains(text(),'%s')]/..//*[@class='chzn-container chzn-container-single']";
    public static final By COMMENT_FORM_ID = By.id("addResultComment_display");
    public static final By ADD_RESULT_FORM_ID = By.id("addResultSubmit");

    public NewAddResultModal(WebDriver driver) {
        super(driver);
    }

    public void addResultForm(String statusOption, String comment, String assignToOption, String version, String elapsed, String defects) {
        driver.findElement(By.xpath(String.format(DROP_DOWN_FORM_XPATH, "Status"))).click();
        driver.findElement(By.xpath(String.format(CLICK_DROPDOWN_XPATH, statusOption))).click();
        driver.findElement(COMMENT_FORM_ID).sendKeys(comment);
        driver.findElement(By.xpath(String.format(DROP_DOWN_FORM_XPATH, "Assign To"))).click();
        driver.findElement(By.xpath(String.format(CLICK_DROPDOWN_XPATH, assignToOption))).click();
        driver.findElement(By.xpath(String.format(INPUT_FORM_XPATH, "Version"))).sendKeys(version);
        driver.findElement(By.xpath(String.format(INPUT_FORM_XPATH, "Elapsed"))).sendKeys(elapsed);
        driver.findElement(By.xpath(String.format(INPUT_FORM_XPATH, "Defects"))).sendKeys(defects);
        driver.findElement(ADD_RESULT_FORM_ID).click();
    }
}
