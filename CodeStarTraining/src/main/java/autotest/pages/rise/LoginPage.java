package autotest.pages.rise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class LoginPage extends CommonPage {

    @FindBy(id = "email") @CacheLookup WebElement emailInput;
    @FindBy(id = "password") @CacheLookup WebElement passwordInput;
    @FindBy(xpath = "//button") @CacheLookup WebElement signInButton;
    
    JavascriptExecutor js;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
        js = (JavascriptExecutor) driver;
    }

    public void Login(String name, String password) {
    	
        js.executeScript("arguments[0].value = arguments[1];", emailInput, name);
        js.executeScript("arguments[0].value = arguments[1];", passwordInput, password);
        js.executeScript("arguments[0].click();", signInButton);
        
    }

    public void clearAll() {
        js.executeScript("arguments[0].value = '';", emailInput);
        js.executeScript("arguments[0].value = '';", passwordInput);
    }

    public void addCookies() {
        Cookie cookie = new Cookie.Builder("ci_session", "430e682f4f36bbcb9214e6d5cbf6beff")
                .isHttpOnly(true)
                .isSecure(false)
                .build();
        driver.manage().addCookie(cookie);
    }


}
