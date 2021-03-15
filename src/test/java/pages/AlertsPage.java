package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends PageBase {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    WebElement alertBtn1;

    public AlertsPage clickAlertButton1() {
        alertBtn1.click();
        return this;
    }

    @FindBy(id = "timerAlertButton")
    WebElement alertBtn2;

    public AlertsPage clickAlertButton2AndWait() {
        alertBtn2.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();
        return this;
    }


    public AlertsPage clickAlertButton2AndWait1() {
        alertBtn2.click();
        pause(5000);
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement alertBtn3;

    public AlertsPage clickAlertBtn3() {
        alertBtn3.click();
        return this;
    }

    public AlertsPage clickOnCancelButton(String text) {
        if (text != null && text.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        } else if (text != null && text.equals("Ok")) {
            driver.switchTo().alert().accept();
        }
        return this;
    }

    public String getConfirmResult() {
        return driver.findElement(By.id("confirmResult")).getText();
    }

    @FindBy(xpath = "(//*[@class='col']//button)[last()]")
    WebElement alertBtn4;

    public AlertsPage clickAlertButton4() {
        alertBtn4.click();
        return this;
    }

    public AlertsPage sendTextToAlert(String text) {
        if (text != null)
            driver.switchTo().alert().sendKeys(text);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        return this;
    }

    public String getConfirmLastResult() {
        return driver.findElement(By.xpath("//span[@id ='promptResult']")).getText();
    }
}