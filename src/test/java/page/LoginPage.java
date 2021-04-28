package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public static final String LOGIN_INPUT_XPATH = "//*[@id='name']";
    public static final String PASSWORD_INPUT_XPATH = "//*[@id='password']";
    public static final String LOGIN_BUTTON_XPATH = "//*[@id='button_primary']";
    public static final String WAIT_FOR_LOGIN_PAGE_XPATH ="//*[@id='navigation-dashboard']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open LoginPage")
    public void openLoginPage(){
        driver.get(URL);
    }
    @Step("Login by user {username}")
    public void loginSetUp(String login, String password){
        driver.findElement(By.xpath(String.format(LOGIN_INPUT_XPATH,login)));
        driver.findElement(By.xpath(String.format(PASSWORD_INPUT_XPATH,password)));
        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
    }
    public void isDashBoardPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WAIT_FOR_LOGIN_PAGE_XPATH)));
        } catch (Exception ex) {
            Assert.fail("DashboardPage was not opened"); //
        }
    }
}
