package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CoursesPage {

    public CoursesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[text()='Courses']")
    public WebElement courses;

    //Syimyk's task delete courses
    @FindBy(xpath = "//*[text()='Courses']")
    public WebElement courses1;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[2]")
    public WebElement editMenuButton;

    @FindBy(xpath = "(//*[text()='Delete'])[2]")
    public WebElement delete1;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeMedium MuiButton-containedSizeMedium sc-eKJbhj iZsItr css-fab8xs']")
    public WebElement confirmDelete1;

    @FindBy(xpath = "//*[text()='Trash']")
    public WebElement trash;

    @FindBy(xpath = "//tbody[@class='MuiTableBody-root css-1xnox0e']/tr")
    public List<WebElement> listOfElements;
    @FindBy(xpath = "//p[@class='sc-dkrFOg hbyUzQ']")
    public WebElement popUpWindow;

    //Syimyk's task2 edit course
    @FindBy(xpath = "(//*[text()='Edit'])[2]")
    public WebElement editButton;

    @FindBy(name = "courseName")
    public WebElement editCourseName;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement editDescription;

    @FindBy(name = "dateOfFinish")
    public WebElement editDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement popUp;

    @FindBy(xpath = "//button[text()='Create course']")
    public WebElement createCourse;

    @FindBy(name = "courseName")
    public WebElement courseName;

    @FindBy(xpath = "//*[@name='dateOfFinish']")
    public WebElement date;

    @FindBy(css = "textarea[name='description']")
    public WebElement description;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement create;

    @FindBy(xpath = "//div[@class='css-1qf1rpk']/div")
    public List<WebElement> listOfCourses;

    @FindBy(xpath = "//p[text()='The course successfully created']")
    public WebElement courseSuccessfullySavedAlert;
    @FindBy(xpath = "//p[text()='Course with the same title already exists']")
    public WebElement courseAlreadyExistsAlert;



}
