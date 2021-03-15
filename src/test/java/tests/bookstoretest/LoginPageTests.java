package tests.bookstoretest;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginPageTests extends TestBase {

    @Test
    public void loginTest(){
        new HomePage(driver).goToBookStore();
        new ProfilePage(driver).goToLoginPage();
        new LoginPage(driver).loginPositive("AGranov","Grom12345!")
                .verifyUserName("AGranov")
                .logout();
    }
}


