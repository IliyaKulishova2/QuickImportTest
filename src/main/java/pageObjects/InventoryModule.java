package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Webxloo Company on 6/1/2017.
 */
public class InventoryModule {

    public InventoryModule(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(how = How.XPATH, using = ".//*[@id='selFilter']/option[10]")
    private WebElement findVinNumberField;

    @FindBy(how = How.XPATH, using = ".//*[@id='selValue']")
    private WebElement pasteVinNumber;

    @FindBy(how = How.LINK_TEXT, using = "Find")
    private WebElement clickFind;

    @FindBy(how = How.XPATH, using = ".//*[@id='inventory-list']/tbody/tr[2]/td[11]")
    private WebElement getInscription;


    public void findVinNumberField(){

        findVinNumberField.click();
    }

    public void pasteVinNumber(){

        pasteVinNumber.sendKeys("AE22E8BE0DD780920");
    }

    public void clickFind(){

        clickFind.click();
    }

    public String getInscription(){

        return getInscription.getText();
    }
}

