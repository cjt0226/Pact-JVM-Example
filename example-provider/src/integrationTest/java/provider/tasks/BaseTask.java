package provider.tasks;

import net.serenitybdd.screenplay.Task;
import org.springframework.boot.test.context.SpringBootTest;
import provider.Application;


@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class BaseTask implements Task {
}
