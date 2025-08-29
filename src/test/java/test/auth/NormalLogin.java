package test.auth;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NormalLogin {

    @Test(groups = {"smoke"})
    void generateUI () {
        System.out.println("NormalLogin: generateUI");
//        Assert.fail();
        Assert.assertTrue(true);
    }
    @Test(groups = {"regression"})
    void loginNormal() {
        System.out.println("NormalLogin: Login normally");
    }
}
