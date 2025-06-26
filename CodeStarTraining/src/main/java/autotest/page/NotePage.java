package autotest.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import autocom.common.CommonPage;
import autocom.common.LabelPopup;

public class NotePage extends CommonPage {
	private LabelPopup labelPopup;
	
	public NotePage(WebDriver driver) {
		this.driver = driver;
		this.labelPopup = new LabelPopup(driver);
	}
	
	By btnAddNote = By.xpath("//a[@title='Add note']");
	By inputTitle = By.id("title");
	By inputDescription = By.id("description");
	By editor = By.cssSelector("note-editable");
	By selectCategory = By.xpath("//div[@id='notes-dropzone']//a[@class='select2-choice' and contains(.,'Category')]");
	By optionsCategory = By.xpath("//li[contains(.,'Category')]//parent::ul//li");
	By inputLabel = By.xpath("//input[@id='id=note_labels']/preceding::div");
	By colorPanel = By.xpath("//div[@class='color-palet']//span");
	By customColor = By.id("custom-color");
	By btnUpdateFile = By.xpath("//button[contains(.,'Upload File')]");
	
	// Manage labels
	By btnManageLabels = By.xpath("//a[@title='Manage labels']");
	By labelList = By.xpath("//div[@id='label-show-area']//span");
	
	
	private By getLabelValue(String value) {
	    return By.xpath(String.format(
			"//ul[@class='select2-results']/parent::div[contains(@style,'display: block')]//li[contains(.,'%s')]", 
			value
	    ));
	}
	
	private List<String> getTextLabels() {
		this.clickManageLabels();
		List<String> labelTexts = new ArrayList<>();
		List<WebElement> labels = driver.findElements(labelList);
		
		for (WebElement label : labels) {
		    labelTexts.add(label.getText());
		}
		
		return labelTexts;
	}
	
	public void clickManageLabels() {
		driver.findElement(btnManageLabels).click();
	}
	
	public void clickAddNote() {
		driver.findElement(btnAddNote).click();
	}
	
	public void addNote(HashMap<String, String> note, List<String> labelsToAdd, List<String> allLabels) {
		driver.findElement(inputTitle).sendKeys(note.get("title"));
		driver.findElement(inputDescription).click();
		driver.findElement(editor).sendKeys(note.get("description"));
		driver.findElement(selectCategory).click();
		List<WebElement> options = driver.findElements(optionsCategory);
		
		if (options.size() > 0) {			
			options.get(0).click();
		}
		
		driver.findElement(inputLabel).click();
		addLabels(labelsToAdd, allLabels);
	}
	
	private void addLabels(List<String> labelsToAdd, List<String> allLabels) {
		for (String label : labelsToAdd) {
	        if (!allLabels.contains(label)) {
	            throw new IllegalArgumentException("Label không hợp lệ: " + label);
	        } else {
	        	WebElement labelElement = driver.findElement(getLabelValue(label));
	        	labelElement.click();
	        }
	    }
	}
}
