package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import properties.PropertyLoader;

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

    //Click on dropdown with vehicle status Inventory
    @FindBy(how = How.XPATH, using = ".//*[@id='form-simple-import']/table[1]/tbody/tr/td[2]/select/option[2]")
    private WebElement statusInventory;

    //Click on dropdown with vehicle status Pending
    @FindBy(how = How.XPATH, using = ".//*[@id='form-simple-import']/table[1]/tbody/tr/td[2]/select/option[3]")
    private WebElement statusPending;

    //Paste link with csv file
    @FindBy(how = How.ID, using = "file_url")
    private WebElement pasteURLcsv;

    //Paste link with xml file
    @FindBy(how = How.ID, using = "file_url")
    private WebElement pasteURLxml;

    //Paste link with zip file
    @FindBy(how = How.ID, using = "file_url")
    private WebElement pasteURLzip;

    //Click on the button Import Now
    @FindBy(how = How.LINK_TEXT, using = "Import Now")
    private WebElement clickImport;

    //Set vehicle status for import to Leave it as it is
    public void leaveItAsItIs() {
        leaveItAsItIs.click();
    }

    //Set vehicle status for import to Inventory
    public void statusInventory() {
        statusInventory.click();
    }

    //Set vehicle status for import to Pending
    public void statusPending() {
        statusPending.click();
    }

    //Paste URL csv
    public void pasteURLcsv() {
        pasteURLcsv.clear();
        pasteURLcsv.sendKeys(PropertyLoader.loadProperty("file.csv"));
    }

    //Paste URL xml
    public void pasteURLxml() {
        pasteURLxml.clear();
        pasteURLxml.sendKeys(PropertyLoader.loadProperty("file.xml"));
    }

    //Paste URL zip
    public void pasteURLzip() {
        pasteURLzip.clear();
        pasteURLzip.sendKeys(PropertyLoader.loadProperty("file.zip"));
    }

    //Click on the button Import Now
    public void clickImport() {
        clickImport.click();
    }
}
