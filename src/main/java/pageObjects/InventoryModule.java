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
public class InventoryModule {

    public InventoryModule(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    //Find field Vin Number
    @FindBy(how = How.XPATH, using = ".//*[@id='selFilter']/option[10]")
    private WebElement findVinNumberField;

    //Find field to paste Vin Number
    @FindBy(how = How.XPATH, using = ".//*[@id='selValue']")
    private WebElement pasteVinNumber;

    //Find button Find
    @FindBy(how = How.LINK_TEXT, using = "Find")
    private WebElement clickFind;

    //Find inscription with status
    @FindBy(how = How.XPATH, using = ".//*[@id='inventory-list']/tbody/tr[2]/td[11]")
    private WebElement getInscription;

    //Click on the search field to find Vin Number
    public void findVinNumberField(){
        findVinNumberField.click();
    }

    //Paste vin number from csv file
    public void pasteVinNumberCsv(){
        pasteVinNumber.sendKeys(PropertyLoader.loadProperty("vin.number.csv"));
    }

    //Paste vin number from xml file
    public void pasteVinNumberXml(){
        pasteVinNumber.sendKeys(PropertyLoader.loadProperty("vin.number.xml"));
    }

    //Click on the button Find
    public void clickFind(){
        clickFind.click();
    }

    //Read vehicle status
    public String getInscription(){
        return getInscription.getText();
    }
}

