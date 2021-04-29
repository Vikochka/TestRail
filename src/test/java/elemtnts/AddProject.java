package elemtnts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProject {

    WebDriver driver;
    String label;
    public static final String ADD_PROJECT_XPATH = "//*[@class='button-group grid-buttons bottom']/*[contains(text(),'%s')]";

    public AddProject(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void addProjectButton() {
        driver.findElement(By.xpath(String.format(ADD_PROJECT_XPATH, label))).click();
    }
}
