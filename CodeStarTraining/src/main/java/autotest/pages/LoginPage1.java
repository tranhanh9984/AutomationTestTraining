package autotest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class LoginPage1 extends CommonPage {
	String txtCompanyName = "companyUsername";
	String txtPassword = "password";
	String txtTaxCode = "taxCode";
	String btnLogin = "//button[@title='Đăng nhập']";
	String eyesIcon = "//div[@class='KTFormInput ']//i";

	public WebDriver driver;

	public LoginPage1(WebDriver dr) {
		driver = dr;
		}

	public void inputAllFields(String gmail, String password, String MST) {
		driver.findElement(By.id(txtCompanyName)).sendKeys(gmail);
		driver.findElement(By.id(txtPassword)).sendKeys(password);
		driver.findElement(By.id(txtTaxCode)).sendKeys(MST);
	}

	public void clickSubmitButton() {
		driver.findElement(By.xpath(btnLogin)).click();
		pause(1500);
	}

	public void leaveAllFieldsWithBlank(String gmail) {
		driver.findElement(By.id(txtCompanyName)).sendKeys(gmail);
		driver.findElement(By.id(txtCompanyName)).clear();
	}

	public void clickEyesIcon() {
		driver.findElement(By.xpath(eyesIcon)).click();
	}
}
