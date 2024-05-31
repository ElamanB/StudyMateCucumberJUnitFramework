package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.GroupsPage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtils;
import utilities.TestContext;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateGroup {

    static WebDriver driver;
    GroupsPage groupsPage = new GroupsPage();
    CommonPage commonPage = new CommonPage();
    WebDriverWait wait;

    Faker faker = new Faker();
    TestContext context = new TestContext();

    @Given("user Logged in on studymate.com")
    public void user_logged_in_on_studymate_com() {
        driver = Driver.getDriver();
        driver.get(Config.getProperty("studyMateURL"));
        LoginPage loginPage = new LoginPage();
        loginPage.languageDropdown.click();
        loginPage.englishLanguage.click();
        loginPage.emailInputField.sendKeys(Config.getProperty("studyMateEmail"));
        loginPage.passwordInputField.sendKeys(Config.getProperty("studyMatePassword"));
        loginPage.loginButton.click();
    }

    @Given("user navigates to the Groups Page")
    public void user_navigates_to_the_groups_page() {
        commonPage.groupsTab.click();
    }

    @When("user clicks on create group button")
    public void user_clicks_on_create_group_button() {
        groupsPage.createGroupButton.click();
    }

    @Then("verify that a popUp window appears")
    public void verify_that_a_popup_window_appears() {
        Assert.assertTrue(groupsPage.popUpGroupWindow.isDisplayed());
    }

    @When("user enters Group name")
    public void user_enters_group_name() {
        String groupName = faker.lorem().word();
        context.setGroupName(groupName);
        groupsPage.groupNameInput.sendKeys(groupName);
    }

    @When("user enters Date of creation")
    public void user_enters_date_of_creation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String creationDate = LocalDate.now().format(formatter);
        context.setCreationDate(creationDate);
        groupsPage.creationDateInput.sendKeys(creationDate);
    }

    @When("user enters Description")
    public void user_enters_description() {
        String description = faker.lorem().sentence();
        context.setDescription(description);
        groupsPage.descriptionInput.sendKeys(description);
    }

    @When("user provides Group Photo")
    public void user_provides_group_photo() throws AWTException {
        groupsPage.groupImage.click();
        SeleniumUtils.waitForSeconds(2);

        String filePath = "C:\\Users\\Elaman\\OneDrive\\Desktop\\Screenshots\\GroupPhoto.png";

        // Copy the file path to the clipboard
        StringSelection filePathSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);

        // Paste the file path using Robot
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter to close the file upload dialog
        r.setAutoDelay(2000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }

    @When("user clicks on Create button")
    public void user_clicks_on_create_button() {
        groupsPage.createButton.click();
    }

    @Then("verify that an alert message {string} is displayed")
    public void verify_that_an_alert_message_is_displayed(String alertMessage) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(groupsPage.groupSuccessfullySavedAlert));

        Assert.assertTrue(groupsPage.groupSuccessfullySavedAlert.isDisplayed());
        Assert.assertTrue(groupsPage.groupSuccessfullySavedAlert.getText().contains(alertMessage));
        wait.until(ExpectedConditions.invisibilityOf(groupsPage.groupSuccessfullySavedAlert));
    }

    @Then("verify that a group with the specified name exists on the Groups Page")
    public void verify_that_a_group_with_the_specified_name_exists_on_the_groups_page() {
        SeleniumUtils.waitForSeconds(2);
        Assert.assertTrue(groupsPage.listOfGroups.get(0).getText().contains(context.getGroupName()));
    }

    @Then("verify that the cancel button is displayed")
    public void verify_that_the_cancel_button_is_displayed() {
        Assert.assertTrue(groupsPage.cancelButton.isDisplayed());
    }

    @Then("user clicks on Cancel button")
    public void user_clicks_on_cancel_button() {
        groupsPage.cancelButton.click();
    }

    @Then("verify that a popUp window disappears")
    public void verify_that_a_popup_window_disappears() {
        Assert.assertFalse(groupsPage.popUpGroupWindow.isDisplayed());
    }

    @When("user enters Group name which is already exists")
    public void user_enters_group_name_which_is_already_exists() {
        String existingName = groupsPage.listOfGroupNames.getFirst().getText();
        groupsPage.groupNameInput.sendKeys(existingName);
    }

    @Then("verify that an error alert message {string} is displayed")
    public void verify_that_an_error_alert_message_is_displayed(String string) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(groupsPage.titleAlreadyExistsAlert));
        Assert.assertTrue(groupsPage.titleAlreadyExistsAlert.isDisplayed());
        wait.until(ExpectedConditions.invisibilityOf(groupsPage.titleAlreadyExistsAlert));
    }

    @Then("the user logs out")
    public void the_user_logs_out() {
        commonPage.administratorButton.click();
        commonPage.logOutButton.click();
        commonPage.logOutConfirmationButton.click();
        driver.manage().deleteAllCookies();
    }

    @Then("verify that a group with the specified name does not exists on the Groups Page")
    public void verify_that_a_group_with_the_specified_name_does_not_exists_on_the_groups_page() {
        SeleniumUtils.waitForSeconds(2);
        Assert.assertFalse(groupsPage.listOfGroups.get(0).getText().contains(context.getGroupName()));
    }
}
