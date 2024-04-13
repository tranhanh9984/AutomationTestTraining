package autotest.pages;

import autocom.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class CamLy_BaiTap extends CommonPage {
    WebDriver driver;


    @BeforeTest
    public void start_page() {
        driver = this.startBrower("https://selectorshub.com/xpath-practice-page/", "chrome");
    }

    @AfterTest
    public void close_page() throws InterruptedException {
        Thread.sleep(2);
        this.closeBrowser(driver);
    }

    @Test
    public void testXpath() throws InterruptedException {
//        By byName = By.name("email");
//        By byName1 = By.xpath("//*[@id=\"content\"]/div/div[1]/section[2]/div/div[1]/div/div[1]/div/div/div[1]/div/div/div/input[1]");
//        WebElement txtName = driver.findElement(byName1);
//        txtName.click();
//        pause(2);
//        txtName.sendKeys("Nguyen Thi Cam Ly");
//        pause(40000);
//        String text = txtName.getAttribute("value");
//        Assert.assertEquals("Nguyen Thi Cam Ly",text);

//        List<WebElement> options = driver.findElements(By.xpath("//*[@id='cars']"));
//        //Count the Values
//        System.out.println(options.size());
//
//        for (int i = 0; i < options.size(); i++) {
//            //Print the text
//            System.out.println(options.get(i).getText());
//
//            String optionName = options.get(i).getText();
//            //If u want to select the perticular Value
//            if (optionName.equals("Saab")) {
//                //Instead of xxxxx u put the value option 1 or 2 or 3 like that
//                //If the value of option 1 is like Books, u want to select that put Books replace  with xxxxx
//                options.get(i).click();
//
//
        Select select = new Select(driver.findElement(By.id("cars")));
        select.selectByVisibleText("Saab");

        pause(40000);

//
//        public void clickDroplist(){
//            Select cbb = new Select()
//        }











    }


}
