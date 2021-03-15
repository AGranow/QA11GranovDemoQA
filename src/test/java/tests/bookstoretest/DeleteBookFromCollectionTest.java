package tests.bookstoretest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class DeleteBookFromCollectionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {  //обеспечить предварительные условия
        new HomePage(driver).goToBookStore();
        new ProfilePage(driver).goToLoginPage();
        new LoginPage(driver).loginPositive("AGranov", "Grom12345!");
    }

    @Test
    public void deleteBookFromYourCollectionTest() {
        String text = "Git";
        new ProfilePage(driver).typeInSearchFieldInput(text).clickByFirstBookInTab()
                .addBookToYourCollection().clickOnProfileBtn().clickOnTrashToDeleteBook();
        Assert.assertTrue(new ProfilePage(driver).verifyEmptyField().contains(""));
    }
}
