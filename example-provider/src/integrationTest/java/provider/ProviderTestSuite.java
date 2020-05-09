package provider;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.openqa.selenium.interactions.ButtonReleaseAction;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"}
        ,features = "classpath:features"
//        ,features="src/test/resources/features"
//        ,features = "src/integrationTest/resources/features/get-user-information.feature"
//        ,features = "src/test/resources/features/provider/get_information/get-user-information.feature"
//        ,features = "classpath:features/provider/get_information/get-user-information.feature"
//        ,features = "src/integrationTest/resources/features/provider/get_information/get-user-information.feature"
//        ,glue = {"provider.test.step_definitions"}
//        ,glue = "src/integrationTest/java/provider/test"
//        ,dryRun = true
//        ,monochrome  = true
)
public class ProviderTestSuite {
}