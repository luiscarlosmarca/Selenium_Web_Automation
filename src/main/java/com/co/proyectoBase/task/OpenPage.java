package com.co.proyectoBase.task;

import com.co.proyectoBase.utils.MyWebDriverFactory;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenPage implements Task {

    String url;
    public OpenPage(String url) {
        this.url = url;
    }
    public static OpenPage openPage(String url) {
        return instrumented(OpenPage.class, url);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.can(BrowseTheWeb.with(MyWebDriverFactory.web().
                onPage(url)));
    }
}
