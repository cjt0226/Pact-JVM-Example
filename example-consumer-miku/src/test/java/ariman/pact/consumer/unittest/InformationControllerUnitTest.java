package ariman.pact.consumer.unittest;

import ariman.pact.consumer.Information;
import ariman.pact.consumer.InformationController;
import ariman.pact.consumer.ProviderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
//@WebMvcTest(InformationController.class)
public class InformationControllerUnitTest {
    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

//    @Autowired
//    InformationController informationController;

    @MockBean
    ProviderService providerService;

    @Before
    public void setup() throws Exception {
        //独立测试方式：通过参数指定一组控制器，这样就不需要从上下文获取了；
//        this.mockMvc = standaloneSetup(this.informationController).build();
        //集成Web环境方式：指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc；
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void testMiku() throws Exception {
        Map<String, String> contact = new HashMap<>();
        contact.put("Phone Number", "130");
        contact.put("Email", "Test@test.com");

        Information mikuInfo = Information.builder()
                .name("Frank.Chen")
                .nationality("China")
                .salary(10000)
                .contact(contact)
                .build();
        //Mocking service
        when(providerService.getInformation()).thenReturn(mikuInfo);
        MvcResult result = mockMvc.perform(get("/miku"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("miku"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("name", "mail", "phone"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assertThat(result.getModelAndView().getModel().get("name"),is("Frank.Chen"));
        assertThat(result.getModelAndView().getModel().get("mail"),is("Test@test.com"));
        assertThat(result.getModelAndView().getModel().get("phone"),is("130"));
    }

}
