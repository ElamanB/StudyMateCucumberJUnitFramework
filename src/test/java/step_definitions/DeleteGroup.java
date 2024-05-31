package step_definitions;

import io.cucumber.java.en.*;
import pages.CommonPage;
import pages.GroupsPage;

public class DeleteGroup {
    GroupsPage groupsPage = new GroupsPage();
    CommonPage commonPage = new CommonPage();
    @Then("Admin clicks Groups button.")
    public void admin_clicks_groups_button() {
       commonPage.groupsTab.click();
    }
    @Then("Admin clicks delete button to delete  the group from the platform.")
    public void admin_clicks_delete_button_to_delete_the_group_from_the_platform() {
       groupsPage.deleteGroupThreeDots.click();
       groupsPage.deleteButton.click();
    }
    @Then("Admin  must not  see the deleted group in the groups list.")
    public void admin_must_not_see_the_deleted_group_in_the_groups_list() {

    }
}
