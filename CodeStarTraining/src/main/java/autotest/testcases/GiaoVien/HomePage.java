package autotest.testcases.GiaoVien;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class HomePage extends CommonPage {
	public HomePage() {
		
	}
	public void clickMenu() {
		driver.findElement(By.linkText("Lớp học")).click();
		driver.findElement(By.partialLinkText("Thời khóa biểu")).click();
	}

}
