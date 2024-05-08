package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TeachersPage {
    public TeachersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[text()='Teachers']")
    public WebElement teachersTab;
    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[1]")
    public WebElement threeDots;
    @FindBy(xpath = "//li[text()='Edit']")
    public WebElement editButton;
    @FindBy(css = "input[name='name']")
    public WebElement editTeacherName;
    @FindBy(css = "input[name='lastName']")
    public WebElement editTeacherLastname;
    @FindBy(css = "input[name='phoneNumber']")
    public WebElement editTeacherPhoneNumber;
    @FindBy(css = "input[name='email']")
    public WebElement editTeacherEmail;
    @FindBy(css = "input[name='specialization']")
    public WebElement editTeacherSpecialization;
    @FindBy(xpath = "//label[text()='Choose courses']")
    public WebElement editTeacherCourses;
    @FindBy(xpath = "//li[text()='SDET - TEST 1']")
    public WebElement sdetTest1;
    @FindBy(xpath = "//li[text()='Jira group 1']")
    public WebElement jiraGroup1;
    @FindBy(xpath = "//li[text()='test Case 1']")
    public WebElement testCase1;
    @FindBy(xpath = "//li[text()='Test1 ']")
    public WebElement test1;
    @FindBy(xpath = "//li[text()='Java Batch 1']")
    public WebElement javaBatch1;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;
    @FindBy(xpath = "(//li[text()='Delete'])[1]")
    public WebElement threeDotsDeleteButton;
    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement deleteButton;
    @FindBy(xpath = "//p[text()='User with the same email already exists']")
    public WebElement warningText;

}