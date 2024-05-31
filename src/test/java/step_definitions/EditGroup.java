package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pages.GroupsPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class EditGroup {
    WebDriver driver = Driver.getDriver();
    GroupsPage groupsPage = new GroupsPage();
    CommonPage commonPage = new CommonPage();
    String text;
    @Then("Admin clicks Groups button")
    public void admin_clicks_groups_button() {
       commonPage.groupsTab.click();
    }
    @Then("Admin sees list of groups in the platform.")
    public void admin_sees_list_of_groups_in_the_platform() {
        List<WebElement> groups = driver.findElements(By.xpath("//div[@class='MuiPopover-root " +
                "MuiModal-root MuiModal-hidden css-jpt4u3']"));
        int size = groups.size();
        Assert.assertEquals(10,size);
    }
    @Then("Admin finds the group")
    public void admin_finds_the_group() {

    }
    @Then("Admin clicks on three dots\\(more options)")
    public void admin_clicks_on_three_dots_more_options() {
       groupsPage.threeDots.click();
    }
    @And(("Admin clicks on edit button."))
    public void admin_clicks_on_edit_button(){
        groupsPage.editButton1.click();
        SeleniumUtils.waitForSeconds(3);
    }
    @Then("Admin fills-out the form by providing:\\(group name)")
    public void admin_fills_out_the_form_by_providing_group_name() {
        Actions actions = new Actions(driver);
        actions.keyDown(groupsPage.groupNameInput, Keys.COMMAND).sendKeys("a");
        actions.keyUp(groupsPage.groupNameInput, Keys.COMMAND);
        actions.keyDown(groupsPage.groupNameInput, Keys.BACK_SPACE);
        actions.keyUp(groupsPage.groupNameInput, Keys.BACK_SPACE);
        actions.build().perform();
        Faker faker = new Faker();
        text = faker.name().title();
        groupsPage.groupNameInput.sendKeys(text);
    }
    @Then("Admin clicks on save button.")
    public void admin_clicks_on_save_button() {
        SeleniumUtils.waitForSeconds(3);
        groupsPage.saveButton.click();
    }
    @Then("Admin must see the edited group in the groups list.")
    public void admin_must_see_the_edited_group_in_the_groups_list() {
        WebElement confirmation = driver.findElement(By.xpath("//div[text()='"+text+"']"));
        Assert.assertEquals(confirmation.getText(),text);
    }

}
