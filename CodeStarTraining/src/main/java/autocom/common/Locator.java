package autocom.common;

import org.openqa.selenium.By;

public class Locator {
//	public static final By btnAdd = By.cssSelector("a[title^='Add']");
	public static final By btnSubmit = By.xpath("//button[@type='submit' and normalize-space()='Save']");
    public static final By btnConfirmDelete = By.id("confirmDeleteButton");
    
    public static final By appAlert = By.className("app-alert");
    public static final By alertMessage = By.className("app-alert-message");
    
    public static final By btnDelete = By.cssSelector("[title^='Delete']");
    public static final By btnEdit = By.cssSelector("[title^='Edit']");

    public static final By descriptionBox = By.id("description");
    public static final By descriptionEditor = By.className("note-editable");
	
    public static final By colTitle = By.xpath("./td[2]/a");
    
    public static By btnAdd(String labelText) {
        return By.xpath(String.format("//div[contains(@class,'tab-title')]//a[@title='%s']", labelText));
    }
    
	public static By inputByLabelText(String labelText) {
        return By.xpath(String.format("//label[normalize-space()='%s']/following::input[1]", labelText));
    }

    public static By select2Option(String value) {
        return By.xpath(String.format(
            "//ul[contains(@class, 'select2-results')]//div[contains(text(),'%s')]",
            value
        ));
    }
    
    public static By tableRows(String tableId) {
        return By.xpath(String.format("//table[@id='%s-table']/tbody/tr", tableId));
    }

    public static By xPathTableEmpty(String tableId) {
        return By.xpath(String.format(
            "//table[@id='%s-table']//td[@class='dataTables_empty' and contains(text(), 'No record found')]",
            tableId
        ));
    }

    public static By tableSearchInput(String tableId) {
        return By.xpath(String.format("//div[@id='%s-table_filter']//input", tableId));
    }

    


    public static By dropdownNearLabel(String labelText) {
        return By.xpath(String.format(
            "//label[normalize-space()='%s']/following::div[1]//div[contains(@class,'select2-container')]",
            labelText
        ));
    }
    
    public static By inputDropdownFollowingLabel(String labelText) {
    	return By.xpath(String.format(
    		"//label[contains(.,'%s')]//following::div[1]//ul//input", 
    		labelText
    	));
    }

    public static By inputDropdownNearLabel(String labelText) {
    	return By.xpath(String.format(
    		"//div[@class='select2-search']//label[contains(text(),'%s')]//following::input", 
    		labelText
    	));
    }
    
    public static By clickDropdownNearLabel(String labelText) {
    	return By.xpath(String.format(
    		"//div[@class='container-fluid']//label[contains(., '%s')]//following-sibling::div[1]//div[contains(@class,'select2-container')]", 
    		labelText
    	));
    }
    
    public static By optionDropdown(String value) {
    	return By.xpath(String.format(
            "//ul[contains(@class, 'select2-results')]//div[contains(@class, 'select2-result-label') and contains(.,'%s')]",
            value
        ));
    }
}
