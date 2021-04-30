package test;

import org.testng.annotations.Test;

public class AdministrationTest extends BaseTest {

    @Test(description = "Checking transition")
    public void transitionTest() {
        loginStep.login(login, password);
        administrationSteps.admin("Projects");
    }
}