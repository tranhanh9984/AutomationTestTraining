package autotest.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class HomePage extends CommonPage {

	KeywordConstant comConstant = new KeywordConstant();
	String txtCompanyName = "companyUsername";
	String txtPassword = "password";
	String txtTaxCode = "taxCode";
	String menuHoadon = "//a[@href='/hoa-don-dau-ra/hoa-don']";
	String hoadonOptions = "//div[@class='menu-submenu']//a[contains(@href,'hoa-don-dau-ra/hoa-don')]";
	String btnLogin = "//button[@title='Đăng nhập']";
	String avatarImg = "//div[contains(@class,'KTTooltip ')]//img";
	String toastMsg = "//*[contains(text(), '" + comConstant.HO_TEN + "')]";

	public WebDriver driver;

	public HomePage(WebDriver dr) {
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

	public void clickOnAvatar() {
		boolean isDisplay = true;
		while (true) {
			isDisplay = driver.findElement(By.xpath(toastMsg)).isDisplayed();
			if (isDisplay == false) {
				break;
			}
			pause(1000);
		}
//		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(toastMsg)));
		pause(4000);
//		boolean isEnabled = true;
//		isEnabled = driver.findElement(By.xpath(avatarImg)).isDisplayed();
//		if (isEnabled == false) {
//			pause(2000);
//		}
		driver.findElement(By.xpath(avatarImg)).click();
	}

	public void clickHoadonMenu(String option) {
		driver.findElement(By.xpath(menuHoadon)).click();
		List<WebElement> allOptions = driver.findElements(By.xpath(hoadonOptions));
		for (int i = 0; i < allOptions.size(); i++) {
			if (allOptions.get(i).getText().contains(option)) {
				allOptions.get(i).click();
			}
		}
	}
}