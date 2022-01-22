package com.github.maksu.bdd.pages;

import com.github.maksu.bdd.model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "ap_password")
    private WebElement passwordInput;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    @FindBy(css = "span.a-list-item")
    private WebElement alertMessage;

    public void loginWithUser(User user){
        String email = user.getEmail();
        String password = user.getPassword();

        type(emailInput, email);
        click(continueButton);
        type(passwordInput, password);
        click(signInButton);

        if (!password.equalsIgnoreCase("admin123")){
            wait.until(ExpectedConditions.titleContains("Amazon.com.tr"));
        }

    }

    public boolean isAlertPresent(){
        return getText(alertMessage).contains("Şifreniz yanlış");
    }



}
