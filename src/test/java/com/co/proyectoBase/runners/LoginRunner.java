package com.co.proyectoBase.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = "com.co.mentu.stepdefinitions",
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class LoginRunner {
}
