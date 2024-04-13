package autocom.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends CommonPage {

    private WebDriver driver;
    private CommonFuncs commonFuncs;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    private By btn_hoadon = By.xpath("//a[@class='menu-link menu-toggle']//span[@class='menu-text'][contains(text(),'Hóa đơn')]");
    private final By btn_taoHoaDon = By.xpath("//span[contains(text(),'Tạo hoá đơn')]");
    private final By btn_dsHD = By.xpath("//span[contains(text(),'Danh sách hoá đơn')]");
    private final By btn_HDmayin = By.xpath("//span[contains(text(),'HĐ từ máy tính tiền')]");
    private By btn_logbom = By.xpath("//span[contains(text(),'Danh sách log bơm')]");
    private By btn_xuLyHD = By.xpath("//a[@class='menu-link menu-toggle']//span[@class='menu-text'][contains(text(),'Xử lý hóa đơn')]");
    private By btn_LStruyennhan = By.xpath("//span[contains(text(),'Lịch sử truyền nhận')]");
    private By btn_baoCao = By.xpath("//a[normalize-space()='']");
    private By btn_danhMuc = By.xpath("//span[contains(text(),'Danh mục')]");
    private By btn_heThong = By.xpath("//span[contains(text(),'Hệ thống')]");
    private By btn_taiPhanMem = By.xpath("//span[contains(text(),'Tải phần mềm ký')]");




    public void clickHoaDon() {
        WebElement hoadon = driver.findElement(btn_hoadon);
        if (hoadon.isDisplayed())
            hoadon.click();
    }

    public void clickTaoHoaDon(){
        // Chờ cho phần tử "Hóa đơn" xuất hiện trong khoảng thời gian nhất định
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_hoadon));

        // Sau khi phần tử "Hóa đơn" xuất hiện, thực hiện click vào nó
        WebElement hoadon = driver.findElement(btn_hoadon);
        if (hoadon.isDisplayed()) {
            hoadon.click();

            // Chờ cho phần tử "Tạo hóa đơn" xuất hiện trong khoảng thời gian nhất định
            wait.until(ExpectedConditions.visibilityOfElementLocated(btn_taoHoaDon));

            // Sau khi phần tử "Tạo hóa đơn" xuất hiện, thực hiện click vào nó
            WebElement taohoadon = driver.findElement(btn_taoHoaDon);
            if(taohoadon.isDisplayed()) {
                taohoadon.click();
            }
        }
    }

    public TaoHoaDon taoHD() throws Exception{
        clickTaoHoaDon();
        return new TaoHoaDon(driver);
    }
    public void clickDShoadon(){
        WebElement dsHoaDon = driver.findElement(btn_dsHD);
        if(dsHoaDon.isDisplayed())
            dsHoaDon.click();
    }

    public void clickHDtuMayIn(){
        WebElement HDtumayIn= driver.findElement(btn_HDmayin);
        if(HDtumayIn.isDisplayed())
            HDtumayIn.click();
    }
    public void clickXuLyHoaDon(){
        WebElement xulyHD = driver.findElement(btn_xuLyHD);
        if(xulyHD.isDisplayed())
            xulyHD.click();
    }

    public void clickLichSuTruyenN(){
        WebElement LStruyenNhan = driver.findElement(btn_LStruyennhan);
        if(LStruyenNhan.isDisplayed())
            LStruyenNhan.click();
    }


    public String getSignInPageTitle(){
        String pageTile = driver.getTitle();
        return pageTile;
    }

    public boolean verifySignInPageTitle(){
        String expectedTitle = "Đăng nhập";
        return getSignInPageTitle().equals(expectedTitle);
    }





}
