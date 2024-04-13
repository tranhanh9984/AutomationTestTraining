package autocom.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SignInPage extends CommonPage {
    private WebDriver driver;
    private CommonFuncs commonFuncs;

    private final By email_input = By.id("companyUsername");
    private final By password_input = By.id("password");
    private final By taxcode_input = By.xpath("//input[@id='taxCode']");
    private final By SignIn_btn = By.xpath("//button[contains(text(),'Đăng nhập')]");
    private By forgotPass = By.xpath("//span[contains(text(),'Quên mật khẩu')]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getSignInPageTitle(){
        String pageTile = driver.getTitle();
        return pageTile;
    }

    public boolean verifySignInPageTitle(){
        String expectedTitle = "Đăng nhập";
        return getSignInPageTitle().equals(expectedTitle);
    }

    public Boolean verifySignInPageText(){
        WebElement element = driver.findElement(forgotPass);
        String pageText = element.getText();
        String expectedPageText = "Quên mật khẩu";
        return pageText.contains(expectedPageText);

    }

    public HomePage sigin(String email,String password,String taxcode) throws Exception{
        enterEmail(email);
        enterPassword(password);
        enterTaxcode(taxcode);
        clickSignIn();

        return new HomePage(driver);
    }

    public void enterEmail(String email){
        WebElement email_tb = driver.findElement(email_input);
        Assert.assertTrue(email_tb.isDisplayed(),"Textbox email khong hien thi");
        email_tb.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement pass_tb = driver.findElement(password_input);
        if(pass_tb.isDisplayed())
            pass_tb.sendKeys(password);
    }


    public void enterTaxcode(String taxcode){
        WebElement taxcode_tb = driver.findElement(taxcode_input);
        if(taxcode_tb.isDisplayed())
            taxcode_tb.sendKeys(taxcode);
    }

    public void clickSignIn(){
        WebElement sigin = driver.findElement(SignIn_btn);
        if(sigin.isDisplayed())
            sigin.click();
    }





}
