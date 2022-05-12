package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends  BasePage{

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(id = "hasAgreedTos")
    public WebElement hasAgreeBtn;

    @FindBy(xpath = "//div[@role='presentation']")
    public WebElement captchaBtn;

    @FindBy(id = "accreditedYes")
    public WebElement accreditedBtn;

    @FindBy(xpath = "//button[@data-testid='submit-button']")
    public WebElement submitBtn;

}
