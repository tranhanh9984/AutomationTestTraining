package auto.page.Rise;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePageRise {

    WebDriver driver;
    WebDriverWait wait;

    public HomePageRise(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, (10)); // Sửa Duration
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

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

    public void clickMenuProjects() {
        WebElement menuProjects = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Projects']")));
        menuProjects.click();
    }

    public void clickAddProject() {
        WebElement addProjectBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Add project']")));
        try {
            addProjectBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addProjectBtn);
        }
    }

    public void fillProjectForm(String title, String startDate, String deadline, String price, String description) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
        titleInput.clear();
        titleInput.sendKeys(title);
        sleep(500);

        WebElement startDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("start_date")));
        startDateInput.clear();
        startDateInput.sendKeys(startDate);
        sleep(500);

        WebElement deadlineInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("deadline")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", deadlineInput);
        deadlineInput.clear();
        deadlineInput.sendKeys(deadline);
        sleep(500);

        WebElement priceInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("price")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", priceInput);
        priceInput.clear();
        priceInput.sendKeys(price);
        sleep(500);

        // Gọi hàm nhập mô tả
        enterDescription(description);
    }

    public void enterDescription(String description) {
        WebElement descDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("div.note-editable[contenteditable='true']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerHTML = arguments[1];", descDiv, description);
        sleep(500); // đợi sau khi chèn
    }
    
    public void clickSaveButton() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@type='submit' and contains(., 'Save')]")));
        
        try {
            saveBtn.click(); // Thử click thường
        } catch (Exception e) {
            // Nếu lỗi, dùng JavaScript click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);
        }
    }
    /**
     * Xóa project theo projectId (data-id)
     */
    public void deleteProjectById(String projectId) {
        // XPath icon thùng rác (delete) theo data-id
        String deleteIconXpath = String.format("//a[contains(@class,'delete') and @data-id='%s']", projectId);

        // Scroll tới và click icon xóa
        WebElement deleteIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deleteIconXpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteIcon);
        deleteIcon.click();
        sleep(1000); // Đợi modal hiện

        // Click nút confirm Delete
        WebElement confirmDeleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmDeleteButton")));
        confirmDeleteBtn.click();
        sleep(1500); // Đợi xóa hoàn thành
    }
}
