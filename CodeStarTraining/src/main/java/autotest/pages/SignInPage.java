package autotest.pages;

import autocom.common.CommonFuncs;
import autocom.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import autocom.constant.KeywordConstant;

public class SignInPage extends CommonPage {
    private WebDriver driver;
    private CommonFuncs commonFuncs;
    private KeywordConstant keywordConstant;

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

    public HomePage sigin() throws Exception{
        enterEmail();
        enterPassword();
        enterTaxcode();
        clickSignIn();

        return new HomePage(driver);
    }

    public void enterEmail(){
        WebElement email_tb = driver.findElement(email_input);
        Assert.assertTrue(email_tb.isDisplayed(),"Textbox email khong hien thi");
        email_tb.sendKeys(keywordConstant.EMAIL);
    }

    public void enterPassword(){
        WebElement pass_tb = driver.findElement(password_input);
        if(pass_tb.isDisplayed()) {
            pass_tb.sendKeys(keywordConstant.PASSWORD);
        }
    }


    public void enterTaxcode(){
        WebElement taxcode_tb = driver.findElement(taxcode_input);
        if(taxcode_tb.isDisplayed())
            taxcode_tb.sendKeys(keywordConstant.MST);
    }

    public void clickSignIn(){
        WebElement sigin = driver.findElement(SignIn_btn);
        if(sigin.isDisplayed())
            sigin.click();
    }

}
