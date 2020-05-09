package provider.step_definitions;

import org.springframework.boot.test.context.SpringBootTest;
import provider.Application;

@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseSteps {
}
