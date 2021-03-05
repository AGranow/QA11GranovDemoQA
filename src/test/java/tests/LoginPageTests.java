package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTests extends TestBase {

    @Test
    public void loginTest(){
        new LoginPage(driver).loginPositiv("AGranov","Grom12345!")
                .verifyUserName("AGranov")
                .logout();
    }


}


