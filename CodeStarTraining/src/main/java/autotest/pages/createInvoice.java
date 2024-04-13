package autotest.pages;

import autocom.common.CommonFuncs;
import autocom.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import autotest.pages.Login_2;
import org.testng.annotations.Test;

public class createInvoice extends CommonPage {
    private WebDriver driver;
    private Login_2 loginpage;
    private CommonFuncs commonFuncs;

    @BeforeTest
    public void startPage() {
        if (driver == null) {
            driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");
        }
    }
    @BeforeClass
    public void loginTest() throws InterruptedException {
        loginpage = new Login_2();
        loginpage.testLogin();
    }
    @AfterTest
    public void closePage() {
        this.closeBrowser(driver);
    }
    private final By linkHoaDon = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]/span[2]");
    private final By linkTaoHoaDon = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/ul[1]/li[1]/a[1]");
    private final By cbbMST = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/section[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/button[1]");
    private final By row1 = By.xpath("//div[@id='row-0']");
    // private By btn_layThongTin = By.xpath(" //body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/section[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[4]/button[1]");
    // private By tb_tenDonVi = By.xpath("//input[@id='customerCompanyName']");
    // private By tb_diaChi = By.xpath("//input[@id='customerFullAddress']");
    private final By tb_nguoiMua = By.xpath("//input[@id='customerName']");
    private final By tb_soDT = By.xpath(" //input[@id='customerPhone']");
    private final By tb_STK = By.xpath("//input[@id='customerAccountNumber']");
    private final By tb_bank = By.xpath("//input[@id='customerBankName']");
    private final By cbb_hinhThucTT = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/section[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]");
    private final By option_tm = By.xpath("//div[contains(text(),'Tiền mặt')]");
    private final By tb_email = By.xpath(" //input[@id='customerEmail']");
    // private final By cb_tinhChat = By.xpath("  //body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/section[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/label[1]/span[1]/input[1]");
    private final By cb_chinh = By.xpath("//span[contains(text(),'Tự động tính số liệu điều chỉnh')]");
    private final By ccb_loaiTien = By.xpath("//span[contains(text(),'Loại tiền:')]");
    private final By tb_tigia = By.xpath("//span[contains(text(),'Tỷ giá:')]");
    private final By cbb_chietKhau = By.xpath("//span[contains(text(),'Chiết khấu:')]");
    private final By cb_daTT = By.xpath("  //span[contains(text(),'Đã thanh toán')]");
    private final By hh1 = By.xpath("//input[@id='good_name']");
    private final By r1 = By.xpath("//div[contains(text(), 'Xăng RON 95-III')]");
    // private final By table = By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]");
    private final By btn_Lưu = By.xpath(" //span[@title = 'Lưu']/parent::button");
    //private final By hh1 = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/section[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/label[1]/span[1]");



    @Test(dependsOnMethods = "testLogin")
    public void testCreatInvoice() throws InterruptedException{
        // Click vào liên kết "Hóa đơn đầu ra"
        commonFuncs.clickElement(linkHoaDon);
        // Click vào liên kết "Tạo hóa đơn mới"
        commonFuncs.clickElement(linkTaoHoaDon);


        // Tìm và chọn phần tử <select> bằng id
//        WebElement selectElement = driver.findElement(cbbMST);
//        Select select = new Select(selectElement);

        // Chọn tùy chọn bằng văn bản
        commonFuncs.clickElement(cbbMST);
        commonFuncs.clickDropdown("//div[@id='row-2']");
        // commonFuncs.clickElement(btn_layThongTin);
        //commonFuncs.setText(tb_tenDonVi,"Đơn vị A");
        //commonFuncs.setText(tb_diaChi,"Hà Huy Tập");
        commonFuncs.setText(tb_nguoiMua,"Nguyễn Thị Cẩm Ly");
        commonFuncs.setText(tb_soDT,"0869042748");
        commonFuncs.setText(tb_STK,"23456789");
        //  commonFuncs.scrollDown();
        commonFuncs.setText(tb_bank,"VietComBank");
        commonFuncs.clickElement(cbb_hinhThucTT);
        commonFuncs.clickDropdown("//div[contains(text(),'Chuyển khoản')]");
        //  commonFuncs.selectOptionByText(cbb_hinhThucTT,"Chuyển khoản");
        commonFuncs.setText(tb_email,"nguyencamly@gmail.com");
        //   commonFuncs.clickElement(cb_tinhChat);
        //   commonFuncs.selectCheckBox(cb_chinh);
        // commonFuncs.selectOptionByText(ccb_loaiTien,"VNĐ");
        // commonFuncs.setText(tb_tigia,"6");
        // commonFuncs.selectOptionByText(cbb_chietKhau,"Không chiết khấu");
        // commonFuncs.selectCheckBox(cb_daTT);
        commonFuncs.clickElement(hh1);
        commonFuncs.clickElement(r1);


        commonFuncs.clickElement(btn_Lưu);
        pause(40000);




    }

}
