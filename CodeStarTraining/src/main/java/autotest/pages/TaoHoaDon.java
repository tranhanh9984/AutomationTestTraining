package autotest.pages;

import autocom.common.CommonFuncs;
import autocom.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaoHoaDon extends CommonPage {
    private WebDriver driver;
    private CommonFuncs commonFuncs;
    public TaoHoaDon(WebDriver driver) {
        this.driver=driver;
        this.commonFuncs = new CommonFuncs(driver);
    }
    private final By cbbMST = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/section[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/button[1]");
    private final By row1 = By.xpath("//p[contains(text(),'I HOÀNG')]");
    private final By tb_nguoiMua = By.xpath("//input[@id='customerName']");
    private final By tb_soDT = By.xpath(" //input[@id='customerPhone']");
    private final By tb_STK = By.xpath("//input[@id='customerAccountNumber']");
    private final By tb_bank = By.xpath("//input[@id='customerBankName']");
//    private final By cbb_hinhThucTT = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/section[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]");
//    private final By option_tm = By.xpath("//div[contains(text(),'Tiền mặt')]");
//    private final By tb_email = By.xpath(" //input[@id='customerEmail']");
//    private final By cb_chinh = By.xpath("//span[contains(text(),'Tự động tính số liệu điều chỉnh')]");
//    private final By ccb_loaiTien = By.xpath("//span[contains(text(),'Loại tiền:')]");
//    private final By tb_tigia = By.xpath("//span[contains(text(),'Tỷ giá:')]");
//    private final By cbb_chietKhau = By.xpath("//span[contains(text(),'Chiết khấu:')]");
//    private final By cb_daTT = By.xpath("  //span[contains(text(),'Đã thanh toán')]");
    private final By hh1 = By.xpath("//input[@id='good_name']");
    private final By r1 = By.xpath("//div[contains(text(), 'Xăng RON 95-III')]");
    private final By btn_Lưu = By.xpath(" //span[@title = 'Lưu']/parent::button");

    public void clickMST(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cbbMST));
        WebElement hoadon = driver.findElement(cbbMST);
        if (hoadon.isDisplayed()) {
            hoadon.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(row1));
            WebElement taohoadon = driver.findElement(row1);
            if(taohoadon.isDisplayed()) {
                taohoadon.click();
            }
        }
    }

    public void enterNguoiMuaHang(String nguoiMua){
        WebElement nguoiMuaHang = driver.findElement(tb_nguoiMua);
        if(nguoiMuaHang.isDisplayed())
            nguoiMuaHang.sendKeys(nguoiMua);
    }

    public void enterSDT(String sdt){
        WebElement soDT = driver.findElement(tb_soDT);
        if(soDT.isDisplayed())
            soDT.sendKeys(sdt);
    }

    public void enterSTK(String sotk){
        WebElement stk = driver.findElement(tb_STK);
        if(stk.isDisplayed())
            stk.sendKeys(sotk);
    }
    public void enterNganHang(String nganHang){
        WebElement nganhang = driver.findElement(tb_bank);
        if(nganhang.isDisplayed())
            nganhang.sendKeys(nganHang);
    }

    public void clicktenHangHoa(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(hh1));
        WebElement hoadon = driver.findElement(hh1);
        if (hoadon.isDisplayed()) {
            hoadon.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(r1));
            WebElement taohoadon = driver.findElement(r1);
            if(taohoadon.isDisplayed()) {
                taohoadon.click();
            }
        }
    }

    public void clickLuu(){
        WebElement Luu = driver.findElement(btn_Lưu);
        if(Luu.isDisplayed())
            Luu.click();
    }

    public DanhSachHoaDon luu(String nguoiMuaHang, String sodienthoai, String stk, String tennganhang) throws Exception{
        clickMST();
        enterNguoiMuaHang(nguoiMuaHang);
        enterSDT(sodienthoai);
        enterSTK(stk);
        enterNganHang(tennganhang);
        clicktenHangHoa();
        clickLuu();

        return new DanhSachHoaDon(driver);
    }





}
