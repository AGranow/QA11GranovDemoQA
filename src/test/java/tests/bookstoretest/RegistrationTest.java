package tests.bookstoretest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToBookStore();
        new LoginPage(driver).clickOnNewUserButton();
    }

    @Test
    public void registrationTest(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);

        String fName = "Robert" + i;
        String lName = "Downey" + i;
        String uName = "RobertDowney" + i;
        String pwd = "Robert!" + i;

        new RegisterPage(driver).fillRegistrationForm(fName,lName,uName,pwd).clickOnRecaptcha();
    }
}
