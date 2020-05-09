package provider.step_definitions;

import com.google.common.collect.ImmutableMap;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.screenplay.actors.OnStage;
import provider.Verify.VerifyGetInformation;
import provider.tasks.GetInformation;

import java.util.Map;


public class GetInformation_defs extends BaseSteps implements En {
    public static Logger logger = LoggerFactory.getLogger(GetInformation_defs.class);

//    @Steps
//    GetInformation getInformation;

//    @Steps
//    VerifyGetInformation VerifyGetInformation;

    public GetInformation_defs() {
        Given("{word} is in the system", (String userName) -> {
//            // Do nothing
        });
        When("Anyone get the {word} information", ( String userName) -> {
            // Write code here that turns the phrase above into concrete actions
//            OnStage.theActorCalled(actorName).attemptsTo(getInformation);
            OnStage.aNewActor().attemptsTo(GetInformation.with(userName));
        });
        Then("Anyone should be able to see the information", (DataTable dataTable) -> {
//            throw new io.cucumber.java.PendingException();
//            // Do nothing
            Map<String,String> dataMap =dataTable.asMap(String.class, String.class);
            OnStage.theActorInTheSpotlight().attemptsTo(VerifyGetInformation.equal(ImmutableMap.copyOf(dataMap)));
        });
    }

}