package autotest.pagesHD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import autocom.common.CommonPage;


public class LoginPage extends CommonPage {
    WebDriver driver;
    WebDriverWait wait;

     public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);  
        PageFactory.initElements(driver, this);
    }

     @FindBy(id = "email")
    WebElement txtUserName;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[contains(@class, 'p-toast-detail')]")
    WebElement msgError;  

     public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(txtUserName)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }

     public String getErrorMsg() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(msgError)).getText();
        } catch (Exception e) {
            return "";  
        }
    }
}
