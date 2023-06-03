package com.co.proyectoBase.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class setupConfiguration {

    public static Actor User = Actor.named("User");


    public WebDriver hisBrowser;

    @Before
    public void setUp() {
        User= Actor.named("User").can(BrowseTheWeb.with(hisBrowser));
        OnStage.setTheStage(new OnlineCast());
    }

}
