package autotest_buoi9;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class ThucHanh extends CommonPage {

	public ThucHanh() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	private void fillForm() {
		Actions actions = new Actions(driver);

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("lienkieu@gmail.com");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("12345678");
		driver.findElement(By.xpath("(//input[@name='company'])[1]")).sendKeys("Google");
		driver.findElement(By.xpath("(//input[@name='mobile number'])[1]")).sendKeys("0982783888");

		driver.findElement(By.xpath("//button[@value='Submit']")).click();

		driver.findElement(By.xpath("//input[@title='Enter your first crush name']")).sendKeys("C789789");

		// Nếu muốn hover và click dropdown:
		// actions.moveToElement(driver.findElement(By.xpath("//button[text()='Checkout here']"))).perform();
		// driver.findElement(By.xpath("//div[@class='dropdown-content']/a[1]")).click();

		driver.findElement(By.xpath("//select[@id='cars']")).click();
		driver.findElement(By.xpath("//select[@id='cars']/option[text()='Audi']")).click();

		driver.findElement(By.xpath("//input[@id='datepicker']")).clear();
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("29-07-2000");
		driver.findElement(By.xpath("//input[@name='the_date']")).sendKeys("29-07-2000");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement table = driver.findElement(By.xpath("//table[@id='resultTable']"));
		js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top + window.pageYOffset - 100);", table);
		pause(2);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		
		for (WebElement row : rows) {
			WebElement checkboxCol = row.findElement(By.xpath("./td[1]/input"));
			checkboxCol.click();
			WebElement usernameCol = row.findElement(By.xpath("td[2]"));
		    System.out.println(usernameCol.getText());
		    
		}
		
		WebElement innerUsername = getNestedShadowElement("div#userName", "#kils");
		innerUsername.sendKeys("bichlien");
		
		WebElement innerPizzaName = getNestedShadowElement("div#userName", "div#app2", "#pizza");
		WebElement innerTraining = getNestedShadowElement("div#userName", "div#concepts", "#training");
		WebElement innerPassword = getNestedShadowElement("div#userName", "div#userPass", "#pwd");
		
		innerPizzaName.sendKeys("Pizza Muc - Thit");
		innerTraining.sendKeys("traninggggggg");
		innerPassword.sendKeys("123456");
		
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top + window.pageYOffset - 100);", element);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("F:\\Desktop\\Automation test\\Selenium\\Test data\\anh.jpg");

		
		driver.findElement(By.xpath("//button[text()='Click To Open Window Alert']")).click();
		pause(2);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		driver.findElement(By.xpath("//button[text()='Click To Open Window Prompt Alert']")).click();
		Alert prompt = driver.switchTo().alert();
		pause(2);
		prompt.sendKeys("No");
		prompt.accept();

		pause(2);
		
		driver.findElement(By.xpath("//button[@id='myBtn']")).click();
		pause(2);
		driver.findElement(By.xpath("//div[@id='myModal']//span[@class='close']")).click();
		
		
		WebElement numberPerPage = driver.findElement(By.xpath("//select[@class='dt-input']"));
		js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top + window.pageYOffset - 200);", numberPerPage);
		pause(2);
		Select select = new Select(numberPerPage);
		select.selectByValue("50");
		driver.findElement(By.xpath("//label[text()='Search:']/following::input[@type='search']")).sendKeys("windows");

	}

	public WebElement getNestedShadowElement(String... selectors) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    Object current = driver.findElement(By.cssSelector(selectors[0]));

	    for (int i = 1; i < selectors.length; i++) {
	        // Lấy shadowRoot của current element
	        current = js.executeScript("return arguments[0].shadowRoot", current);

	        if (current == null) {
	            return null;
	        }

	        // Lấy element con trong shadowRoot
	        current = js.executeScript("return arguments[0].querySelector(arguments[1])", current, selectors[i]);
	    }

	    return (WebElement) current;
	}
	
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlSelectorsHub, "chrome");
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
	}
}
