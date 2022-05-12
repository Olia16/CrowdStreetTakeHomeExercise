package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    @FindBy(xpath = "//a [@href=\"/invexp/accounts/create-account\" ]")
    public WebElement createAccountBtn;


}
