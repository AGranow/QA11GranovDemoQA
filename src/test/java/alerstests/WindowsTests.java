package alerstests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrowserWidowsPage;
import pages.HomePage;
import pages.SidePanelPage;
import tests.bookstoretest.TestBase;

public class WindowsTests  extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).goToAlertPage();
        new SidePanelPage(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest(){
        new BrowserWidowsPage(driver).clickOnNewTabBtn();
        Assert.assertTrue(new BrowserWidowsPage(driver).getTextFromNewTab().contains("sample"));
    }

    @Test
    public void newWindowTest(){
        new BrowserWidowsPage(driver).clickOnNewWindowBtn();
        Assert.assertTrue(new BrowserWidowsPage(driver).getTextFromNewTab().contains("sample"));
    }

    @Test
    public void newWindowMessageTest(){
        new BrowserWidowsPage(driver).clickOnNewWindowMessageBtn();
        Assert.assertTrue(new BrowserWidowsPage(driver).getTextFromNewTab().contains("sample"));
    }
}
