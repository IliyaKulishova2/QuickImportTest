package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iliya on 6/1/2017.
 */
public class QuickImportModule {
    public QuickImportModule(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    //Click on dropdown with vehicle status Leave It As It Is
    @FindBy(how = How.XPATH, using = ".//*[@id='form-simple-import']/table[1]/tbody/tr/td[2]/select/option[1]")
    private WebElement leaveItAsItIs;

    //Paste link with csv file
    @FindBy(how = How.ID, using = "file_url")
    private WebElement pasteURL;

    //Click on the button Import Now
    @FindBy(how = How.LINK_TEXT, using = "Import Now")
    private WebElement clickImport;


    public void leaveItAsItIs() {
        leaveItAsItIs.click();
    }

    public void pasteURL() {
        pasteURL.clear();
        pasteURL.sendKeys("http://admin.autoxloo.com/datafeed_input/autoxloo/Renault_v10.csv");
    }

    public void clickImport() {
        clickImport.click();
    }


}
