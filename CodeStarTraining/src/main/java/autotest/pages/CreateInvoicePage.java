package autotest.pages;

import org.openqa.selenium.By;

import autocom.constant.KeywordConstant;

public class CreateInvoicePage extends LoginPage {
	
	String xpathBTNTaoMoi = "//button[@type='submit']";
	
	String errorText = "Tên đơn vị hoặc người mua hàng không được bỏ trống";

	public CreateInvoicePage() {
		// TODO Auto-generated constructor stub
	}
	
	public void gotoCreateInvoicePage() {
		this.login(KeywordConstant.USER_NAME, KeywordConstant.PASS_WORD);
		
		MenuBar menuBar = new MenuBar(driver);
		menuBar.getMenuItemByText(KeywordConstant.MENUBAR_INVOICE).click();
		menuBar.getSubMenuItemByText(KeywordConstant.MENUBAR_INVOICE_SUB_LHD).click();
		
		pause(2);
	}
	
	public void clickTaoMoi() {
		driver.findElement(By.xpath(xpathBTNTaoMoi)).click();
	}
	
	public void fillData() {
		
	}

}
