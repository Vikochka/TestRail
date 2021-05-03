package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps extends BaseSteps {

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login by user:Viktoriya Yermakovich")
    public void login(String login, String password) {
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginSetUp(login, password);
        loginPage.isDashBoardPageOpen();
    }
}