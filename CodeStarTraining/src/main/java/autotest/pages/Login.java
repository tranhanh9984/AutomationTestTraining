package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Keys;

public class Login {

	WebDriver driver;

	public Login() {

	}

	// Hàm khởi tạo WebDriver
	public void setUp() {
		// Cấu hình WebDriver cho Chrome (có thể thay đổi thành trình duyệt khác nếu
		// cần)
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		driver = new ChromeDriver();
	}

	// Hàm tắt trình duyệt sau khi test
	public void tearDown() {
		driver.quit();
	}

	// Hàm nhập dữ liệu vào trường input
	public void enterText(By locator, String text) {
		WebElement element = driver.findElement(locator);
		clearTextField(element); // Xóa dữ liệu cũ trong input field trước khi nhập mới
		element.sendKeys(text);
	}

	// Hàm xóa text trong các trường nhập liệu (input fields)
	public void clearTextField(WebElement element) {
		element.clear(); // Dùng hàm clear() để xóa trường input
	}

	// Hàm thực hiện test login thành công
	public void loginSuccess(String username, String password) {
		enterText(By.id("email"), username);
		enterText(By.id("password"), password);
		driver.findElement(By.xpath("//button")).click();

		// Chờ trang chuyển hướng đến dashboard
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.urlToBe("https://uat-invoice.kaike.vn/dashboard"));
			System.out.println("Login thành công và chuyển đến trang dashboard.");
		} catch (TimeoutException e) {
			System.out.println("Chuyển hướng không thành công. URL hiện tại là: " + driver.getCurrentUrl());
		}
	}

	// Hàm thực hiện test login với sai username
	public void loginFailWrongUsername(String username, String password) {
		enterText(By.id("email"), username);
		enterText(By.id("password"), password);
		driver.findElement(By.xpath("//button")).click();

		// Chờ thông báo lỗi xuất hiện
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			WebElement errorMessage = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Có lỗi xảy ra')]")));
			System.out.println("Thông báo lỗi: " + errorMessage.getText());
		} catch (TimeoutException e) {
			System.out.println("Không tìm thấy thông báo lỗi.");
		}
	}

	// Hàm thực hiện test login với sai password
	public void loginFailWrongPassword(String username, String password) {
		enterText(By.id("email"), username);
		enterText(By.id("password"), password);
		driver.findElement(By.xpath("//button")).click();

		// Chờ thông báo lỗi xuất hiện
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			WebElement errorMessage = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Có lỗi xảy ra')]")));
			System.out.println("Thông báo lỗi: " + errorMessage.getText());
		} catch (TimeoutException e) {
			System.out.println("Không tìm thấy thông báo lỗi.");
		}
	}

	// Test case cho các tình huống login
	public void runTests() {
		// URL đăng nhập
		driver.get("https://uat-invoice.kaike.vn/login");

		// 1. Test login thành công
		loginSuccess("999", "000");

		// 2. Test login thất bại với sai username
		loginFailWrongUsername("invalid_username", "000");

		// 3. Test login thất bại với sai password
		loginFailWrongPassword("999", "wrong_password");
	}

	// Chạy toàn bộ test
	public static void main(String[] args) {
		Login test = new Login();
		test.setUp();
		test.runTests();
		test.tearDown();
	}
}
