package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPage {

    public CommonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[text()='Administrator']/..")
    public WebElement administratorButton;

    @FindBy(xpath = "//li[text()='Log out']/../..")
    public WebElement logOutButton;

    @FindBy(xpath = "//button[text()='Log out']")
    public WebElement logOutConfirmationButton;

    @FindBy(xpath = "//*[text()='Courses']")
    public WebElement  coursesTab;

    @FindBy(xpath = "//li[text()='Groups']")
    public WebElement groupsTab;

}
