package ariman.pact.consumer.unittest;

import ariman.pact.consumer.unittest.InformationControllerUnitTest;
import ariman.pact.consumer.unittest.ProviderServiceUnitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProviderServiceUnitTest.class, InformationControllerUnitTest.class})
public class TestSuits {
}
