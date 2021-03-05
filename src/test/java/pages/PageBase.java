package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;


    public PageBase(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void type(WebElement element, String text){
        if (text != null){

            element.click();
            element.clear();
            element.sendKeys();
        }


    }
}


