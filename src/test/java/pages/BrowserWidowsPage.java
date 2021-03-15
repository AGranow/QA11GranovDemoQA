package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWidowsPage extends PageBase {
    public BrowserWidowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement newTabBtn;



    public BrowserWidowsPage clickOnNewTabBtn() {
        newTabBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public String getTextFromNewTab() {
        return driver.findElement(By.id("sampleHeading")).getText();
    }


//---------------------------------------------------------------------------------------------------

    @FindBy(id ="windowButton")
    WebElement newWindowsBtn;

    public BrowserWidowsPage clickOnNewWindowBtn() {
        newWindowsBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public String getTextFromNewWindow() {
        return driver.findElement(By.id("sampleHeading")).getText();
    }

    //-----------------------------------------------------------------------------------------

    public BrowserWidowsPage clickOnNewWindowMessageBtn() {
        newWindowsBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
}
