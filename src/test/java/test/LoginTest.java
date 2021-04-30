package test;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        loginStep.login(login, password);
    }
}