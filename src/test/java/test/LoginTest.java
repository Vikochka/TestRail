package test;

import org.testng.annotations.Test;
import page.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginSetUp(login, password);
        loginPage.isDashBoardPage();
        administrationMenu.projectButton();
        projectPage.addNewProject();
    }
}
