package test;

import org.testng.annotations.Test;

public class AdministrationTest extends BaseTest {

    @Test(description = "Checking transition")
    public void transition() {
        loginStep.login(login, password);
        administrationSteps.admin("Projects");
    }
}