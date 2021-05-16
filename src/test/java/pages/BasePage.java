package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static final String URL = "https://vikakatestrail.testrail.io/index.php";
    WebDriver driver;
    WebDriverWait wait;

    String breadcrumbLink = "//*[contains(@class,'content-breadcrumb')]//a[contains(text(),'%s')]";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage clickBreadCrumb(String breadcrumb) {
        driver.findElement(By.xpath(String.format(breadcrumbLink, breadcrumb))).click();
        return this;
    }

}