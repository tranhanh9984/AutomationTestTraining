package page.Rise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class ClientPage extends CommonPage {
	public ClientPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[@title = 'Add client']") @CacheLookup WebElement txtClickTaoClient;
	public void clickTaoClient() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", txtClickTaoClient);
	}
	
	@FindBy (id = "company_name") @CacheLookup WebElement txtCompanyName;
	@FindBy (xpath = "//label[contains(text(), 'Owner')]//parent::div//div/div") @CacheLookup WebElement Owner;
	@FindBy (xpath = "//input[@id='s2id_autogen3_search']") @CacheLookup WebElement txtOwner;  //ul[@id='select2-results-3452']//preceding-sibling::div/input
	@FindBy (id = "address") @CacheLookup WebElement txtAddress;
	@FindBy (id = "city") @CacheLookup WebElement txtCity;
	@FindBy (id = "state") @CacheLookup WebElement txtState;
	@FindBy (id = "zip") @CacheLookup WebElement txtZip;
	@FindBy (id = "country") @CacheLookup WebElement txtCountry;
	@FindBy (id = "phone") @CacheLookup WebElement txtPhone;
	@FindBy (id = "vat_number") @CacheLookup WebElement txtVAT;
	@FindBy (id = "gst_number") @CacheLookup WebElement txtGST;
	@FindBy (xpath = "//label[text() = 'Client groups']//parent::div//div/div") @CacheLookup WebElement Clientgroups;
	@FindBy (xpath = "//div[@id='s2id_group_ids']/ul/li/child::label//following-sibling::input") @CacheLookup WebElement txtClients;
	@FindBy (xpath = "//label[text() = 'Currency']//parent::div//div/div") @CacheLookup WebElement Currency;
	@FindBy (xpath = "//div[@id='select2-drop']/div/label//following-sibling::input") @CacheLookup WebElement txtCurrency;
	@FindBy (id = "currency_symbol") @CacheLookup WebElement txtCurrencySymbol;
	@FindBy (xpath = "//label[text() = 'Labels']//parent::div//div/div") @CacheLookup WebElement Labels;
	@FindBy (xpath = "//label[text() = 'Labels']//following-sibling::input") @CacheLookup WebElement txtLabels;
	@FindBy (id = "disable_online_payment") @CacheLookup WebElement Disableonlinepayment;
	@FindBy (xpath = "//a[text()='Clients']") @CacheLookup WebElement dsclient;
	@FindBy (xpath = "//th[contains(text(),'ID')]") @CacheLookup WebElement ID;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Name'])+1]") @CacheLookup WebElement CFName;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Name'])+3]") @CacheLookup WebElement CFPhone;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Name'])+4]/descendant::li") @CacheLookup WebElement CFClients;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Name'])+5]") @CacheLookup WebElement CFLabels;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Name'])+6]") @CacheLookup WebElement CFProject;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Name'])+7]") @CacheLookup WebElement CFTTinvoiced;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Name'])+8]") @CacheLookup WebElement CFPMReceived;
	@FindBy (xpath = "//tr[1]/td[count(//th[text()='Name'])+9]") @CacheLookup WebElement CFDue;
	
    public void clickOutside(WebElement WebElement) {
	    
	    Actions actions = new Actions(driver);

	    // Di chuyển chuột đến phần tử và sau đó di chuyển offset ra ngoài để click "bên ngoài"
	    actions.moveToElement(WebElement, -50, -50).click().build().perform();
	}
	public void dientencongty(String congty) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + congty + "';", txtCompanyName);
		clickOutside(txtCompanyName);
	}
	public void dienOwner(String owner) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Owner);	
//		js.executeScript("arguments[0].value='" + owner + "';", txtOwner);
		txtOwner.sendKeys(owner);
		js.executeScript("var e = new KeyboardEvent('keydown', {key: 'Enter', keyCode: 13, which: 13}); arguments[0].dispatchEvent(e);",txtOwner);
	}
	public void diendiachi(String diachi) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + diachi + "';", txtAddress);
	}
	public void dienthanhpho(String thanhpho) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + thanhpho + "';", txtCity);
	}
	public void dienstate(String state) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + state + "';", txtState);
	}
	public void dienzip(String zip) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + zip + "';", txtZip);
	}
	public void diendatnuoc(String country) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + country + "';", txtCountry);
	}
	public void diensdt(String phone) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + phone + "';", txtPhone);
	}
	public void dienVAT(String VAT) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + VAT + "';", txtVAT);
	}
	public void dienGST(String GST) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + GST + "';", txtGST);
	}
	public void dienClientgroups(String Clients) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Clientgroups);
		txtClients.sendKeys(Clients);
//		js.executeScript("arguments[0].value='" + Clients + "';", txtClients);
		js.executeScript("var e = new KeyboardEvent('keydown', {key: 'Enter', keyCode: 13, which: 13}); arguments[0].dispatchEvent(e);",txtClients);
	}
	public void dienCurrency(String currency) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Currency);
		txtCurrency.sendKeys(currency);
//		js.executeScript("arguments[0].value='" + currency + "';", txtCurrency);
		js.executeScript("var e = new KeyboardEvent('keydown', {key: 'Enter', keyCode: 13, which: 13}); arguments[0].dispatchEvent(e);",txtCurrency);
	}
	public void dienCurrencySymbol(String CurrencySymbol) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + CurrencySymbol + "';", txtCurrencySymbol);
	}
	public void dienLabels(String label) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Labels);
		txtLabels.sendKeys(label);
//		js.executeScript("arguments[0].value='" + label + "';", txtLabels);
		js.executeScript("var e = new KeyboardEvent('keydown', {key: 'Enter', keyCode: 13, which: 13}); arguments[0].dispatchEvent(e);",txtLabels);
	}
	public void tickdisable() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Disableonlinepayment);
	}

	@FindBy (xpath = "//button[@type= 'submit']") @CacheLookup WebElement txtClickSave;
	public void clickSave() {
		txtClickSave.click();
	}
	public void clickdsclient() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dsclient);
	}
	public void clickID() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ID);
	}
	 public String gettxtName() {
		    return
		    		CFName.getText();
	    }
	 public String gettxtphone() {
		    return
		    		CFPhone.getText();
	    }
	 public String gettxtClient() {
		    return
		    		CFClients.getText();
	    }
	 public String gettxtCFLabels() {
		    return
		    		CFLabels.getText();
	    }
	 public String gettxtCFProject() {
		    return
		    		CFProject.getText();
	    }
	 public String gettxtCFTTinvoiced() {
		    return
		    		CFTTinvoiced.getText();
	    }
	 public String gettxtCFPMReceived() {
		    return
		    		CFPMReceived.getText();
	    }
	 public String gettxtCCFDue() {
		    return
		    		CFDue.getText();
	    }
	 @FindBy (xpath = "//span[@id= 'company_name-error']") @CacheLookup WebElement txtNameError;
		public String getNameError() {
			return txtNameError.getText();
		}
		
	 @FindBy (xpath = "//div[@class= 'modal-body clearfix']/descendant::div[@class= 'app-alert-message']") @CacheLookup WebElement txtAlert;
		public String getAlert() {
			if (txtAlert.isDisplayed() == true) {
				return txtAlert.getText();
			}
			return "[]";
		}	
		
	 @FindBy (xpath = "//button[@type= 'submit']/preceding-sibling::button[contains (text() , 'Close')]") @CacheLookup WebElement txtClickClose;
		public void clickClose() {
			txtClickClose.click();
		}
	 @FindBy (xpath = "//div[@id = 'select2-drop']/descendant::li") @CacheLookup WebElement txtNoMatchFound;
		public String getNoMatchFound() {
			return txtNoMatchFound.getText();
		}	
	
}
