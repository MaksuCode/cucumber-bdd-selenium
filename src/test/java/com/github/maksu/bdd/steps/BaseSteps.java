package com.github.maksu.bdd.steps;

import com.github.maksu.bdd.drivermanager.BrowserType;
import com.github.maksu.bdd.drivermanager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseSteps extends DriverManager {

    @Before
    public static void setUp(){
        setUp(BrowserType.CHROME);
    }

    @After
    public static void tearDown(){
        quitDriver();
    }

}
