package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TrashPage {

    public TrashPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
