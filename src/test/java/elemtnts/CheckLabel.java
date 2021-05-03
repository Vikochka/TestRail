package elemtnts;

import org.openqa.selenium.WebDriver;

public class CheckLabel {
    public static final String CHECK_LABEL_XPATH = "//*[@class='content-header-result']/../*[contains(text(),'%s')]";

    WebDriver driver;
    String label;

    public CheckLabel(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
}