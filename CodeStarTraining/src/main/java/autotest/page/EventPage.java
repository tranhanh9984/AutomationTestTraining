package autotest.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class EventPage extends CommonPage {

	@FindBy(className="fc-day-today") WebElement dayToday;
	@FindBy(xpath="//td[contains(@class,'fc-day-today')]//div[@class='fc-daygrid-event-harness']") List<WebElement> eventItems;
	
	public EventPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public int getEventCount() {
	    return eventItems.size();
	}

	public void getEventsToday() {
		for (WebElement event : eventItems) {
			String text = removeHtmlTags(event.getText());
	        System.out.println(event.getText().trim());
	    }
	}
}
