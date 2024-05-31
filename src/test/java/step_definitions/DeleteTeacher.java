package step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.TeachersPage;
import utilities.Driver;

import java.util.List;

public class DeleteTeacher {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    TeachersPage teachersPage = new TeachersPage();
    @When("Admin logins by providing right credentials.")
    public void admin_logins_by_providing_right_credentials() {
        loginPage.logIn("admin@codewise.com","codewise123");
    }
    @Then("Admin sees list of teachers in the platform.")
    public void admin_sees_list_of_teachers_in_the_platform() {
        List<WebElement> teachers = driver.findElements(By.xpath("//tr[@class='MuiTableRow-root css-1ipg9de']"));
        Assert.assertEquals(teachers.size(),10);
    }
    @Then("Admin clicks three dots\\( more options)")
    public void admin_clicks_three_dots_more_options() {
       teachersPage.threeDots.click();
    }
    @Then("Admin clicks on delete button.")
    public void admin_clicks_on_delete_button() {
       teachersPage.threeDotsDeleteButton.click();
       teachersPage.deleteButton.click();
    }
    @Then("Admin must not see the deleted teacher in the list.")
    public void admin_must_not_see_the_deleted_teacher_in_the_list() {
      WebElement confirmation = driver.findElement(By.xpath("(//td[@class='MuiTableCell-root MuiTableCell-body " +
              "MuiTableCell-alignLeft MuiTableCell-sizeMedium css-q34dxg'])[3]"));
      String text = confirmation.getText();
      Assert.assertNotEquals(text,"Yryskeldi s1");

    }

}
