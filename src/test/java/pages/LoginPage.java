package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;


    @FindBy(id = "password")
    WebElement password;


    @FindBy(id = "login")
    WebElement loginBtn;


    public ProfilePage loginPositive(String username, String pswd){
        type(userName,username);
        type(password,pswd);
        loginBtn.click();
        return  new ProfilePage(driver);
    }

    public LoginPage loginNegative(String username, String pswd){
        type(userName,username);
        type(password,pswd);
        loginBtn.click();
        return  this;
    }

    @FindBy(id="newUser")
    WebElement newUserBtn;

    public RegisterPage clickOnNewUserButton(){
        newUserBtn.click();
        return new RegisterPage(driver);
    }
}
