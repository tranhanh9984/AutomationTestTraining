package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import autocom.common.CommonPage;

public class MenuBar {
	
	String xpathMenuBar = "//ul[@role='menubar']//span[contains(@class, 'p-menuitem-text') and text()='%s']";
	String xpathSubMenu = "//ul[@role='menu' and @class='p-submenu-list']//span[contains(@class, 'p-menuitem-text') and text()='%s']";
	WebDriver _driver;

	public MenuBar(WebDriver driver) {
		// TODO Auto-generated constructor stub
		_driver = driver;
		
	}
	
	public WebElement getElementByText(String xpath, String text) {
		return _driver.findElement(By.xpath(String.format(xpath, text)));
	}
	
	public WebElement getMenuItemByText(String text) {
		return this.getElementByText(xpathMenuBar, text);
	}
	
	public WebElement getSubMenuItemByText(String text) {
		return this.getElementByText(xpathSubMenu, text);
	}
	
}
