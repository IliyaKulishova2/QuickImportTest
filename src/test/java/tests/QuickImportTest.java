package tests;

import dmsLogin.LoginToDms;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.EventLogModule;
import pageObjects.InventoryModule;
import pageObjects.QuickImportModule;

import java.util.concurrent.TimeUnit;

/**
 * Created by Webxloo Company on 6/1/2017.
 */
public class QuickImportTest {
    public String baseURL = "http://www.map2.iliya.ixloo.com";
    static WebDriver driver;
    private LoginToDms loginToDms;
    private QuickImportModule quickImportModule;
    private EventLogModule eventLogModule;
    private InventoryModule inventoryModule;

    private String inscription1 = "IMPORT SIMPLE";
    private String inscription2 = "success";
    private String inscription3 = "Simple Import Complete";
    private String inscription4 = "INVENTORY";


    @BeforeSuite

    public void login(){
        driver = new FirefoxDriver();
        loginToDms = new LoginToDms(driver);
    //    driver.manage().window().maximize();
        driver.get(baseURL + "/dms/login");
        loginToDms.loginToDmsHome();
     //   driver.findElement(By.id("login")).sendKeys("autotest2");
     //   driver.findElement(By.id("password")).sendKeys("123");
     //   driver.findElement(By.id("login2")).click();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }


    @Test(priority = 1)

    public void csvQuickImport() {
        quickImportModule = new QuickImportModule(driver);
        driver.get("http://www.map2.iliya.ixloo.com/dms/inventory/quickimport");
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        quickImportModule.leaveItAsItIs();
        quickImportModule.pasteURL();
        quickImportModule.clickImport();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    @Test(priority = 2)

    public void csvEventLog(){
        eventLogModule = new EventLogModule(driver);
        driver.get("http://www.map2.iliya.ixloo.com/dms/admin/log");
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        Assert.assertEquals(eventLogModule.inscriptionImportSimple(), inscription1);
        Assert.assertEquals(eventLogModule.inscriptionSuccess(), inscription2);
        Assert.assertEquals(eventLogModule.inscriptionSimpleImportComplete(), inscription3);
        }

    @Test(priority = 3)

    public void csvInventory(){
        inventoryModule = new InventoryModule(driver);
        driver.get("http://www.map2.iliya.ixloo.com/dms/inventory");
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        inventoryModule.findVinNumberField();
        inventoryModule.pasteVinNumber();
        inventoryModule.clickFind();

        Assert.assertEquals(inventoryModule.getInscription(), inscription4);

    }


    @AfterSuite
    public void closeBrowser(){
        if (driver != null)
            driver.quit();
    }
}
