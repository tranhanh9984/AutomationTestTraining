package autotest.testcases.fclass;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public final class TS_ClickJoinTraining extends CommonPage {
    private String originalWindow;

    @BeforeMethod
    public void init() {
        driver = this.startBrower(KeywordConstant.xPathPage, KeywordConstant.BROWSER);
    }

    @Test
    public void testClickJoinTraining() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // Lưu lại cửa sổ gốc trước khi mở tab mới
        originalWindow = driver.getWindowHandle();

        // Tìm và click vào nút Checkout
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Checkout here']")));
        safeClick(checkoutButton);

        // Chờ cho trang tải hoàn tất
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Join Training']")));

        // Click vào link "Join Training"
        WebElement joinTrainingLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Join Training']")));
        safeClick(joinTrainingLink);

        switchToNewTab();

        // Kiểm tra URL
        String expectedURL = "https://selectorshub.com/bootcamp";
        String actualURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + actualURL);
        Assert.assertTrue(actualURL.startsWith(expectedURL), "Không điều hướng đúng trang Join Training!");

        driver.close(); 
        driver.switchTo().window(originalWindow);

        wait.until(ExpectedConditions.urlToBe("https://selectorshub.com/xpath-practice-page/"));

        closeBrowser(driver);
    }

    public void safeClick(WebElement element) {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            try {
                element.click();
                return;  
            } catch (ElementClickInterceptedException e) {
                pause(2);  
            }
        }
        throw new RuntimeException("Không thể click vào phần tử sau nhiều lần thử.");
    }

    public void switchToNewTab() {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                return;
            }
        }
    }

    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
