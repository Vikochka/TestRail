package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.LoginPage;

public class LoginSteps {
    WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login by user:Viktoriya Yermakovich")
    public void login(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginSetUp(login, password);
        loginPage.isDashBoardPage();
    }
}
