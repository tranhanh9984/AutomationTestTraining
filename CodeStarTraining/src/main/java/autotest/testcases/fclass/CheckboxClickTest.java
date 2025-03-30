package autotest.testcases.fclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class CheckboxClickTest extends CommonPage {

    private WebDriver driver;

    @BeforeMethod
    public void init() {
        driver = this.startBrower(KeywordConstant.xPathPage, KeywordConstant.BROWSER);
    }

    @Test
    public void testCheckboxClick() {
        // Chờ checkbox có thể click được
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("ohrmList_chkSelectRecord_25")));
        
        // Click vào checkbox
        checkbox.click();
        
        // Kiểm tra checkbox đã được chọn chưa
        Assert.assertTrue(checkbox.isSelected(), "Checkbox should be selected after click.");
    }

    @AfterMethod
    public void tearDown() {
        pause(10);
        closeBrowser(driver);
    }
}
