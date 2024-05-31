package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.TeachersPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;
import java.util.List;

public class EditTeacher {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    TeachersPage teachersPage = new TeachersPage();
    String phoneNumber;
    @Given("Studymate.com")
    public void studymate_com() {
    driver.get("https://codewise.studymate.us/login");
    }
    @When("Admin logins by providing right credential.")
    public void admin_logins_by_providing_right_credentials() {
        loginPage.logIn("admin@codewise.com","codewise123");
    }
    @Then("Admin sees main page.")
    public void admin_sees_main_page() {
       String mainPageUrl = "https://codewise.studymate.us/admin/groups?size=10&page=1";
        SeleniumUtils.waitForSeconds(3);
        Assert.assertEquals(driver.getCurrentUrl(),mainPageUrl);
    }
    @Then("Admin clicks Teachers button")
    public void admin_clicks_teachers_button() {
       teachersPage.teachersTab.click();
    }
    @Then("sees list of teachers in the platform.")
    public void sees_list_of_teachers_in_the_platform() {
        List<WebElement> teachers = driver.findElements(By.xpath("//tr[@class='MuiTableRow-root css-1ipg9de']"));
        Assert.assertEquals(teachers.size(),10);
    }
    @Then("Admin finds the teacher that they created")
    public void admin_finds_the_teacher_that_they_created() {

    }
    @Then("Admin finds the given teacher")
    public void admin_finds_the_given_teacher() {

    }
    @Then("Admin clicks on three dots \\(more options)")
    public void user_clicks_on_three_dots_more_options() {
        teachersPage.threeDots.click();
    }
    @Then("user clicks on edit button.")
    public void admin_clicks_on_edit_button() {
        teachersPage.editButton.click();
    }
    @Then("Admin sees fill-out form")
    public void admin_sees_fill_out_form() {

    }
    @Then("Admin edits the form by changing phone number to a different phone number")
    public void admin_edits_the_form_by_changing_first_name_to_a_different_first_name() {
        Actions actions = new Actions(driver);
        actions.keyDown(teachersPage.editTeacherPhoneNumber, Keys.COMMAND).sendKeys("a");
        actions.keyUp(teachersPage.editTeacherPhoneNumber, Keys.COMMAND);
        actions.keyDown(teachersPage.editTeacherPhoneNumber, Keys.BACK_SPACE);
        actions.keyUp(teachersPage.editTeacherPhoneNumber, Keys.BACK_SPACE);
        actions.build().perform();
        Faker faker = new Faker();
        String a1 = faker.number().digits(3);
        String a2 = faker.number().digits(3);
        String a3 = faker.number().digits(4);
        phoneNumber = a1+" "+a2+" "+a3;
        teachersPage.editTeacherPhoneNumber.sendKeys(phoneNumber);
    }
    @Then("user clicks on save button.")
    public void user_clicks_on_save_button() {
        teachersPage.saveButton.click();
    }
    @Then("Admin see the changed phone number in the list.")
    public void admin_see_the_changed_first_name_in_the_list() {
        WebElement confirmation = driver.findElement(By.xpath("//td[text()='+1 "+phoneNumber+"']"));
        phoneNumber = "+1"+" "+phoneNumber;
        Assert.assertEquals(confirmation.getText(),phoneNumber);
    }
}
