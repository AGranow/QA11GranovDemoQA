package alerstests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;
import pages.SidePanelPage;
import tests.bookstoretest.TestBase;

public class AlertsTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).goToAlertPage();
        new SidePanelPage(driver).selectAlerts();
    }

    @Test
    public void SeeAlert(){
        new AlertsPage(driver).clickAlertButton1();
    }

    @Test
    public void AlertWaitTest() {
        new AlertsPage(driver).clickAlertButton2AndWait();
    }

    @Test
    public void cancelAlertTest() {
        new AlertsPage(driver).clickAlertBtn3().clickOnCancelButton("Cancel");
        Assert.assertTrue(new AlertsPage(driver).getConfirmResult().contains("Cancel"));
    }

    @Test
    public void okAlertTest() {
        new AlertsPage(driver).clickAlertBtn3().clickOnCancelButton("Ok");
        Assert.assertTrue(new AlertsPage(driver).getConfirmResult().contains("Ok"));
    }

    @Test
    public void alertSendTextTest() {
        new AlertsPage(driver).clickAlertButton4().sendTextToAlert("Hello");
        Assert.assertTrue(new AlertsPage(driver).getConfirmLastResult().contains("Hello"));
    }
}
