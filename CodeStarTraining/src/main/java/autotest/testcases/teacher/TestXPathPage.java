package autotest.testcases.teacher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestXPathPage {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Khởi tạo trình duyệt Chrome
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\AutomationTestTraining\\CodeStarTraining\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Sửa lỗi này

        // Mở trang web
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
    }

    @Test
    public void fillForm() throws InterruptedException {
        // Điền thông tin vào form
        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("test@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@placeholder='Enter your company']")).sendKeys("AutoTest Co.");
        driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys("0987654321");

        // Click submit
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        Thread.sleep(3000);  // Chờ 3s để xem kết quả
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
