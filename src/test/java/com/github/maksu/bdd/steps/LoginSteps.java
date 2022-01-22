package com.github.maksu.bdd.steps;

import com.github.maksu.bdd.drivermanager.DriverManager;
import com.github.maksu.bdd.model.User;
import com.github.maksu.bdd.pages.HomePage;
import com.github.maksu.bdd.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginSteps extends DriverManager {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    User Mustafa = BackgroundSteps.getMustafa();

    @When("Mustafa logs in with his valid credentials")
    public void mustafaLogsInWithHisValidCredentials() {
        homePage.navigationBar().navigateToLogin();
        loginPage.loginWithUser(Mustafa);
    }

    @Then("He should be directed to home page")
    public void heShouldBeDirectedToHomePage() {
        Assertions.assertTrue(homePage.titleContains("Amazon.com.tr"), "Not on home page!");
    }

    @And("He should see his name on the navigation bar")
    public void heShouldSeeHisNameOnTheNavigationBar() {
        Assertions.assertEquals(Mustafa.getName(), homePage.navigationBar().getUserName(), "User name is not displayed on nav bar!");
    }

    @When("Mustafa tries to log in in with invalid credentials")
    public void mustafaTriesToLoginInWithInvalidCredentials() {
        Mustafa.setPassword("admin123");
        homePage.navigationBar().navigateToLogin();
        loginPage.loginWithUser(Mustafa);
    }

    @Then("He could not log in")
    public void heCouldNotLogIn() {
        Assertions.assertTrue(loginPage.isAlertPresent(), "Alert is not showed to client!");
        Assertions.assertTrue(loginPage.titleContains("Amazon Giriş Yap"), "Client is not on login page!");
    }

    @But("He should not see log in button on the navigation bar")
    public void heShouldNotSeeLogInButtonOnTheNavigationBar() {
        Assertions.assertFalse(homePage.navigationBar().isLoginButtonPresent(), "Login button is still on page!");
    }
}
