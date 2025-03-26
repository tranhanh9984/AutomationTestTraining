package autotest.pages.fclass;

import autocom.common.CommonPage;
import org.openqa.selenium.By;

public class HomePage extends CommonPage {

	 public HomePage() {
	        // TODO Auto-generated constructor stub
 	        super();
	    }

	    public void clickMenu() {
	        driver.findElement(By.partialLinkText("Bài kiểm tra trực tuyến")).click();
	    }

}
