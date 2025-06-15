package autotest.pages.rise;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonPage;

public class ProjectPage extends CommonPage {

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    By menuText(String text) {
        return By.xpath("//span[@class='menu-text ' and text()='" + text + "']");
    }

    By addProjectLink = By.linkText("Add project");

    By titleInput = By.id("title");
    By descriptionArea = By.className("note-editable");
    By descriptionClick = By.id("description");

    By startDateInput = By.id("start_date");
    By deadlineInput = By.id("deadline");
    By priceInput = By.id("price");
    By labelInput = By.xpath("//label[text()='Labels']/following-sibling::input");

    By submitBtn = By.xpath("//button[@type='submit']");
    By searchBox = By.xpath("//input[@type='search']");

    By editBtn = By.xpath("(//a[@class='edit'])[1]");
    By deleteBtn = By.xpath("(//a[@class='delete'])[1]");
    By confirmDeleteBtn = By.id("confirmDeleteButton");

    By emptyRow = By.xpath("//td[contains(@class, 'dataTables_empty')]");
    By firstRowTitle = By.xpath("//table[@id='project-table']/tbody/tr[1]/td[2]");

    public void clickMenu(String menu) {
        driver.findElement(menuText(menu)).click();
    }

    public void clickAddProject() {
        driver.findElement(addProjectLink).click();
    }

    public void fillProjectForm(Map<String, String> data) {
        driver.findElement(titleInput).sendKeys(data.get("title"));
        driver.findElement(descriptionClick).click();
        driver.findElement(descriptionArea).sendKeys(data.get("description"));
        driver.findElement(startDateInput).sendKeys(data.get("start_date"));
        driver.findElement(deadlineInput).sendKeys(data.get("deadline"));
        driver.findElement(priceInput).sendKeys(data.get("price"));

        driver.findElement(labelInput).click();
        driver.findElement(labelInput).sendKeys(data.get("label"));
        driver.findElement(labelInput).sendKeys(Keys.ENTER);
        pause(5);
    }

    public void submitForm() {
        driver.findElement(submitBtn).click();
    }

    public void searchProject(String projectName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(projectName, Keys.ENTER);
        pause(5);
    }

    public void editProject(String newPrice) {
        driver.findElement(editBtn).click();
        driver.findElement(priceInput).clear();
        driver.findElement(priceInput).sendKeys(newPrice);
        submitForm();
        pause(5);
    }

    public void deleteProject() {
        driver.findElement(deleteBtn).click();
        pause(3);
        driver.findElement(confirmDeleteBtn).click();
        pause(3);
    }

    public void deleteAllProjectsByName(String name) {
        clickMenu("Projects");
        pause(2);
        searchProject(name);
        pause(2);

        while (true) {
            if (driver.findElements(emptyRow).size() > 0) {
                break;
            }
            deleteProject();
            searchProject(name);
            pause(2);
        }
    }
}
