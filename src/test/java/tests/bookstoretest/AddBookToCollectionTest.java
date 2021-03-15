package tests.bookstoretest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class AddBookToCollectionTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).goToBookStore();
        new ProfilePage(driver).goToLoginPage();
                new LoginPage(driver).loginPositive("AGranov","Grom12345!");
    }

    @Test
    public void addBookToCollectionTest(){
        String text = "Git";
        new ProfilePage(driver).typeInSearchFieldInput(text).clickByFirstBookInTab()
                .addBookToYourCollection().clickOnProfileBtn();
        Assert.assertTrue(new ProfilePage(driver).takeNameOfBook().contains(text));
    }
}
