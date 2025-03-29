package autotest.pages.fclass;

import autocom.common.CommonPage;
import org.openqa.selenium.By;

public class HomePage extends CommonPage {

	 public HomePage() {
	        // TODO Auto-generated constructor stub
 	        super();
	    }

	    public void clickMenu(String name) {
	        driver.findElement(By.xpath(name)).click();
	    }

}
