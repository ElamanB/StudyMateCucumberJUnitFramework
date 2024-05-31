package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class GroupsPage {

    public GroupsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//h2/following-sibling::button")
    public WebElement createGroupButton;

    @FindBy(css = "input[name='name']")
    public WebElement groupNameInput;

    @FindBy(name = "dateOfFinish")
    public WebElement creationDateInput;

    @FindBy(css = "textarea[name='description']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement createButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='css-1qf1rpk']/div")
    public List<WebElement> listOfGroups;

    @FindBy(xpath = "//div[@class='css-1qf1rpk']/div/div/div/div")
    public List<WebElement> listOfGroupNames;

    @FindBy(xpath = "//img[@alt='there should be a photo here']")
    public WebElement groupImage;


    @FindBy(id = "modal")
    public WebElement popUpGroupWindow;

    @FindBy(xpath = "//div[text()='Group one!']")
    public WebElement newCreatedGroup;


    @FindBy(xpath = "//p[text()='Group successfully saved']")
    public WebElement groupSuccessfullySavedAlert;

    @FindBy(xpath = "//p[text()='A group with the same title already exists']")
    public WebElement titleAlreadyExistsAlert;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[1]")
    public WebElement threeDots;
    @FindBy(xpath = "(//li[text()='Edit group'])[1]")
    public WebElement editButton1;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "(//li[text()='Delete group'])[1]")
    public WebElement deleteGroupThreeDots;
    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement deleteButton;
    @FindBy(xpath = "//p[text()='A group with the same title already exists']")
    public WebElement warningText;
    @FindBy(xpath = "(//div[@class='MuiTypography-root MuiTypography-h5" +
            " MuiTypography-gutterBottom sc-dwnOUR gaIZVK css-1i17kim'])[1]")
    public WebElement firstGroupText;






}
