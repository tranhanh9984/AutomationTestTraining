package TCRise;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import auto.page.Rise.Dashboard;
import autocom.common.commonPage;
import autocom.constant.KeywordConstant;

public class autodashboard {

    Dashboard dashboard;
    WebDriver driver;
    commonPage common;

    @BeforeTest
    public void setup() {
        common = new commonPage();  // Khởi tạo commonPage
        driver = common.startBrower(KeywordConstant.urlproject, "chrome");  // Lấy driver
        dashboard = new Dashboard(driver);  // Truyền driver vào Dashboard
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testInvoiceStats() {
        dashboard.loginPage(KeywordConstant.usernameproject, KeywordConstant.passwordproject);
        dashboard.clickLogin();

        Map<String, String[]> stats = dashboard.getInvoiceStats();

        Assert.assertEquals(stats.get("overdue")[0], "5", "Số lượng Overdue không đúng");
        Assert.assertEquals(stats.get("overdue")[1], "$2,648.50", "Giá trị tiền Overdue không đúng");
        Assert.assertTrue(dashboard.clickInvoiceFilterAndVerifyTable("overdue"), "Bảng Overdue không có dữ liệu");

        Assert.assertEquals(stats.get("not_paid")[0], "5", "Số lượng Not paid không đúng");
        Assert.assertEquals(stats.get("not_paid")[1], "$3,256.00", "Giá trị tiền Not paid không đúng");
        Assert.assertTrue(dashboard.clickInvoiceFilterAndVerifyTable("not_paid"), "Bảng Not Paid không có dữ liệu");

        Assert.assertEquals(stats.get("partially_paid")[0], "9", "Số lượng Partially paid không đúng");
        Assert.assertEquals(stats.get("partially_paid")[1], "$10,720.00", "Giá trị tiền Partially paid không đúng");
        Assert.assertTrue(dashboard.clickInvoiceFilterAndVerifyTable("partially_paid"), "Bảng Partially Paid không có dữ liệu");

        Assert.assertEquals(stats.get("fully_paid")[0], "11", "Số lượng Fully paid không đúng");
        Assert.assertEquals(stats.get("fully_paid")[1], "$12,470.00", "Giá trị tiền Fully paid không đúng");
        Assert.assertTrue(dashboard.clickInvoiceFilterAndVerifyTable("fully_paid"), "Bảng Fully Paid không có dữ liệu");

        Assert.assertEquals(stats.get("draft")[0], "2", "Số lượng Draft không đúng");
        Assert.assertEquals(stats.get("draft")[1], "$120.00", "Giá trị tiền Draft không đúng");
        Assert.assertTrue(dashboard.clickInvoiceFilterAndVerifyTable("draft"), "Bảng Draft không có dữ liệu");
    }

}
