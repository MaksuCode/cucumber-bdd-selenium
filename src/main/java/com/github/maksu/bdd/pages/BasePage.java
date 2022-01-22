package com.github.maksu.bdd.pages;

import com.github.maksu.bdd.drivermanager.DriverManager;
import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends DriverManager {

    NavigationBar navigationBar;
    Actions action;

    public BasePage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(driver), this);
        this.action = new Actions(driver);
    }

    public NavigationBar navigationBar(){
        this.navigationBar = new NavigationBar();
        return this.navigationBar;
    }

    protected void click(WebElement element){
        element.click();
    }

    protected void type(WebElement element, String text){
        element.sendKeys(text);
    }

    protected void hoverOver(WebElement element){
        action.moveToElement(element).perform();
    }

    public boolean isPresent(WebElement element){
        try {
            element.getText();
            return true;
        }catch (NoSuchElementException noSuchElementException){
            return false;
        }
    }
    
    private String getTitle(){
        return driver.getTitle();
    }

    public boolean titleContains(String text){
        return getTitle().contains(text);
    }

    public String getText(WebElement element){
        return element.getText();
    }


}
