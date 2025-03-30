package autotest.testcases.fclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public final class TS_SelectAudiAndClickAudit extends CommonPage {

    @BeforeMethod
    public void init() {
        driver = this.startBrower(KeywordConstant.xPathPage, KeywordConstant.BROWSER);
    }

    @Test
    public void testSelectAudiAndClickAudit() {
        Select carDropdown = new Select(driver.findElement(By.id("cars")));
        carDropdown.selectByVisibleText("Audi");

        WebElement auditButton = driver.findElement(By.xpath("//button[text()='Audit']"));
        auditButton.click();

        closeBrowser(driver);
    }
}