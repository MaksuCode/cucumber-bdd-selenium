package com.github.maksu.bdd.steps;

import com.github.maksu.bdd.drivermanager.DriverManager;
import com.github.maksu.bdd.model.User;
import io.cucumber.java.en.Given;

public class BackgroundSteps extends DriverManager {

    static User Mustafa;

    @Given("Mustafa has an account on Amazon")
    public void mustafaHasAnAccountOnAmazon() {
        Mustafa = new User("Mustafa","mustafaksu43333@gmail.com", "****");
    }

    @Given("Mustafa is on home page")
    public void mustafaIsOnHomePage() {
        driver.get("https://www.amazon.com.tr/");
    }

    protected static User getMustafa(){
        return Mustafa ;
    }

}
