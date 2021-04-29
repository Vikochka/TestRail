package elemtnts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Administration {
    WebDriver driver;
    String label;
    public static final String ADMINISTRATION_LABEL_XPATH="//*[@class='content-header-result']/../*[contains(text(),'%s')]";

    public Administration(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void administration(String name){
        driver.findElement(By.xpath(String.format(ADMINISTRATION_LABEL_XPATH,name))).click();
    }
}
