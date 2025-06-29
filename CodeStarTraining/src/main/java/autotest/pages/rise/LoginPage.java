package autotest.pages.rise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class LoginPage extends CommonPage {

    @FindBy(id = "email") @CacheLookup WebElement emailInput;
    @FindBy(id = "password") @CacheLookup WebElement passwordInput;
    @FindBy(xpath = "//button") @CacheLookup WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
    
    public void Login(String name, String password) {
        emailInput.sendKeys(name);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public void clearAll() {
        emailInput.clear();
        passwordInput.clear();
    }

    public void addCookies() {
        Cookie cookie = new Cookie.Builder("myCookie", "0alfe6b98f99dd87da7a44927013ac19")
                .isHttpOnly(true)
                .isSecure(false)
                .build();
        driver.manage().addCookie(cookie);
    }
}
