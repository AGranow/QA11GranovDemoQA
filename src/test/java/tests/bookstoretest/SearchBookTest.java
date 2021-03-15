package tests.bookstoretest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProfilePage;
import java.io.IOException;

public class SearchBookTest extends  TestBase{

    @Test
    public void  searchBookPositiveTest() throws IOException {
        new HomePage(driver).goToBookStore();
            String text = "Git";
            new ProfilePage(driver).typeInSearchFieldInput(text).takeNameOfBook();
            Assert.assertTrue(new ProfilePage(driver).takeNameOfBook().contains(text));
            new ProfilePage(driver).takeScreenshotField(driver.findElement(By.xpath("//span[@class='mr-2']/a")));
    }

    @Test
    public void verifyEmptyFieldTest(){
        new HomePage(driver).goToBookStore();
        new ProfilePage(driver).typeInSearchFieldInput("  ").verifyEmptyField();
        Assert.assertTrue(new ProfilePage(driver).verifyEmptyField().contains(""));
    }
}
