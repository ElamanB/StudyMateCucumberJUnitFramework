package step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pages.CoursesPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.SeleniumUtils;

public class EditCourse {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    //CoursesPage deleteCourseTests = new CoursesPage();
    CoursesPage editCoursePage = new CoursesPage();
    CommonPage commonPage = new CommonPage();
    Actions action = new Actions(driver);

    @Given("Admin navigates to Studymate")
    public void admin_navigates_to_studymate() {
       driver.get("https://codewise.studymate.us/login");
    }
    @When("Admin logins by providing correct user name and password.")
    public void admin_logins_by_providing_correct_user_name_and_password() {
        loginPage.logIn("Admin@codewise.com", "codewise123");
    }
    @When("Admin clicks Course button, then sees list of course in the platform.")
    public void admin_clicks_course_button_then_sees_list_of_course_in_the_platform() {
        commonPage.coursesTab.click();
    }
    @When("In course section choose batch5 course and click on the Edit button")
    public void in_course_section_choose_batch5_course_and_click_on_the_button() {
        editCoursePage.editMenuButton.click();
        editCoursePage.editButton.click();
    }
    @When("Admin changes course name to {string}")
    public void admin_changes_course_name_to(String name) {
        action.keyDown(editCoursePage.editCourseName, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
        action.keyDown(editCoursePage.editCourseName,Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
        action.perform();
        editCoursePage.editCourseName.sendKeys(name);
    }
    @When("Admin changes course description to {string}")
    public void admin_changes_course_description_to(String description) {
        action.keyDown(editCoursePage.editDescription, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
        action.keyDown(editCoursePage.editDescription,Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
        action.perform();
        editCoursePage.editDescription.sendKeys("course");
    }
    @When("Admin put the date to the course date {string}")
    public void admin_put_the_date_to_the_course_date(String string) {
        action.keyDown(editCoursePage.editDate, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
        action.keyDown(editCoursePage.editDate,Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
        action.perform();
        editCoursePage.editDate.sendKeys("12042024");
        editCoursePage.saveButton.click();
    }
    @When("In course section choose Jira… course and click on the save button")
    public void in_course_section_choose_jira_course_and_click_on_the_button() {
        Assert.assertTrue(editCoursePage.popUp.isDisplayed());
    }
    @Then("After making your changes, click on the Save button to save your modifications.")
    public void after_making_your_changes_click_on_the_save_button_to_save_your_modifications() {
        SeleniumUtils.waitForSeconds(5);
        commonPage.administratorButton.click();
        commonPage.logOutButton.click();
        commonPage.logOutConfirmationButton.click();
    }

}

