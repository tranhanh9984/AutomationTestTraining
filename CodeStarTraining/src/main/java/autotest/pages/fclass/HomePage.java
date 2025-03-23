package autotest.pages.fclass;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class HomePage extends CommonPage{

	public HomePage() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void clickMenu() {
		driver.findElement(By.linkText("Bài kiểm tra trực tuyến")).click();
	}
}
