package step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pages.CoursesPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.SeleniumUtils;

public class DeleteCourse {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    CoursesPage deleteCourseTests = new CoursesPage();
    CommonPage commonPage = new CommonPage();

    @Given("given Studymate")
    public void admin_navigates_to_studymate() {
        driver.get("https://codewise.studymate.us/login");

    }
    @When("Admin logins by providing user name and password.")
    public void admin_logins_by_providing_correct_user_name_and_password() {
        loginPage.logIn("Admin@codewise.com", "codewise123");
    }

    @When("In course section choose batch5 and click on the delete button")
    public void in_course_section_choose_batch5_and_click_on_the_delete_button() {
        deleteCourseTests.courses1.click();
        deleteCourseTests.editMenuButton.click();
        deleteCourseTests.delete1.click();
        deleteCourseTests.confirmDelete1.click();

    }

    @Then("After making your changes, click on the save button.")
    public void after_making_your_changes_click_on_the_save_button_to_save_your_changes() {
        SeleniumUtils.waitForSeconds(3);
        Assert.assertTrue(deleteCourseTests.popUpWindow.isDisplayed());
        deleteCourseTests.trash.click();
        SeleniumUtils.waitForSeconds(3);
        boolean isElementFound = false;
        for (WebElement element : deleteCourseTests.listOfElements) {
            if (element.getText().contains("batch5")){
                isElementFound = true;
                System.out.println(isElementFound);
                break;
            }
        }
        Assert.assertTrue(isElementFound);


        commonPage.administratorButton.click();
        commonPage.logOutButton.click();
        commonPage.logOutConfirmationButton.click();
    }
}
