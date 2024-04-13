package autocom.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DanhSachHoaDon extends CommonPage {
    private WebDriver driver;
    private CommonFuncs commonFuncs;
    public DanhSachHoaDon(WebDriver driver) {
        this.driver=driver;
    }


     private By Loc = By.xpath("//button[@title='Lọc']");
     private By ky = By.xpath("//div[@class='ant-select custom-ant-select css-1vorn7o ant-select-single ant-select-show-arrow ant-select-show-search']");
     private By loc_hn = By.xpath("//div[contains(text(),'Hôm nay')]");

     private By btn_apDung = By.xpath("//span[contains(text(),'Áp dụng')]");



    public void Loctheongay(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Loc));
        WebElement loc_ngay = driver.findElement(Loc);
        if (loc_ngay.isDisplayed()) {
            loc_ngay.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(ky));
            WebElement loc_ky = driver.findElement(ky);
            if(loc_ky.isDisplayed()) {
                loc_ky.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(loc_hn));
                WebElement chon_homnay = driver.findElement(loc_hn);
                if(chon_homnay.isDisplayed()) {
                    chon_homnay.click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(btn_apDung));
                    WebElement apDung = driver.findElement(btn_apDung);
                    if(apDung.isDisplayed()) {
                        apDung.click();
                    }
                }
            }


        }
    }






}
