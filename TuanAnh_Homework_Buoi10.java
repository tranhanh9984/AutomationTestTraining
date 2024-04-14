package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class TuanAnh_Homework_Buoi10 extends CommonPage {
	WebDriver driver;

	@BeforeTest
	public void startPage() {
		driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");
	}

//	@AfterTest
//	public void closePage() throws InterruptedException {
//		Thread.sleep(2);
//		this.closeBrowser(driver);
//	}

	@Test
	public void testXpath() throws InterruptedException {
		// login
		By userName = By.name("companyUsername");
		By passWord = By.name("password");
		By maSoThue = By.name("taxCode");
		By buttonLogin = By.xpath("//button[@class='btn btn-primary font-weight-bold flex-grow-1 col']");
		// taohoadon
		By hoaDon = By.xpath("//ul[@class='menu-nav pt-0']/li[3]");
		By taoHoaDon = By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[3]/div/ul/li[1]/a/span");

		// txtUsername
		Thread.sleep(10);
		WebElement txtUserName = driver.findElement(userName);
		txtUserName.click();
		pause(3000);
		txtUserName.sendKeys("caonv174@gmail.com");
		pause(3000);
		String textUser = txtUserName.getAttribute("value");
		Assert.assertEquals("caonv174@gmail.com", textUser);
		System.out.println("txtUserName is oke");

		// txtpassword
		Thread.sleep(10);
		WebElement txtPassWord = driver.findElement(passWord);
		txtUserName.click();
		pause(3000);
		txtPassWord.sendKeys("123456");
		System.out.println("txtPassWord is oke");

		// txtTax
		Thread.sleep(10);
		WebElement txtMaSoThue = driver.findElement(maSoThue);
		txtMaSoThue.click();
		pause(3000);
		txtMaSoThue.sendKeys("0312303803-999");
		pause(3000);
		String textMaST = txtMaSoThue.getAttribute("value");
		Assert.assertEquals("0312303803-999", textMaST);
		System.out.println("txtMaSoThue is oke");

		// btnLogin
		Thread.sleep(10);
		WebElement btnLogin = driver.findElement(buttonLogin);
		btnLogin.click();
		pause(3000);
		System.out.println("BtnLogin is oke");

		Thread.sleep(10);
		WebElement menuHoaDon = driver.findElement(hoaDon);
		menuHoaDon.click();
		pause(3000);
		System.out.println("menuHoaDon is oke");

		Thread.sleep(10);
		WebElement menuTaoHoaDon = driver.findElement(taoHoaDon);
		menuTaoHoaDon.click();
		pause(3000);
		System.out.println("menuTaoHoaDon is oke");

		By mstNguoiMua = By.xpath("//*[@name='customerTaxCode']");
		By buttonClose = By.xpath("//*[@id='einvoice-container']/div/div[2]/div/div[3]/div/div[1]/div[4]/div/div/div[2]/div/div/div/div[2]/button[2]/span");
		By tenDonVi = By.xpath("//*[@name='customerCompanyName']");
		By diaChi = By.xpath("//*[@name='customerFullAddress']");
		By nguoiMuaHang = By.xpath("//*[@name='customerName']");
		By soDienThoai = By.xpath("//*[@name='customerPhone']");
		By soTkNganHang = By.xpath("//*[@name='customerAccountNumber']");
//		By hinhThucTT = By.xpath("//*[@id=\"einvoice-container\"]/div/div[2]/div/div[3]/div/div[1]/div[9]/div[1]/div/div");
		By emailKH = By.xpath("//*[@name='customerEmail']");
		By tenHangHoa = By.name("good_name");
		By maHangHoa = By.xpath("//div[@class='sc-feUZmu ioMWOe rdt_TableBody']/div[2]");
		By buttonLuuHoaDon = By.xpath("//footer[@id='footer']/div[2]/button[2]");

		Thread.sleep(10);
		WebElement txtMstNguoiMua = driver.findElement(mstNguoiMua);
		txtMstNguoiMua.click();
		pause(3000);
		txtMstNguoiMua.sendKeys("8484834343");
		pause(3000);
		String textMSTnguoimua = txtMstNguoiMua.getAttribute("value");
		Assert.assertEquals("8484834343", textMSTnguoimua);
		System.out.println("txtMstNguoiMua is oke");

		// btnLogin
		Thread.sleep(10);
		WebElement btnEsc = driver.findElement(buttonClose);
		btnEsc.click();
		pause(3000);
		System.out.println("btnEsc is oke");

		Thread.sleep(10);
		WebElement txtTenDonVi = driver.findElement(tenDonVi);
		txtTenDonVi.click();
		pause(3000);
		txtTenDonVi.sendKeys("abcd");
		pause(3000);
		String textTenDonVi = txtTenDonVi.getAttribute("value");
		Assert.assertEquals("abcd", textTenDonVi);
		System.out.println("txtTenDonVi is oke");

		Thread.sleep(10);
		WebElement txtDiaChi = driver.findElement(diaChi);
		txtDiaChi.click();
		pause(3000);
		txtDiaChi.sendKeys("NT-LB-HN");
		pause(3000);
		String textDiaChi = txtDiaChi.getAttribute("value");
		Assert.assertEquals("NT-LB-HN", textDiaChi);
		System.out.println("txtDiaChi is oke");

		Thread.sleep(10);
		WebElement txtNguoiMuaHang = driver.findElement(nguoiMuaHang);
		txtNguoiMuaHang.click();
		pause(3000);
		txtNguoiMuaHang.sendKeys("Tuan Anh");
		pause(3000);
		String textNguoiMuaHang = txtNguoiMuaHang.getAttribute("value");
		Assert.assertEquals("Tuan Anh", textNguoiMuaHang);
		System.out.println("txtNguoiMuaHang is oke");

		Thread.sleep(10);
		WebElement txtSoDienThoai = driver.findElement(soDienThoai);
		txtSoDienThoai.click();
		pause(3000);
		txtSoDienThoai.sendKeys("0334118297");
		pause(3000);
		String textSoDienThoai = txtSoDienThoai.getAttribute("value");
		Assert.assertEquals("0334118297", textSoDienThoai);
		System.out.println("txtSoDienThoai is oke");

		Thread.sleep(10);
		WebElement txtSoTkNganHang = driver.findElement(soTkNganHang);
		txtSoTkNganHang.click();
		pause(3000);
		txtSoTkNganHang.sendKeys("090208886");
		pause(3000);
		String textSoTkNganHang = txtSoTkNganHang.getAttribute("value");
		Assert.assertEquals("090208886", textSoTkNganHang);
		System.out.println("txtSoTkNganHang is oke");
		

//		Thread.sleep(10);
//		WebElement slbHinhThucTT = driver.findElement(hinhThucTT);
//		slbHinhThucTT.click();
//		pause(2);
//		String selectboxHinhThucTT = slbHinhThucTT.getAttribute("value");
//		Assert.assertEquals("Chuyển khoản", selectboxHinhThucTT);
//		System.out.println("slbHinhThucTT is oke");

		Thread.sleep(10);
		WebElement txtEmailKH = driver.findElement(emailKH);
		txtEmailKH.click();
		pause(3000);
		txtEmailKH.sendKeys("tuananh.vss651@gmail.com");
		pause(3000);
		String textEmailKH = txtEmailKH.getAttribute("value");
		Assert.assertEquals("tuananh.vss651@gmail.com", textEmailKH);
		System.out.println("txtEmailKH is oke");

		Thread.sleep(10);
		WebElement txtTenHangHoa = driver.findElement(tenHangHoa);
		txtTenHangHoa.click();
		
		Thread.sleep(10);
		WebElement txtMaHangHoa = driver.findElement(maHangHoa);
		txtMaHangHoa.click();
		pause(3000);
		String textMaHangHoa = txtMaHangHoa.getAttribute("value");
		Assert.assertEquals("Xăng RON 95-III", textMaHangHoa);
		System.out.println("txtMaHangHoa is oke");
		
		
		// btnLogin
		Thread.sleep(10);
		WebElement btnLuuHoaDon = driver.findElement(buttonLuuHoaDon);
		btnLogin.click();
		pause(3000);
		System.out.println("btnLuuHoaDon is oke");

	}

}
