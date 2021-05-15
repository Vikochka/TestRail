package test;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        loginStep.login(login, password);
    }
}