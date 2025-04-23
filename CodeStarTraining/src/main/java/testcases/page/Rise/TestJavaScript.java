package testcases.page.Rise;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import page.Rise.HomePageRise;
import page.Rise.LoginPageRise;
import page.Rise.ProjectPage;


public class TestJavaScript extends CommonPage {


    @Test
    public void jsExecutorDemo01() throws InterruptedException {
        // Creating the JavascriptExecutor interface object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://anhtester.com/");
        Thread.sleep(1);
        // Click on "Website Testing" module using JavascriptExecutor
        WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
        js.executeScript("arguments[0].click();", button);
        Thread.sleep(1);
        // Get page title and Domain using JavascriptExecutor
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: " + titleText);
        String domainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain is: " + domainName);
        // Add Alert window using JavascriptExecutor
        js.executeScript("alert('Successfully Logged In');");
        Thread.sleep(1);
    }
    
    @Test
    public void jsExecutorDemo02() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
      driver.get("https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/clients");
        Thread.sleep(1000);
        // sendKeys text on input
      js.executeScript("document.getElementById('email').setAttribute('value','admin02@mailinator.com');"); 
      js.executeScript("document.getElementById('password').setAttribute('value','123456');");
        js.executeScript("document.getElementsByClassName('btn-primary')[0].click()");
        Thread.sleep(2000);
    }
    
    @Test
    public void jsExecutorDemo03() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Gọi lại hàm login
        jsExecutorDemo02();


        WebElement webElement = driver.findElement(By.xpath("//span[normalize-space()='Store']"));
        //webElement.click();  //Nếu dùng dòng này đơn thuần sẽ không click được
        // Scroll to element and click
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", webElement);
        Thread.sleep(2000);
    }
//    @Test
//    public void localStorage() throws InterruptedException {
//
//
//        String localGetVar = "";
//    driver.navigate().to("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
//        Thread.sleep(1000);
//
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//
//        //Set giá trị
//        js.executeScript("window.localStorage.setItem(arguments[0],arguments[1])", "age", "30");
//
//
//        Thread.sleep(1000);
//
//
//        //Get giá trị
//        localGetVar = (String) js.executeScript("return window.localStorage.getItem(arguments[0])", "age");
//
//
//        System.out.println(localGetVar);
//
//
//        Thread.sleep(1000);
//    }

    
    @BeforeTest
    public void startBrowser() {
        driver = this.startBrower("https://anhtester.com/", KeywordConstant.BROWSER);
    }

    
}
