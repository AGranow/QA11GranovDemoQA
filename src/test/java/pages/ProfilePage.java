package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProfilePage extends LoginPage {


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement user;

    @FindBy(id = "submit")
    WebElement logoutBtn;


    public ProfilePage verifyUserName(String uName) {
        if (user.getText().equalsIgnoreCase(uName)) {
            System.out.println("Correct user name: " + user.getText());
        } else {
            System.out.println("Incorrect user name: " + user.getText());
        }
        return this;
    }

    public LoginPage logout() {
        System.out.println("Let's  out from profile");
        logoutBtn.click();
        return new LoginPage(driver);
    }

    @FindBy(id = "login")
    WebElement loginButn;

    public LoginPage goToLoginPage() {
        loginButn.click();
        return new LoginPage(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchInput;

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement nameOfBook;


    public ProfilePage typeInSearchFieldInput(String text) {
        type(searchInput, text);
        return this;
    }

    public String takeNameOfBook() {
        pause(500);
        return driver.findElement(By.xpath("//span[@class='mr-2']/a")).getText();

    }

    public String verifyEmptyField() {
        pause(500);
        return driver.findElement(By.cssSelector(".rt-tr-group:nth-child(1) .rt-td:nth-child(2)")).getText();
    }

    public ProfilePage clickByFirstBookInTab() {
        nameOfBook.click();
        return this;
    }

    @FindBy(css = ".text-right.fullButton")
    WebElement addToCollectionButton;

    public ProfilePage addBookToYourCollection() {
        clickWitchAction(addToCollectionButton, 0, 300);
        pause(500);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(css = ".show #item-3")
    WebElement profileBtn;

    public ProfilePage clickOnProfileBtn(){
        clickWitchAction(profileBtn,0,500);
        return this;
    }

    @FindBy(xpath = "//*[@id='delete-record-undefined']")
    List<WebElement> bookList;

    @FindBy(id = "closeSmallModal-ok")
    WebElement okButton;

    public ProfilePage clickOnTrashToDeleteBook() {
        bookList.get(0).click();
        pause(2000);
        okButton.click();
        pause(2000);
        driver.switchTo().alert().accept();
        return this;
    }
}