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
import properties.PropertyLoader;

import java.util.concurrent.TimeUnit;

/**
 * Created by Iliya on 6/12/2017.
 */

public class QuickImportTest {

    private QuickImportModule quickImportModule;
    private EventLogModule eventLogModule;
    private InventoryModule inventoryModule;
    private LoginToDms loginToDms;

    protected WebDriver driver;

    private String inscription1 = "IMPORT SIMPLE";
    private String inscription2 = "success";
    private String inscription3 = "Simple Import Complete";
    private String inscription4 = "INVENTORY";
    private String inscription5 = "PENDING";


    @BeforeSuite

    //Login to dms
    public void login(){
        driver = new FirefoxDriver();
        loginToDms = new LoginToDms(driver);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        loginToDms.loginToDmsHome();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    // Import csv file with status Leave it as it is
    @Test(priority = 1)

    public void csvQuickImport() {
        quickImportModule = new QuickImportModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.quickImportURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        quickImportModule.leaveItAsItIs();
        quickImportModule.pasteURLcsv();
        quickImportModule.clickImport();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    // Check import in Event Log module
    @Test(priority = 2)

    public void csvEventLog(){
        eventLogModule = new EventLogModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.eventLogURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        Assert.assertEquals(eventLogModule.inscriptionImportSimple(), inscription1);
        Assert.assertEquals(eventLogModule.inscriptionSuccess(), inscription2);
        Assert.assertEquals(eventLogModule.inscriptionSimpleImportComplete(), inscription3);
        }

    // Check imported vehicle in Inventory module status Inventory
    @Test(priority = 3)

    public void csvInventory(){
        inventoryModule = new InventoryModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.inventoryURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        inventoryModule.findVinNumberField();
        inventoryModule.pasteVinNumberCsv();
        inventoryModule.clickFind();

        Assert.assertEquals(inventoryModule.getInscription(), inscription4);
    }

    // Import csv file with status Inventory
    @Test(priority = 4)

    public void csvQuickImportInventory() {
     //   quickImportModule = new QuickImportModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.quickImportURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        quickImportModule.statusInventory();
        quickImportModule.pasteURLcsv();
        quickImportModule.clickImport();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    // Check import in Event Log module
    @Test(priority = 5)

    public void csvEventLogInventory(){
     //   eventLogModule = new EventLogModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.eventLogURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        Assert.assertEquals(eventLogModule.inscriptionImportSimple(), inscription1);
        Assert.assertEquals(eventLogModule.inscriptionSuccess(), inscription2);
        Assert.assertEquals(eventLogModule.inscriptionSimpleImportComplete(), inscription3);
    }

    // Check imported vehicle in Inventory module status Inventory
    @Test(priority = 6)

    public void csvInventoryStatusInventory(){
    //    inventoryModule = new InventoryModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.inventoryURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        inventoryModule.findVinNumberField();
        inventoryModule.pasteVinNumberCsv();
        inventoryModule.clickFind();

        Assert.assertEquals(inventoryModule.getInscription(), inscription4);
    }

    // Import csv file with status Pending
    @Test(priority = 7)

    public void csvQuickImportPending() {
    //    quickImportModule = new QuickImportModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.quickImportURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        quickImportModule.statusPending();
        quickImportModule.pasteURLcsv();
        quickImportModule.clickImport();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    // Check import in Event Log module
    @Test(priority = 8)

    public void csvEventLogPending(){
        //   eventLogModule = new EventLogModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.eventLogURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        Assert.assertEquals(eventLogModule.inscriptionImportSimple(), inscription1);
        Assert.assertEquals(eventLogModule.inscriptionSuccess(), inscription2);
        Assert.assertEquals(eventLogModule.inscriptionSimpleImportComplete(), inscription3);
    }

    // Check imported vehicle in Inventory module status Pending
    @Test(priority = 9)

    public void csvInventoryStatusPending(){
    //    inventoryModule = new InventoryModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.inventoryURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        inventoryModule.findVinNumberField();
        inventoryModule.pasteVinNumberCsv();
        inventoryModule.clickFind();

        Assert.assertEquals(inventoryModule.getInscription(), inscription5);
    }


    // Import xml file with status Leave it as it is
    @Test(priority = 10)

    public void xmlQuickImport() {
    //    quickImportModule = new QuickImportModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.quickImportURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        quickImportModule.leaveItAsItIs();
        quickImportModule.pasteURLxml();
        quickImportModule.clickImport();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    // Check import in Event Log module
    @Test(priority = 11)

    public void xmlEventLog(){
    //    eventLogModule = new EventLogModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.eventLogURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        Assert.assertEquals(eventLogModule.inscriptionImportSimple(), inscription1);
        Assert.assertEquals(eventLogModule.inscriptionSuccess(), inscription2);
        Assert.assertEquals(eventLogModule.inscriptionSimpleImportComplete(), inscription3);
    }

    // Check imported vehicle in Inventory module status Inventory
    @Test(priority = 12)

    public void xmlInventory(){
    //    inventoryModule = new InventoryModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.inventoryURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        inventoryModule.findVinNumberField();
        inventoryModule.pasteVinNumberXml();
        inventoryModule.clickFind();

        Assert.assertEquals(inventoryModule.getInscription(), inscription4);
    }

    // Import xml file with status Inventory
    @Test(priority = 13)

    public void xmlQuickImportInventory() {
    //    quickImportModule = new QuickImportModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.quickImportURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        quickImportModule.statusInventory();
        quickImportModule.pasteURLxml();
        quickImportModule.clickImport();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    // Check import in Event Log module
    @Test(priority = 14)

    public void xmlEventLogInventory(){
        //   eventLogModule = new EventLogModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.eventLogURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        Assert.assertEquals(eventLogModule.inscriptionImportSimple(), inscription1);
        Assert.assertEquals(eventLogModule.inscriptionSuccess(), inscription2);
        Assert.assertEquals(eventLogModule.inscriptionSimpleImportComplete(), inscription3);
    }

    // Check imported vehicle in Inventory module status Inventory
    @Test(priority = 15)

    public void xmlInventoryStatusInventory(){
        //    inventoryModule = new InventoryModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.inventoryURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        inventoryModule.findVinNumberField();
        inventoryModule.pasteVinNumberXml();
        inventoryModule.clickFind();

        Assert.assertEquals(inventoryModule.getInscription(), inscription4);
    }

    // Import xml file with status Pending
    @Test(priority = 16)

    public void xmlQuickImportPending() {
        //    quickImportModule = new QuickImportModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.quickImportURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        quickImportModule.statusPending();
        quickImportModule.pasteURLxml();
        quickImportModule.clickImport();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    // Check import in Event Log module
    @Test(priority = 17)

    public void xmlEventLogPending(){
        //   eventLogModule = new EventLogModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.eventLogURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        Assert.assertEquals(eventLogModule.inscriptionImportSimple(), inscription1);
        Assert.assertEquals(eventLogModule.inscriptionSuccess(), inscription2);
        Assert.assertEquals(eventLogModule.inscriptionSimpleImportComplete(), inscription3);
    }

    // Check imported vehicle in Inventory module status Pending
    @Test(priority = 18)

    public void xmlInventoryStatusPending(){
        //    inventoryModule = new InventoryModule(driver);
        driver.get(PropertyLoader.loadProperty("dms.inventoryURL"));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        inventoryModule.findVinNumberField();
        inventoryModule.pasteVinNumberXml();
        inventoryModule.clickFind();

        Assert.assertEquals(inventoryModule.getInscription(), inscription5);
    }

    @AfterSuite
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            driver.quit();
        }
    }

}
