package autotest.buoi8;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class editProject extends CommonPage {
@Test
	public void testLogin(){
		addCookies();
		clearAll();
		this.Login("admin@demo.com", "riseDemo");
		editProject();
	}
	
	public void Login(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button")).click();
	}
	
	public void editProject() {
		driver.findElement(By.linkText("Projects")).click();
//Lay id của title
//		String xpath = "//tr[td[text()='" + title + "']]";
//		String datapostid = driver.findElement(By.xpath(xpath)).getAttribute("data-post-id");
//		driver.findElement(By.xpath("//a[@title= 'Edit project' and @data-post-id='10']")).click();
		boolean found = false;
		for (int page = 1; page <= 10; page++) {
			int rowCount = driver.findElements(By.xpath("//table//tr/td[1]")).size();
			for (int i = 1; i <= rowCount; i++) {
                try {
                    String projectID = driver.findElement(By.xpath("//table//tr[" + i + "]/td[1]")).getText();
                    if (projectID.equalsIgnoreCase("11")) {
                    	driver.findElement(By.xpath("//a[@title= 'Edit project' and @data-post-id='"+projectID+"']")).click();
                        pause(1);
                        driver.findElement(By.id("title")).clear();
                        pause(1);
                        driver.findElement(By.id("title")).sendKeys("Project 1 - Đã sửa");                     
                        pause(1);
                        driver.findElement(By.xpath("//button[@type='submit' and contains(., 'Save')]")).click();
                        found = true;
                        break;
                    }
                } catch (Exception e) {
                }
            }

            if (found) break;

            // Tìm và click nút trang kế tiếp ">"
            try {
            	driver.findElement(By.xpath("//li[@id='project-table_next' and not(contains(@class, 'disabled'))]/a")).click();
                Thread.sleep(1000);
            } catch (Exception e) {
                break; // không còn trang tiếp theo
            }
        }
		if (!found) {
            System.out.println("❌ Không tìm thấy Project.");
        }

	}
	
	public void clearAll() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
	}
	private void addCookies() {		 
		 Cookie cookie = new Cookie.Builder("myCookie", "90697424f47dc5542d1d7b3cbefd9f4e")
	                .isHttpOnly(true)
	                .isSecure(false)
	                .build();
		 driver.manage().addCookie(cookie);
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}

}
