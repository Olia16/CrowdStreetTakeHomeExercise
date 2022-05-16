package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.util.converter.LocalDateStringConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreateAccountPage;
import pages.LoginPage;
import utils.ConfigurationReader;
import utils.Driver;

import java.time.LocalDate;
import java.util.Locale;

public class CreateAccountStepDefs {

    LoginPage loginPage = new LoginPage();
    CreateAccountPage accountPage = new CreateAccountPage();
    Faker faker = new Faker();



    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("crowdstreet.url"));


    }
    @When("User clicks Create an Account button")
    public void userClicksCreateAnAccountButton() {
        loginPage.createAccountBtn.click();
    }

    @Then("User is taken to new page where has to enter First Name")
    public void userIsTakenToNewPageWhereHasToEnterFirstName() {
        accountPage.firstNameField.sendKeys(faker.name().firstName());
    }
    @And("User has to enter Last Name")
    public void userHasToEnterLastName() {
        accountPage.lastNameField.sendKeys(faker.name().lastName());
    }

    @And("User has to enter email")
    public void userHasToEnterEmail() {
        accountPage.emailField.sendKeys(faker.name().username() + "@gmail.com");
    }

    @And("User has to enter password")
    public void userHasToEnterPassword() {
        accountPage.passwordField.sendKeys("Password@" + LocalDate.now());
    }

    @Then("User needs to confirm password")
    public void user_needs_to_confirm_password() {
        accountPage.confirmPasswordField.sendKeys("Password@" + LocalDate.now());

    }
    @Then("User has to accept terms and conditions by clicking on the button")
    public void user_has_to_accept_terms_and_conditions_by_clicking_on_the_button() {
        accountPage.hasAgreeBtn.click();

    }

    @And("User needs to answer if he is accredited investor")
    public void userNeedsToAnswerIfHeIsAccreditedInvestor() {
        accountPage.accreditedBtn.click();

    }

    @And("User needs to click ok on captcha")
    public void userNeedsToClickOkOnCaptcha() {

        new WebDriverWait(Driver.getDriver(), 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));
        new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(accountPage.captchaBtn));
        accountPage.captchaBtn.click();



    }

    @Then("User has to click create account button")
    public void user_has_to_click_create_account_button() throws InterruptedException {
        Driver.getDriver().switchTo().parentFrame();
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,780)");


        new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(accountPage.createAccountBtn));
        js.executeScript("arguments[0].click();", accountPage.createAccountBtn);




    }


}
