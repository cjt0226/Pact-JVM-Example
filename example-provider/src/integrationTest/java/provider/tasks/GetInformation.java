package provider.tasks;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

@RequiredArgsConstructor
public class GetInformation extends BaseTask {

    private final String userName;

//    protected GetInformation(String userName){
//        this.userName=userName;
//    }

    public static GetInformation with(String userName) {
        return Tasks.instrumented(GetInformation.class,userName);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
//        actor.attemptsTo(Get.resource("/information").with(request -> request.queryParam("name", "Miku")));
        actor.attemptsTo(Get.resource("/information").with(request -> request.queryParam("name", userName)));
    }
}
