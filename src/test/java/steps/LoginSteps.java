package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login by user: {login}")
    public void login(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginSetUp(login, password);
        loginPage.isDashBoardPageOpen();
    }
}