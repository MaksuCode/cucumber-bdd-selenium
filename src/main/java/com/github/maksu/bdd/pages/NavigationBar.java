package com.github.maksu.bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends BasePage{

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement loginSection;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement nameOnNavBar;

    @FindBy(css = "span.nav-action-inner")
    private WebElement loginButton;


    public void navigateToLogin() {
        click(loginSection);
    }

    public String getUserName() {
        return getText(nameOnNavBar);
    }

    public boolean isLoginButtonPresent(){
        hoverOver(loginSection);
        return isPresent(loginButton);
    }

}

