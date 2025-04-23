package autotest.pagesHD;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import autotest.pagesHD.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ThongTinKhachHang  {
    public static void main(String[] args) throws IOException {
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();

        Tao_KH kh = new Tao_KH(driver);
        driver.get("https://uat-invoice.kaike.vn/login");
        driver.manage().window().maximize();


         WebDriverWait wait = new WebDriverWait(driver, 10);
 
         driver.findElement(By.xpath("//input[@id='email']")).sendKeys("0312303803-999");
         driver.findElement(By.xpath("//input[@id='password']")).sendKeys("0312303803-999");

         driver.findElement(By.xpath("//button[@type='submit']")).click();

          kh.openMenu();


        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("KhachHang");

        // Ghi header
        Row header = sheet.createRow(0);
        String[] headers = {"Loại", "Mã KH", "Tên KH", "Người mua hàng", "MST", "Địa chỉ", "Email", "SĐT"};
        for (int i = 0; i < headers.length; i++) {
            header.createCell(i).setCellValue(headers[i]);
        }

         int rowNum = 1;
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            Row excelRow = sheet.createRow(rowNum++);
            for (int i = 0; i < cells.size(); i++) {
                excelRow.createCell(i).setCellValue(cells.get(i).getText());
            }
        }

         FileOutputStream out = new FileOutputStream("danhsach_khachhang.xlsx");
        workbook.write(out);
        out.close();
        workbook.close();

         driver.quit();
    }
}


