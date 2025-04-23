package page.Rise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class ProjectPage extends CommonPage {
	public ProjectPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//a[@title = 'Add project']") @CacheLookup WebElement txtClickTaoProject;
	public void clickTaoProject() {
		txtClickTaoProject.click();
	}
	@FindBy (id = "title") @CacheLookup public WebElement txtTile;
	@FindBy (xpath = "//label[contains(text(), 'Owner')]//parent::div//div/div") @CacheLookup WebElement txtClickProjectType;
	@FindBy (xpath = "//input[@id = 's2id_autogen9_search']") @CacheLookup public WebElement txtProjectType;
	@FindBy (xpath = "//span[text() = 'Demo Client']//parent::a") @CacheLookup WebElement txtClickDemoClient;
	@FindBy (xpath = "//input[@id = 's2id_autogen7_search']") @CacheLookup public WebElement txtDemoClient;
	@FindBy (xpath = "//textarea[@name= 'description']//parent::div") @CacheLookup WebElement txtClickDes;
	@FindBy (xpath = "//div[@class= 'note-editable']") @CacheLookup WebElement txtDes;
	@FindBy (id = "start_date") @CacheLookup WebElement txtStartDate;
	@FindBy (id = "deadline") @CacheLookup WebElement txtDeadline;
	@FindBy (id = "price") @CacheLookup WebElement txtPrice;
	@FindBy (xpath = "//label[text()= 'Labels']/parent::li") @CacheLookup WebElement txtClickLabel;
	@FindBy (xpath = "//label[text()= 'Labels']/following-sibling::input") @CacheLookup WebElement txtLabel;
	@FindBy (xpath = "//div[@class='page-title clearfix projects-page']/child::h1") @CacheLookup WebElement txtproject;
	@FindBy (xpath = "//th[contains(text(),'ID')]") @CacheLookup WebElement ID;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Title'])+1]/descendant::a") @CacheLookup WebElement CFtitle;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Title'])+2]/descendant::a") @CacheLookup WebElement CFClient;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Title'])+3]") @CacheLookup WebElement CFPrice;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Title'])+4]") @CacheLookup WebElement CFStartdate;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Title'])+5]") @CacheLookup WebElement CFDealine;
	public void dienTitle(String title) {
		txtTile.clear();
		txtTile.sendKeys(title);
	}
	
	public void clear (WebElement element) {
		element.clear();
	}
	public void projectType(String projectType) {
		txtClickProjectType.click();
		txtProjectType.sendKeys(projectType);
		txtProjectType.sendKeys(Keys.ENTER);
	} 
	
	public void clickOutside(WebElement WebElement) {
	    
	    Actions actions = new Actions(driver);

	    // Di chuyển chuột đến phần tử và sau đó di chuyển offset ra ngoài để click "bên ngoài"
	    actions.moveToElement(WebElement, -50, -50).click().build().perform();
	}
	
	public void projectTypeClear() {
		txtProjectType.clear();
	}
	
	public void client(String client) {
		txtClickDemoClient.click();
		txtDemoClient.sendKeys(client);
		txtDemoClient.sendKeys(Keys.ENTER);
	}
	
	public void description(String des) {
		txtClickDes.click();
		txtDes.clear();
		txtDes.sendKeys(des);
	}
	
	public void Date(String startDate, String deadline) {
		txtStartDate.click();
		txtStartDate.sendKeys(startDate);
		txtDeadline.click();
		txtDeadline.sendKeys(deadline);
	}
	
	public void price(String price) {
		scrollToElement("//input[@id = 'price']");
		txtPrice.clear();
		txtPrice.sendKeys(price);
	}
	
	public void label() {
		txtClickLabel.click();
		txtLabel.sendKeys("high");
		txtLabel.sendKeys(Keys.ENTER);
		txtClickLabel.click();
		txtLabel.sendKeys("on");
		txtLabel.sendKeys(Keys.ENTER);
	}
	
	@FindBy (xpath = "//button[@type= 'submit']") @CacheLookup WebElement txtClickSave;
	public void clickSave() {
		txtClickSave.click();
	}
	
	@FindBy (xpath = "//button[@type= 'submit']/preceding-sibling::button[contains (text() , 'Close')]") @CacheLookup WebElement txtClickClose;
	public void clickClose() {
		txtClickClose.click();
	}
	
	@FindBy (xpath = "//button[@id= 'save-and-continue-button']") @CacheLookup WebElement txtSaveAndContinue;
	public void clickSaveAndContinue() {
		txtSaveAndContinue.click();
	}
	
	@FindBy (xpath = "//span[@id= 'title-error']") @CacheLookup WebElement txtTitleError;
	public String getTitleError() {
		return txtTitleError.getText();
	}
	
	@FindBy (xpath = "//div[@id = 'select2-drop']/descendant::li") @CacheLookup WebElement txtNoMatchFound;
	public String getNoMatchFound() {
		return txtNoMatchFound.getText();
	}
	
	@FindBy (xpath = "//div[@class= 'modal-body clearfix']/descendant::div[@class= 'app-alert-message']") @CacheLookup WebElement txtAlert;
	public String getAlert() {
		if (txtAlert.isDisplayed() == true) {
			return txtAlert.getText();
		}
		return "[]";
	}
	
    public String gettxtproject() {
	    return txtproject.getText();
    }
    
    public void sapxepID() {
	     ID.click();
	     ID.click();
    }
    
    public String gettxttile() {
	    return
			    CFtitle.getText();
    }
    
     public String getClient() {
	 return
			CFClient.getText();
    }
     
    public String getStartdate() {
	   return
			CFStartdate.getText();
   }
    
   public String gettxtprice() {
	   return
			CFPrice.getText();
   }
   
   public String getDealine() {
	   return
			CFDealine.getText();
   }
}
