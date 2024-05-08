package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "email")
    public WebElement emailInputField;

    @FindBy(name = "password")
    public WebElement passwordInputField;

    @FindBy(xpath = "//button[@type='button']//following-sibling::button")
    public WebElement loginButton;

    @FindBy(id = "mui-component-select-language")
    public WebElement languageDropdown;

    @FindBy(css = "li[data-value=en]")
    public WebElement englishLanguage;

    public void logIn(String email, String password) {

        languageDropdown.click();
        englishLanguage.click();

        emailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);

        loginButton.click();
    }


}
