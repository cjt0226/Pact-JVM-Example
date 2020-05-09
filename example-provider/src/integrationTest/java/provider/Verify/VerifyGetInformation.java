package provider.Verify;


import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import org.slf4j.LoggerFactory;
import provider.tasks.BaseTask;

import static org.hamcrest.Matchers.*;

import org.slf4j.Logger;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

@RequiredArgsConstructor
public class VerifyGetInformation extends BaseTask {
    public static Logger logger = LoggerFactory.getLogger(VerifyGetInformation.class);

    private final ImmutableMap<String, String> expectedUserInformation;

    public static VerifyGetInformation equal(ImmutableMap<String, String> expectedUserInformation) {
        return Tasks.instrumented(VerifyGetInformation.class, expectedUserInformation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // should只显示结果，不显示详细信息
//        actor.should(seeThatResponse("is OK，return 200",response -> response.statusCode(200)));
        actor.should(seeThatResponse("is OK，return 200", response -> response.statusCode(200)
                .body("name",equalTo(expectedUserInformation.get("name")))
                .body("nationality", equalTo(expectedUserInformation.get("nationality")))
                .body("salary", equalTo(Integer.parseInt(expectedUserInformation.get("salary"))))
                .body("content.Email", equalTo(expectedUserInformation.get("content.Email")))
                .body("'content.Phone Number'", equalTo(expectedUserInformation.get("content.Phone Number")))
        ));
        // attemptsTo Verify 显示详细信息
//        actor.attemptsTo(Verify.that);
    }
}
