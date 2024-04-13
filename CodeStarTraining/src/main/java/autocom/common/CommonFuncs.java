package autocom.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonFuncs {
	private WebDriver driver;
	private WebDriverWait wait;
	JavascriptExecutor js;

	public CommonFuncs(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
		js = (JavascriptExecutor) driver;
	}
	/**
	 * get datetime
	 * 
	 * @param format
	 */
	public String getDateTime(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());
		return dateTime;
	}
	public void setText(By element, String value){
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(value);
	}
	public void clickElement(By element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
		// click vào 1 phần tử element truyền vào
		driver.findElement(element).click();
		//click cua jd
		//js.executeAsyncScript("argoments[0].click();",driver.findElement(element));;
	}

	public void selectOptionByText(By element,String text){
		// chuyển từ đối tượng By sang WebElement thì thêm driver.findElemt
		Select select = new Select(driver.findElement(element));
		select.selectByVisibleText(text);
	}

	public void selectCheckBox(By checkboxLocator){
		WebElement checkBox = driver.findElement(checkboxLocator);
		if (!checkBox.isSelected()){
			checkBox.click();
		}

	}
	public void clickLinktext(String linkText){
		WebElement link = driver.findElement(By.xpath(linkText));
		link.click();
	}
	public void clickDropdown(String xpath) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			element.click();
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			// Nếu nhấp vào bị chặn, thử nhấp lại sau khi chờ một khoảng thời gian
			try {
				Thread.sleep(1000); // Đợi 1 giây
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath(xpath));
			element.click();
		}
	}

	public void scrollDown() {
		// Cuộn trang xuống dưới cùng
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void clickElementTable(By elementLocator, By tableLocator) {
		// Click vào phần tử để hiển thị bảng
		WebElement elementToClick = driver.findElement(elementLocator);
		elementToClick.click();

		// Chờ cho bảng xuất hiện trong 10 giây
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));

		// Chọn phần tử trong bảng (thực hiện các thao tác khác tại đây)
		// Ví dụ:
		// WebElement elementInTable = table.findElement(By.xpath("//tr[@id='your_row_id']/td[@class='your_cell_class']"));
		// elementInTable.click();
	}



}
