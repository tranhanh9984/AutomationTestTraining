package auto.page.Rise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Dashboard {
    private WebDriver driver;
    private WebDriverWait wait;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,(10));
    }

    // Nhập email và password
    public void loginPage(String email, String password) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign in']")));
        loginBtn.click();
    }

    public boolean clickInvoiceFilterAndVerifyTable(String filterType) {
        try {
            // Click vào thẻ thống kê
            WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[data-filter='" + filterType + "']")
            ));
            filterElement.click();

            // Đợi bảng invoice xuất hiện (giả định bảng có id="page-content" hoặc div chứa bảng)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table")));

            // Kiểm tra xem có ít nhất 1 hàng trong tbody không
            WebElement tbody = driver.findElement(By.cssSelector("table tbody"));
            return !tbody.findElements(By.tagName("tr")).isEmpty();

        } catch (Exception e) {
            System.out.println("Không kiểm tra được bảng cho filter: " + filterType + " - " + e.getMessage());
            return false;
        }
    }
 // Hàm lấy số lượng và số tiền cho từng trạng thái invoice
    public Map<String, String[]> getInvoiceStats() {
        Map<String, String[]> stats = new HashMap<>();

        String[] filters = {"overdue", "not_paid", "partially_paid", "fully_paid", "draft"};

        for (String filter : filters) {
            try {
                WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("a[data-filter='" + filter + "']")));
                
                String quantity = container.findElement(By.cssSelector("div.w15p.text-center")).getText();
                String amount = container.findElement(By.cssSelector("div.w25p.text-end")).getText();

                stats.put(filter, new String[]{quantity, amount});
            } catch (Exception e) {
                System.out.println("Error getting stats for filter: " + filter + ", " + e.getMessage());
                stats.put(filter, new String[]{"N/A", "N/A"});
            }
        }
        return stats;
    }


}
