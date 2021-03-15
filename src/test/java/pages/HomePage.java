package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
    WebElement bookStoryApplicationButton;

    public ProfilePage goToBookStore(){
        bookStoryApplicationButton.click();
        return new ProfilePage(driver);
    }


    @FindBy (xpath = "//div/h5[.='Alerts, Frame & Windows']")
    WebElement alertFrameAndWindowsBtn;

    public SidePanelPage goToAlertPage() {
        clickWitchAction(alertFrameAndWindowsBtn, 0, 300);
        return new SidePanelPage(driver);
    }
}
