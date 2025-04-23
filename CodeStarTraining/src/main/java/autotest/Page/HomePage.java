package autotest.Page;
import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class HomePage extends CommonPage{
    public HomePage (){

    }

    String txtThanhCong = "//span[text() = '0312303803-999']";
    public String getText() {
        return driver.findElement(By.xpath(txtThanhCong)).getText();

    }
    String txtClickHD = "(//span[text()='Hóa đơn '])[1]";
    String txtClickHDBanHang = "//span[text()= 'Hóa đơn bán hàng']";
    public void clickHDBanHang() {
        driver.findElement(By.xpath(txtClickHD)).click();
        driver.findElement(By.xpath(txtClickHDBanHang)).click();
    }
String txtClickdanhmuc = "//span[text()='Danh mục']";
String txtClickkhachhang = "//span[text()='Khách hàng']";
public void clickkhachhang() {
	driver.findElement(By.xpath(txtClickdanhmuc)).click();
	driver.findElement(By.xpath(txtClickkhachhang)).click();
}
String txtkhachhang = "//th[@id='th_partyName']";
public String gettextKH() {
	return driver.findElement(By.xpath(txtkhachhang)).getText();
}
}