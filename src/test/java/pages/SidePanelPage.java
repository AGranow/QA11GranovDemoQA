package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase{



    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsBtn;

    public void selectBrowserWindows(){
        clickWitchAction(browserWindowsBtn,0,300);
        new BrowserWidowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alertsBtn;

    public AlertsPage selectAlerts(){
        clickWitchAction(alertsBtn,0,300);
        return new AlertsPage(driver);

    }
}
