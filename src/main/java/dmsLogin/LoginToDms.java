package dmsLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import properties.PropertyLoader;


/**
 * Created by Webxloo Company on 6/1/2017.
 */
public class LoginToDms  {

    public LoginToDms(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    //Declare elements on the page

    @FindBy(how = How.ID, using = "login")
    private WebElement loginField;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "login2")
    private WebElement signInButton;

    public void loginToDmsHome() {
        loginField.clear();
        loginField.sendKeys(PropertyLoader.loadProperty("manager.login"));
        passwordField.clear();
        passwordField.sendKeys(PropertyLoader.loadProperty("manager.pw"));
        signInButton.click();

    }

}