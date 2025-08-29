package test.auth;

import org.testng.SkipException;
import org.testng.annotations.Test;


public class SSOLogin {

    @Test
    void anExistingTestMethod() {
        throw new SkipException("SOO feature is disable temporary");
    }

    @Test(groups = {"smoke"})
    void generateUI () {
        System.out.println("SSOLogin: Login with SSO");
    }

    @Test(groups = {"regression"})
    void loginWithCorrectCredential () {
        System.out.println("SSOLogin: Login with SSO");
    }
}
