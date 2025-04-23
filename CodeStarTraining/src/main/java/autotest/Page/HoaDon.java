package autotest.Page;
import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class HoaDon extends CommonPage {

    public HoaDon(){

    }
    
    String txtNgayThang = "(//p-calendar[contains(@class,  'p-element p-inputwrapper')])[1]";
    String txtPrev = "//span[contains(@class,  'p-datepicker-prev')]";
    String txtNgay1 = "(//span[text() ='1'])[1]";
    String txtChonHDSo1 = "(//span[contains(@class, 'pi pi-fw pi-pencil')])";

    public void nhapNgayThang() {
        
    }
    
    public void chonHD() {
         driver.findElement(By.xpath(txtNgayThang)).click();
        
        for (int i = 0; i <6; i++) {
        driver.findElement(By.xpath(txtPrev)).click();
        }
        
        driver.findElement(By.xpath(txtNgay1)).click();
    	driver.findElement(By.xpath(txtChonHDSo1+"[5]")).click();
    	
    }
}