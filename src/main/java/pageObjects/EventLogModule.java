package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Webxloo Company on 6/1/2017.
 */
public class EventLogModule {

    public EventLogModule(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = ".//*[@id='event-log']/tbody/tr[2]/td[3]")
    private WebElement inscriptionImportSimple;

    @FindBy(how = How.XPATH, using = ".//*[@id='event-log']/tbody/tr[2]/td[5]")
    private WebElement inscriptionSuccess;

    @FindBy(how = How.XPATH, using = ".//*[@id='event-log']/tbody/tr[2]/td[6]")
    private WebElement inscriptionSimpleImportComplete;


    public String inscriptionImportSimple(){

        return inscriptionImportSimple.getText();
    }

    public String inscriptionSuccess(){

        return inscriptionSuccess.getText();
    }

    public String inscriptionSimpleImportComplete(){

        return inscriptionSimpleImportComplete.getText();
    }
}


