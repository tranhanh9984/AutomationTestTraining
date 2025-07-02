package autotest.pages.rise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class DashboardPage extends CommonPage {

	By itemText(String text) {
		return By.xpath(String.format("//span[text()='%s']/parent::div", text));
	}

	By invoiceItemText(String text) {
		return By.xpath(String.format("//div[normalize-space() = '%s']", text));
	}

	By invoiceItemQuantity(String text) {
		return By.xpath(String.format(
				"//div[normalize-space() = '%s']/following-sibling::div[contains(@class,'text-center')]", text));
	}

	By invoiceItemTotalMoney(String text) {
		return By.xpath(String
				.format("//div[normalize-space() = '%s']/following-sibling::div[contains(@class,'text-end')]", text));
	}

	By bigItem(String text) {
		return By.xpath(String.format("//span[text()='%s']/preceding-sibling::h1", text));
	}

	By projectsItem(String text) {
		return By.xpath(String.format("//span[text()='%s']/preceding-sibling::h4", text));
	}

	By row(String text) {
		return By.xpath(String.format("//table[@id='%s']//tbody/tr", text));
	}

	By header(String text) {
		return By.xpath(String.format("//table[@id='%s']//thead/tr/th", text));
	}

	@FindBy(xpath = "//span[contains(normalize-space(), 'Progression')]")
	@CacheLookup
	WebElement progressText;

//	@FindBy(xpath = "//button[contains(@class,'show-filter')]")
//	@CacheLookup
//	WebElement btnShowFilter;

//	@FindBy(xpath = "//div[@class ='filter-form']/div[2]/div")
//	@CacheLookup
//	WebElement droplistStatus;
	
	@FindBy(xpath = "//div[text()='Total invoiced']/following-sibling::div[1]")
	@CacheLookup
	WebElement getTotalInvoicedMoney;

//	@FindBy(xpath = "//div[@class ='filter-form']/div[2]/div/input")
//	@CacheLookup
//	WebElement droplistStatusInput;

	By miniMenuOfSales(String text) {
		return By.xpath(
				String.format("//span[@class='menu-text ' and text()='Sales']/ancestor::li//span[text()='%s']", text));
	}
	
	

	JavascriptExecutor js;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	public void clickItem(String key) {
		WebElement element = driver.findElement(itemText(key));
		js.executeScript("arguments[0].click();", element);
	}

	public void clickInvoiceItem(String key) {
		WebElement element = driver.findElement(invoiceItemText(key));
		js.executeScript("arguments[0].click();", element);
	}

	public int getQuantityOfBigItem(String key) {
		WebElement element = driver.findElement(bigItem(key));
		String value = (String) js.executeScript("return arguments[0].textContent;", element);
		return Integer.parseInt(value.trim());
	}

	public float getQuantityOfDueItem() {
		WebElement element = driver.findElement(bigItem("Due"));
		String valueStr = (String) js.executeScript("return arguments[0].textContent;", element);
		String value = valueStr.replace("$", "").replace(",", "").trim();
		return Float.parseFloat(value.trim());
	}

	public int getQuantityOfProjectsItem(String key) {
		WebElement element = driver.findElement(projectsItem(key));
		String value = (String) js.executeScript("return arguments[0].textContent;", element);
		return Integer.parseInt(value.trim());
	}

	public int getQuantityOfInvoiceItem(String key) {
		WebElement element = driver.findElement(invoiceItemQuantity(key));
		String value = (String) js.executeScript("return arguments[0].textContent;", element);
		return Integer.parseInt(value.trim());
	}

	public float getTotalInvoicedMoney() {
		String valueStr = (String) js.executeScript("return arguments[0].textContent;", getTotalInvoicedMoney);
		String value = valueStr.replace("$", "").replace(",", "");
		return Float.parseFloat(value.trim());
	}
	
	public float getTotalMoneyOfInvoiceItem(String key) {
		WebElement element = driver.findElement(invoiceItemTotalMoney(key));
		String valueStr = (String) js.executeScript("return arguments[0].textContent;", element);
		String value = valueStr.replace("$", "").replace(",", "");
		return Float.parseFloat(value.trim());
	}

	public int countRows(String key) {
		int totalRows = 0;
		pause(2);
		while (true) {
//            List<WebElement> rows = driver.findElements(row("task-table"));
//            totalRows += rows.size();
//          
			long currentRows = (long) js
					.executeScript("return document.querySelectorAll('#" + key + " tbody tr').length;");
			if (currentRows == 1) {
				String cellText = (String) js
						.executeScript("return document.querySelector('#" + key + " tbody tr td').textContent.trim();");
				if (cellText.equalsIgnoreCase("No record found.")) {
					currentRows = (long) 0;
				}
			}
			totalRows += currentRows;
//			System.out.println("Total:  " + totalRows);
			List<WebElement> nextBtn = driver.findElements(By.xpath("//li[@class='paginate_button page-item next']"));
			if (!nextBtn.isEmpty() && nextBtn.get(0).isEnabled()) {
				js.executeScript("arguments[0].click();", nextBtn.get(0));
				pause(2);
			} else {
				break;
			}
		}

		System.out.println("Total:  " + totalRows);
		return totalRows;
	}

	public int countEventsToday() {
		List<WebElement> events = driver
				.findElements(By.xpath("//td[contains(@class, 'fc-day-today')]//div[@class='fc-daygrid-day-events']"));
		int total = events.size();
		System.out.println("Total:  " + total);
		return total;
	}

	public int getValueProgress() {
		String valueStr = (String) js.executeScript("return arguments[0].textContent;", progressText);
		String value = valueStr.replaceAll("[^0-9]", "");
		System.out.println("Value:  " + value);
		return Integer.parseInt(value.trim());
	}

	public MoneySummary countQuantityAndSumTotal(String headerName, String table) {
		List<WebElement> headers = driver.findElements(header(table));
		int columnIndex = -1;

		for (int i = 0; i < headers.size(); i++) {
			if (headers.get(i).getText().trim().equalsIgnoreCase(headerName.trim())) {
				columnIndex = i + 1;
				break;
			}
		}

		if (columnIndex == -1) {
			throw new RuntimeException("Not found: " + headerName);
		}

//		List<WebElement> columnCells = driver.findElements(By.xpath("//table/tbody/tr/td[" + columnIndex + "]"));

		float totalDue = 0;
		int totalRows = 0;

		while (true) {
			List<WebElement> rows = driver.findElements(row(table));

			if (rows.size() == 1 && rows.get(0).getText().toLowerCase().contains("No record found.")) {
				return new MoneySummary(0, 0);
			}

			for (WebElement row : rows) {
				WebElement dueCell = row.findElement(By.xpath("./td[" + columnIndex + "]"));

				totalRows++;

				String dueText = dueCell.getText().replace("$", "").replace(",", "").trim();

				if (!dueText.isEmpty()) {
					try {
						float due = Float.parseFloat(dueText);
						totalDue += due;
//						System.out.println("Total: " + totalDue);
					} catch (NumberFormatException e) {
						System.out.println("Cannot parse.");
					}
				}
			}

			List<WebElement> nextBtn = driver.findElements(By.xpath("//li[@class='paginate_button page-item next']"));
			if (!nextBtn.isEmpty() && nextBtn.get(0).isEnabled()) {
				js.executeScript("arguments[0].click();", nextBtn.get(0));
				pause(2);
			} else {
				break;
			}
		}

		System.out.println("Total: " + totalDue);
		return new MoneySummary(totalDue, totalRows);
	}

	public void clickShowFilter() {
		pause(2);
		driver.findElement(By.xpath("//button[contains(@class,'show-filter')]")).click();
//		js.executeScript("arguments[0].click();", btnShowFilter);
	}

	public void filterInvoiceByStatus(String status) {
		pause(2);
		driver.findElement(By.xpath("//label[text()='Yearly']")).click();
		driver.findElement(By.xpath("//div[@class ='filter-form']/div[2]/div")).click();
//		js.executeScript("arguments[0].click();", droplistStatus);
//		pause(5);
//		WebElement input = driver.findElement(By.xpath("//div[@class ='filter-form']/div[2]/div/input"));
//		js.executeScript("arguments[0].click();", input);
//		js.executeScript("arguments[0].value = arguments[1];", input, status);
		pause(2);
		dropdownSearch.click();
		dropdownSearch.sendKeys(status);
		dropdownSearch.sendKeys(Keys.ENTER);

		// Enter
//		js.executeScript(
//				"arguments[0].dispatchEvent(new KeyboardEvent('keydown', {key: 'Enter', keyCode: 13, which: 13}));"
//						+ "arguments[0].dispatchEvent(new KeyboardEvent('keyup', {key: 'Enter', keyCode: 13, which: 13}));",
//				input);
	}

	public void clickMiniMenuOfSales(String key) {
		WebElement element = driver.findElement(miniMenuOfSales(key));
		js.executeScript("arguments[0].click();", element);
	}

	public class MoneySummary {
		public float total;
		public int rowCount;

		public MoneySummary(float total, int rowCount) {
			this.total = total;
			this.rowCount = rowCount;
		}
	}

}
