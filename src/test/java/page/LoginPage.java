package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public static final String LOGIN_INPUT_ID = "name";
    public static final String PASSWORD_INPUT_ID= "password";
    public static final String LOGIN_BUTTON_ID = "button_primary";
    public static final String WAIT_FOR_LOGIN_PAGE_ID ="navigation-dashboard";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open LoginPage")
    public void openLoginPage(){
        driver.get(URL);
    }
    @Step("Login by user {username}")
    public void loginSetUp(String login, String password){
        driver.findElement(By.id(LOGIN_INPUT_ID)).sendKeys(login);
        driver.findElement(By.id(PASSWORD_INPUT_ID)).sendKeys(password);
        driver.findElement(By.id(LOGIN_BUTTON_ID)).click();
    }
    public void isDashBoardPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(WAIT_FOR_LOGIN_PAGE_ID)));
        } catch (Exception ex) {
            Assert.fail("DashboardPage was not opened");
        }
    }
}
