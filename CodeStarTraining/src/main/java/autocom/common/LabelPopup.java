package autocom.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LabelPopup extends CommonPage {
	private List<String> labels;
	
	// Manage labels
	private By btnManageLabels = By.xpath("//a[@title='Manage labels']");
	private By btnSave = By.xpath("//div[contains(@class, 'add-label')]//button[contains(.,'Save')]");
	private By btnDelete = By.id("label-delete-btn");;
	
	private By labelItems = By.xpath("//div[@id='label-show-area']//span");
	private By inputLabel = By.id("label-title");
	
	private By colorItems = By.xpath("//div[@class='color-palet']//span");
	private By colorInput = By.xpath("//div[@class='color-palet']//input[@id='custom-color']");
	
	public LabelPopup(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public List<String> getTextLabels() {
		this.clickManageLabels();
		List<String> labelTexts = new ArrayList<>();
		List<WebElement> labels = driver.findElements(labelItems);
		
		for (WebElement label : labels) {
		    labelTexts.add(label.getText());
		}
		
		return labelTexts;
	}
	
	private By getLabel(HashMap<String, String> label) {
	    return By.xpath(String.format(
			"//div[@id='label-show-area']//span[text()='%s' and contains(@style, 'background-color: %s')]", 
			label.get("name"),
			label.get("color")
	    ));
	}
	
	private By getColor(String color) {
		return By.xpath(String.format(
			"//div[@class='color-palet']//span[contains(@style, 'background-color:%s')]", 
			color
	    ));
	}
	
	public void clickManageLabels() {
		driver.findElement(btnManageLabels).click();
	}
	
	public void clickSave() {
		driver.findElement(btnSave).click();
    }
	
	public void clickDelete() {
		driver.findElement(btnDelete).click();
    }
	
	public void fillLabel(String name) {
		driver.findElement(inputLabel).clear();
		driver.findElement(inputLabel).sendKeys(name);
    }
	
	public void addLabel(HashMap<String, String> label) {
		fillLabel(label.get("name"));
		selectColor(label.get("color"));
		clickSave();
	}
	
	public void editLabel(HashMap<String, String> label, HashMap<String, String> newLabel) {
		List<WebElement> labels = driver.findElements(getLabel(label));
		
		 System.out.println("labels: " + labels);
		for (WebElement el : labels) {
			String color = rgbaToHex(el.getCssValue("background-color"));
			
			System.out.println("color: " + color);
			String text = el.getText();
			pause(2);
			el.click();
			pause(2);
			if (!text.equals(newLabel.get("name"))) {				
				fillLabel(newLabel.get("name"));
			}
			
			if (!color.equals(newLabel.get("color"))) {	
				selectColor(newLabel.get("color"));
				clickSave();
			}
		}
		
	}
	
	public void deleteLabel(HashMap<String, String> label) {
		List<WebElement> labels = driver.findElements(getLabel(label));
		
		for (WebElement el : labels) {
			pause(2);
			el.click();
			pause(2);
			clickDelete();
		}
    }
	
	public void selectColor(String color) {
		List<WebElement> colorElements = driver.findElements(getColor(color));
		System.out.println(colorElements);
		if (!colorElements.isEmpty()) {
			colorElements.get(0).click();
        } else {        	
        	WebElement colorPicker = driver.findElement(colorInput);
        	colorPicker.click();
        	pause(1);
//        	colorPicker.clear();
//        	colorPicker.sendKeys(color);
        	
        	JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                "arguments[0].value = arguments[1];" +
                "arguments[0].dispatchEvent(new Event('input'));" +
                "arguments[0].dispatchEvent(new Event('change'));",
                colorPicker, color);
        }
	}
	
	public void verifyAddedLabel(HashMap<String, String> label) {
		List<WebElement> addedLabels = driver.findElements(getLabel(label));
		 System.out.println("addedLabels: " + addedLabels);
//		Assert.assertEquals(addedLabels.size(), 1);
		
	}
	
	public String rgbaToHex(String rgba) {
	    try {
	        String clean = rgba.replace("rgba(", "").replace("rgb(", "").replace(")", "");
	        String[] parts = clean.split(",");
	        int r = Integer.parseInt(parts[0].trim());
	        int g = Integer.parseInt(parts[1].trim());
	        int b = Integer.parseInt(parts[2].trim());
	        return String.format("#%02X%02X%02X", r, g, b);  // chữ hoa
	    } catch (Exception e) {
	        System.out.println("Invalid color format: " + rgba);
	        return "";
	    }
	}
}
