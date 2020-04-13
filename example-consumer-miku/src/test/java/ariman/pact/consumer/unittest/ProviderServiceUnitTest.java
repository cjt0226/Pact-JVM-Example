package ariman.pact.consumer.unittest;


import ariman.pact.consumer.Information;
import ariman.pact.consumer.ProviderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProviderServiceUnitTest {
    @Autowired
    private ProviderService providerService;

    // MockBean is the annotation provided by Spring that wraps mockito one
    // Annotation that can be used to add mocks to a Spring ApplicationContext.
    // If any existing single bean of the same type defined in the context will be replaced by the mock, if no existing bean is defined a new one will be added.
    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testGetInformation() throws Exception {
        Map<String, String> contact = new HashMap<>();
        contact.put("mobile","130");
        Information information = Information.builder()
                .name("Frank.Chen")
                .nationality("China")
                .salary(10000)
                .contact(contact)
                .build();
        // Mocking remote service
        when(restTemplate.getForObject(any(String.class),any(Class.class))).thenReturn(information);
        Information information_result = providerService.getInformation();
        assertThat(information_result.getName(), is("Frank.Chen"));
        assertThat(information_result, hasProperty("name",is("Frank.Chen")));
        assertThat(information_result, equalTo(information));
    }
}
