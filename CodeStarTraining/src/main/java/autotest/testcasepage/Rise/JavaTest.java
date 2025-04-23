package autotest.testcasepage.Rise;
import org.openqa.selenium.By;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
public class JavaTest extends CommonPage {
    WebDriver driver;

	public JavaTest() {
 	}
//	@Test
//    public void jsExecutorDemo01() throws InterruptedException {
//	    driver = this.startBrower("https://anhtester.com/", KeywordConstant.BROWSER);
//        // Creating the JavascriptExecutor interface object
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        driver.get("https://anhtester.com/");
//        Thread.sleep(1000);
//        // Click on "Website Testing" module using JavascriptExecutor
//        WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
//        js.executeScript("arguments[0].click();", button);
//        Thread.sleep(1000);
//        // Get page title and Domain using JavascriptExecutor
//        String titleText = js.executeScript("return document.title;").toString();
//        System.out.println("Page Title is: " + titleText);
//        String domainName = js.executeScript("return document.domain;").toString();
//        System.out.println("Domain is: " + domainName);
//        // Add Alert window using JavascriptExecutor
//        js.executeScript("alert('Successfully Logged In');");
//        Thread.sleep(2000);
//    }
	@Test
	public void jsExecutorDemo02()  {
	    driver = this.startBrower("https://rise.fairsketch.com", KeywordConstant.BROWSER);

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	  driver.get("https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/clients");
	  pause(2);
 	  js.executeScript("document.getElementById('email').value = '';");  
	  js.executeScript("document.getElementById('email').value = 'admin@demo.com';"); 
	  pause(2);

	  js.executeScript("document.getElementById('password').value = '';");
	  js.executeScript("document.getElementById('password').value ='riseDemo';");
	  pause(2);
	  js.executeScript("document.getElementsByClassName('btn-primary')[0].click()");
	   
 
	  System.out.println("Clicking button...");
	  pause(1);
	  js.executeScript("document.querySelector('a[data-title=\"Add client\"]').click();");
	  pause(1);

	  System.out.println("Setting company name...");
//	  js.executeScript("document.getElementById('company_name').value = 'riseDemo hehe';");
	  writeInputPureJS("Company name", "Tech Innovators Ltd.");
	  pause(1);
//	  js.executeScript("document.getElementById('s2id_created_by').click();");
//	  js.executeScript("let item = document.querySelector('ul.select2-results li div[data-title=\"Michael Wood\"]');"
//	  		+ " if (item) { item.click(); }"
//	  		+ " else { console.warn('Không tìm thấy phần tử mong muốn!'); }"); 
 
	  selectFromDropdownJS("s2id_created_by","Michael Wood");
	  pause(2);

	  writeInputPureJS("Address", "456 Future Road, Silicon Valley");
	  writeInputPureJS("City", "San Francisco");
	  writeInputPureJS("State", "California");
	  writeInputPureJS("Zip", "94107");
	  writeInputPureJS("Country", "United States");

	  writeInputPureJS("Phone", "+1 123 456 7890");
	  writeInputPureJS("Currency Symbol", "$");

	  pause(2);
	  
	  js.executeScript("document.getElementsByClassName('btn btn-primary')[0].click();");
	  pause(2);  

	   
	  driver.get("https://rise.fairsketch.com/clients/index/clients_list#all_clients");
	  pause(2);  
//
//	  js.executeScript(
//			    "const input = document.querySelector('#client-table_filter input');" +
//			    "input.value = 'Tech Innovators Ltd.';" +
//			    "const event = new KeyboardEvent('keydown', {key: 'Enter', keyCode: 13, which: 13, bubbles: true});" +
//			    "input.dispatchEvent(event);"
//			);
	  WebElement searchInput = driver.findElement(By.cssSelector("#client-table_filter input"));
	  searchInput.sendKeys("Tech Innovators Ltd.");
	  searchInput.sendKeys(Keys.ENTER);
	 pause(2);  

 	 Map<String, String> info = getClientInfo("Tech Innovators Ltd.");
 	 Assert.assertNotNull(info, "Không tìm thấy thông tin khách hàng!");
	 pause(2);  

     Assert.assertEquals(info.get("name"), "Tech Innovators Ltd.","Tên không đúng");
     Assert.assertEquals(info.get("phone"), "+1 123 456 7890","SDT không đúng");
     System.out.println("Đã tìm thấy khách hàng và có ID là: "+info.get("id"));

 	  


	// Check client list
//	pause(2); // chờ reload danh sách
//	Boolean isClientPresent = (Boolean) js.executeScript(
//	    "return Array.from(document.querySelectorAll('#client-table td'))" +
//	    ".some(td => td.textContent.includes('riseDemo hehe'));"
//	);
//	Assert.assertTrue(isClientPresent, "Client 'riseDemo hehe' not found");
//
//
 	}
	public void writeInputPureJS(String labelText, String text) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript(
	        "const labels = Array.from(document.querySelectorAll('label'));" +
	        "for (const label of labels) {" +
	        "  if (label.textContent.includes(arguments[0])) {" +
	        "    const input = label.parentElement.querySelector('input');" +
	        "    if (input) {" +
	        "      input.value = arguments[1];" +
	        "      input.dispatchEvent(new Event('input'));" +
	        "      break;" +
	        "    }" +
	        "  }" +
	        "}",
	        labelText, text
	    );
	}
	public void writeDescription(String text) {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        
	        // 1. Click bằng JavaScript thuần qua ID
	        js.executeScript("document.getElementById('description').click();");
	        
	        // 2. Tìm và điền nội dung (giữ nguyên logic cũ)
	        WebElement editor = driver.findElement(
	            By.xpath("//label[contains(text(), 'Description')]/following-sibling::div//div[@class='note-editable']")
	        );
	        js.executeScript("arguments[0].innerHTML = arguments[1];", editor, text);
	        
	    } catch (Exception e) {
	        System.err.println("Lỗi khi thao tác với editor: " + e.getMessage());
	        throw e;
	    }
	}

	public void selectFromDropdownJS(String dropdownId, String valueToSelect) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    try {
 	        js.executeScript("document.getElementById(arguments[0]).click();", dropdownId);

 	        new WebDriverWait(driver, 5).until(d -> 
	            (Boolean) js.executeScript(
	                "return document.querySelectorAll('ul.select2-results li').length > 0"
	            )
	        );

	        if (valueToSelect != null && !valueToSelect.isEmpty()) {   
	            WebElement optionElement = driver.findElement(By.xpath("//ul[@role='listbox']//li//div[text()='" + valueToSelect + "']"));
	            optionElement.click();
	            System.out.println("Đã chọn option: " + valueToSelect);
	        } else {
	            System.out.println("Không thỏa điều kiện để chọn option.");
	        }
	    } catch (Exception e) {
	        System.err.println("Có lỗi xảy ra khi chọn dropdown.");
	        e.printStackTrace();
	    }}
	public void selectFromDropdownJSs(String dropdownId, String valueToSelect) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    try {
	        // 1. Click mở dropdown
	        js.executeScript("document.getElementById(arguments[0]).click();", dropdownId);
	        System.out.println("Đã click dropdown: " + dropdownId);
	        pause(2);

	        if (valueToSelect != null && !valueToSelect.isEmpty()) {   
	            WebElement optionElement = driver.findElement(By.xpath("//ul[@class='select2-results']//li//div[text()='" + valueToSelect + "']"));
	            optionElement.click();
	            System.out.println("Đã chọn option: " + valueToSelect);
	        } else {
	            System.out.println("Không thỏa điều kiện để chọn option.");
	        }
	    } catch (Exception e) {
	        System.err.println("Có lỗi xảy ra khi chọn dropdown.");
	        e.printStackTrace();
	    }}
	public Map<String, String> getClientInfo( String clientName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script =
                "const rows = document.querySelectorAll('#client-table tbody tr');" +
                "for (let row of rows) {" +
                "  const cells = row.querySelectorAll('td');" +
                "  if (cells[1] && cells[1].innerText.trim() === '" + clientName + "') {" +  
                "    return {" +
                "      id: cells[0].textContent.trim()," +
                "      name: cells[1].textContent.trim()," +
                "      primaryContact: cells[2].textContent.trim()," +
                "      phone: cells[3].textContent.trim()," +
                "      clientGroups: cells[4].textContent.trim()," +
                "      labels: cells[5].textContent.trim()," +
                "      projects: cells[6].textContent.trim()," +
                "      totalInvoiced: cells[7].textContent.trim()," +
                "      paymentReceived: cells[8].textContent.trim()," +
                "      due: cells[9].textContent.trim()" +
                "    };" +
                "  }" +
                "}" +
                "return null;";
        return (Map<String, String>) js.executeScript(script);

    }
	}


//	@Test
//	public void jsExecutorDemo03()   {
//	    pause(2);
//	    driver = this.startBrower("https://rise.fairsketch.com/clients", KeywordConstant.BROWSER);
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//
//	    System.out.println("Login and navigate...");
//	    jsExecutorDemo02();
//
//	    System.out.println("Clicking button...");
//	    js.executeScript("document.querySelector('a[data-title=\"Add client\"]').click();");
//
//	    System.out.println("Setting company name...");
//	    js.executeScript("document.getElementById('company_name').value = 'riseDemo hehe';");
//	


//	    WebElement webElement = driver.findElement(By.xpath("//span[normalize-space()='Store']"));
//	    //webElement.click();  //Nếu dùng dòng này đơn thuần sẽ không click được
//	    // Scroll to element and click
//	    js.executeScript("arguments[0].scrollIntoView(true);", webElement);
//	    Thread.sleep(1000);
//	    js.executeScript("arguments[0].click();", webElement);
//	    Thread.sleep(2000);
//	}
//	@Test
//	public void localStorage() throws InterruptedException {
//
//
//	    String localGetVar = "";
//	driver.navigate().to("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
//	    Thread.sleep(1000);
//
//
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//
//
//	    //Set giá trị
//	    js.executeScript("window.localStorage.setItem(arguments[0],arguments[1])", "age", "30");
//
//
//	    Thread.sleep(1000);
//
//
//	    //Get giá trị
//	    localGetVar = (String) js.executeScript("return window.localStorage.getItem(arguments[0])", "age");
//
//
//	    System.out.println(localGetVar);
//
//
//	    Thread.sleep(1000);
	//}

