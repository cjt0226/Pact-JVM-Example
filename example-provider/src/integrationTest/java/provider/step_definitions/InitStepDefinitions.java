package provider.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java8.En;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class InitStepDefinitions extends BaseSteps implements En {
    EnvironmentVariables environmentVariables;
    @Before
    public void setTheStage(){
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("http://localhost:8080");
        OnStage.setTheStage(Cast.whereEveryoneCan(
                CallAnApi.at(theRestApiBaseUrl)
        ));

    }
    @After
    public void clearStage() {
        OnStage.drawTheCurtain();
    }
}
